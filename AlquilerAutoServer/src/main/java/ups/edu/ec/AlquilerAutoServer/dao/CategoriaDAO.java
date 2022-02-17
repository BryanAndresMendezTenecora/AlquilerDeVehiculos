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
 * Objeto de acceso a datos para categoria
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class CategoriaDAO {

	@PersistenceContext
	private EntityManager em;// Para el contexto de persistencia

	/**
	 * Metodo para insertar Categoria
	 * 
	 * @param recibe objeto Categoria
	 * @throws Exception para capturar excepciones
	 */
	public void insert(Categoria p) throws Exception {
		em.persist(p);
	}

	/**
	 * Metodo para actualizar la categoria
	 * 
	 * @param recibe p como objeto categoria
	 * @throws Exception para capturar excepciones
	 */
	public void update(Categoria p) throws Exception {
		em.merge(p);
	}

	/**
	 * Metodo para actualizar el estado de la categoria
	 * 
	 * @param recibe id de la categoria
	 * @param recibe nombre de la categoria
	 * @param recibe estado de la categoria
	 * @throws Exception para capturar excepciones
	 */
	public void updateestado(int id, String nombre, String estado) throws Exception {
		Categoria ca = new Categoria();
		ca.setId(id);
		ca.setNombre(nombre);
		ca.setEstado(estado);
		em.merge(ca);
	}

	/**
	 * Metodo para buscar la categoria
	 * 
	 * @param recibe el id de la categoria
	 * @return devuelve el objeto persona encontrada
	 * @throws Exception para capturar excepciones
	 */
	public Categoria read(int id) throws Exception {
		Categoria p = em.find(Categoria.class, id);
		return p;
	}

	/**
	 * Metodo para eliminar la categoria
	 * 
	 * @param recibe id de la categoria
	 * @throws Exception para capturar excepciones
	 */
	public void delete(int id) throws Exception {
		Categoria p = em.find(Categoria.class, id);
		em.remove(p);
	}

	/**
	 * Metodo para listar las categorias
	 * 
	 * @return devuelve una lista de categoria
	 */
	public List<Categoria> getList() {
		List<Categoria> listado = new ArrayList<Categoria>();
		String jpql = "SELECT p FROM Categoria p";
		Query query = em.createQuery(jpql, Categoria.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Metodo para buscar categoria por nombre
	 * 
	 * @param recibe nombre de la categoria
	 * @return devuelve una lista de categoria encontrada por nombre
	 * @throws Exception para capturar excepciones
	 */
	public Categoria buscarNombre(String nombre) throws Exception {
		List<Categoria> listado = new ArrayList<Categoria>();
		// String nombre=categoria.getNombre();
		String jpql = "SELECT p FROM Categoria p WHERE nombre = ?";
		Query query = em.createQuery(jpql, Categoria.class);
		listado = query.getResultList();
		Categoria c = new Categoria();
		if (listado.size() == 1) {
			for (Categoria var : listado) {
				c = var;
			}
		}
		return c;
	}

	/**
	 * Metodo para listar categorias
	 * 
	 * @return devulve una lista de categoria
	 */
	public List<Categoria> listarcategorias() {
		List<Categoria> listaCategorias = null;

		String jpql = "SELECT c FROM Categoria c";
		Query query = em.createQuery(jpql, Categoria.class);
		listaCategorias = query.getResultList();
		return listaCategorias;
	}

}
