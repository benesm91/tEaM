package cz.zswi.testovaniLoader.readers.csv;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.NaplanovanyTestDTO;

/**
 * Cteci trida pro data o naplanovanych testech
 */
public class NaplanovaneDataReader implements IDataReader {
	/**
	 * Precte data z predaneho souboru
	 * @param file soubor, ze kterho se cte
	 * @return list prectenych dat
	 */
	@Override
	public List<Data> read(File file) {
		List<Data> naplanovaneTesty = new ArrayList<Data>();

		Reader in;
		Iterable<CSVRecord> records = null;
		try {
			in = new FileReader(file);
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		} catch (Exception e) {
			System.err.println("Error: Chyba pri cteni dat ze souboru " + file);
			return null;
		}
		
		
		for(CSVRecord record : records) {
			NaplanovanyTestDTO naplanovanyTest = new NaplanovanyTestDTO();
			naplanovanyTest.setIdTestPripadu(record.get(0));
			naplanovanyTest.setIdMilnik(record.get(1));
			naplanovanyTest.setPoradoveCislo(record.get(2));
			
			naplanovaneTesty.add(naplanovanyTest);
			
		}
		return naplanovaneTesty;
	}

}
