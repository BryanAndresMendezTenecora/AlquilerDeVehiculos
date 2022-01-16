package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.dao.TarjetacreditoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.TarjetaCredito;
@Local
public interface TarjetacreditoONLocal {

	public void insertarTarjetaCredito(TarjetaCredito tarjetaCredito) throws Exception ;
	public void actualizarTarjetaCredito(TarjetaCredito tarjetaCredito) throws Exception;
	public TarjetaCredito buscarTarjetaCredito(int id) throws Exception;
	public void eliminarTarjetaCredito(int id) throws Exception;
	public List<TarjetaCredito> getTarjetaCreditos();
}
