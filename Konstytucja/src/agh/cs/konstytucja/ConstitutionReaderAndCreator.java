package agh.cs.konstytucja;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConstitutionReaderAndCreator {
	//protected static String pathToFile;// ="./resource/konstytucja.txt";
	private ConstitutionParser constitutionParser = null;
	private ArrayList<String> lines = new ArrayList<>();



	public void openAndReadAFile(String path) throws IOException {
		FileReader file = null;
		
		try {
			file = new FileReader(path);
		} catch (FileNotFoundException e) {
			path = "." + path;
			try {
				 file = new FileReader(path);
			} catch (FileNotFoundException e1) {
				throw new FileNotFoundException("Nieprawidlowa sciezka do pliku lub plik nie istnieje");
			}
		}

		BufferedReader buffer = new BufferedReader(file);

		String sCurrentLine;
		while ((sCurrentLine = buffer.readLine()) != null) {
			lines.add(sCurrentLine);
		}
		
		buffer.close();
		file.close();

		constitutionParser = new ConstitutionParser(lines);
		constitutionParser.parseConstitution();
		//constitutionParser.printPreamble();

	}

	public Constitution getContitution() {
		return constitutionParser.getConstitution();
	}

	public ArrayList<String> getLines() {
		return lines;
	}

}
