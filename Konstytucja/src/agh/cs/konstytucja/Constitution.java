package agh.cs.konstytucja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Constitution {
	private String preamble;
	private ArrayList<Chapter> chapters;
	private ArrayList<String> articles;

	public Constitution(String preamble, ArrayList<Chapter> chapters, ArrayList<String> articles) {
		this.preamble = preamble;
		this.chapters = chapters;
		this.articles = articles;
	}

	public void printArticle(int argInt) {
		System.out.println(articles.get(argInt - 1));
	}

	public String getArtcile(int argInt) {
		return articles.get(argInt - 1);
	}

	public void printRangeOfArticlesWithoutChapters(RangeOfArticleInChapters rangeOfArticles) {
		for (int i = rangeOfArticles.beginningOfRange - 1; i < rangeOfArticles.endOfRange; i++) {
			System.out.println(articles.get(i));
		}
	}

	public void printRangeOfArticlesWithChapters(RangeOfArticleInChapters rangeOfArticles) {
		int x = this.searchFirstChapter(rangeOfArticles);
		int y = this.searchLastChapter(rangeOfArticles);
		Chapter chapter = chapters.get(x);
		int i = rangeOfArticles.getBeginningOfRange()-1;

		while (i < chapter.getEndOfRange() && i < rangeOfArticles.getEndOfRange()) {
			if (chapter.subchapters.containsKey(i)) {
				System.out.println(chapter.subchapters.get(i));
			}
			System.out.println(articles.get(i));
			i++;
		}
		if (x == y) {
			return;
		}
		x++;
		
		while (x < y) {
			printChapter(x);
			x++;
		}

		chapter = chapters.get(y);
		i = chapter.getBeginningOfRange();
		if (i == rangeOfArticles.getEndOfRange() - 1) {
			chapter.printTitle();
			System.out.println(articles.get(i));
		} else {
			chapter.printTitle();
			while (i < rangeOfArticles.getEndOfRange()) {
				if (chapter.subchapters.containsKey(i)) {
					System.out.println(chapter.subchapters.get(i));
				}
				System.out.println(articles.get(i));
				i++;
			}
		}

	}

	private int searchLastChapter(RangeOfArticleInChapters rangeOfArticles) {
		int e = rangeOfArticles.getEndOfRange();
		for (int i = chapters.size() - 1; i >= 0; i--) {
			if (e > chapters.get(i).getBeginningOfRange())
				return i;
		}
		return -1;
	}

	private int searchFirstChapter(RangeOfArticleInChapters rangeOfArticles) {
		int b = rangeOfArticles.getBeginningOfRange() ;
		for (int i = 0; i < chapters.size(); i++) {
			if (b < chapters.get(i).getEndOfRange())
				return i;
		}
		return -1;
	}

	public String getRangeOfArticles(RangeOfArticleInChapters rangeOfArticles) {
		StringBuilder builder = new StringBuilder();
		for (int i = rangeOfArticles.beginningOfRange - 1; i < rangeOfArticles.endOfRange - 1; i++) {
			builder.append(articles.get(i)).append(" ");
		}
		int index = rangeOfArticles.endOfRange - 1;
		builder.append(articles.get(index));
		return builder.toString();
	}

	public void printChapter(int argInt) {
		Chapter chapter = chapters.get(argInt - 1);
		System.out.println(chapter.title);

		for (int i = chapter.getBeginningOfRange(); i <= chapter.getEndOfRange(); i++) {
			if (chapter.subchapters.containsKey(i)) {
				System.out.println(chapter.subchapters.get(i));
			} 
				System.out.println(articles.get(i));
			
		}

	}

	public String getChapter(int argInt) {
		Chapter chapter = chapters.get(argInt - 1);
		StringBuilder builder = new StringBuilder();
		builder.append(chapter.title);

		for (int i = chapter.getBeginningOfRange(); i < chapter.getEndOfRange(); i++) {
			if (chapter.subchapters.containsKey(i)) {
				builder.append(chapter.subchapters.get(i));
			}

			builder.append(articles.get(i));

		}
		return builder.toString();

	}

}
