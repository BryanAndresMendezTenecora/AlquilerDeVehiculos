package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

/**
 * Objeto de acceso a datos para vehiculo
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class VehiculoDAO {
	@PersistenceContext
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar el objeto vehículo
	 * 
	 * @param vehiculo recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void insert(Vehiculo vehiculo) throws Exception {
		em.persist(vehiculo);
	}

	/**
	 * Metodo para actualizar el objeto vehículo
	 * 
	 * @param vehiculo recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void update(Vehiculo vehiculo) throws Exception {
		em.merge(vehiculo);
	}

	/**
	 * Metodo para buscar el objeto vehículo a partir del id
	 * 
	 * @param id recibe id
	 * @return devuelve el objeto vehiculo encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Vehiculo read(int id) throws Exception {
		Vehiculo p = em.find(Vehiculo.class, id);
		return p;
	}

	/**
	 * Metodo para eliminar el objeto vehículo encontrado a partir del id
	 * 
	 * @param id recibe el id
	 * @throws Exception para capturar excepciones
	 */
	public void delete(int id) throws Exception {
		Vehiculo vehiculo = em.find(Vehiculo.class, id);
		em.remove(vehiculo);
	}

	/**
	 * Metodo que devuelve una lista de vehiculos
	 * 
	 * @return devuelve una lista
	 */
	public List<Vehiculo> getList() {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de categorias de vehiculos
	 * 
	 * @param nombre recibe el nombre de la categoria
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getCategoria(String nombre) {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p WHERE c";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de vehiculos por estado
	 * 
	 * @param nombre recibe el estado
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosDisponibilidad(String nombre) {

		String jpql2 = "SELECT p FROM Vehiculo p WHERE estado = ?1";

		// nombre= nombre+"%";
		Query query = em.createQuery(jpql2, Vehiculo.class);
		query.setParameter(1, nombre);

		List<Vehiculo> vehiculos = query.getResultList();
		return vehiculos;

	}

	/**
	 * Devuelve una lista de categorias de vehiculos
	 * 
	 * @return devuelve la lista
	 */
	public List<Categoria> listarcategorias() {
		List<Categoria> listaCategorias = null;

		String jpql = "SELECT c FROM Categoria c";
		Query query = em.createQuery(jpql, Categoria.class);
		listaCategorias = query.getResultList();
		return listaCategorias;
	}

	/**
	 * Devuelve una lista de vehiculos por precio en orden descendente
	 * 
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosPrecioMayorMenor() {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p ORDER BY precio DESC";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de vehiculos por precio en orden ascendente
	 * 
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosPrecioMenorMayor() {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p ORDER BY precio";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de vehiculos por modelo ordenado de A a la Z
	 * 
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosNombreAZ() {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p ORDER BY modelo";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de vehiculos por modelo ordenado de la Z a la A
	 * 
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosModeloZA() {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p ORDER BY modelo DESC";
		Query query = em.createQuery(jpql, Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de vehiculos por categoria
	 * 
	 * @param categoria recibe la categoria
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosCategoria(Categoria categoria) {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p WHERE categoria LIKE ?1";
		Query query = em.createQuery(jpql, Vehiculo.class);
		query.setParameter(1, categoria);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Devuelve una lista de vehiculos por estado
	 * 
	 * @param estado recibe el estado
	 * @return devuelve la lista
	 */
	public List<Vehiculo> getVehiculosEstado(String estado) {
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		String jpql = "SELECT p FROM Vehiculo p WHERE estado LIKE ?1";
		Query query = em.createQuery(jpql, Vehiculo.class);
		query.setParameter(1, estado);
		listado = query.getResultList();
		return listado;
	}

}
