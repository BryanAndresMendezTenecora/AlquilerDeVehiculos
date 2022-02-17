package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

/**
 * Interfaz local del objeto de negocio Comentario
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface ComentarioONLocal {
	/**
	 * Declaracion del metodo Insertar comentario
	 * 
	 * @param comentario recibe el objeto
	 * @throws Exception
	 */
	public void insertarComentario(Comentario comentario) throws Exception;

	/**
	 * Declaracion del metodo actualizar comentario
	 * 
	 * @param comentario recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarComentario(Comentario comentario) throws Exception;

	/**
	 * Declaracion del metodo buscar comentario
	 * 
	 * @param id recibe el id
	 * @return devuelve el objeto comentario encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Comentario buscarComentario(int id) throws Exception;

	/**
	 * Declaracion del metodo eliminar comentario
	 * 
	 * @param id recibe el id
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarComentario(int id) throws Exception;

	/**
	 * Declaracion del metodo que devuelve una lista de comentario
	 * 
	 * @return devuelve la lista
	 */
	public List<Comentario> getComentarios();

	/**
	 * Declaracion del metodo que devuelve una lista de comentarios por vehiculo
	 * 
	 * @param vehiculo recibe el objeto
	 * @return devuelve la lista
	 */
	public List<Comentario> getComentariosVehiculo(Vehiculo vehiculo);
}
