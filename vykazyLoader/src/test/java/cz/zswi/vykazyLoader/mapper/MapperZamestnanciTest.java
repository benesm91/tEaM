package cz.zswi.vykazyLoader.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.model.Zamestnanec;
import cz.zswi.vykazyLoader.readers.CSVSourceReader;

public class MapperZamestnanciTest {

	@Test
	public void testMapper() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> zamestnanci = reader.read(DocType.ZAMESTNANCI, "src/test/resources/testZamestnanci.csv");
		
		MapperZamestnanci mapper = new MapperZamestnanci();
		
		List<OutData> zamestnanciOut = mapper.map(zamestnanci);
		
		assertEquals(zamestnanciOut.size(), 1);
		
	}
	
	@Test
	public void testAttributes() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> zamestnanci = reader.read(DocType.ZAMESTNANCI, "src/test/resources/testZamestnanci.csv");
		
		MapperZamestnanci mapper = new MapperZamestnanci();
		
		List<OutData> zamestnanciOut = mapper.map(zamestnanci);
		Zamestnanec zamestnanecTemp = (Zamestnanec) zamestnanciOut.get(0);
		
		assertEquals(zamestnanecTemp.getIcp(), 123456);
		assertEquals(zamestnanecTemp.getZkratka(), "ACS");
		assertEquals(zamestnanecTemp.getStredisko(), "FAV");
	}

}
