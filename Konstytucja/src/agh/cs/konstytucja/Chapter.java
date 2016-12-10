package agh.cs.konstytucja;

import java.util.HashMap;
import java.util.LinkedList;

public class Chapter {
	private int index;
	private RangeOfArticleInChapters rangeOfArticleInChapters  ;
	private HashMap<Integer, String> subchapters = new HashMap<>();
	
	public Chapter(int index, RangeOfArticleInChapters rangeOfArticleInChapters) {
		super();
		this.index = index;
		this.rangeOfArticleInChapters = rangeOfArticleInChapters;
	}
	
	
	
}
