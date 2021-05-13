package cz.zswi.vykazyLoader.writers;

import static org.junit.Assert.*;

import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.mapper.MapperVykazy;
import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.readers.CSVSourceReader;

public class WriterVykazyTest {

	@Test
	public void testWrite() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> vykazy = reader.read(DocType.VYKAZY, "src/test/resources/testVykazy.csv");
		
		MapperVykazy mapper = new MapperVykazy();
		
		List<OutData> vykazyOut = mapper.map(vykazy);
		
		MongoConnecter connecter = new MongoConnecter();
		MongoDatabase db = connecter.connect("mongodb://localhost:27017");
		
		WriterVykazy writer = new WriterVykazy();
		writer.write(vykazyOut, db);
		
		MongoCollection<Document> collection = db.getCollection("VykazyPrace");
		
		long count = collection.countDocuments();
		assertEquals(count, 1);
	}

}
