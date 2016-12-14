package agh.cs.konstytucja;

import java.util.ArrayList;
import java.util.LinkedList;

public class ConstitutionParser {

	
	private ArrayList<String> lines = new ArrayList<>();
	private ArrayList<Chapter> chapters = new ArrayList();
	private ArrayList<String> articles = new ArrayList<>();
	
	private String preamble = "";
	private int amountOfArticles = 0;
	private int amountOfChapters = 0;

	private int beginningOfProperText = 0;
	
	public Constitution getConstitution (){
		Constitution constitution = new Constitution(preamble, chapters, articles);
		return constitution;
	}	
	public ConstitutionParser(ArrayList<String> lines) {
		this.lines = lines;
	
	}

	public void parseConstitution() {
		this.removeWrongLines();
		this.removeSingleLetterInPreamble();
		this.searchDividedWords();
		this.parsePreamble();
		this.parseProperText();
		
	}

	public void printAllLines() {
		for (String line : lines) {
			System.out.println(line);
		}
		System.out.println(lines.get(0));

	}

	public void printPreamble() {
		System.out.println(this.preamble);
	}

	private void removeSingleLetterInPreamble() {
		int i = 0;
		while (!RegexWordMatcher.isChapter(lines.get(i))) {
			if (RegexWordMatcher.isSingleLetterInPreamble(lines.get(i))) {
				lines.remove(i);
				i--;
			}
			i++;
		}
	}

	private void searchDividedWords() {
		for (int i = 0; i < lines.size(); i++) {
			if (RegexWordMatcher.isDividedWord(lines.get(i))) {
				this.mergeDividedWords(i);
			}
		}
	}

	private void mergeDividedWords(int i) {
		String[] previousWord = lines.get(i).split("\\s+"); // divide by space
		String[] nextWord = lines.get(i + 1).split("\\s+");

		String mergedWord = this.mergeString(previousWord[previousWord.length - 1], nextWord[0]);

		String previousLine = "";
		String nextLine = "";

		for (int j = 0; j < previousWord.length - 1; j++) {
			previousLine += previousWord[j] + " ";
		}
		previousLine += mergedWord;
		lines.set(i, previousLine);

		if (nextWord.length > 1) {
			for (int j = 1; j < nextWord.length - 1; j++) {
				nextLine += nextWord[j] + " ";
			}

			nextLine += nextWord[nextWord.length - 1];
			lines.set(i + 1, nextLine);
		} else
			lines.remove(i + 1);// delete empty line
	}

	private String mergeString(String s1, String s2) {
		return s1.substring(0, s1.length() - 1) + s2;
	}

	private void parsePreamble() {
		StringBuilder stringBuilder = new StringBuilder();

		int i = 0;
		while (!RegexWordMatcher.isEndOfPreamble(lines.get(i))) {
			stringBuilder.append(lines.get(i));
			stringBuilder.append("\n");
			i++;
		}
		beginningOfProperText = i;
		preamble = stringBuilder.toString();

	}

	private void parseProperText() {
		int i = beginningOfProperText;
		StringBuilder builderArticle = new StringBuilder();
		Chapter chapter = new Chapter();
		chapter.rangeOfArticleInChapters.beginningOfRange = 0;
		chapter.title = lines.get(i)+"\n"+lines.get(i+1);
		i+=2;
		
		while (i < lines.size()) {
			if (RegexWordMatcher.isChapter(lines.get(i))) {
				chapter.rangeOfArticleInChapters.endOfRange = amountOfArticles;
				chapters.add(chapter);
				chapter = new Chapter();
				chapter.rangeOfArticleInChapters.beginningOfRange = amountOfArticles;

				
				chapter.title = lines.get(i)+"\n"+lines.get(i+1);
				i++;
			} else if (RegexWordMatcher.isUpperCasePattern(lines.get(i))) {
		
				chapter.subchapters.put(amountOfArticles, lines.get(i));

			} else if (RegexWordMatcher.isArticle(lines.get(i))) {
				
				builderArticle = new StringBuilder();
				builderArticle.append(lines.get(i));
				builderArticle.append("\n");
				i++;
				
				while (i < lines.size() && RegexWordMatcher.isPartOfArticle(lines.get(i))) {
					builderArticle.append(lines.get(i));
					builderArticle.append("\n");
					i++;
				}
				
				i--;
				articles.add(builderArticle.toString());
				amountOfArticles++;
				
			}
			
			i++;
		}
		

	}

	private void removeWrongLines() {
		for (int i = 0; i < lines.size(); i++) {

			if (RegexWordMatcher.detectingWrongLine(lines.get(i))) {
				lines.remove(i);
				i--;
			}

		}
	}

}
