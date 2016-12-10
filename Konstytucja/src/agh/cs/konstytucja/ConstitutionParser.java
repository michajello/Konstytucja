package agh.cs.konstytucja;

import java.util.ArrayList;

public class ConstitutionParser {

	private Constitution constitution;
	private ArrayList<String> lines = new ArrayList<>();

	public ConstitutionParser(ArrayList<String> lines) {
		this.lines = lines;
		this.constitution = new Constitution();
	}

	public void parseConstitution() {
		this.removeWrongLines();
		this.removeSingleLetterInPreamble();
		this.searchDividedWords();
		this.parsePreamble();
		this.parseChapters();
		this.parseArticles();
	}

	public void printAllLines() {
		for (String line : lines) {
			System.out.println(line);
		}
		System.out.println(lines.get(0));

	}

	public void printPreamble() {
		for (int i = 0; i < 57; i++) {
			System.out.println(lines.get(i));
		}
	}

	private void removeSingleLetterInPreamble() {
		int i = 0;
		while (!RegexWorldMatcher.isEndOfPreamble(lines.get(i))) {
			if (RegexWorldMatcher.isSingleLetterInPreamble(lines.get(i))) {
				System.out.println(lines.get(i));
				lines.remove(i);
				i--;
			}
			i++;
		}
	}

	private void searchDividedWords() {
		for (int i = 0; i < lines.size(); i++) {
			
		}
	}

	private void mergeDividedWords() {

	}

	private void parsePreamble() {
		// TODO Automatycznie wygenerowany zaczątek metody

	}

	private void parseChapters() {
		// TODO Automatycznie wygenerowany zaczątek metody

	}

	private void parseArticles() {
		// TODO Automatycznie wygenerowany zaczątek metody

	}

	private void removeWrongLines() {
		for (int i = 0; i < lines.size(); i++) {

			if (RegexWorldMatcher.detectingWrongLine(lines.get(i))) {
				lines.remove(i);
				i--;
			}

		}
	}

}
