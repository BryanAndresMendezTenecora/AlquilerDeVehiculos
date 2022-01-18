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
}
