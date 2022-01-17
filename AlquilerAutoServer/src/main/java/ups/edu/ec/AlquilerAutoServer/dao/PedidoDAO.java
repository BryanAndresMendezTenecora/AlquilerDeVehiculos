package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;


@Stateless
public class PedidoDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(pedidoCabecera p) {
		em.persist(p);
	}
	
	public void update(pedidoCabecera p) {
		em.merge(p);
	}
	
	public pedidoCabecera read(int id) {
		pedidoCabecera p= em.find(pedidoCabecera.class, id);
		return p;
	}
	
	public void delete(int id) {
		pedidoCabecera p= em.find(pedidoCabecera.class, id);
		em.remove(p);
	}
	public List<pedidoCabecera> getList(){
		List<pedidoCabecera> listado=new ArrayList<pedidoCabecera>();
		String jpql="SELECT p FROM pedidoCabecera p";
		Query query= em.createQuery(jpql,pedidoCabecera.class);
		listado = query.getResultList();
		return listado;
	}
}
