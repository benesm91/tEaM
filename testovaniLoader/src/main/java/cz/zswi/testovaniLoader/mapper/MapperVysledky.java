package cz.zswi.testovaniLoader.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.model.VysledekTestu;
import cz.zswi.testovaniLoader.model.VysledekTestuDTO;

/**
 * Mapuje data o vysledcich testu
 */
public class MapperVysledky implements IMapper {
	
	/**
	 * Provede mapování dat
	 * @param resource List dat
	 * @return list zmapovanych dat
	 */
	public List<OutData> map(List<Data> resource) {
		List<OutData> vysledkyOut = new ArrayList<OutData>();

		for(int i = 0; i < resource.size(); i++) {
			VysledekTestu vysledek = new VysledekTestu();
			VysledekTestuDTO tmp = (VysledekTestuDTO) resource.get(i);

			if(!tmp.getIdVysledek().equals("")) vysledek.setIdVysledek(Integer.parseInt(tmp.getIdVysledek()));
			if(!tmp.getIdMilnik().equals("")) vysledek.setIdMilnik(Integer.parseInt(tmp.getIdMilnik()));
			if(!tmp.getIdTestPripad().equals("")) vysledek.setIdTestPripad(Integer.parseInt(tmp.getIdTestPripad()));
			vysledek.setVysledek(tmp.getVysledek());
			vysledek.setKod(tmp.getKod());
			vysledek.setNazev(tmp.getNazev());
			if(!tmp.getPriorita().equals("")) vysledek.setPriorita(Integer.parseInt(tmp.getPriorita()));
			vysledek.setStav(tmp.getStav());
			vysledek.setSystem(tmp.getSystem());
			vysledek.setTypTestu(tmp.getTypTestu());
			vysledek.setPriznak(tmp.getPriznak());
			vysledek.setOtestoval(tmp.getOtestoval());
			if(!tmp.getIdSkupinyVeSkupine().equals("")) vysledek.setIdSkupinyVeSkupine(Integer.parseInt(tmp.getIdSkupinyVeSkupine()));
			if(!tmp.getIdSkupinyTestu().equals("")) vysledek.setIdSkupinyTestu(Integer.parseInt(tmp.getIdSkupinyTestu()));
			if(!tmp.getDatumDokonceni().equals("")) vysledek.setDatumDokonceni(getDateAndTime(tmp.getDatumDokonceni()));

			vysledkyOut.add(vysledek);
		}

		return vysledkyOut;
	}
	
	/**
	 * Vrati Date datum a cas predane jako String
	 * @param myDate String
	 * @return Date
	 */
	private Date getDateAndTime(String myDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(myDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}
}
