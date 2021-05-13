package cz.zswi.testovaniLoader.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.model.VysledekTestu;
import cz.zswi.testovaniLoader.readers.CSVSourceReader;

public class MapperVysledkyTest {

	@Test
	public void testMapper() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vysledky = reader.read(DocType.VYSLEDKY, "src/test/resources/testVysledekTestu.csv");

		MapperVysledky mapper = new MapperVysledky();

		List<OutData> vysledkyOut = mapper.map(vysledky);

		assertEquals(vysledkyOut.size(), 1);

	}

	@Test
	public void testAttributes() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vysledky = reader.read(DocType.VYSLEDKY, "src/test/resources/testVysledekTestu.csv");

		MapperVysledky mapper = new MapperVysledky();

		List<OutData> vysledkyOut = mapper.map(vysledky);
		VysledekTestu vysledekTemp = (VysledekTestu) vysledkyOut.get(0);

		assertEquals(vysledekTemp.getIdTestPripad(), 370);
		assertEquals(vysledekTemp.getVysledek(), "OK");
		assertEquals(vysledekTemp.getIdMilnik(), 123);
	}

}
