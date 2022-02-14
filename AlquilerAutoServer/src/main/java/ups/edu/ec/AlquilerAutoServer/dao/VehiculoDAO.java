package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
@Stateless
public class VehiculoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) throws Exception {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) throws Exception{
		em.merge(vehiculo);
	}
	
	public Vehiculo read(int id) throws Exception {
		Vehiculo p = em.find(Vehiculo.class, id);
		return p;
	}
	
	public void delete(int id) throws Exception {
		Vehiculo  vehiculo= em.find(Vehiculo.class, id);
		em.remove(vehiculo);
	}

	public List<Vehiculo> getList(){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p";
		Query query= em.createQuery(jpql,Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> getCategoria(String nombre){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p WHERE c";
		Query query= em.createQuery(jpql,Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}
	
	
	public List<Vehiculo> getVehiculosDisponibilidad(String nombre){
		
		String jpql2="SELECT p FROM Vehiculo p WHERE estado = ?1";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Vehiculo.class);
		query.setParameter(1, nombre);
		
		List<Vehiculo> vehiculos=query.getResultList();
		return vehiculos;
		
	}
	public List<Categoria> listarcategorias(){
		List<Categoria> listaCategorias=null;
		
		String jpql="SELECT c FROM Categoria c";
		Query query= em.createQuery(jpql,Categoria.class);
		listaCategorias = query.getResultList();
		return listaCategorias;
	}
	
	public List<Vehiculo> getVehiculosPrecioMayorMenor(){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p ORDER BY precio DESC";
		Query query= em.createQuery(jpql,Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> getVehiculosPrecioMenorMayor(){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p ORDER BY precio";
		Query query= em.createQuery(jpql,Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> getVehiculosNombreAZ(){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p ORDER BY modelo";
		Query query= em.createQuery(jpql,Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> getVehiculosModeloZA(){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p ORDER BY modelo DESC";
		Query query= em.createQuery(jpql,Vehiculo.class);
		listado = query.getResultList();
		return listado;
	}
	
	public List<Vehiculo> getVehiculosCategoria(Categoria categoria){
		List<Vehiculo> listado=new ArrayList<Vehiculo>();
		String jpql="SELECT p FROM Vehiculo p WHERE categoria LIKE ?1";
		Query query= em.createQuery(jpql,Vehiculo.class);
		query.setParameter(1, categoria);
		listado = query.getResultList();
		return listado;
	}
}
