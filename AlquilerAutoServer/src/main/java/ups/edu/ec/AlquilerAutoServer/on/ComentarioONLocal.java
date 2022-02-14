package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
@Local
public interface ComentarioONLocal {
	public void insertarComentario(Comentario comentario) throws Exception;
	public void actualizarComentario(Comentario comentario) throws Exception;
	public Comentario buscarComentario(int id) throws Exception;
	public void eliminarComentario(int id) throws Exception;
	public List<Comentario> getComentarios();
	public List<Comentario> getComentariosVehiculo(Vehiculo vehiculo);
}
