package cz.zswi.testovaniLoader.model;

/**
 * Objektova DTO trida pro Milnik
 */
public class MilnikDTO implements Data {
	private String id;
	private String kod;
	private String nazev;
	private String system;
	private String datumTermin;
	private String stavMilniku;
	private String cisloHlaseni;
	private String rokHlaseni;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getDatumTermin() {
		return datumTermin;
	}
	public void setDatumTermin(String datumTermin) {
		this.datumTermin = datumTermin;
	}
	public String getStavMilniku() {
		return stavMilniku;
	}
	public void setStavMilniku(String stavMilniku) {
		this.stavMilniku = stavMilniku;
	}
	public String getCisloHlaseni() {
		return cisloHlaseni;
	}
	public void setCisloHlaseni(String cisloHlaseni) {
		this.cisloHlaseni = cisloHlaseni;
	}
	public String getRokHlaseni() {
		return rokHlaseni;
	}
	public void setRokHlaseni(String rokHlaseni) {
		this.rokHlaseni = rokHlaseni;
	}
	
}
