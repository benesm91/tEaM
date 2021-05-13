package cz.zswi.vykazyLoader.readers.csv;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.ZamestnanecDTO;

public class ZamestnanciDataReaderTest {

	@Test
	public void testRead() throws Exception {
		ZamestnanciDataReader reader = new ZamestnanciDataReader();
		List<Data> zamestnanci = reader.read(new File("src/test/resources/testZamestnanci.csv")); 
		
		ZamestnanecDTO zamTemp = (ZamestnanecDTO) zamestnanci.get(0);
		
		assertEquals(zamTemp.getStredisko(), "FAV");
		assertEquals(zamTemp.getFunkce(), "NAN");
		assertEquals(zamTemp.getIcp(), "123456");
	}
	
	@Test
	public void testException() throws Exception {
		ZamestnanciDataReader reader = new ZamestnanciDataReader();
		List<Data> zamestnanci = reader.read(null);
		
		assertEquals(zamestnanci, null);
		
	}

}
