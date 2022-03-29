package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;




@Entity
@Table (name ="ansatt", schema = "oblig3")
public class Ansatt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansatt_id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsedato;
	private int avdeling_id;
	private String stilling;
	private int manedslonn;
	private int prosjekt_id;
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "ansatt_id", referencedColumnName = "sjef")
	private Avdeling avdeling;
	
	@ManyToMany(mappedBy="ansatte")
    private List<Prosjekt> prosjekter;
	
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @PrimaryKeyJoinColumn(name = "ansatt_id", referencedColumnName = "sjef")
	 private Avdeling sjef;

	
	public Ansatt() {
		
	}
	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelsedato,
			String stilling, int manedslonn, int avdeling_id) {

		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsedato = ansettelsedato;
		this.stilling = stilling;
		this.manedslonn = manedslonn;
	}
	public String getStilling() {
		return stilling;
	}
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}
	
	public int getAnsatt_id() {
		return ansatt_id;
	}
	public void setAnsatt_id(int ansatt_id) {
		this.ansatt_id = ansatt_id;
	}
	public String getBrukernavn() {
		return brukernavn;
	}
	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public LocalDate getAnsettelsedato() {
		return ansettelsedato;
	}
	public void setAnsettelsedato(LocalDate ansettelsedato) {
		this.ansettelsedato = ansettelsedato;
	}
	public int getManedslonn() {
		return manedslonn;
	}
	public void setManedslonn(int manedslonn) {
		this.manedslonn = manedslonn;
	}
	@Override
	public String toString() {
		return "Ansatt_id:" + ansatt_id + " Brukernavn:" + brukernavn + " Fornavn:" + fornavn
				+ " Etternavn:" + etternavn + " AnsettelseDato:" + ansettelsedato + " Stilling:" + stilling + " Maanedslonn:" + manedslonn
				+ " avd_id:" + avdeling_id;
	}
	public int getAvdeling_id() {
		return avdeling_id;
	}
	public void setAvdeling_id(int avd_id) {
		this.avdeling_id = avd_id;
	}
	public int getProsjekt_id() {
		return prosjekt_id;
	}
	public void setProsjekt_id(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}

}
