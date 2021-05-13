package cz.zswi.testovaniLoader.model;

import java.util.Date;


/**
 * Objektova trida pro Vysledek testu
 * 
 */
public class VysledekTestu implements OutData {
	private int idVysledek;
	private int idMilnik;
	private int idTestPripad;
	private String vysledek;
	private String kod;
	private String nazev;
	private int priorita;
	private String stav;
	private String system;
	private String typTestu;
	private String priznak;
	private String otestoval;
	private int idSkupinyVeSkupine;
	private int idSkupinyTestu;	
	private Date datumDokonceni;
	public int getIdVysledek() {
		return idVysledek;
	}
	public void setIdVysledek(int idVysledek) {
		this.idVysledek = idVysledek;
	}
	public int getIdMilnik() {
		return idMilnik;
	}
	public void setIdMilnik(int idMilnik) {
		this.idMilnik = idMilnik;
	}
	public int getIdTestPripad() {
		return idTestPripad;
	}
	public void setIdTestPripad(int idTestPripad) {
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
	public int getPriorita() {
		return priorita;
	}
	public void setPriorita(int priorita) {
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
	public int getIdSkupinyVeSkupine() {
		return idSkupinyVeSkupine;
	}
	public void setIdSkupinyVeSkupine(int idSkupinyVeSkupine) {
		this.idSkupinyVeSkupine = idSkupinyVeSkupine;
	}
	public int getIdSkupinyTestu() {
		return idSkupinyTestu;
	}
	public void setIdSkupinyTestu(int idSkupinyTestu) {
		this.idSkupinyTestu = idSkupinyTestu;
	}
	public Date getDatumDokonceni() {
		return datumDokonceni;
	}
	public void setDatumDokonceni(Date datumDokonceni) {
		this.datumDokonceni = datumDokonceni;
	}
	
	
}
