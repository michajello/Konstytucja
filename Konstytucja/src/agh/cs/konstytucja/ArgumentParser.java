package agh.cs.konstytucja;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ArgumentParser {

	
	private final String EXIT = "exit";
	private final String ARTICLE = "a";
	private final String CHAPTER = "c";
	private final String ARTICLES = "aa";
	private final int AMOUNT_OF_CHAPTER = 13;
	private final int AMOUNT_OF_ARTICLE = 243;
	
	private Constitution constitution = null;
	 Scanner input = new Scanner(System.in);
	
	 
	public void setScanner (String[] args){
		if(args.length==0)return;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < args.length ; i++) {
			builder.append(args[i]).append(" ");
		}
		builder.append(EXIT);
		
		input = new Scanner(builder.toString());
	}
	public Constitution getConstitution (){
		return this.constitution;
	}
	public void parseArguments() {

		System.out.println("Witaj w programie. Podaj sciezke do katalogu");
		

		ConstitutionReaderAndCreator conReaderAndCreator = new ConstitutionReaderAndCreator();
		
		
		try {
			conReaderAndCreator.openAndReadAFile(input.next());
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return;
		} catch (IOException e) {
			System.out.println(e);
			return;
		}

		constitution = conReaderAndCreator.getContitution();

		this.printAppropiateUsage();

		String arg = input.next();	

		while (!EXIT.equalsIgnoreCase(arg)) {
				
			if (CHAPTER.equalsIgnoreCase(arg)) {
				try {
					runUsageChapter();
				} catch (IllegalArgumentException e) {
						
					System.out.println(e);

				}
			}

			else if (ARTICLE.equalsIgnoreCase(arg)) {
				try {
					runUsageArticle();
				} catch (IllegalArgumentException e) {
					
					System.out.println(e);
				}
			}	else if (ARTICLES.equalsIgnoreCase(arg)) {
				try {
					runUsageArticles();
				} catch (IllegalArgumentException e) {
					
					System.out.println(e);
				}
			}
			else System.out.println("Podano nieprawidłowe argumenty\n");
			
			System.out.println("Podaj argumenty po raz kolejny");
			arg=input.next();
			
		}
		System.out.println("Zakonczono dzialanie programu");
	}

	

	private void printAppropiateUsage() {
		System.out.println("Uzyj nastepujacych opcji:\n1.Opcja c <liczba> -wyswietla okreslony rozdzial.\n"
				+ "2.Opcja: a <liczba> - wyswietla okresony artykul\n"
				+ "3.Opcja: aa <liczba> <licba> - wyswietla artykuly na okreslonym przedziale\n"
				+ "4.Opcja: exit - konczy dzialanie programu");

	}

	private void runUsageArticle() {
		int argInt = 0;
		if (input.hasNextInt()) {
			argInt = input.nextInt();
			if (argInt <= 0 || argInt > AMOUNT_OF_ARTICLE) {
				throw new IllegalArgumentException("Zbyt mały lub zbyt duży nr artykulu");
			}
				constitution.printArticle(argInt);
		} else
			throw new IllegalArgumentException("Podaj odpowiedni nr artykulu");

	}

	private void runUsageArticles() {
		int argInt =0;
		int argInt2 = 0;
		if (input.hasNextInt()) {
			argInt = input.nextInt();
			if (argInt <= 0 || argInt > AMOUNT_OF_ARTICLE ) {
				throw new IllegalArgumentException("Zbyt mała lub zbyt duża liczba pierwszego parametru");
			}
			if(input.hasNextInt()){
				argInt2=input.nextInt();
				if (argInt2 <= 0 || argInt2 > AMOUNT_OF_ARTICLE || argInt2<argInt ) {
					throw new IllegalArgumentException("Zbyt mała lub zbyt duża liczba drugiego parametru");
				}
				else {
					RangeOfArticleInChapters rangeOfArticles = new RangeOfArticleInChapters(argInt,argInt2);
					constitution.printRangeOfArticlesWithChapters(rangeOfArticles);
	
				}
			}
		}
		else
			throw new IllegalArgumentException("Podaj odpowiedni poczatek przedzialu");
	}

	private void runUsageChapter() {
		int argInt;
		if (input.hasNextInt()) {
			argInt = input.nextInt();
			if (argInt <= 0 || argInt > AMOUNT_OF_CHAPTER)
				throw new IllegalArgumentException("Zbyt mała lub zbyt duża liczba");
			constitution.printChapter(argInt);
		} else
			throw new IllegalArgumentException("Podaj odpowiedni rozdzial");
	}

}
