package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;


import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
@Local
public interface FacturaONLocal {
	public void insertarFactura(Factura factura) throws Exception;
	public void actualizarFactura(Factura factura) throws Exception;
	public Factura buscarFactura(int id) throws Exception;
	public void eliminarFactura(int id) throws Exception;
	public List<Factura> getFacturas();
	public List<Factura> getFacturasPedidos(List<pedidoCabecera> pedidos);
}
