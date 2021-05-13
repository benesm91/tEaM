package cz.zswi.testovaniLoader.readers.csv;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.MilnikDTO;

public class MilnikDataReaderTest {

	@Test
	public void testRead() throws Exception {
		MilnikDataReader reader = new MilnikDataReader();
		List<Data> milnik = reader.read(new File("src/test/resources/testMilnik.csv")); 
		
		MilnikDTO milnikTemp = (MilnikDTO) milnik.get(0);
		
		assertEquals(milnikTemp.getId(), "123");
		assertEquals(milnikTemp.getKod(), "HL 12345/2020");
		assertEquals(milnikTemp.getRokHlaseni(), "2020");
	}
	
	@Test
	public void testException() throws Exception {
		MilnikDataReader reader = new MilnikDataReader();
		List<Data> milnik = reader.read(null);
		
		assertEquals(milnik, null);
		
	}

}


