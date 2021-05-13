package cz.zswi.testovaniLoader.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.NaplanovanyTest;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.readers.CSVSourceReader;

public class MapperNaplanovaneTest {

	@Test
	public void testMapper() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> naplanovane = reader.read(DocType.NAPLANOVANE, "src/test/resources/testNaplanovaneTesty.csv");

		MapperNaplanovane mapper = new MapperNaplanovane();

		List<OutData> naplanovaneOut = mapper.map(naplanovane);

		assertEquals(naplanovaneOut.size(), 1);

	}

	@Test
	public void testAttributes() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> naplanovane = reader.read(DocType.NAPLANOVANE, "src/test/resources/testNaplanovaneTesty.csv");

		MapperNaplanovane mapper = new MapperNaplanovane();

		List<OutData> naplanovaneOut = mapper.map(naplanovane);
		NaplanovanyTest naplanovaneTemp = (NaplanovanyTest) naplanovaneOut.get(0);

		assertEquals(naplanovaneTemp.getIdTestPripadu(), 111);
		assertEquals(naplanovaneTemp.getIdMilnik(), 123);

	}

}
