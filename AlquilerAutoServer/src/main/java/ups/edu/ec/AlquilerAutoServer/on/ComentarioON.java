package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.ComentarioDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
@Stateless
public class ComentarioON implements ComentarioONLocal{
	@Inject
	private ComentarioDAO comentarioDAO;
	
	public void insertarComentario(Comentario comentario) throws Exception {
		comentarioDAO.insert(comentario);
	}
	
	
	public void actualizarComentario(Comentario comentario) throws Exception {
		comentarioDAO.update(comentario);
	}
	
	public Comentario buscarComentario(int id) throws Exception {
		return comentarioDAO.read(id);
	}
	
	public void eliminarComentario(int id) throws Exception {
		comentarioDAO.delete(id);
	}
	public List<Comentario> getComentarios(){
		return comentarioDAO.getList();
	}
	
	public List<Comentario> getComentariosVehiculo(Vehiculo vehiculo){
		return comentarioDAO.getcomentariosVehiculo(vehiculo);
	}
}
