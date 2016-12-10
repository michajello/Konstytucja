package agh.cs.konstytucja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileReaderAndOpener {
	protected final String pathToFile="./resource/konstytucja.txt";
	
	private ArrayList<String> lines = new ArrayList<>();

	public void openAndReadAFile () throws IOException{
		FileReader file= new FileReader(pathToFile);
		BufferedReader buffer = new BufferedReader(file);
				
		String sCurrentLine;
		while ((sCurrentLine = buffer.readLine()) != null) {
			lines.add(sCurrentLine);
			}
		file.close();
		
	}
	
	public ArrayList<String> getLines() {
		return lines;
	}
	
	
}
