package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
@Stateless
public class ComentarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Comentario comentario) throws Exception {
		em.persist(comentario);
	}
	
	public void update(Comentario comentario) throws Exception{
		em.merge(comentario);
	}
	
	public Comentario read(int id) throws Exception {
		Comentario p = em.find(Comentario.class, id);
		return p;
	}
	
	public void delete(int id) throws Exception {
		Comentario p = em.find(Comentario.class, id);
		em.remove(p);
	}

	public List<Comentario> getComentarios() throws Exception{
		String jpql2="SELECT p FROM Comentario p";
		
		//nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Comentario.class);
		//query.setParameter(1, nombre);
		
		List<Comentario> Comentarios=query.getResultList();
		return Comentarios;
	}
	public List<Comentario> getList(){
		List<Comentario> listado=new ArrayList<Comentario>();
		String jpql="SELECT p FROM Comentario p";
		Query query= em.createQuery(jpql,Comentario.class);
		listado = query.getResultList();
		return listado;
	}
}
