package cz.zswi.vykazyLoader.readers;

import java.io.File;
import java.util.List;

import cz.zswi.vykazyLoader.DocType;
import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.readers.csv.IDataReader;


/**
 * 
 * trida na nacitani csv souboru a jejich docasne ulozeni do pomocnych objektu
 *
 */
public class CSVSourceReader implements ISourceReader {

	/**
	 * metoda cteni dat,podle prvniho pismena nazvu souboru se rozhoduje, jaky soubor se bude cist
	 * @throws Exception 
	 */
	@Override
	public List<Data> read(DocType type, String resource) throws Exception {
		File file = new File(resource);
		IDataReader reader;

		reader = DataReaderFactory.getReader(type);
		if(reader == null) return null;
		return reader.read(file);
	}
}
