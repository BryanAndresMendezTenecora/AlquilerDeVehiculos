package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.metodoDePagoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

@Stateless
public class MetodoDePagoON implements MetodoDePagoONLocal{
	@Inject
	private metodoDePagoDAO tarjetacreditoDAO;
	
	public void insertarMetodoPago(MetodoDePago tarjetaCredito) throws Exception {
		tarjetaCredito.setNombrepropietario(tarjetaCredito.getNombrepropietario().toUpperCase());
		tarjetaCredito.setTipo(tarjetaCredito.getTipo().toUpperCase());
		tarjetaCredito.setDireccion(tarjetaCredito.getDireccion().toUpperCase());
		tarjetaCredito.setEstado(tarjetaCredito.getEstado().toUpperCase());
		tarjetacreditoDAO.insert(tarjetaCredito);
	}
	
	
	public void actualizarMetodoPago(MetodoDePago tarjetaCredito) throws Exception {
		tarjetaCredito.setNombrepropietario(tarjetaCredito.getNombrepropietario().toUpperCase());
		tarjetaCredito.setTipo(tarjetaCredito.getTipo().toUpperCase());
		tarjetaCredito.setDireccion(tarjetaCredito.getDireccion().toUpperCase());
		tarjetaCredito.setEstado(tarjetaCredito.getEstado().toUpperCase());
		tarjetacreditoDAO.update(tarjetaCredito);
	}
	
	public MetodoDePago buscarMetodoPago(int id) throws Exception {
		return tarjetacreditoDAO.read(id);
	}
	
	public void eliminarMetodoPago(int id) throws Exception {
		tarjetacreditoDAO.delete(id);
	}
	public List<MetodoDePago> getMetodoPagos() throws Exception{
		return tarjetacreditoDAO.getList();
	}
	
	public MetodoDePago getPago(int c) throws Exception {
		return tarjetacreditoDAO.read(c);
	}
	
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
