package DataLoaderNoSQL;

public class Zamestnanec {
	
	int ICP;
	String jmeno;
	String zkratka;
	int cislo_karty;
	int rodne_cislo;
	String pomer_od;
	String pomer_do;
	String stredisko;
	int uvazek;
	String funkce;
	int ICP_ved;
	
	public Zamestnanec(int ICP, String jmeno, String zkratka, int cislo_karty, 
			int rodne_cislo, String pomer_od, String pomer_do, String stredisko, 
			int uvazek, String funkce, int ICP_ved) {
		this.ICP = ICP;
		this.jmeno = jmeno;
		this.zkratka = zkratka;
		this.cislo_karty = cislo_karty;
		this.rodne_cislo = rodne_cislo;
		this.pomer_od = pomer_od;
		this.pomer_do = pomer_do;
		this.stredisko = stredisko;
		this.uvazek = uvazek;
		this.funkce = funkce;
		this.ICP_ved = ICP_ved;
		
	}
}
