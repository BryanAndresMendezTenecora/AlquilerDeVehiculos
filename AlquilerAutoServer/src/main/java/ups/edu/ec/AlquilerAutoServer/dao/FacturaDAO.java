package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
@Stateless
public class FacturaDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(Factura f) {
		em.persist(f);
	}
	
	public void update(Factura f) {
		em.merge(f);
	}
	
	public Factura read(int id) {
		Factura f= em.find(Factura.class, id);
		return f;
	}
	
	public void delete(int id) {
		Factura f= em.find(Factura.class, id);
		em.remove(f);
	}
	public List<Factura> getList(){
		List<Factura> listado=new ArrayList<Factura>();
		String jpql="SELECT f FROM Factura f";
		Query query= em.createQuery(jpql,Factura.class);
		listado = query.getResultList();
		return listado;
	}

	public Factura getPedido(pedidoCabecera codigo) {
		List<Factura> facturas= new ArrayList<Factura>();
		String jpql="SELECT f FROM Factura f WHERE pedido LIKE ?1";
		Query query= em.createQuery(jpql,Factura.class);
		query.setParameter(1, codigo);
		facturas=query.getResultList();
		Factura f = new Factura();
		for(Factura elemento: facturas) {
			f=elemento;
		}
		return f;
	}
}
