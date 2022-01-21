package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
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
		Devolucion p = em.find(Devolucion.class, id);
		return p;
	}
	
	public void delete(int id) throws Exception {
		Devolucion p = em.find(Devolucion.class, id);
		em.remove(p);
	}

	public List<Devolucion> getDevoluciones() throws Exception{
		String jpql2="SELECT p FROM Devolucion p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Devolucion.class);
		//query.setParameter(1, nombre);
		
		List<Devolucion> Devolucions=query.getResultList();
		return Devolucions;
	}
	public List<Devolucion> getAntecedentes(Factura factura){
		List<Devolucion> listado=new ArrayList<Devolucion>();
		String jpql="SELECT p FROM Devolucion p WHERE factura = ?1";
		Query query= em.createQuery(jpql,Devolucion.class);
		query.setParameter(1, factura);
		listado = query.getResultList();
		Devolucion d= new Devolucion();
		//for(Devolucion elemento: listado) {
			//d=elemento;
		//}
		return listado;
	}
}
