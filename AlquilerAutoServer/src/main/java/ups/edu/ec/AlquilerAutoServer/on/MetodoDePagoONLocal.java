package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.dao.metodoDePagoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;
@Local
public interface MetodoDePagoONLocal {

	public void insertarMetodoPago(MetodoDePago tarjetaCredito) throws Exception;
	public void actualizarMetodoPago(MetodoDePago tarjetaCredito) throws Exception;
	public MetodoDePago buscarMetodoPago(int id) throws Exception;
	public void eliminarMetodoPago(int id) throws Exception;
	public List<MetodoDePago> getMetodoPagos() throws Exception;
	public MetodoDePago getPago(int c) throws Exception;
	public void guardar(MetodoDePago p) throws Exception;
}
