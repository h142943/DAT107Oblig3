package no.hvl.dat107;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "avdeling", schema = "oblig3")

public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdeling_id;
	private int sjef;
	private String avd_navn;
	@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
	List<Ansatt> ansatt;
	
	public int getAvd_id() {
		return avdeling_id;
	}
	public void setAvd_id(int avd_id) {
		this.avdeling_id = avd_id;
	}
	public Avdeling() {
		
	}
	
	public Avdeling( int sjef, String avd_navn) {
		super();
		this.sjef = sjef;
		this.avd_navn = avd_navn;

	}
	public int getSjef() {
		return sjef;
	}
	public void setSjef(int sjef) {
		this.sjef = sjef;
	}
	public String getNavn() {
		return avd_navn;
	}
	public void setNavn(String navn) {
		this.avd_navn = navn;
	}
	@Override
	public String toString() {
		String karString = "";
		for(Ansatt a: ansatt) {
			karString += "\n" + a;
		}
		return "Avd_id:" + avdeling_id + " Avd_navn:" + avd_navn  + " AnsattNRSjef:"+ sjef + karString; 
	}


}
