package cz.zswi.vykazyLoader.writers;

import static org.junit.Assert.*;

import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.mapper.MapperZamestnanci;
import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.readers.CSVSourceReader;

public class WriterZamestnanciTest {

	@Test
	public void testWrite() throws Exception {
		CSVSourceReader reader = new CSVSourceReader();
		List<Data> zam = reader.read(DocType.ZAMESTNANCI, "src/test/resources/testZamestnanci.csv");
		
		MapperZamestnanci mapper = new MapperZamestnanci();
		
		List<OutData> zamOut = mapper.map(zam);
		
		MongoConnecter connecter = new MongoConnecter();
		MongoDatabase db = connecter.connect("mongodb://localhost:27017");
		
		WriterZamestnanci writer = new WriterZamestnanci();
		writer.write(zamOut, db);
		
		MongoCollection<Document> collection = db.getCollection("Zamestnanci");
		
		long count = collection.countDocuments();
		assertEquals(count, 1);
	}

}
