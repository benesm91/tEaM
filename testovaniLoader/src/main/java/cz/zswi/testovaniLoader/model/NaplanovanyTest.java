package cz.zswi.testovaniLoader.model;

/**
 * Objektova trida pro Naplanovany test
 */
public class NaplanovanyTest implements OutData {
	private int idTestPripadu;
	private int idMilnik;
	private int poradoveCislo;
	
	
	public int getIdTestPripadu() {
		return idTestPripadu;
	}
	public void setIdTestPripadu(int idTestPripadu) {
		this.idTestPripadu = idTestPripadu;
	}
	public int getIdMilnik() {
		return idMilnik;
	}
	public void setIdMilnik(int idMilnik) {
		this.idMilnik = idMilnik;
	}
	public int getPoradoveCislo() {
		return poradoveCislo;
	}
	public void setPoradoveCislo(int poradoveCislo) {
		this.poradoveCislo = poradoveCislo;
	}
	

}
