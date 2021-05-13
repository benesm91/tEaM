package cz.zswi.testovaniLoader.readers;

import java.util.List;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.model.Data;

/**
 * Rozhrani cteci tridy
 */
public interface ISourceReader {
	/**
	 * Precte data ze zdrojoveho souboru
	 * @param typ souboru
	 * @param resource nazev souboru
	 * @return list prectenych dat
	 */
	public List<Data> read(DocType typ, String resource);
}
