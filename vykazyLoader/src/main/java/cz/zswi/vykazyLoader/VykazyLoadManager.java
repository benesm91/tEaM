package cz.zswi.vykazyLoader;

import java.util.List;
import java.util.Scanner;

import com.mongodb.client.MongoDatabase;

import cz.zswi.vykazyLoader.mapper.IMapper;
import cz.zswi.vykazyLoader.mapper.MapperFactory;
import cz.zswi.vykazyLoader.readers.ISourceReader;
import cz.zswi.vykazyLoader.writers.IMongoWriter;
import cz.zswi.vykazyLoader.writers.MongoConnecter;
import cz.zswi.vykazyLoader.writers.MongoWriterFactory;
import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;

/**
 * Ridici trida programu
 */
public class VykazyLoadManager {

	

	public MongoDatabase connectToMongoDB() {
		System.out.print("Zadej URI: ");
		Scanner sc = new Scanner(System.in);
		String uri = sc.nextLine();
		MongoConnecter connecter = new MongoConnecter();
		sc.close();
		try {
			return connecter.connect(uri);
		}
		catch(Exception e) {
			System.err.println("Error: chyba pri pripojovani k databazi");
			return null;
		}
	}

	/**
	 * Zajisti zpracovani predanych parametru
	 * @param typ souboru
	 * @param souborVykazy zaznamy o vykazech prace
	 * @param souborZamestnanci zaznamy o zamestnancich
	 */
	public void load(String typ, String souborVykazy, String souborZamestnanci) throws Exception{
		
		/*cteni dat*/
		ISourceReader reader = SourceReaderFactory.getReader(typ);
		if(reader == null) return;
		List<Data> dataVykazy = reader.read(DocType.VYKAZY, souborVykazy);
		List<Data> dataZamestnanci = reader.read(DocType.ZAMESTNANCI, souborZamestnanci);
		if((dataVykazy == null) || (dataZamestnanci == null)) return;
		
		/*mapovani dat*/
		IMapper mapper;
		mapper = MapperFactory.getMapper(DocType.VYKAZY);
		List<OutData> dataOutVykazy = mapper.map(dataVykazy);
		mapper = MapperFactory.getMapper(DocType.ZAMESTNANCI);
		List<OutData> dataOutZamestnanci = mapper.map(dataZamestnanci);
		if((dataOutVykazy == null) || (dataOutZamestnanci == null)) return;
		
		/*pripojeni k databazi*/
		MongoDatabase db = connectToMongoDB();
		if(db == null) return;
		
		/*zapis dat do databaze*/
		IMongoWriter writer;
		writer = MongoWriterFactory.getWriter(DocType.VYKAZY);
		writer.write(dataOutVykazy, db);
		writer = MongoWriterFactory.getWriter(DocType.ZAMESTNANCI);
		writer.write(dataOutZamestnanci, db);

	}
}
