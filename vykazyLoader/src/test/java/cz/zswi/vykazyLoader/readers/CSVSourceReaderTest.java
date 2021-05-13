package cz.zswi.vykazyLoader.readers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.model.Data;

public class CSVSourceReaderTest {
	
	/* test cteni souboru, testujeme delku vytvoreneho seznamu */
	@Test
	public void testVykazy() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vykazy = reader.read(DocType.VYKAZY, "src/test/resources/testVykazy.csv");
		
		assertEquals(vykazy.size(), 1);
	}
	
	/* test vyjimky pri spatne zadane ceste k souboru */
	@Test
	public void testExceptionVykazy() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vykazy = reader.read(DocType.VYKAZY, "file.csv");
		
		assertEquals(vykazy, null);
	}
	
	/* test cteni souboru, testujeme delku vytvoreneho seznamu */
	@Test
	public void testZamestnanci() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> zamestnanci = reader.read(DocType.ZAMESTNANCI, "src/test/resources/testZamestnanci.csv");
		
		assertEquals(zamestnanci.size(), 1);
	}
	
	/* test vyjimky pri spatne zadane ceste k souboru */
	@Test
	public void testExceptionZamestnanci() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> zamestnanci = reader.read(DocType.ZAMESTNANCI, "file.csv");
		
		assertEquals(zamestnanci, null);
	}
	
	
	
	

}
