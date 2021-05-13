package cz.zswi.vykazyLoader.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.model.Vykaz;
import cz.zswi.vykazyLoader.readers.CSVSourceReader;

public class MapperVykazyTest {

	@Test
	public void testMapper() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vykazy = reader.read(DocType.VYKAZY, "src/test/resources/testVykazy.csv");
		
		MapperVykazy mapper = new MapperVykazy();
		
		List<OutData> vykazyOut = mapper.map(vykazy);
		
		assertEquals(vykazyOut.size(), 1);
		
	}
	
	@Test
	public void testAttributes() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vykazy = reader.read(DocType.VYKAZY, "src/test/resources/testVykazy.csv");
		
		MapperVykazy mapper = new MapperVykazy();
		
		List<OutData> vykazyOut = mapper.map(vykazy);
		Vykaz vykazTemp = (Vykaz) vykazyOut.get(0);
		
		assertEquals(vykazTemp.getIdZaznamu(), 123456);
		assertEquals(vykazTemp.getKodPracovnika(), "ABC");
		assertEquals(vykazTemp.getPozice(), 1);
	}

}
