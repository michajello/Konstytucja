package agh.cs.konstytucja;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		ConstitutionReaderAndCreator conReaderAndCreator = new ConstitutionReaderAndCreator();
		conReaderAndCreator.openAndReadAFile();
/*		try {
			file.openAndReadAFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
		String a="cos";
		a+= "\n" + "cokolwiek";
		System.out.println(a);
	}

}
