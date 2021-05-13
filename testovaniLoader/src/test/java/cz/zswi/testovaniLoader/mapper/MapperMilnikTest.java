package cz.zswi.testovaniLoader.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.Milnik;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.readers.CSVSourceReader;

public class MapperMilnikTest {

	@Test
	public void testMapper() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> milnik = reader.read(DocType.MILNIK, "src/test/resources/testMilnik.csv");
		
		MapperMilnik mapper = new MapperMilnik();
		
		List<OutData> milnikOut = mapper.map(milnik);
		
		assertEquals(milnikOut.size(), 1);
		
	}
	
	@Test
	public void testAttributes() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> milnik = reader.read(DocType.MILNIK, "src/test/resources/testMilnik.csv");
		
		MapperMilnik mapper = new MapperMilnik();
		
		List<OutData> milnikOut = mapper.map(milnik);
		Milnik milnikTemp = (Milnik) milnikOut.get(0);
		
		assertEquals(milnikTemp.getId(), 123);
		assertEquals(milnikTemp.getKod(), "HL 12345/2020");
		assertEquals(milnikTemp.getRokHlaseni(), 2020);
	}

}
