package DataLoaderNoSQL;

public class VykazPrace {
	int id_zaznamu;
	String datum_cinnosti;
	int os_cislo;
	int kod_pracovnika;	
	String zakazka;
	int polozka;
	int pozice;
	int vykazane_hodiny;
	int cislo_hlaseni;
	int cislo_ukol;
	
	
	public VykazPrace(int id_zaznamu, String datum_cinnosti, int os_cislo,int kod_pracovnika, String zakazka, int polozka, int pozice, int vykazane_hodiny, int cislo_hlaseni, int cislo_ukol) {
		this.id_zaznamu = id_zaznamu;
		this.datum_cinnosti = datum_cinnosti;
		this.os_cislo = os_cislo;
		this.zakazka = zakazka;
		this.polozka = polozka;
		this.pozice = pozice;
		this.vykazane_hodiny = vykazane_hodiny;
		this.cislo_hlaseni = cislo_hlaseni;
		this.cislo_ukol = cislo_ukol;
	}
}
