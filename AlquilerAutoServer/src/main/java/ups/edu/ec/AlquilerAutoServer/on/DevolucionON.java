package ups.edu.ec.AlquilerAutoServer.on;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.DevolucionDAO;
import ups.edu.ec.AlquilerAutoServer.dao.FacturaDAO;
import ups.edu.ec.AlquilerAutoServer.dao.PedidoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Objeto de negocio de Devolucion
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class DevolucionON implements DevolucionONLocal {
	@Inject
	private DevolucionDAO devolucionDAO; // Se inyecta el objeto de acceso a datos de devolucion

	@Inject
	private FacturaDAO facturaDAO; // Se inyecta el objeto de acceso a datos de factura

	@Inject
	private PedidoDAO pedidoDAO; // Se inyecta el objeto de acceso a datos de pedido

	/**
	 * Metodo Insertar devolucion
	 * 
	 * @param devolucion recibe el objeto devolucion
	 * @throws Exception para capturar excepciones
	 */
	public void insertarDevolucion(Devolucion devolucion) throws Exception {
		devolucionDAO.insert(devolucion);
	}

	/**
	 * Metodo actualizar devolucion
	 * 
	 * @param devolucion recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarDevolucion(Devolucion devolucion) throws Exception {
		devolucionDAO.update(devolucion);
	}

	/**
	 * Metodo buscar Devolucion
	 * 
	 * @param id recibe el id de la devolucion
	 * @return devuelve el objeto devolucion encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Devolucion buscarDevolucion(int id) throws Exception {
		return devolucionDAO.read(id);
	}

	/**
	 * Metodo eliminar Devolucion
	 * 
	 * @param id recibe el id de la devolucion
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarDevolucion(int id) throws Exception {
		devolucionDAO.delete(id);
	}

	/**
	 * Metodo que devuelve una lista de devoluciones
	 * 
	 * @return devuelve la lista
	 */
	public List<Devolucion> getDevolucions() {
		try {
			return devolucionDAO.getDevoluciones();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Metodo que devuelve una lista de antecedentes de devoluciones por cedula de
	 * la persona
	 * 
	 * @param cedula recibe el objeto
	 * @return devuelve una lista
	 */
	public List<Devolucion> getAntecedentes(Persona cedula) {
		List<Devolucion> devoluciones = new ArrayList<Devolucion>();
		List<pedidoCabecera> pedidos = pedidoDAO.getListaNombre(cedula);
		System.out.println("Lista pedidos:" + pedidos.size());

		for (pedidoCabecera elemento : pedidos) {
			System.out.println(elemento.getId());
			Factura f = new Factura();
			f = facturaDAO.getPedido(elemento);
			List<Devolucion> listado = devolucionDAO.getAntecedentes(f);
			Devolucion d = new Devolucion();
			if (listado.size() == 1) {

				// Devolucion d= new Devolucion();
				// pedidoCabecera cab= new pedidoCabecera();
				listado = devolucionDAO.getAntecedentes(f);
				d = listado.get(0);
				devoluciones.add(d);
			} else {
				for (Devolucion ele : listado) {
					devoluciones.add(ele);
				}
			}

		}
		return devoluciones;
	}

}
