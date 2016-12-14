package agh.cs.konstytucja;

public class Application {

	public static void main(String[] args) {

		ArgumentParser arguments= new ArgumentParser();
		
		arguments.setScanner(args);
		arguments.parseArguments();
		
	}

}
