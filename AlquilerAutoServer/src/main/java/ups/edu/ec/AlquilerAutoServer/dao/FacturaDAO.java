package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Objeto de acceso a datos para la Factura
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class FacturaDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar el objeto vehículo
	 * 
	 * @param f recibe el objeto
	 */
	public void insert(Factura f) {
		em.persist(f);
	}

	/**
	 * Metodo para actualizar el objeto vehículo
	 * 
	 * @param f recibe el objeto
	 */
	public void update(Factura f) {
		em.merge(f);
	}

	/**
	 * Metodo para buscar el objeto vehículo a partir del id
	 * 
	 * @param id recibe el id
	 * @return devuelve el objeto Factura encontrado
	 */
	public Factura read(int id) {
		Factura f = em.find(Factura.class, id);
		return f;
	}

	/**
	 * Metodo para eliminar el objeto vehículo encontrado a partir del id
	 * 
	 * @param id recibe el id
	 */
	public void delete(int id) {
		Factura f = em.find(Factura.class, id);
		em.remove(f);
	}

	/**
	 * Metodo que devuelve una lista de facturas
	 * 
	 * @return devuelve la lista
	 */
	public List<Factura> getList() {
		List<Factura> listado = new ArrayList<Factura>();
		String jpql = "SELECT f FROM Factura f";
		Query query = em.createQuery(jpql, Factura.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de facturas en base al objeto pedido
	 * 
	 * @param codigo recibe el objeto
	 * @return devuelve la lista
	 */
	public Factura getPedido(pedidoCabecera codigo) {
		List<Factura> facturas = new ArrayList<Factura>();
		String jpql = "SELECT f FROM Factura f WHERE pedido LIKE ?1";
		Query query = em.createQuery(jpql, Factura.class);
		query.setParameter(1, codigo);
		facturas = query.getResultList();
		Factura f = new Factura();
		for (Factura elemento : facturas) {
			f = elemento;
		}
		return f;
	}
}
