package agh.cs.konstytucja;

public class RangeOfArticleInChapters{
	protected int beginningOfRange;
	protected int endOfRange;

	public RangeOfArticleInChapters(int x, int y) {
		beginningOfRange = x;
		endOfRange = y;
	}
	public RangeOfArticleInChapters() {
		beginningOfRange = -1;
		endOfRange = -1;
	}

	public int getBeginningOfRange() {
		return beginningOfRange;
	}

	public int getEndOfRange() {
		return endOfRange;
	}

}
