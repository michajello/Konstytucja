package agh.cs.konstytucja;

import java.util.HashMap;

public class Chapter {
	protected int index;
	protected String title;
	protected RangeOfArticleInChapters rangeOfArticleInChapters;
	protected HashMap<Integer, String> subchapters = new HashMap<>();

	public Chapter() {
		super();
		rangeOfArticleInChapters = new RangeOfArticleInChapters();
	}

	public int getBeginningOfRange() {
		return rangeOfArticleInChapters.getBeginningOfRange();
	}

	public int getEndOfRange() {
		return rangeOfArticleInChapters.getEndOfRange();
	}
	public void printTitle(){
		System.out.println(title);
	}
}
