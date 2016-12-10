package agh.cs.konstytucja;

import java.util.HashMap;
import java.util.LinkedList;

public class Chapter {
	protected int index;
	protected String title;
	protected RangeOfArticleInChapters rangeOfArticleInChapters  ;
	protected HashMap<Integer, String> subchapters = new HashMap<>();
	public Chapter() {
		super();
		rangeOfArticleInChapters=new RangeOfArticleInChapters();
	}
	
}
