package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Objeto de acceso a datos para Pedido
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class PedidoDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar el objeto pedidoCabecera
	 * 
	 * @param p recibe el objeto
	 */
	public void insert(pedidoCabecera p) {
		em.persist(p);
	}

	/**
	 * Metodo para actualizar el objeto pedidoCabecera
	 * 
	 * @param p recibe el objeto
	 */
	public void update(pedidoCabecera p) {
		em.merge(p);
	}

	/**
	 * Metodo para buscar el objeto pedidoCabecera a partir del id
	 * 
	 * @param id recibe el id
	 * @return devuelve el objeto pedidoCabecera encontrado
	 */
	public pedidoCabecera read(int id) {
		pedidoCabecera p = em.find(pedidoCabecera.class, id);
		return p;
	}

	/**
	 * Metodo para eliminar el objeto pedidoCabecera encontrado a partir del id
	 * 
	 * @param id recibe el id
	 */
	public void delete(int id) {
		pedidoCabecera p = em.find(pedidoCabecera.class, id);
		em.remove(p);
	}

	/**
	 * Metodo que devuelve una lista de pedidos
	 * 
	 * @return devuelve la lista
	 */
	public List<pedidoCabecera> getList() {
		List<pedidoCabecera> listado = new ArrayList<pedidoCabecera>();
		String jpql = "SELECT p FROM pedidoCabecera p";
		Query query = em.createQuery(jpql, pedidoCabecera.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Metodo que devuelve una lista de pedidos por persona
	 * 
	 * @param nombre recibe el objeto Persona
	 * @return devuelve una lista
	 */
	public List<pedidoCabecera> getListaNombre(Persona nombre) {
		List<pedidoCabecera> listado = new ArrayList<pedidoCabecera>();
		String jpql = "SELECT p FROM pedidoCabecera p WHERE persona LIKE ?1";
		Query query = em.createQuery(jpql, pedidoCabecera.class);
		query.setParameter(1, nombre);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Metodo que devuelve una lista de pedidos por persona
	 * 
	 * @param nombre recibe el objeto Persona
	 * @return devuelve una lista
	 */
	public List<pedidoCabecera> getPedidosNombre(Persona nombre) {
		List<pedidoCabecera> listado = new ArrayList<pedidoCabecera>();
		String jpql = "SELECT p FROM pedidoCabecera p WHERE persona LIKE ?1";
		Query query = em.createQuery(jpql, pedidoCabecera.class);
		query.setParameter(1, nombre);
		listado = query.getResultList();
		return listado;
	}

}
