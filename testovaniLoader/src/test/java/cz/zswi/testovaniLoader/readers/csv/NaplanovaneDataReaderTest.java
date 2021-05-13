package cz.zswi.testovaniLoader.readers.csv;


import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.NaplanovanyTestDTO;



public class NaplanovaneDataReaderTest {

	@Test
	public void testRead() throws Exception {
		NaplanovaneDataReader reader = new NaplanovaneDataReader();
		List<Data> naplanovane = reader.read(new File("src/test/resources/testNaplanovaneTesty.csv")); 
		
		NaplanovanyTestDTO naplanovaneTemp = (NaplanovanyTestDTO) naplanovane.get(0);
		
		assertEquals(naplanovaneTemp.getIdMilnik(), "123");
		assertEquals(naplanovaneTemp.getIdTestPripadu(), "111");
	}
	
	@Test
	public void testException() throws Exception {
		NaplanovaneDataReader reader = new NaplanovaneDataReader();
		List<Data> naplanovane = reader.read(null);
		
		assertEquals(naplanovane, null);
		
	}

}
