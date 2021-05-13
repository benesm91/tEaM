package cz.zswi.testovaniLoader.readers.csv;

import java.io.File;
import java.util.List;

import cz.zswi.testovaniLoader.model.Data;


/**
 * 
 * rozhrani ctecich trid
 *
 */
public interface IDataReader {
	public List<Data> read(File file);
}
