package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

/**
 * Objeto de acceso a datos para comentario
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class ComentarioDAO {
	@PersistenceContext
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar Comentario
	 * 
	 * @param recibe objeto comentario
	 * @throws Exception para capturar excepciones
	 */
	public void insert(Comentario comentario) throws Exception {
		em.persist(comentario);
	}

	/**
	 * Metodo para actualizar comentario
	 * 
	 * @param recibe objeto comentario
	 * @throws Exception para capturar excepciones
	 */
	public void update(Comentario comentario) throws Exception {
		em.merge(comentario);
	}

	/**
	 * Metodo para buscar comentario
	 * 
	 * @param recibe id del comentario
	 * @return devuelve lista de comentarios
	 * @throws Exception para capturar excepciones
	 */
	public Comentario read(int id) throws Exception {
		Comentario p = em.find(Comentario.class, id);
		return p;
	}

	/**
	 * Metodos para eliminar comentario
	 * 
	 * @param recibe id del comentario
	 * @throws Exception para capturar excepciones
	 */
	public void delete(int id) throws Exception {
		Comentario p = em.find(Comentario.class, id);
		em.remove(p);
	}

	/**
	 * Metodo para listar comentarios
	 * 
	 * @return devuelve lista de comentarios
	 * @throws Exception para capturar excepciones
	 */
	public List<Comentario> getComentarios() throws Exception {
		String jpql2 = "SELECT p FROM Comentario p";
		Query query = em.createQuery(jpql2, Comentario.class);
		List<Comentario> Comentarios = query.getResultList();
		return Comentarios;
	}

	/**
	 * Metodo para listar comentario
	 * 
	 * @return devuelve lista de comentarios
	 */
	public List<Comentario> getList() {
		List<Comentario> listado = new ArrayList<Comentario>();
		String jpql = "SELECT p FROM Comentario p";
		Query query = em.createQuery(jpql, Comentario.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Metodo para listar comentarios de vehiculos
	 * 
	 * @param recibe objeto vehiculo
	 * @return devuelve una lista de comentarios por vehiculo
	 */
	public List<Comentario> getcomentariosVehiculo(Vehiculo vehiculo) {
		List<Comentario> listado = new ArrayList<Comentario>();
		String jpql = "SELECT p FROM Comentario p WHERE vehiculo LIKE ?1";
		Query query = em.createQuery(jpql, Comentario.class);
		query.setParameter(1, vehiculo);
		listado = query.getResultList();
		return listado;
	}
}
