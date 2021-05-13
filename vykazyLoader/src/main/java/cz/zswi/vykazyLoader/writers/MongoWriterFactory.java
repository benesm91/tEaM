package cz.zswi.vykazyLoader.writers;

import cz.zswi.vykazyLoader.DocType;

/**
 * Factory trida vytvori IMongoWriter podle typu dat
 */
public class MongoWriterFactory {
	
	/**
	 * ziskani writeru podle typu dat
	 * @param type - typ dat
	 */
	public static IMongoWriter getWriter(DocType type) {
		switch(type) {
		case VYKAZY:
			return new WriterVykazy();
		case ZAMESTNANCI:
			return new WriterZamestnanci();
		default:
			return null;
		}

	}
}
