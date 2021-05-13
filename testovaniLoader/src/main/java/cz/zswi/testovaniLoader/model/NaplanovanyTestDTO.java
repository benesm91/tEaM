package cz.zswi.testovaniLoader.model;


/**
 * Objektova DTO trida pro Naplanovany test
 */
public class NaplanovanyTestDTO implements Data {
	private String idTestPripadu;
	private String idMilnik;
	private String poradoveCislo;
	
	
	public String getIdTestPripadu() {
		return idTestPripadu;
	}
	public void setIdTestPripadu(String idTestPripadu) {
		this.idTestPripadu = idTestPripadu;
	}
	public String getIdMilnik() {
		return idMilnik;
	}
	public void setIdMilnik(String idMilnik) {
		this.idMilnik = idMilnik;
	}
	public String getPoradoveCislo() {
		return poradoveCislo;
	}
	public void setPoradoveCislo(String poradoveCislo) {
		this.poradoveCislo = poradoveCislo;
	}
	

}
