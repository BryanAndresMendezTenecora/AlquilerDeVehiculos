package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;
import ups.edu.ec.AlquilerAutoServer.dao.metodoDePagoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;

/**
 * Interfaz de Objeto de negocio de metodo de pago
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface MetodoDePagoONLocal {

	/**
	 * Declaracion del metodo insertar metodo pago
	 * 
	 * @param recibe objeto tarjetaCredito
	 * @throws Exception para capturar excepciones
	 */
	public void insertarMetodoPago(MetodoDePago tarjetaCredito) throws Exception;

	/**
	 * Declaracion del metodo actualizar
	 * 
	 * @param recibe objeto tarjetaCredito
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarMetodoPago(MetodoDePago tarjetaCredito) throws Exception;

	/**
	 * Declaracion del metodo buscar metodo
	 * 
	 * @param recibe id del metodo de pago
	 * @return devuelve objeto metodo de pago
	 * @throws Exception para capturar excepciones
	 */
	public MetodoDePago buscarMetodoPago(int id) throws Exception;

	/**
	 * Declaracion del metodo eliminar metodo del pago
	 * 
	 * @param recibe id del metodo del pago
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarMetodoPago(int id) throws Exception;

	/**
	 * Declaracion del metodo de listar metodos de pagos
	 * 
	 * @return devuelve una lista de metodos de pagos
	 * @throws Exception para capturar excepciones
	 */
	public List<MetodoDePago> getMetodoPagos() throws Exception;

	/**
	 * Declaracion del metodo buscar metodo de pago
	 * 
	 * @param recibe c como objeto metodoDePago
	 * @return devuelve una lista de metodos de pagos
	 * @throws Exception para capturar excepciones
	 */
	public MetodoDePago getPago(int c) throws Exception;

	/**
	 * 
	 * Declaracion del metodo guardar metodo de pago
	 * 
	 * @param recibe p como objeto metodo de pago
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(MetodoDePago p) throws Exception;
}
