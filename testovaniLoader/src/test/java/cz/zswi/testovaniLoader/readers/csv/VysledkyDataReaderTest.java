package cz.zswi.testovaniLoader.readers.csv;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.model.Data;

import cz.zswi.testovaniLoader.model.VysledekTestuDTO;

public class VysledkyDataReaderTest {

	@Test
	public void testRead() throws Exception {
		VysledkyDataReader reader = new VysledkyDataReader();
		List<Data> vysledek = reader.read(new File("src/test/resources/testVysledekTestu.csv"));

		VysledekTestuDTO vysledekTemp = (VysledekTestuDTO) vysledek.get(0);

		assertEquals(vysledekTemp.getIdMilnik(), "123");
		assertEquals(vysledekTemp.getIdTestPripad(), "370");
		assertEquals(vysledekTemp.getVysledek(), "OK");

	}

	@Test
	public void testException() throws Exception {
		VysledkyDataReader reader = new VysledkyDataReader();
		List<Data> vysledek = reader.read(null);

		assertEquals(vysledek, null);

	}

}
