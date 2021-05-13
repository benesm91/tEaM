package cz.zswi.testovaniLoader.readers.csv;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.VysledekTestuDTO;

/**
 * Cteci trida pro data o vysledcich testu
 */
public class VysledkyDataReader implements IDataReader {
	/**
	 * Precte data z predaneho souboru
	 * @param file soubor, ze kterho se cte
	 * @return list prectenych dat
	 */
	@Override
	public List<Data> read(File file) {
		List<Data> vysledky = new ArrayList<Data>();

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
			VysledekTestuDTO vysledek = new VysledekTestuDTO();
			vysledek.setIdVysledek(record.get(0));
			vysledek.setIdMilnik(record.get(1));
			vysledek.setIdTestPripad(record.get(2));
			vysledek.setVysledek(record.get(3));
			vysledek.setKod(record.get(4));
			vysledek.setNazev(record.get(5));
			vysledek.setPriorita(record.get(6));
			vysledek.setStav(record.get(7));
			vysledek.setSystem(record.get(8));
			vysledek.setTypTestu(record.get(9));
			vysledek.setPriznak(record.get(10));
			vysledek.setOtestoval(record.get(11));
			vysledek.setIdSkupinyVeSkupine(record.get(12));
			vysledek.setIdSkupinyTestu(record.get(13));
			vysledek.setDatumDokonceni(record.get(14));

			vysledky.add(vysledek);

		}
		return vysledky;
	}

}
