package agh.cs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import agh.cs.konstytucja.RegexWordMatcher;

public class RegexWorldMatcherTest {

	@Test
	public void tests() {
		assertTrue(RegexWordMatcher.isArticle("Art. 6."));
		assertTrue(RegexWordMatcher.isChapter("Rozdział V"));
		assertTrue(RegexWordMatcher.isDividedWord("szala-"));
		
		assertFalse(RegexWordMatcher.isDividedWord("Buda-Peszt"));
		
		assertTrue(RegexWordMatcher.isUpperCasePattern("KURS"));
		assertFalse(RegexWordMatcher.isUpperCasePattern("KUrS"));
	}

}
