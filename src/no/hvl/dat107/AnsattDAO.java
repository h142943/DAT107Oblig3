package no.hvl.dat107;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {
	private EntityManagerFactory emf;
	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("ansattPU");
	}
	public Ansatt finnAnsattMedId(int ansatt_id){
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Ansatt.class, ansatt_id);
		}finally {
			em.close();
		}
	}
	
	public List<Ansatt> finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(
			        "SELECT a FROM Ansatt as a where a.brukernavn like '%"+ brukernavn+"%'", Ansatt.class);
			return query.getResultList();
		}finally {
			em.close();
		}
	}
	public List<Ansatt> listAlleAnsatte(){
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em.createQuery(
					"Select a FROM Ansatt a", Ansatt.class);
			return query.getResultList();
		}finally {
			em.close();
		}
	}
	public void oppdaterStillingOgLonn(int id, String nyStilling, int nyLonn) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Ansatt x = em.find(Ansatt.class,id);
			x.setStilling(nyStilling);
			x.setManedslonn(nyLonn);
			em.getTransaction().commit();
		
	} catch (Throwable e) {
		e.printStackTrace();
		em.getTransaction().rollback();
	} finally {
			em.close();
		}
	}
	public void leggTilAnsatt(Ansatt a, int avd) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction ex = em.getTransaction();
		try {
			ex.begin();
			a.setAvdeling_id(avd);
			em.persist(a);
			ex.commit();
		}catch(Exception e){
			e.printStackTrace();
			ex.rollback();
		}finally {
			em.close();
		}
	}
	public void byttStilling() {
		//maa huske aa bytte sjef_id i avdeling om du lager denne metoden!
	}
	
	public void oppdaterAvdeling(Ansatt a, int avd) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			if(!a.getStilling().equals("sjef")) {
				a.setAvdeling_id(avd);
			}
		    em.merge(a);
			em.getTransaction().commit();
		}catch(Exception e){
		e.printStackTrace();
		em.getTransaction().rollback();
		}
		finally {
			em.close();
		}	
	}
}
