package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.TarjetacreditoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.TarjetaCredito;

@Stateless
public class TarjetacreditoON implements TarjetacreditoONLocal{
	@Inject
	private TarjetacreditoDAO tarjetacreditoDAO;
	public void insertarTarjetaCredito(TarjetaCredito tarjetaCredito) throws Exception {
		tarjetacreditoDAO.insert(tarjetaCredito);
	}
	
	
	public void actualizarTarjetaCredito(TarjetaCredito tarjetaCredito) throws Exception {
		tarjetacreditoDAO.update(tarjetaCredito);
	}
	
	public TarjetaCredito buscarTarjetaCredito(int id) throws Exception {
		return tarjetacreditoDAO.read(id);
	}
	
	public void eliminarTarjetaCredito(int id) throws Exception {
		tarjetacreditoDAO.delete(id);
	}
	public List<TarjetaCredito> getTarjetaCreditos(){
		return tarjetacreditoDAO.getList();
	}
}
