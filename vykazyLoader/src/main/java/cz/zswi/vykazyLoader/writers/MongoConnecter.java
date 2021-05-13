package cz.zswi.vykazyLoader.writers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;


/**
 * Trida zajistujici pripojeni k MongoDB
 */
public class MongoConnecter {
	
	/**
	 * pripojeni k MongoDB
	 * @return databaze k niz se chceme pripojit
	 * @throws Exception
	 */
	public MongoDatabase connect(String uri) throws Exception{
		MongoClient client = null;
		MongoDatabase db = null;

		client = new MongoClient(new MongoClientURI(uri));
		db = client.getDatabase("VykazyReporting");
		
		return db;
	}

}
