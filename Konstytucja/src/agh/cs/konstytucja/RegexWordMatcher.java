package agh.cs.konstytucja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWordMatcher {
	public final static Pattern wrongDatePattern = Pattern.compile("2009-11-16");
	public final static Pattern wrongPattern1 = Pattern.compile("©Kancelaria Sejmu");
	public final static Pattern wrongPatternInPreamble = Pattern.compile(".");
	public final static Pattern cuttedPattern = Pattern.compile(".+[-]$");
	public final static Pattern articlePattern = Pattern.compile("Art. [0-9]{1,3}[\\.]*");
	public final static Pattern chapterPattern = Pattern.compile("Rozdział [IVXL]+");
	public final static Pattern numParagraphPattern = Pattern.compile("[0-9]{1,3}[\\.]");
	public final static Pattern subParagraphPattern = Pattern.compile("[0-9]{1,3}[)]");
	public final static Pattern upperCasePattern = Pattern.compile("[A-Z ĄĘÓŁĆŻŹŃŚĆ]{2,}");
	static Matcher matcher;

	public static boolean detectingWrongLine(String line) {
		matcher = wrongDatePattern.matcher(line);
		if (matcher.matches())
			return true;
		matcher = wrongPattern1.matcher(line);
		if (matcher.matches())
			return true;

		return false;
	}

	public static boolean isEndOfPreamble(String line) {
		matcher = chapterPattern.matcher(line);
		if (matcher.matches())
			return true;

		return false;
	}

	public static boolean isDividedWord (String line){
		matcher = cuttedPattern.matcher(line);
		if (matcher.matches()) return true;
		
		return false;
	}

	public static boolean isSingleLetterInPreamble(String line) {
		matcher = wrongPatternInPreamble.matcher(line);
		if (matcher.matches())
			return true;

		return false;
	}
	public static boolean isChapter(String line ){
		matcher = chapterPattern.matcher(line);
		if (matcher.matches())
			return true;

		return false;
	}
	public static boolean isUpperCasePattern(String line ){
		matcher = upperCasePattern.matcher(line);
		if (matcher.matches())
			return true;

		return false;
	}

	public static boolean isArticle(String line) {
		matcher = articlePattern.matcher(line);
		if (matcher.matches())
			return true;
		return false;
	}

	public static boolean isPartOfArticle(String line) {
		if(RegexWordMatcher.isChapter(line) || RegexWordMatcher.isUpperCasePattern(line) || RegexWordMatcher.isArticle(line) )return false;

		return true;
	}
}
