package agh.cs.konstytucja;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConstitutionReaderAndCreator {
	protected final String pathToFile="./resource/konstytucja.txt";

	private ArrayList<String> lines = new ArrayList<>();
	
	
	public void openAndReadAFile () throws IOException{
		
		FileReader file= new FileReader(pathToFile);
		BufferedReader buffer = new BufferedReader(file);
				
		String sCurrentLine;
		while ((sCurrentLine = buffer.readLine()) != null) {
			lines.add(sCurrentLine);
			}
		
		buffer.close();
		file.close();
				
		ConstitutionParser constitutionParser = new ConstitutionParser(lines);
		constitutionParser.parseConstitution();
		constitutionParser.printPreamble();		
		
	}
	
	public ArrayList<String> getLines() {
		return lines;
	}
	
}
