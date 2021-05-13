package cz.zswi.testovaniLoader.readers;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.readers.csv.IDataReader;
import cz.zswi.testovaniLoader.readers.csv.*;

/**
 * Factory trida vytvori IDataReader podle typu dat
 */
public class DataReaderFactory {
	
	/**
	 * Vytvori prislusny IDataReader podle typu dat
	 * @param type typ dat
	 * @return prislusny IDataReader
	 */
	public static IDataReader getReader(DocType type) {
		switch(type) {
		case MILNIK:
			return new MilnikDataReader();
		case NAPLANOVANE:
			return new NaplanovaneDataReader();
		case VYSLEDKY:
			return new VysledkyDataReader();
		}
		return null;
	}
}
