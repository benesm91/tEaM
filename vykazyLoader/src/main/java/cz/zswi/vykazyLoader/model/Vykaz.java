package cz.zswi.vykazyLoader.model;

import java.util.Date;

/**
 * Objektova trida pro vykazy prace
 */
public class Vykaz implements OutData{
	
	private long idZaznamu;
	private Date datumCinnosti;
	private String osobniCislo;
	private String kodPracovnika;
	private String zakazka;
	private int polozka;
	private int pozice;
	private double vykazano;
	private String cisloHlaseni;
	private String cisloUkol;
	private String popisCinnosti;
	public long getIdZaznamu() {
		return idZaznamu;
	}
	public void setIdZaznamu(long idZaznamu) {
		this.idZaznamu = idZaznamu;
	}
	public Date getDatumCinnosti() {
		return datumCinnosti;
	}
	public void setDatumCinnosti(Date datumCinnosti) {
		this.datumCinnosti = datumCinnosti;
	}
	public String getOsobniCislo() {
		return osobniCislo;
	}
	public void setOsobniCislo(String osobniCislo) {
		this.osobniCislo = osobniCislo;
	}
	public String getKodPracovnika() {
		return kodPracovnika;
	}
	public void setKodPracovnika(String kodPracovnika) {
		this.kodPracovnika = kodPracovnika;
	}
	public String getZakazka() {
		return zakazka;
	}
	public void setZakazka(String zakazka) {
		this.zakazka = zakazka;
	}
	public int getPolozka() {
		return polozka;
	}
	public void setPolozka(int polozka) {
		this.polozka = polozka;
	}
	public int getPozice() {
		return pozice;
	}
	public void setPozice(int pozice) {
		this.pozice = pozice;
	}
	public double getVykazano() {
		return vykazano;
	}
	public void setVykazano(double vykazano) {
		this.vykazano = vykazano;
	}
	public String getCisloHlaseni() {
		return cisloHlaseni;
	}
	public void setCisloHlaseni(String cisloHlaseni) {
		this.cisloHlaseni = cisloHlaseni;
	}
	public String getCisloUkol() {
		return cisloUkol;
	}
	public void setCisloUkol(String cisloUkol) {
		this.cisloUkol = cisloUkol;
	}
	public String getPopisCinnosti() {
		return popisCinnosti;
	}
	public void setPopisCinnosti(String popisCinnosti) {
		this.popisCinnosti = popisCinnosti;
	}
	
}
