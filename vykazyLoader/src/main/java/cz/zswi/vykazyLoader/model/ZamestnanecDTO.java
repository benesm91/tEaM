package cz.zswi.vykazyLoader.model;

/**
 * Objektova trida DTO pro Zamestnance
 */
public class ZamestnanecDTO implements Data{
	private String icp;
	private String jmeno;
	private String zkratka;
	private String pomerOd;
	private String pomerDo;
	private String stredisko;
	private String uvazek;
	private String funkce;
	private String icpVed;
	public String getIcp() {
		return icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}
	public String getJmeno() {
		return jmeno;
	}
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	public String getZkratka() {
		return zkratka;
	}
	public void setZkratka(String zkratka) {
		this.zkratka = zkratka;
	}
	public String getPomerOd() {
		return pomerOd;
	}
	public void setPomerOd(String pomerOd) {
		this.pomerOd = pomerOd;
	}
	public String getPomerDo() {
		return pomerDo;
	}
	public void setPomerDo(String pomerDo) {
		this.pomerDo = pomerDo;
	}
	public String getStredisko() {
		return stredisko;
	}
	public void setStredisko(String stredisko) {
		this.stredisko = stredisko;
	}
	public String getUvazek() {
		return uvazek;
	}
	public void setUvazek(String uvazek) {
		this.uvazek = uvazek;
	}
	public String getFunkce() {
		return funkce;
	}
	public void setFunkce(String funkce) {
		this.funkce = funkce;
	}
	public String getIcpVed() {
		return icpVed;
	}
	public void setIcpVed(String icpVed) {
		this.icpVed = icpVed;
	}
}
