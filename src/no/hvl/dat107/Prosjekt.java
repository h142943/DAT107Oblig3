package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "prosjekt", schema = "oblig3")

public class Prosjekt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjekt_id;
	private String prosjekt_navn;
	private String prosjekt_beskrivelse;
	private int ansatt_id;
	private int arbeidstimer;
	private String prosjekt_rolle;
	
	
	@OneToMany(mappedBy="prosjekt")
    private List<Prosjektdeltagelse> deltagelser;
    
	//trenger ikke List<Prosjekt> prosjekt i konstruktoer?
	public Prosjekt(String prosjekt_navn, String prosjekt_beskrivelse, int ansatt_id, int arbeidstimer,
			String prosjekt_rolle) {
		super();
		this.prosjekt_navn = prosjekt_navn;
		this.prosjekt_beskrivelse = prosjekt_beskrivelse;
		this.ansatt_id = ansatt_id;
		this.arbeidstimer = arbeidstimer;
		this.prosjekt_rolle = prosjekt_rolle;
	}

	public int getProsjekt_id() {
		return prosjekt_id;
	}

	public void setProsjekt_id(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}

	public String getProsjekt_navn() {
		return prosjekt_navn;
	}

	public void setProsjekt_navn(String prosjekt_navn) {
		this.prosjekt_navn = prosjekt_navn;
	}

	public String getProsjekt_beskrivelse() {
		return prosjekt_beskrivelse;
	}

	public void setProsjekt_beskrivelse(String prosjekt_beskrivelse) {
		this.prosjekt_beskrivelse = prosjekt_beskrivelse;
	}

	public int getAnsatt_id() {
		return ansatt_id;
	}

	public void setAnsatt_id(int ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public int getArbeidstimer() {
		return arbeidstimer;
	}

	public void setArbeidstimer(int arbeidstimer) {
		this.arbeidstimer = arbeidstimer;
	}

	public String getProsjekt_rolle() {
		return prosjekt_rolle;
	}

	public void setProsjekt_rolle(String prosjekt_rolle) {
		this.prosjekt_rolle = prosjekt_rolle;
	}

//	public List<Prosjekt> getProsjekt() {
//		return prosjekt;
//	}
//
//	public void setProsjekt(List<Prosjekt> prosjekt) {
//		this.prosjekt = prosjekt;
//	}
}
