package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.ComentarioDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

/**
 * Objeto de negocio de Comentario
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class ComentarioON implements ComentarioONLocal {
	@Inject // Se inyecta el objeto de acceso a datos de comentario
	private ComentarioDAO comentarioDAO;

	/**
	 * Declaracion del metodo Insertar comentario
	 * 
	 * @param comentario recibe el objeto
	 * @throws Exception
	 */
	public void insertarComentario(Comentario comentario) throws Exception {
		comentarioDAO.insert(comentario);
	}

	/**
	 * Declaracion del metodo actualizar comentario
	 * 
	 * @param comentario recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarComentario(Comentario comentario) throws Exception {
		comentarioDAO.update(comentario);
	}

	/**
	 * Declaracion del metodo buscar comentario
	 * 
	 * @param id recibe el id
	 * @return devuelve el objeto comentario encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Comentario buscarComentario(int id) throws Exception {
		return comentarioDAO.read(id);
	}

	/**
	 * Declaracion del metodo eliminar comentario
	 * 
	 * @param id recibe el id
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarComentario(int id) throws Exception {
		comentarioDAO.delete(id);
	}

	/**
	 * Declaracion del metodo que devuelve una lista de comentario
	 * 
	 * @return devuelve la lista
	 */
	public List<Comentario> getComentarios() {
		return comentarioDAO.getList();
	}

	/**
	 * Declaracion del metodo que devuelve una lista de comentarios por vehiculo
	 * 
	 * @param vehiculo recibe el objeto
	 * @return devuelve la lista
	 */
	public List<Comentario> getComentariosVehiculo(Vehiculo vehiculo) {
		return comentarioDAO.getcomentariosVehiculo(vehiculo);
	}
}
