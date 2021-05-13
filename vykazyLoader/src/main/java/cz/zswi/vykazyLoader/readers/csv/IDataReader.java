package cz.zswi.vykazyLoader.readers.csv;

import java.io.File;
import java.util.List;

import cz.zswi.vykazyLoader.model.*;

/**
 *Rozhrani ctecich trid
 */
public interface IDataReader {
	
	/**
	 * Precte data z predaneho souboru
	 * @param resource soubor, ze kterho se cte
	 * @return list prectenych dat
	 */
	public List<Data> read(File resource) throws Exception;
	
}
