package cz.zswi.vykazyLoader.readers;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.readers.csv.IDataReader;
import cz.zswi.vykazyLoader.readers.csv.VykazyDataReader;
import cz.zswi.vykazyLoader.readers.csv.ZamestnanciDataReader;


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
		case VYKAZY:
			return new VykazyDataReader();
		case ZAMESTNANCI:
			return new ZamestnanciDataReader();
		default:
			return null;
		}
		
	}


}
