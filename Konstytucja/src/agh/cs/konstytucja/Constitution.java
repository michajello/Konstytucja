package agh.cs.konstytucja;

import java.util.LinkedList;

public class Constitution {
	private String preamble;
	private LinkedList<Chapter> chapters;
	private LinkedList<Article> articles;
	public Constitution() {
		
		this.chapters = new LinkedList<>();
		this.articles = new LinkedList<>();
	}
	
}
