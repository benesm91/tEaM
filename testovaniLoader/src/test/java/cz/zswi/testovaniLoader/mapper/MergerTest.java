package cz.zswi.testovaniLoader.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.SourceReaderFactory;
import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.Milnik;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.readers.ISourceReader;

public class MergerTest {

	@Test
	public void testMergeData() {
		ISourceReader reader = SourceReaderFactory.getReader("CSV");
		if (reader == null)
			return;
		List<Data> dataMilniky = reader.read(DocType.MILNIK, "src/test/resources/testMilnik.csv");
		List<Data> dataNaplanovane = reader.read(DocType.NAPLANOVANE, "src/test/resources/testNaplanovaneTesty.csv");
		List<Data> dataVysledky = reader.read(DocType.VYSLEDKY, "src/test/resources/testVysledekTestu.csv");
		if ((dataMilniky == null) || (dataNaplanovane == null) || (dataVysledky == null))
			return;

		/* mapovani dat */
		IMapper mapper;
		mapper = MapperFactory.getMapper(DocType.MILNIK);
		List<OutData> dataMilnikyOut = mapper.map(dataMilniky);
		mapper = MapperFactory.getMapper(DocType.NAPLANOVANE);
		List<OutData> dataNaplanovaneOut = mapper.map(dataNaplanovane);
		mapper = MapperFactory.getMapper(DocType.VYSLEDKY);
		List<OutData> dataVysledkyOut = mapper.map(dataVysledky);

		/* mergovani */
		Merger merger = new Merger();
		merger.mergeData(dataMilnikyOut, dataNaplanovaneOut, dataVysledkyOut);

		Milnik milnikTemp = (Milnik) dataMilnikyOut.get(0);

		assertEquals(milnikTemp.getNaplanovaneTesty().size(), 1);
		assertEquals(milnikTemp.getVysledkyTestu().size(), 1);

	}

}
