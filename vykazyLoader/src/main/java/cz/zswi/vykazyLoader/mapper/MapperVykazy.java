package cz.zswi.vykazyLoader.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.zswi.vykazyLoader.model.Data;
import cz.zswi.vykazyLoader.model.OutData;
import cz.zswi.vykazyLoader.model.Vykaz;
import cz.zswi.vykazyLoader.model.VykazDTO;


/**
 *Trida na mapovani dat o vykazech prace 
 *
 */
public class MapperVykazy implements IMapper{

	
	/**
	 * Provede mapovani dat 
	 * @param list dat ktere se maji zmapovat
	 * @return list zmapovanych dat 
	 */
	public List<OutData> map(List<Data> dataList) throws Exception {
		List<OutData> vykazy = new ArrayList<OutData>();

		for(int i = 0; i < dataList.size(); i++) {
			Vykaz vykaz = new Vykaz();
			VykazDTO temp = (VykazDTO) dataList.get(i);

			if(!temp.getIdZaznamu().equals("")) vykaz.setIdZaznamu(Long.parseLong(temp.getIdZaznamu()));

			String myDate = temp.getDatumCinnosti();
			if(!myDate.equals("")) vykaz.setDatumCinnosti(getDate(myDate));

			if(!temp.getOsobniCislo().equals("")) vykaz.setOsobniCislo(temp.getOsobniCislo());
			if(!temp.getKodPracovnika().equals("")) vykaz.setKodPracovnika(temp.getKodPracovnika());
			if(!temp.getZakazka().equals("")) vykaz.setZakazka(temp.getZakazka());
			if(!temp.getPolozka().equals("")) vykaz.setPolozka(Integer.parseInt(temp.getPolozka()));
			if(!temp.getPozice().equals("")) vykaz.setPozice(Integer.parseInt(temp.getPozice()));
			if(!temp.getVykazano().equals("")) vykaz.setVykazano(Double.parseDouble(temp.getVykazano()));
			if(!temp.getCisloHlaseni().equals("")) vykaz.setCisloHlaseni(temp.getCisloHlaseni());
			if(!temp.getCisloUkol().equals("")) vykaz.setCisloUkol(temp.getCisloUkol());
			if(!temp.getPopisCinnosti().equals("")) vykaz.setPopisCinnosti(temp.getPopisCinnosti());

			vykazy.add(vykaz);
		}


		return vykazy;
	}
	
	/**
	 * pomocna metoda na parsovani Date
	 * @param myDate - datum ve forme retezce
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
