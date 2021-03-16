package DataLoaderNoSQL;

public class VykazPrace {
	int ID_zaznamu;
	String Datum_cinnosti;
	int Os_cislo;
	int Kod_pracovnika;	
	String Zakazka;
	int Polozka;
	int Pozice;
	int Vykazane_hodiny;
	int Cislo_hlaseni;
	int Cislo_ukol;
	
	
	public VykazPrace(int id_zaznamu, String datum_cinnosti, int os_cislo,int kod_pracovnika, String zakazka, int polozka, int pozice, int vykazane_hodiny, int cislo_hlaseni, int cislo_ukol) {
		this.ID_zaznamu = id_zaznamu;
		this.Datum_cinnosti = datum_cinnosti;
		this.Os_cislo = os_cislo;
		this.Zakazka = zakazka;
		this.Polozka = polozka;
		this.Pozice = pozice;
		this.Vykazane_hodiny = vykazane_hodiny;
		this.Cislo_hlaseni = cislo_hlaseni;
		this.Cislo_ukol = cislo_ukol;
	}
}
