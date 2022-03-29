package no.hvl.dat107;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {
	private EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}

	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
	}

	public void opprettAvdeling(int id) {
		Scanner in = new Scanner(System.in);
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Ansatt x = em.find(Ansatt.class, id);
			if (x.getStilling().equals("sjef")) {
				System.out.println("Feilmelding: Den ansatte er allerede sjef i en annen avdeling!");
			} else {
				System.out.println("Navn paa ny avdeling: ");
				String avdelingNavn = in.nextLine();
				Avdeling nyAvd = new Avdeling(x.getAnsatt_id(), avdelingNavn);
				x.setStilling("sjef");
				em.persist(nyAvd);
				em.persist(x);
			}
			em.getTransaction().commit();
	
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			in.close();
			em.close();
		}
	
	}
	public List<String> listAlleAvdelinger(){
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			List<Avdeling> listAlleAvdelinger = em.createQuery("Select a from Avdeling a",Avdeling.class).getResultList();
			List<String> avdelingsNavn = new ArrayList<String>();
			for(Avdeling x : listAlleAvdelinger) {
				avdelingsNavn.add(x.getNavn());
			}
			return avdelingsNavn;
		}finally {
			em.close();
		}
	}

	public List<Ansatt> listAlleAnsatte(int avd) {
		EntityManager em = emf.createEntityManager();
		try {

			TypedQuery<Ansatt> query = em.createQuery("Select a FROM Ansatt a" + " where a.avdeling_id =:avd",
					Ansatt.class);
			query.setParameter("avd", avd);

			List<Ansatt> ansattList = query.getResultList();
			// for utheving av hvem som er sjef.
			for (Ansatt x : ansattList) {
				if (x.getStilling().equals("sjef")) {
					x.setFornavn(x.getFornavn().toUpperCase());
					x.setEtternavn(x.getEtternavn().toUpperCase());
					x.setStilling(x.getStilling().toUpperCase());
				}
			}
			return ansattList;
		} finally {
			em.close();
		}
	}
}
