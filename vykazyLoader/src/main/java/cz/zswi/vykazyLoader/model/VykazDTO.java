package cz.zswi.vykazyLoader.model;

/**
 * Objektova trida DTO pro vykazy prace
 */
public class VykazDTO implements Data{
	private String idZaznamu;
	private String datumCinnosti;
	private String osobniCislo;
	private String kodPracovnika;
	private String zakazka;
	private String polozka;
	private String pozice;
	private String vykazano;
	private String cisloHlaseni;
	private String cisloUkol;
	private String popisCinnosti;
	
	
	public String getIdZaznamu() {
		return idZaznamu;
	}
	public void setIdZaznamu(String idZaznamu) {
		this.idZaznamu = idZaznamu;
	}
	public String getDatumCinnosti() {
		return datumCinnosti;
	}
	public void setDatumCinnosti(String datumCinnosti) {
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
	public String getPolozka() {
		return polozka;
	}
	public void setPolozka(String polozka) {
		this.polozka = polozka;
	}
	public String getPozice() {
		return pozice;
	}
	public void setPozice(String pozice) {
		this.pozice = pozice;
	}
	public String getVykazano() {
		return vykazano;
	}
	public void setVykazano(String vykazano) {
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
