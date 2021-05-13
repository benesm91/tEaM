package cz.zswi.vykazyLoader.writers;

import java.util.List;

import com.mongodb.client.MongoDatabase;

import cz.zswi.vykazyLoader.model.OutData;

/**
 *Rozhrani zapisovaci tridy to MongoDB
 */
public interface IMongoWriter {
	
	/**
	 * zapise data do MongoDB
	 * @param outDataList list dat ktere se maji zapsat
	 * @param db jmeno databaze
	 */
	public void write(List<OutData> outDataList, MongoDatabase db);
}
