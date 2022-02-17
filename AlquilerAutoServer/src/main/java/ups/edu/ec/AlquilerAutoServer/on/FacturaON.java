package ups.edu.ec.AlquilerAutoServer.on;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.FacturaDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Objeto de negocio de Factura
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class FacturaON implements FacturaONLocal {
	@Inject
	private FacturaDAO facturaDAO; // Se inyecta el objeto de acceso a datos de factura

	/**
	 * Metodo Insertar Factura
	 * 
	 * @param factura recibe el objeto Factura
	 * @throws Exception para capturar excepciones
	 */
	public void insertarFactura(Factura factura) throws Exception {
		facturaDAO.insert(factura);
	}

	/**
	 * Metodo actualizar Factura
	 * 
	 * @param factura recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarFactura(Factura factura) throws Exception {
		facturaDAO.update(factura);
	}

	/**
	 * Metodo buscar Factura
	 * 
	 * @param id el id de la factura
	 * @return devuelve el objeto factura encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Factura buscarFactura(int id) throws Exception {
		return facturaDAO.read(id);
	}

	/**
	 * Metodo eliminar Factura
	 * 
	 * @param id recibe el id de la Factura
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarFactura(int id) throws Exception {
		facturaDAO.delete(id);
	}

	/**
	 * Metodo que devuelve una lista de factura
	 * 
	 * @return devuelve la lista
	 */
	public List<Factura> getFacturas() {
		return facturaDAO.getList();
	}

	/**
	 * Metodo que devuelve una lista de facturas en base al objeto pedido
	 * 
	 * @param pedidos recibe el objeto
	 * @return devuelve una lista
	 */
	public List<Factura> getFacturasPedidos(List<pedidoCabecera> pedidos) {
		List<Factura> facturas = new ArrayList<Factura>();
		/*
		 * for(pedidoCabecera elemento: pedidos) { Factura
		 * factura=buscarFactura(elemento.get) }
		 */

		for (pedidoCabecera elemento : pedidos) {
			Factura factura = facturaDAO.getPedido(elemento);
			facturas.add(factura);
		}
		return facturas;
	}

}
