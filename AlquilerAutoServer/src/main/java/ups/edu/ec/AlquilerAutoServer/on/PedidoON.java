package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.PedidoDAO;
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
		List<pedidoCabecera> ped=pedidoDAO.getList(); 
		
		System.out.println("tamano d ela lista -------------"+ped.size());
		return pedidoDAO.getList();
	}
}
