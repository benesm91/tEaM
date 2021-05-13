package cz.zswi.testovaniLoader;

import java.util.List;
import java.util.Scanner;

import com.mongodb.client.MongoDatabase;

import cz.zswi.testovaniLoader.mapper.IMapper;
import cz.zswi.testovaniLoader.mapper.MapperFactory;
import cz.zswi.testovaniLoader.mapper.Merger;
import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.readers.ISourceReader;
import cz.zswi.testovaniLoader.writers.MongoWriter;


/**
 * Ridici trida programu
 */
public class TestovaniLoadManager {
	/**
	 * Zajisti zpracovani predanych parametru
	 * @param typ souboru
	 * @param souborMilnik zaznamy o milnicich
	 * @param souborNaplanovane zaznamy o naplanovanych testech
	 * @param souborVysledek zaznamy o vysledcich testu
	 */
	public void load(String typ, String souborMilnik, String souborNaplanovane, String souborVysledek) {
		/* cteni dat */
		ISourceReader reader = SourceReaderFactory.getReader(typ);
		if(reader == null) return;
		List<Data> dataMilniky = reader.read(DocType.MILNIK, souborMilnik);
		List<Data> dataNaplanovane = reader.read(DocType.NAPLANOVANE, souborNaplanovane);
		List<Data> dataVysledky = reader.read(DocType.VYSLEDKY, souborVysledek);
		if((dataMilniky == null) || (dataNaplanovane == null) || (dataVysledky == null)) return;

		/* mapovani dat */
		IMapper mapper;
		mapper = MapperFactory.getMapper(DocType.MILNIK);
		List<OutData> dataMilnikyOut = mapper.map(dataMilniky);
		mapper = MapperFactory.getMapper(DocType.NAPLANOVANE);
		List<OutData> dataNaplanovaneOut = mapper.map(dataNaplanovane);
		mapper = MapperFactory.getMapper(DocType.VYSLEDKY);
		List<OutData> dataVysledkyOut = mapper.map(dataVysledky);
		if((dataMilnikyOut == null) || (dataNaplanovaneOut == null) || (dataVysledkyOut == null)) return;

		/* slouceni dat */
		Merger merger = new Merger();
		merger.mergeData(dataMilnikyOut, dataNaplanovaneOut, dataVysledkyOut);

		/* zapis dat do databaze */
		MongoWriter writer = new MongoWriter();
		System.out.println("Zadej URI: ");
		Scanner sc = new Scanner(System.in);
		String uri = sc.nextLine();
		sc.close();
		MongoDatabase db = writer.connectToDB(uri);
		if(db == null) return;
		writer.write(dataMilnikyOut, db);
	}
}
