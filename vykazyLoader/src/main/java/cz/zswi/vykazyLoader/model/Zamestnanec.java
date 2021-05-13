package cz.zswi.vykazyLoader.model;

import java.util.Date;

/**
 * Objektova trida pro zamestnance
 *
 */
public class Zamestnanec implements OutData {
	private int icp;
	private String jmeno;
	private String zkratka;
	private Date pomerOd;
	private Date pomerDo;
	private String stredisko;
	private double uvazek;
	private String funkce;
	private int icpVed;
	public int getIcp() {
		return icp;
	}
	public void setIcp(int icp) {
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
	public Date getPomerOd() {
		return pomerOd;
	}
	public void setPomerOd(Date pomerOd) {
		this.pomerOd = pomerOd;
	}
	public Date getPomerDo() {
		return pomerDo;
	}
	public void setPomerDo(Date pomerDo) {
		this.pomerDo = pomerDo;
	}
	public String getStredisko() {
		return stredisko;
	}
	public void setStredisko(String stredisko) {
		this.stredisko = stredisko;
	}
	public double getUvazek() {
		return uvazek;
	}
	public void setUvazek(double uvazek) {
		this.uvazek = uvazek;
	}
	public String getFunkce() {
		return funkce;
	}
	public void setFunkce(String funkce) {
		this.funkce = funkce;
	}
	public int getIcpVed() {
		return icpVed;
	}
	public void setIcpVed(int icpVed) {
		this.icpVed = icpVed;
	}
	
	
}
