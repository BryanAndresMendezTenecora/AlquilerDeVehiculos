package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
@Stateless
public class DevolucionDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Devolucion devolucion) throws Exception {
		em.persist(devolucion);
	}
	
	public void update(Devolucion devolucion) throws Exception{
		em.merge(devolucion);
	}
	
	public Devolucion read(int id) throws Exception {
		Devolucion p = em.find(Devolucion.class, cedula);
		return p;
	}
	
	public void delete(int id) throws Exception {
		Devolucion p = em.find(Devolucion.class, cedula);
		em.remove(p);
	}

	public List<Devolucion> getDevolucions() throws Exception{
		String jpql2="SELECT p FROM Devolucion p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Devolucion.class);
		//query.setParameter(1, nombre);
		
		List<Devolucion> Devolucions=query.getResultList();
		return Devolucions;
	}
	public List<Devolucion> getList(){
		List<Devolucion> listado=new ArrayList<Devolucion>();
		String jpql="SELECT p FROM Devolucion p";
		Query query= em.createQuery(jpql,Devolucion.class);
		listado = query.getResultList();
		return listado;
	}
}
