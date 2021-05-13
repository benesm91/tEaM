package cz.zswi.vykazyLoader;

import cz.zswi.vykazyLoader.readers.CSVSourceReader;
import cz.zswi.vykazyLoader.readers.ISourceReader;

/**
 * Rozhodne o vytvoreni prislusneho readeru podle typu souboru
 */
public class SourceReaderFactory {


	/**
	 * Vrati prislusny ISourceReader podle typu souboru
	 * @param typ souboru
	 * @return prislusny ISourceReader
	 */
	public static ISourceReader getReader(String typ) throws Exception {
		if (typ.equals("CSV")) {
			return new CSVSourceReader();
		}
		else {
			System.err.println("Error: neplatny zdroj dat");
			return null;
		}
	}
}
