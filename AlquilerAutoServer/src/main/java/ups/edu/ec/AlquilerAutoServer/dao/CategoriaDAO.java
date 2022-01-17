package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;

@Stateless
public class CategoriaDAO {
	@PersistenceContext // coge el datasourses que tenemos en el proyecto(persistence.xml)
	private EntityManager em;
	
	public void insert(Categoria p) {
		em.persist(p);
	}
	
	public void update(Categoria p) {
		em.merge(p);
	}
	
	public Categoria read(int id) {
		Categoria p= em.find(Categoria.class, id);
		return p;
	}
	
	public void delete(int id) {
		Categoria p= em.find(Categoria.class, id);
		em.remove(p);
	}
	public List<Categoria> getList(){
		List<Categoria> listado=new ArrayList<Categoria>();
		String jpql="SELECT p FROM Categoria p";
		Query query= em.createQuery(jpql,Categoria.class);
		listado = query.getResultList();
		return listado;
	}
}
