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
		tarjetacreditoDAO.insert(tarjetaCredito);
	}
	
	
	public void actualizarMetodoPago(MetodoDePago tarjetaCredito) throws Exception {
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
	
	public void guardar(MetodoDePago p) throws Exception {
		if (tarjetacreditoDAO.read(p.getId()) == null)
		
			tarjetacreditoDAO.insert(p);
		else
			tarjetacreditoDAO.update(p);
	}
}
