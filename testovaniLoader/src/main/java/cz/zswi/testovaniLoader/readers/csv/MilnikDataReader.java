package cz.zswi.testovaniLoader.readers.csv;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.MilnikDTO;

/**
 * Cteci trida pro data o milnicich 
 */
public class MilnikDataReader implements IDataReader{
	/**
	 * Precte data z predaneho souboru
	 * @param file soubor, ze kterho se cte
	 * @return list prectenych dat
	 */
	@Override
	public List<Data> read(File file) {

		List<Data> milniky = new ArrayList<Data>();

		
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
			MilnikDTO milnik = new MilnikDTO();
			milnik.setId(record.get(0));
			milnik.setKod(record.get(1));
			milnik.setNazev(record.get(2));
			milnik.setSystem(record.get(3));
			milnik.setDatumTermin(record.get(4));
			milnik.setStavMilniku(record.get(5));
			milnik.setCisloHlaseni(record.get(6));
			milnik.setRokHlaseni(record.get(7));

			milniky.add(milnik);

		}
		return milniky;
	}


}
