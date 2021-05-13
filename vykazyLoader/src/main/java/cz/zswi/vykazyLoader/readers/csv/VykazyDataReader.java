package cz.zswi.vykazyLoader.readers.csv;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.VykazDTO;


/**
 * Cteci trida pro data o vykazech prace
 */
public class VykazyDataReader implements IDataReader {

	
	/**
	 * Precte data z predaneho souboru
	 * @param file soubor, ze kterho se cte
	 * @return list prectenych dat
	 */
	@Override
	public List<Data> read(File resource) throws Exception {
		List<Data> vykazy = new ArrayList<Data>();

		Reader in;
		
		try {
			in = new FileReader(resource);
		}
		catch(Exception e) {
			return null;
		}
		
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in); 
		
		for(CSVRecord record : records) {
			VykazDTO vykaz = new VykazDTO();
			vykaz.setIdZaznamu(record.get(0));
			vykaz.setDatumCinnosti(record.get(1));
			vykaz.setOsobniCislo(record.get(2));
			vykaz.setKodPracovnika(record.get(3));
			vykaz.setZakazka(record.get(4));
			vykaz.setPolozka(record.get(5));
			vykaz.setPozice(record.get(6));
			String tmp = record.get(7).replace(',', '.');
			vykaz.setVykazano(tmp);
			vykaz.setCisloHlaseni(record.get(8));
			vykaz.setCisloUkol(record.get(9));
			vykaz.setPopisCinnosti(record.get(10));
			vykazy.add(vykaz);
		}

		return vykazy;
	}

}
