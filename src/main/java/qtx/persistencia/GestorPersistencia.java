package qtx.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import qtx.entidades.LugarEstacionamiento;
import qtx.entidades.Persona;

public class GestorPersistencia {
	EntityManagerFactory fabrica;
	
	public GestorPersistencia() {
		this.fabrica = Persistence.createEntityManagerFactory("miBaseDeDatos");
	}
	public Persona getPersonaXID(int id){
		EntityManager em = this.fabrica.createEntityManager();
		Persona personaI = em.find(Persona.class, id);
		personaI.getMascotas().size();
		em.close();
		return personaI;
	}
	public LugarEstacionamiento getEstacionamientoXID(int id){
		EntityManager em = this.fabrica.createEntityManager();
		LugarEstacionamiento estacionamientoI = em.find(LugarEstacionamiento.class, id);
//		em.close();
		return estacionamientoI;
	}
	public boolean insertarPersona(Persona p) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		em.merge(p);
//		em.persist(p);
		try {
			transaccion.commit();
		}
		catch(Exception ex) {
			return false;
		}
		finally { em.close(); }
		return true;
	}
	
	public boolean actualizarPersona(Persona p) {
		System.out.println("\n** GestorPersistencia.actualizarPersona(" + p.getIdPersona() + ") **");
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		try {
			Persona personaMerge = em.merge(p); 
//			em.persist(p);
			transaccion.commit();
		}
		catch(Exception ex) {
			System.out.println(ex.getClass().getSimpleName() + ":" + ex.getMessage());
			return false;
		}
		finally { em.close(); }
		
		return true;
	}
	public boolean eliminarPersona(Persona p) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();
		transaccion.begin();
		try {
			Persona personaMerge = em.merge(p);
			em.remove(personaMerge);
			transaccion.commit();
		}
		catch(Exception ex) {
			return false;
		}
		finally { em.close(); }
		
		return true;
	}
	
	public void cerrar() {
		this.fabrica.close();
	}

}
