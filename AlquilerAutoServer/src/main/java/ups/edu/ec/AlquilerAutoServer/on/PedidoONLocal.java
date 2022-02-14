package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
@Local
public interface PedidoONLocal {
	public void insertarpedidoCabecera(pedidoCabecera pedidoCabece)throws Exception;
	public void actualizarpedidoCabecera(pedidoCabecera pedidoCabece) throws Exception;
	public pedidoCabecera buscarpedidoCabecera(int id) throws Exception;
	public void eliminarpedidoCabecera(int id) throws Exception;
	public List<pedidoCabecera> getpedidoCabeceras();
	public List<pedidoCabecera> getPedidosCedula(Persona persona);
	
}
