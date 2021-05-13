package cz.zswi.vykazyLoader.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.model.Zamestnanec;
import cz.zswi.vykazyLoader.model.ZamestnanecDTO;

/**
 *Trida na mapovani dat o zamestnancich 
 *
 */
public class MapperZamestnanci implements IMapper{

	/**
	 * Provede mapovani dat 
	 * @param list dat ktere se maji zmapovat
	 * @return list zmapovanych dat 
	 */
	public List<OutData> map(List<Data> dataList) throws Exception {
		List<OutData> zamestnanci = new ArrayList<OutData>();

		for(int i = 0; i < dataList.size(); i++) {
			Zamestnanec zamestnanec = new Zamestnanec();

			ZamestnanecDTO temp = (ZamestnanecDTO) dataList.get(i);

			if(!temp.getIcp().equals("")) zamestnanec.setIcp(Integer.parseInt(temp.getIcp()));
			if(!temp.getJmeno().equals("")) zamestnanec.setJmeno(temp.getJmeno());
			if(!temp.getZkratka().equals("")) zamestnanec.setZkratka(temp.getZkratka());

			//pomer od

			String myDate = temp.getPomerOd();
			if(!myDate.equals("")) zamestnanec.setPomerOd(getDate(myDate));


			//pomer do

			myDate = temp.getPomerDo();
			if(!myDate.equals("")) zamestnanec.setPomerDo(getDate(myDate));



			if(!temp.getStredisko().equals("")) zamestnanec.setStredisko(temp.getStredisko());
			if(!temp.getUvazek().equals("")) zamestnanec.setUvazek(Double.parseDouble(temp.getUvazek()));
			if(!temp.getFunkce().equals("")) zamestnanec.setFunkce(temp.getFunkce());
			if(!temp.getIcpVed().equals("")) zamestnanec.setIcpVed(Integer.parseInt(temp.getIcpVed()));

			zamestnanci.add(zamestnanec);

		}
		return zamestnanci;

	}
	
	
	/**
	 * pomocna metoda na parsovani Date
	 * @param myDate datum ve forme retezce
	 * @return datum ve forme Date
	 */
	private Date getDate(String myDate) {
		myDate += " 02";
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH");
		Date date = null;
		try {
			date = sdf.parse(myDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

}
