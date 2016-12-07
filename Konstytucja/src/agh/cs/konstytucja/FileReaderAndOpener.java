package agh.cs.konstytucja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileReaderAndOpener {
	private final String pathToFile="/resource/konstytucja.txt";
	
	private LinkedList<String> lines = new LinkedList<>();

	public void openAndReadAFile () throws IOException{
		FileReader file= new FileReader(pathToFile);
		BufferedReader buffer = new BufferedReader(file);
		
		String sCurrentLine;
		while ((sCurrentLine = buffer.readLine()) != null) {
			System.out.println(sCurrentLine);
		}
		
	}
	
	public LinkedList<String> getLines() {
		return lines;
	}
	
	
}
