package cz.zswi.testovaniLoader.writers;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonDateTime;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import cz.zswi.testovaniLoader.model.Milnik;
import cz.zswi.testovaniLoader.model.NaplanovanyTest;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.model.VysledekTestu;

/**
 * 
 * trida na zapis dat to MongoDB
 *
 */
public class MongoWriter {
	/**
	 * pripojeni k databazi
	 * 
	 * @param uri
	 */
	public MongoDatabase connectToDB(String uri) {

		MongoClient client = new MongoClient(new MongoClientURI(uri));
		MongoDatabase db = client.getDatabase("TestReporting");
		if (db == null)
			System.err.println("Error: Pripojeni k databazi se nezdarilo");

		return db;
	}

	/**
	 * zapis zmergovanych dat do MongoDB
	 * 
	 * @param outDataList - List milniku mergovanych s naplanovanymi testy a
	 *                    vysledkami testu
	 */
	public void write(List<OutData> outDataList, MongoDatabase db) {
		db.getCollection("Testy").drop();
		db.createCollection("Testy");

		for (int i = 0; i < outDataList.size(); i++) {

			Milnik tmpMilnik = (Milnik) outDataList.get(i);

			long millis = tmpMilnik.getDatumTermin().getTime();
			BsonDateTime datumTermin = new BsonDateTime(millis);

			Document doc = new Document("idMilniku", tmpMilnik.getId()).append("kod", tmpMilnik.getKod())
					.append("nazev", tmpMilnik.getNazev()).append("system", tmpMilnik.getSystem())
					.append("datumTermin", datumTermin).append("stavMilniku", tmpMilnik.getStavMilniku())
					.append("cisloHlaseni", tmpMilnik.getCisloHlaseni())
					.append("rokHlaseni", tmpMilnik.getRokHlaseni());

			db.getCollection("Testy").insertOne(doc);
			writeNaplanovane(doc, tmpMilnik, db);
			writeVysledky(doc, tmpMilnik, db);

		}

	}

	/**
	 * zapis pole vysledku testu do MongoDB
	 * 
	 * @param doc       nazev dokumentu v MongoDB
	 * @param tmpMilnik pomocny docasny list Milniku
	 */
	private void writeVysledky(Document doc, Milnik tmpMilnik, MongoDatabase db) {
		ArrayList<VysledekTestu> tmpList = tmpMilnik.getVysledkyTestu();

		for (int i = 0; i < tmpList.size(); i++) {
			VysledekTestu tmpVysledek = (VysledekTestu) tmpList.get(i);

			Date tmpDate = tmpVysledek.getDatumDokonceni();

			BsonDateTime datumDokonceni = null;
			if (tmpDate != null) {
				long millis = tmpDate.getTime();
				datumDokonceni = new BsonDateTime(millis);
			}

			Document vysledek = new Document().append("idVysledek", tmpVysledek.getIdVysledek())
					.append("idTestPripad", tmpVysledek.getIdTestPripad()).append("vysledek", tmpVysledek.getVysledek())
					.append("kod", tmpVysledek.getKod()).append("nazev", tmpVysledek.getNazev())
					.append("priorita", tmpVysledek.getPriorita()).append("stav", tmpVysledek.getStav())
					.append("system", tmpVysledek.getSystem()).append("typTest", tmpVysledek.getTypTestu())
					.append("priznak", tmpVysledek.getPriznak()).append("otestoval", tmpVysledek.getOtestoval())
					.append("idSkupinyVeSkupine", tmpVysledek.getIdSkupinyVeSkupine())
					.append("idSkupinyTestu", tmpVysledek.getIdSkupinyTestu()).append("datumDokonceni", datumDokonceni);

			db.getCollection("Testy").updateOne(doc, Updates.addToSet("vysledkyTestu", vysledek));
		}

	}

	/**
	 * zapis pole naplanovanych testu do Mongodb
	 * 
	 * @param doc       nazev dokumentu v MongoDB
	 * @param tmpMilnik - pomocny docasny list milniku
	 */
	private void writeNaplanovane(Document doc, Milnik tmpMilnik, MongoDatabase db) {
		ArrayList<NaplanovanyTest> tmpList = tmpMilnik.getNaplanovaneTesty();

		for (int i = 0; i < tmpList.size(); i++) {
			NaplanovanyTest tmpNaplanovany = (NaplanovanyTest) tmpList.get(i);
			Document naplanovany = new Document().append("idTestPripade", tmpNaplanovany.getIdTestPripadu())
					.append("poradoveCislo", tmpNaplanovany.getPoradoveCislo());

			db.getCollection("Testy").updateOne(doc, Updates.addToSet("naplanovaneTesty", naplanovany));
		}

	}

}
