package cz.zswi.testovaniLoader.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Objektova trida pro Milnik
 */
public class Milnik implements OutData {
	private int id;
	private String kod;
	private String nazev;
	private String system;
	private Date datumTermin;
	private String stavMilniku;
	private int cisloHlaseni;
	private int rokHlaseni;
	private ArrayList<NaplanovanyTest> naplanovaneTesty;
	private ArrayList<VysledekTestu> vysledkyTestu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getDatumTermin() {
		return datumTermin;
	}
	public void setDatumTermin(Date datumTermin) {
		this.datumTermin = datumTermin;
	}
	public String getStavMilniku() {
		return stavMilniku;
	}
	public void setStavMilniku(String stavMilniku) {
		this.stavMilniku = stavMilniku;
	}
	public int getCisloHlaseni() {
		return cisloHlaseni;
	}
	public void setCisloHlaseni(int cisloHlaseni) {
		this.cisloHlaseni = cisloHlaseni;
	}
	public int getRokHlaseni() {
		return rokHlaseni;
	}
	public void setRokHlaseni(int rokHlaseni) {
		this.rokHlaseni = rokHlaseni;
	}
	
	public ArrayList<NaplanovanyTest> getNaplanovaneTesty() {
		return naplanovaneTesty;
	}
	public void setNaplanovaneTesty(ArrayList<NaplanovanyTest> naplanovaneTesty) {
		this.naplanovaneTesty = naplanovaneTesty;
	}
	public ArrayList<VysledekTestu> getVysledkyTestu() {
		return vysledkyTestu;
	}
	public void setVysledkyTestu(ArrayList<VysledekTestu> vysledkyTestu) {
		this.vysledkyTestu = vysledkyTestu;
	}
	
}
