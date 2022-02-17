package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;
import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
/**
 * Interfaz de Objeto de negocio de pedido
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface PedidoONLocal {
	
	/**
	 * Declaracion de Metodo para insertar pedido
	 * @param recibe objeto pedidoCabece
	 * @throws Exception para capturar excepciones
	 */
	public void insertarpedidoCabecera(pedidoCabecera pedidoCabece)throws Exception;
	
	/**
	 * Declaracion de metodo para actualizar pedido
	 * @param recibe objeto pedidoCabece
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarpedidoCabecera(pedidoCabecera pedidoCabece) throws Exception;
	
	/**
	 * Declaracion de metodo para buscar pedido 
	 * @param recibe id de pedido
	 * @return devuelve objeto pedido
	 * @throws Exception para capturar excepciones
	 */
	public pedidoCabecera buscarpedidoCabecera(int id) throws Exception;
	
	/**
	 * Declaracion de metodo eliminar pedido
	 * @param recibe id de pedido
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarpedidoCabecera(int id) throws Exception;
	
	/**
	 * Declaracion de metodo para listar pedido
	 * @return devuelve una lista de pedidos
	 */
	public List<pedidoCabecera> getpedidoCabeceras();
	
	/**
	 * Declaracion de metodo  de listar pedidos
	 * @param recibe un objeto persona
	 * @return devuelve una lista de pedidos por por persona
	 */
	public List<pedidoCabecera> getPedidosCedula(Persona persona);
	
}
