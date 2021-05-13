package cz.zswi.vykazyLoader.readers;

import java.util.List;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.model.Data;

/**
 * Rozhrani ctecich trid
 */
public interface ISourceReader {
	
	/**
	 * Precte data ze zdrojoveho souboru
	 * @param typ souboru
	 * @param resource nazev souboru
	 * @return list prectenych dat
	 */
	public List<Data> read(DocType typ, String resource) throws Exception;
}
