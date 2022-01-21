package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;
@Stateless
public class metodoDePagoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(MetodoDePago tarjetaCredito) throws Exception {
		em.persist(tarjetaCredito);
	}
	
	public void update(MetodoDePago tarjetaCredito) throws Exception{
		em.merge(tarjetaCredito);
	}
	
	public MetodoDePago read(int id) throws Exception {
		MetodoDePago t = em.find(MetodoDePago.class, id);
		return t;
	}
	
	public void delete(int id) throws Exception {
		MetodoDePago  tarjetaCredito= em.find(MetodoDePago.class, id);
		em.remove(tarjetaCredito);
	}

	public List<MetodoDePago> getList() throws Exception{
		List<MetodoDePago> listado=new ArrayList<MetodoDePago>();
		String jpql="SELECT t FROM MetodoDePago t";
		Query query= em.createQuery(jpql,MetodoDePago.class);
		listado = query.getResultList();
		return listado;
	}
}
