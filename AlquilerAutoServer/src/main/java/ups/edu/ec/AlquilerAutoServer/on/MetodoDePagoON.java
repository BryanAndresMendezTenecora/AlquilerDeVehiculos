package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.metodoDePagoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
/**
 * Objeto de negocio de Metodo de pago
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class MetodoDePagoON implements MetodoDePagoONLocal{
	@Inject
	private metodoDePagoDAO tarjetacreditoDAO; // Se inyecta el objeto de acceso a datos de Metodo de pago
	
	/**
	 * Metodo insertar metodo pago
	 * 
	 * @param recibe objeto tarjetaCredito
	 * @throws Exception para capturar excepciones
	 */
	public void insertarMetodoPago(MetodoDePago tarjetaCredito) throws Exception {
		tarjetaCredito.setNombrepropietario(tarjetaCredito.getNombrepropietario().toUpperCase());
		tarjetaCredito.setTipo(tarjetaCredito.getTipo().toUpperCase());
		tarjetaCredito.setDireccion(tarjetaCredito.getDireccion().toUpperCase());
		tarjetaCredito.setEstado(tarjetaCredito.getEstado().toUpperCase());
		tarjetacreditoDAO.insert(tarjetaCredito);
	}
	
	/**
	 * Metodo actualizar
	 * 
	 * @param recibe objeto tarjetaCredito
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarMetodoPago(MetodoDePago tarjetaCredito) throws Exception {
		tarjetaCredito.setNombrepropietario(tarjetaCredito.getNombrepropietario().toUpperCase());
		tarjetaCredito.setTipo(tarjetaCredito.getTipo().toUpperCase());
		tarjetaCredito.setDireccion(tarjetaCredito.getDireccion().toUpperCase());
		tarjetaCredito.setEstado(tarjetaCredito.getEstado().toUpperCase());
		tarjetacreditoDAO.update(tarjetaCredito);
	}
	
	
	/**
	 * Metodo buscar metodo
	 * 
	 * @param recibe id del metodo de pago
	 * @return devuelve objeto metodo de pago
	 * @throws Exception para capturar excepciones
	 */
	public MetodoDePago buscarMetodoPago(int id) throws Exception {
		return tarjetacreditoDAO.read(id);
	}
	
	
	/**
	 * Metodo eliminar metodo del pago
	 * 
	 * @param recibe id del metodo del pago
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarMetodoPago(int id) throws Exception {
		tarjetacreditoDAO.delete(id);
	}
	
	/**
	 * Metodo de listar metodos de pagos
	 * 
	 * @return devuelve una lista de metodos de pagos
	 * @throws Exception para capturar excepciones
	 */
	public List<MetodoDePago> getMetodoPagos() throws Exception{
		return tarjetacreditoDAO.getList();
	}
	
	
	/**
	 * Metodo buscar metodo de pago
	 * 
	 * @param recibe c como objeto metodoDePago
	 * @return devuelve una lista de metodos de pagos
	 * @throws Exception para capturar excepciones
	 */
	public MetodoDePago getPago(int c) throws Exception {
		return tarjetacreditoDAO.read(c);
	}
	
	
	/**
	 * 
	 * Metodo guardar metodo de pago
	 * 
	 * @param recibe p como objeto metodo de pago
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(MetodoDePago tarjetaCredito) throws Exception {
		tarjetaCredito.setNombrepropietario(tarjetaCredito.getNombrepropietario().toUpperCase());
		tarjetaCredito.setTipo(tarjetaCredito.getTipo().toUpperCase());
		tarjetaCredito.setDireccion(tarjetaCredito.getDireccion().toUpperCase());
		tarjetaCredito.setEstado(tarjetaCredito.getEstado().toUpperCase());
		if (tarjetacreditoDAO.read(tarjetaCredito.getId()) == null) {
		
			tarjetacreditoDAO.insert(tarjetaCredito);
		}else {
			tarjetacreditoDAO.update(tarjetaCredito);
		}
	}
}
