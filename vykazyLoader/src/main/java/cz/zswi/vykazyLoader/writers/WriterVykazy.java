package cz.zswi.vykazyLoader.writers;

import java.util.List;

import org.bson.BsonDateTime;
import org.bson.Document;

import com.mongodb.client.MongoDatabase;

import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.model.Vykaz;


/**
 *Trida na zapsani zmapovanych dat vykazu do MongoDB
 */
public class WriterVykazy implements IMongoWriter{
	
	/**
	 * zapisovani dat vykazu
	 * @param outDataList list zmapovanych dat
	 * @param db jmeno databaze do niz se data zapisuji
	 */
	public void write(List<OutData> outDataList, MongoDatabase db) {
		db.getCollection("VykazyPrace").drop();
		db.createCollection("VykazyPrace");

		for(int i = 0; i < outDataList.size(); i++) {

			Vykaz vykaz = (Vykaz) outDataList.get(i);


			long millis = vykaz.getDatumCinnosti().getTime();           
			BsonDateTime datumCinnosti = new BsonDateTime(millis);

			Document doc = new Document("idZaznamu", vykaz.getIdZaznamu())
					.append("datumCinnosti", datumCinnosti)
					.append("osobniCislo", vykaz.getOsobniCislo())
					.append("kodPracovnika", vykaz.getKodPracovnika())
					.append("zakazka", vykaz.getZakazka())
					.append("polozka", vykaz.getPolozka())
					.append("pozice", vykaz.getPozice())
					.append("vykazano", vykaz.getVykazano())
					.append("cisloHlaseni", vykaz.getCisloHlaseni())
					.append("cisloUkol", vykaz.getCisloUkol())
					.append("popisCinnosti", vykaz.getPopisCinnosti());
			db.getCollection("VykazyPrace").insertOne(doc);

		}

	}
}
