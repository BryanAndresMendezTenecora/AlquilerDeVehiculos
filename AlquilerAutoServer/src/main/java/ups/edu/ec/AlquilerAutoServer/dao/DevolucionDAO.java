package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;

/**
 * Objeto de acceso a datos para la devolucion del vehiculo
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class DevolucionDAO {
	@PersistenceContext
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar el objeto devolucion
	 * 
	 * @param devolucion recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void insert(Devolucion devolucion) throws Exception {
		em.persist(devolucion);
	}

	/**
	 * Metodo para actualizar el objeto devolucion
	 * 
	 * @param devolucion recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void update(Devolucion devolucion) throws Exception {
		em.merge(devolucion);
	}

	/**
	 * Metodo para buscar el objeto devolucion a partir del id
	 * 
	 * @param id recibe el id
	 * @return devuelve el objeto devolucion encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Devolucion read(int id) throws Exception {
		Devolucion p = em.find(Devolucion.class, id);
		return p;
	}

	/**
	 * Metodo para eliminar el objeto devolucion encontrado a partir del id
	 * 
	 * @param id recibe el id
	 * @throws Exception para capturar excepciones
	 */
	public void delete(int id) throws Exception {
		Devolucion p = em.find(Devolucion.class, id);
		em.remove(p);
	}

	/**
	 * Metodo que devuelve una lista de devoluciones
	 * 
	 * @return devuelve la lista
	 * @throws Exception para capturar excepciones
	 */
	public List<Devolucion> getDevoluciones() throws Exception {
		String jpql2 = "SELECT p FROM Devolucion p";

		// nombre= nombre+"%";
		Query query = em.createQuery(jpql2, Devolucion.class);
		// query.setParameter(1, nombre);

		List<Devolucion> Devolucions = query.getResultList();
		return Devolucions;
	}

	/**
	 * Devuelve una lista de antecedentes de devolucion del vehiculo en base al
	 * objeto factura
	 * 
	 * @param factura recibe el objeto
	 * @return devuelve la lista
	 */
	public List<Devolucion> getAntecedentes(Factura factura) {
		List<Devolucion> listado = new ArrayList<Devolucion>();
		String jpql = "SELECT p FROM Devolucion p WHERE factura = ?1";
		Query query = em.createQuery(jpql, Devolucion.class);
		query.setParameter(1, factura);
		listado = query.getResultList();
		Devolucion d = new Devolucion();
		return listado;
	}
}
