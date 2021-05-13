package cz.zswi.testovaniLoader.writers;

import static org.junit.Assert.*;

import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.SourceReaderFactory;
import cz.zswi.testovaniLoader.mapper.IMapper;
import cz.zswi.testovaniLoader.mapper.MapperFactory;
import cz.zswi.testovaniLoader.mapper.Merger;
import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.readers.ISourceReader;

public class MongoWriterTest {

	@Test
	public void testConnectToDB() {
		MongoWriter writer = new MongoWriter();

		MongoDatabase db = null;
		try {
			db = writer.connectToDB("mongodb://localhost:27017");
		} catch (Exception e) {
			fail();
		}

		assertEquals(db.getName(), "TestReporting");
	}

	@Test
	public void testWrite() {
		/* cteni dat */
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
		if ((dataMilnikyOut == null) || (dataNaplanovaneOut == null) || (dataVysledkyOut == null))
			return;

		/* slouceni dat */
		Merger merger = new Merger();
		merger.mergeData(dataMilnikyOut, dataNaplanovaneOut, dataVysledkyOut);

		/* zapis dat do databaze */
		MongoWriter writer = new MongoWriter();
		String uri = "mongodb://localhost:27017";
		MongoDatabase db = writer.connectToDB(uri);
		if (db == null)
			return;
		writer.write(dataMilnikyOut, db);

		MongoCollection<Document> collection = db.getCollection("Testy");

		long count = collection.countDocuments();
		assertEquals(count, 1);
	}

}
