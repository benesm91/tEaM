package cz.zswi.vykazyLoader.writers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mongodb.client.MongoDatabase;

public class MongoConnecterTest {

	@Test
	public void testConnect() {
		MongoConnecter connecter = new MongoConnecter();
		MongoDatabase db = null;
		try {
			db = connecter.connect("mongodb://localhost:27017");
		} catch (Exception e) {
			fail();
		}
		
		assertEquals(db.getName(), "VykazyReporting");
	}

}
