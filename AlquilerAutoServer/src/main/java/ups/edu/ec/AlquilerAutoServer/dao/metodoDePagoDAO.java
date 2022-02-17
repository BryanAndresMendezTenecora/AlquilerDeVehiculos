package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;

/**
 * Objeto de acceso a datos para el metodo de pago
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class metodoDePagoDAO {
	@PersistenceContext
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar el objeto metodo de pago
	 * 
	 * @param tarjetaCredito recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void insert(MetodoDePago tarjetaCredito) throws Exception {
		em.persist(tarjetaCredito);
	}

	/**
	 * Metodo para actualizar el objeto metodo de pago
	 * 
	 * @param tarjetaCredito recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void update(MetodoDePago tarjetaCredito) throws Exception {
		em.merge(tarjetaCredito);
	}

	/**
	 * Metodo para buscar el objeto metodo de pago a partir del id
	 * 
	 * @param id recibe id
	 * @return devuelve el objeto vehiculo encontrado
	 * @throws Exception para capturar excepciones
	 */
	public MetodoDePago read(int id) throws Exception {
		MetodoDePago t = em.find(MetodoDePago.class, id);
		return t;
	}

	/**
	 * Metodo para eliminar el objeto metodo de pago encontrado a partir del id
	 * 
	 * @param id recibe id
	 * @throws Exception para capturar excepciones
	 */
	public void delete(int id) throws Exception {
		MetodoDePago tarjetaCredito = em.find(MetodoDePago.class, id);
		em.remove(tarjetaCredito);
	}

	/**
	 * Metodo que devuelve una lista de metodos de pago
	 * 
	 * @return devuelve la lista
	 * @throws Exception para capturar excepciones
	 */
	public List<MetodoDePago> getList() throws Exception {
		List<MetodoDePago> listado = new ArrayList<MetodoDePago>();
		String jpql = "SELECT t FROM MetodoDePago t";
		Query query = em.createQuery(jpql, MetodoDePago.class);
		listado = query.getResultList();
		return listado;
	}
}
