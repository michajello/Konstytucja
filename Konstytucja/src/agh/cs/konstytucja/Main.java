package agh.cs.konstytucja;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileReaderAndOpener file = new FileReaderAndOpener();
	
		try {
			file.openAndReadAFile();
		} catch (IOException e) {
			// TODO Automatycznie wygenerowany blok „catch”
			e.printStackTrace();
		}
	
	}

}
