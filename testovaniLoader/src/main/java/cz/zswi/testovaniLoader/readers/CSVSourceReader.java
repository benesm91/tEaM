package cz.zswi.testovaniLoader.readers;

import java.io.File;
import java.util.List;

import cz.zswi.testovaniLoader.DocType;
import cz.zswi.testovaniLoader.model.*;
import cz.zswi.testovaniLoader.readers.csv.IDataReader;

/**
 * 
 * trida na nacitani csv souboru a jejich docasne ulozeni do mopocnych objektu
 *
 */
public class CSVSourceReader implements ISourceReader {


	/**
	 * metoda cteni dat,podle prvniho pismena nazvu souboru se rozhoduje, jaky soubor se bude cist
	 */
	@Override
	public List<Data> read(DocType type, String resource) {
		File file = new File(resource);
		IDataReader reader;

		reader = DataReaderFactory.getReader(type);
		return reader.read(file);
	}


}