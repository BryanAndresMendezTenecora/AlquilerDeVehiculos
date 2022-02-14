package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.PedidoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
@Stateless
public class PedidoON implements PedidoONLocal{
	@Inject
	private PedidoDAO pedidoDAO;
	
	public void insertarpedidoCabecera(pedidoCabecera pedidoCabece)throws Exception {
		pedidoDAO.insert(pedidoCabece);
	}
	
	
	public void actualizarpedidoCabecera(pedidoCabecera pedidoCabece) throws Exception {
		pedidoDAO.update(pedidoCabece);
	}
	
	public pedidoCabecera buscarpedidoCabecera(int id) throws Exception {
		return pedidoDAO.read(id);
	}
	
	public void eliminarpedidoCabecera(int id) throws Exception {
		pedidoDAO.delete(id);
	}
	public List<pedidoCabecera> getpedidoCabeceras(){
		return pedidoDAO.getList();
	}
	
	public List<pedidoCabecera> getPedidosCedula(Persona persona){
		return pedidoDAO.getPedidosNombre(persona);
	}
}
