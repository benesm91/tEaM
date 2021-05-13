package cz.zswi.vykazyLoader.writers;

import java.util.List;

import org.bson.BsonDateTime;
import org.bson.Document;

import com.mongodb.client.MongoDatabase;

import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.model.Zamestnanec;

/**
 *Trida na zapsani zmapovanych dat zamestnancu do MongoDB
 */
public class WriterZamestnanci implements IMongoWriter {

	
	/**
	 * zapisovani dat o zamestnancich
	 * @param outDataList list zmapovanych dat
	 * @param db jmeno databaze do niz se data zapisuji
	 */
	public void write(List<OutData> outDataList, MongoDatabase db) {
		db.getCollection("Zamestnanci").drop();
		db.createCollection("Zamestnanci");

		for(int i = 0; i < outDataList.size(); i++) {
			Zamestnanec zamestnanec = (Zamestnanec) outDataList.get(i);

			BsonDateTime pomerOd;
			if(zamestnanec.getPomerOd() != null) {
				long millis = zamestnanec.getPomerOd().getTime();           
				pomerOd = new BsonDateTime(millis);
			}
			else pomerOd = null;

			BsonDateTime pomerDo;
			if(zamestnanec.getPomerDo() != null) {
				long millis = zamestnanec.getPomerDo().getTime();           
				pomerDo = new BsonDateTime(millis);
			}
			else pomerDo = null;


			Document doc = new Document("icp", zamestnanec.getIcp())
					.append("jmeno", zamestnanec.getJmeno())
					.append("zkratka", zamestnanec.getZkratka())
					.append("pomerOd", pomerOd)
					.append("pomerDo", pomerDo)
					.append("stredisko", zamestnanec.getStredisko())
					.append("uvazek", zamestnanec.getUvazek())
					.append("funkce", zamestnanec.getFunkce())
					.append("icpVed", zamestnanec.getIcpVed());
			db.getCollection("Zamestnanci").insertOne(doc);

		}

	}
}
