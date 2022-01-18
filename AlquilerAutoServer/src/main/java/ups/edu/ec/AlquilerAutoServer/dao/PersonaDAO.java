package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

@Stateless
public class PersonaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) throws Exception {
		em.persist(persona);
	}
	
	public void update(Persona persona) throws Exception{
		em.merge(persona);
	}
	
	public Persona read(String cedula) throws Exception {
		Persona p = em.find(Persona.class, cedula);
		return p;
	}
	
	public void delete(String cedula) throws Exception {
		Persona p = em.find(Persona.class, cedula);
		em.remove(p);
	}
/*
	public List<Persona> getPersonas() throws Exception{
		String jpql2="SELECT p FROM Persona p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Persona.class);
		//query.setParameter(1, nombre);
		
		List<Persona> personas=query.getResultList();
		return personas;
	}
	*/
	public List<Persona> getList(){
		List<Persona> listado=new ArrayList<Persona>();
		String jpql="SELECT p FROM Persona p";
		Query query= em.createQuery(jpql,Persona.class);
		listado = query.getResultList();
		return listado;
	}
}
