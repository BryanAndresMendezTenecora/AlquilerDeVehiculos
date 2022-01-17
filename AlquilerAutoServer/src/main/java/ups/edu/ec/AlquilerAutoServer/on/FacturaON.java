package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.FacturaDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
@Stateless
public class FacturaON implements FacturaONLocal{
	@Inject
	private FacturaDAO facturaDAO;
	
	public void insertarFactura(Factura factura) throws Exception {
		facturaDAO.insert(factura);
	}
	
	
	public void actualizarFactura(Factura factura) throws Exception {
		facturaDAO.update(factura);
	}
	
	public Factura buscarFactura(int id) throws Exception {
		return facturaDAO.read(id);
	}
	
	public void eliminarFactura(int id) throws Exception {
		facturaDAO.delete(id);
	}
	public List<Factura> getFacturas(){
		return facturaDAO.getList();
	}
}
