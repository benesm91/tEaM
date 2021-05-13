package cz.zswi.testovaniLoader.readers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.model.Data;

public class CSVSourceReaderTest {

	/* test cteni souboru, testujeme delku vytvoreneho seznamu */
	@Test
	public void testMilniky() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> milniky = reader.read(DocType.MILNIK, "src/test/resources/testMilnik.csv");

		assertEquals(milniky.size(), 1);
	}

	/* test vyjimky pri spatne zadane ceste k souboru */
	@Test
	public void testExceptionMilniky() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> milniky = reader.read(DocType.NAPLANOVANE, "file.csv");

		assertEquals(milniky, null);
	}

	/* test cteni souboru, testujeme delku vytvoreneho seznamu */
	@Test
	public void testNaplanovane() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> naplanovane = reader.read(DocType.NAPLANOVANE, "src/test/resources/testNaplanovaneTesty.csv");

		assertEquals(naplanovane.size(), 1);
	}

	/* test vyjimky pri spatne zadane ceste k souboru */
	@Test
	public void testExceptionNaplanovane() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> naplanovane = reader.read(DocType.NAPLANOVANE, "file.csv");

		assertEquals(naplanovane, null);
	}

	@Test
	public void testVysledky() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vysledek = reader.read(DocType.VYSLEDKY, "src/test/resources/testVysledekTestu.csv");

		assertEquals(vysledek.size(), 1);
	}

	@Test
	public void testExceptionVysledky() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vysledek = reader.read(DocType.VYSLEDKY, "file.csv");

		assertEquals(vysledek, null);
	}
}
