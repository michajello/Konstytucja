package agh.cs.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import agh.cs.konstytucja.ArgumentParser;
import agh.cs.konstytucja.Constitution;

public class ConstitutionTest {
	String[] input = { "/resource/konstytucja.txt  exit" };
	ArgumentParser argParser = new ArgumentParser();
	Constitution constitution = null;

	@Before
	public void preparingForTests() {
		argParser.setScanner(input);
		argParser.parseArguments();
		constitution = argParser.getConstitution();
	}

	@Test
	public void testingArticles() {
		String article13 = "Art. 13.\n"
				+ "Zakazane jest istnienie partii politycznych i innych organizacji odwołujących się w\n"
				+ "swoich programach do totalitarnych metod i praktyk działania nazizmu, faszyzmu i\n"
				+ "komunizmu, a także tych, których program lub działalność zakłada lub dopuszcza\n"
				+ "nienawiść rasową i narodowościową, stosowanie przemocy w celu zdobycia władzy\n"
				+ "lub wpływu na politykę państwa albo przewiduje utajnienie struktur lub członkostwa.\n";
		String articleTest13 = constitution.getArtcile(13);
		//constitution.printArticle(13);
		assertTrue(article13.equals(articleTest13));

	}

}
