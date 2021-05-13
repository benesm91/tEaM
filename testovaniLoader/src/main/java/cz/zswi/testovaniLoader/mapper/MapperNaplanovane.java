package cz.zswi.testovaniLoader.mapper;

import java.util.ArrayList;
import java.util.List;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.NaplanovanyTest;
import cz.zswi.testovaniLoader.model.NaplanovanyTestDTO;
import cz.zswi.testovaniLoader.model.OutData;

/**
 * Mapuje data o naplanovanych testech
 */
public class MapperNaplanovane implements IMapper {

	/**
	 * Provede mapování dat
	 * @param resource List dat
	 * @return list zmapovanych dat
	 */
	@Override
	public List<OutData> map(List<Data> resource) {
		List<OutData> naplanovaneOut = new ArrayList<OutData>();

		for(int i = 0; i < resource.size(); i++) {
			NaplanovanyTest naplanovany = new NaplanovanyTest();
			NaplanovanyTestDTO tmp = (NaplanovanyTestDTO) resource.get(i);

			if(!tmp.getIdTestPripadu().equals("")) naplanovany.setIdTestPripadu(Integer.parseInt(tmp.getIdTestPripadu()));
			if(!tmp.getIdMilnik().equals("")) naplanovany.setIdMilnik(Integer.parseInt(tmp.getIdMilnik()));
			if(!tmp.getPoradoveCislo().equals("")) naplanovany.setPoradoveCislo(Integer.parseInt(tmp.getPoradoveCislo()));

			naplanovaneOut.add(naplanovany);
		}

		return naplanovaneOut;
	}
}
