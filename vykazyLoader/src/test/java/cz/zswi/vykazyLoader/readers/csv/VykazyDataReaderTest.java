package cz.zswi.vykazyLoader.readers.csv;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.VykazDTO;

public class VykazyDataReaderTest {

	@Test
	public void testRead() throws Exception {
		VykazyDataReader reader = new VykazyDataReader();
		List<Data> vykazy = reader.read(new File("src/test/resources/testVykazy.csv")); 
		
		VykazDTO vykazTemp = (VykazDTO) vykazy.get(0);
		
		assertEquals(vykazTemp.getOsobniCislo(), "333");
		assertEquals(vykazTemp.getKodPracovnika(), "ABC");
		assertEquals(vykazTemp.getVykazano(), "0.5");
	}
	
	@Test
	public void testException() throws Exception {
		VykazyDataReader reader = new VykazyDataReader();
		List<Data> vykazy = reader.read(null);
		
		assertEquals(vykazy, null);
		
	}

}
