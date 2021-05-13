package cz.zswi.vykazyLoader.readers.csv;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.ZamestnanecDTO;

/**
 * Cteci trida pro data o zamestnancich
 */
public class ZamestnanciDataReader implements IDataReader {
	
	
	/**
	 * Precte data z predaneho souboru
	 * @param file soubor, ze kterho se cte
	 * @return list prectenych dat
	 */
	@Override
	public List<Data> read(File resource) throws Exception {
		List<Data> zamestnanci = new ArrayList<Data>();

		Reader in;
		
		try {
			in = new FileReader(resource);
		}
		catch(Exception e) {
			return null;
		}
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in); 
		
		for(CSVRecord record : records) {
			ZamestnanecDTO zamestnanec = new ZamestnanecDTO();
			zamestnanec.setIcp(record.get(0));
			zamestnanec.setJmeno(record.get(1));
			zamestnanec.setZkratka(record.get(2));
			zamestnanec.setPomerOd(record.get(5));
			zamestnanec.setPomerDo(record.get(6));
			zamestnanec.setStredisko(record.get(7));
			String tmp = record.get(8).replace(',', '.');
			zamestnanec.setUvazek(tmp);
			zamestnanec.setFunkce(record.get(9));
			zamestnanec.setIcpVed(record.get(10));
			zamestnanci.add(zamestnanec);
		}

		return zamestnanci;
	}

}
