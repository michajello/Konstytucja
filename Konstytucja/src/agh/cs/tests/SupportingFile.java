package agh.cs.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import agh.cs.konstytucja.ConstitutionReaderAndCreator;

public class SupportingFile {

	@Test
	public void testistReadingAndOpeningFile1() {
		ConstitutionReaderAndCreator constitutionReader = new ConstitutionReaderAndCreator();
		try {
			constitutionReader.openAndReadAFile("./resource/konstytucja.txt");
		} catch (IOException e) {
			assertFalse(e instanceof IOException);
		}catch (IllegalArgumentException e) {
			assertFalse(e instanceof IllegalArgumentException);
		}
	}
	@Test
	public void testistReadingAndOpeningFile2() {
		ConstitutionReaderAndCreator constitutionReader = new ConstitutionReaderAndCreator();
		try {
			constitutionReader.openAndReadAFile("badpath");
		} catch (IOException e) {
			assertTrue(e instanceof IOException);
		}catch (IllegalArgumentException e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		//exception is thrown 
		
	}

}
