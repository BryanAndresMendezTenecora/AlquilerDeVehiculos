package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
@Local
public interface VehiculoONLocal {

	public void insertarVehiculo(Vehiculo Vehiculo) throws Exception;
	public void actualizarVehiculo(Vehiculo Vehiculo) throws Exception;
	public Vehiculo buscarVehiculo(int id) throws Exception;
	public void eliminarVehiculo(int id) throws Exception;
	public List<Vehiculo> getvehiculos() throws Exception;
	public List<Vehiculo> buscarCategoria(String categoria);
	public Vehiculo getVehiculo(int codigo) throws Exception;
	
	public void guardar(Vehiculo p) throws Exception;
	public List<Categoria> listarcategorias();
<<<<<<< HEAD
	List<Vehiculo> getlistadoVehiculos(int codigo);
	public List<Vehiculo> getListaVehiculoCategoria(Categoria categoria);
	public List<Vehiculo> getListaVehiculoEstado(String estado);
=======
>>>>>>> 7c84c3ae4d55fde831479bfb84efb35630523692
}
