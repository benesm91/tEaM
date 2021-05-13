package cz.zswi.testovaniLoader;

import cz.zswi.testovaniLoader.readers.CSVSourceReader;
import cz.zswi.testovaniLoader.readers.ISourceReader;

/**
 * Rozhodne o vytvoreni prislusneho readeru podle typu souboru
 */
public class SourceReaderFactory {

	/**
	 * Vrati prislusny IDataReader podle typu souboru
	 * @param typ souboru
	 * @return prislusny IDataReader
	 */
	public static ISourceReader getReader(String typ) {
		if (typ.equals("CSV")) {
			return new CSVSourceReader();
		}
		
		return null;
	}
}

