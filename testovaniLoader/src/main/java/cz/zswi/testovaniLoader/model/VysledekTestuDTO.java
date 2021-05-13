package cz.zswi.testovaniLoader.model;

/**
 * Objektova DTO trida pro Vysledek testu
 */
public class VysledekTestuDTO implements Data {
	private String idVysledek;
	private String idMilnik;
	private String idTestPripad;
	private String vysledek;
	private String kod;
	private String nazev;
	private String priorita;
	private String stav;
	private String system;
	private String typTestu;
	private String priznak;
	private String otestoval;
	private String idSkupinyVeSkupine;
	private String idSkupinyTestu;
	private String datumDokonceni;
	
	public String getIdVysledek() {
		return idVysledek;
	}
	public void setIdVysledek(String idVysledek) {
		this.idVysledek = idVysledek;
	}
	public String getIdMilnik() {
		return idMilnik;
	}
	public void setIdMilnik(String idMilnik) {
		this.idMilnik = idMilnik;
	}
	public String getIdTestPripad() {
		return idTestPripad;
	}
	public void setIdTestPripad(String idTestPripad) {
		this.idTestPripad = idTestPripad;
	}
	public String getVysledek() {
		return vysledek;
	}
	public void setVysledek(String vysledek) {
		this.vysledek = vysledek;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public String getPriorita() {
		return priorita;
	}
	public void setPriorita(String priorita) {
		this.priorita = priorita;
	}
	public String getStav() {
		return stav;
	}
	public void setStav(String stav) {
		this.stav = stav;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getTypTestu() {
		return typTestu;
	}
	public void setTypTestu(String typTestu) {
		this.typTestu = typTestu;
	}
	public String getPriznak() {
		return priznak;
	}
	public void setPriznak(String priznak) {
		this.priznak = priznak;
	}
	public String getOtestoval() {
		return otestoval;
	}
	public void setOtestoval(String otestoval) {
		this.otestoval = otestoval;
	}
	public String getIdSkupinyVeSkupine() {
		return idSkupinyVeSkupine;
	}
	public void setIdSkupinyVeSkupine(String idSkupinyVeSkupine) {
		this.idSkupinyVeSkupine = idSkupinyVeSkupine;
	}
	public String getIdSkupinyTestu() {
		return idSkupinyTestu;
	}
	public void setIdSkupinyTestu(String idSkupinyTestu) {
		this.idSkupinyTestu = idSkupinyTestu;
	}
	public String getDatumDokonceni() {
		return datumDokonceni;
	}
	public void setDatumDokonceni(String datumDokonceni) {
		this.datumDokonceni = datumDokonceni;
	}
	
	
	
}
