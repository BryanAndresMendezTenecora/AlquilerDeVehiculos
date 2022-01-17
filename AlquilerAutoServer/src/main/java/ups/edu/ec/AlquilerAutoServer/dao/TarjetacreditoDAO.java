package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.TarjetaCredito;
@Stateless
public class TarjetacreditoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(TarjetaCredito tarjetaCredito) throws Exception {
		em.persist(tarjetaCredito);
	}
	
	public void update(TarjetaCredito tarjetaCredito) throws Exception{
		em.merge(tarjetaCredito);
	}
	
	public TarjetaCredito read(int id) throws Exception {
		TarjetaCredito t = em.find(TarjetaCredito.class, id);
		return t;
	}
	
	public void delete(int id) throws Exception {
		TarjetaCredito  tarjetaCredito= em.find(TarjetaCredito.class, id);
		em.remove(tarjetaCredito);
	}

	public List<TarjetaCredito> getList(){
		List<TarjetaCredito> listado=new ArrayList<TarjetaCredito>();
		String jpql="SELECT t FROM TarjetaCredito t";
		Query query= em.createQuery(jpql,TarjetaCredito.class);
		listado = query.getResultList();
		return listado;
	}
}
