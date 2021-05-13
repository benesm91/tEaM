package cz.zswi.testovaniLoader.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.Milnik;
import cz.zswi.testovaniLoader.model.MilnikDTO;
import cz.zswi.testovaniLoader.model.OutData;

/**
 * Mapuje data o milnicich 
 */
public class MapperMilnik implements IMapper {

	/**
	 * Provede mapování dat
	 * @param resource List dat
	 * @return list zmapovanych dat
	 */
	@Override
	public List<OutData> map(List<Data> resource) {
		List<OutData> milnikyOut = new ArrayList<OutData>();

		for(int i = 0; i < resource.size(); i++) {
			Milnik milnik = new Milnik();
			MilnikDTO tmp = (MilnikDTO) resource.get(i);

			if(!tmp.getId().equals(""))milnik.setId(Integer.parseInt(tmp.getId()));
			milnik.setKod(tmp.getKod());
			milnik.setNazev(tmp.getNazev());
			milnik.setSystem(tmp.getSystem());
			String myDate = tmp.getDatumTermin();
			milnik.setDatumTermin(getDate(myDate));
			milnik.setStavMilniku(tmp.getStavMilniku());
			if(!tmp.getCisloHlaseni().equals("")) milnik.setCisloHlaseni(Integer.parseInt(tmp.getCisloHlaseni()));
			if(!tmp.getRokHlaseni().equals("")) milnik.setRokHlaseni(Integer.parseInt(tmp.getRokHlaseni()));

			milnikyOut.add(milnik);
		}

		return milnikyOut;
	}
	
	/**
	 * Zpracuje datum predane jako retezec a vrati date
	 * @param myDate retezec
	 * @return datum jako Date
	 */
	private Date getDate(String myDate) {
		myDate += " 01";
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
