package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
@Stateless
public class FacturaDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(Factura f) {
		em.persist(f);
	}
	
	public void update(Factura f) {
		em.merge(f);
	}
	
	public Factura read(int id) {
		Factura f= em.find(Factura.class, id);
		return f;
	}
	
	public void delete(int id) {
		Factura f= em.find(Factura.class, id);
		em.remove(f);
	}
	public List<Factura> getList(){
		List<Factura> listado=new ArrayList<Factura>();
		String jpql="SELECT f FROM Factura f";
		Query query= em.createQuery(jpql,Factura.class);
		listado = query.getResultList();
		return listado;
	}

}
