package agh.cs.tests;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import org.junit.Test;

import agh.cs.konstytucja.FileReaderAndOpener;

public class SupportingFile {

	@Test
	public void testistReadingAndOpeningFile() {
		FileReaderAndOpener testFile = new FileReaderAndOpener();
		try {
			testFile.openAndReadAFile();
		} catch (IOException e) {
			assertFalse( e instanceof IOException);
		}
	}

}
