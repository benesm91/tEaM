package cz.zswi.testovaniLoader.mapper;

import java.util.ArrayList;
import java.util.List;

import cz.zswi.testovaniLoader.model.Milnik;
import cz.zswi.testovaniLoader.model.NaplanovanyTest;
import cz.zswi.testovaniLoader.model.OutData;
import cz.zswi.testovaniLoader.model.VysledekTestu;

public class Merger {
	/**
	 * metoda na spojeni vysledku testu a naplanovanych testu do jednoho listu (milniku), spojuji se pres idMilniku
	 * @param resourceMilniky  list milniku
	 * @param resourceNaplanovane list naplanovanych testu 
	 * @param resourceVysledky list vysledku testu
	 */
	public void mergeData(List<OutData> resourceMilniky, List<OutData> resourceNaplanovane, List<OutData> resourceVysledky) {


		for(int i = 0; i < resourceMilniky.size(); i++) {
			Milnik tmpMilnik = (Milnik) resourceMilniky.get(i);
			ArrayList<NaplanovanyTest> tmpNaplanovaneTesty = new ArrayList<NaplanovanyTest>();

			for(int j = 0; j < resourceNaplanovane.size(); j++) {
				NaplanovanyTest tmpNaplanovany = (NaplanovanyTest) resourceNaplanovane.get(j);
				if(tmpMilnik.getId() == tmpNaplanovany.getIdMilnik()) {
					tmpNaplanovaneTesty.add((NaplanovanyTest) resourceNaplanovane.remove(j--));
				}
			}
			tmpMilnik.setNaplanovaneTesty(tmpNaplanovaneTesty);


			ArrayList<VysledekTestu> tmpVysledkyTestu = new ArrayList<VysledekTestu>();

			for(int j = 0; j < resourceVysledky.size(); j++) {
				VysledekTestu tmpVysledek = (VysledekTestu) resourceVysledky.get(j);
				if(tmpMilnik.getId() == tmpVysledek.getIdMilnik()) {
					tmpVysledkyTestu.add((VysledekTestu) resourceVysledky.remove(j--));
				}
			}
			tmpMilnik.setVysledkyTestu(tmpVysledkyTestu);


		}
	}

}
