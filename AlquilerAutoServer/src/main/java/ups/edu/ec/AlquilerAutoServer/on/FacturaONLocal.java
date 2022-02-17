package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Interfaz local del objeto de negocio Factura
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface FacturaONLocal {
	/**
	 * Declaracion del metodo Insertar Factura
	 * 
	 * @param factura recibe el objeto Factura
	 * @throws Exception para capturar excepciones
	 */
	public void insertarFactura(Factura factura) throws Exception;

	/**
	 * Declaracion del metodo actualizar Factura
	 * 
	 * @param factura recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarFactura(Factura factura) throws Exception;

	/**
	 * Declaracion del metodo buscar Factura
	 * 
	 * @param id el id de la factura
	 * @return devuelve el objeto factura encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Factura buscarFactura(int id) throws Exception;

	/**
	 * Declaracion del metodo eliminar Factura
	 * 
	 * @param id recibe el id de la Factura
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarFactura(int id) throws Exception;

	/**
	 * Declaracion del Metodo que devuelve una lista de factura
	 * 
	 * @return devuelve la lista
	 */
	public List<Factura> getFacturas();

	/**
	 * Declaracion del metodo que devuelve una lista de facturas en base al objeto
	 * pedido
	 * 
	 * @param pedidos recibe el objeto
	 * @return devuelve una lista
	 */
	public List<Factura> getFacturasPedidos(List<pedidoCabecera> pedidos);
}
