package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.VehiculoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;


@Stateless
public class VehiculoON implements VehiculoONLocal{
	
	
	@Inject
	private VehiculoDAO VehiculoDAO;
	
	public void insertarVehiculo(Vehiculo Vehiculo) throws Exception {
		VehiculoDAO.insert(Vehiculo);
	}
	
	public void actualizarVehiculo(Vehiculo Vehiculo) throws Exception {
		VehiculoDAO.update(Vehiculo);
	}
	
	public Vehiculo buscarVehiculo(int id) throws Exception {
		return VehiculoDAO.read(id);
	}
	
	public void eliminarVehiculo(int id) throws Exception {
		VehiculoDAO.delete(id);
	}
	public List<Vehiculo> getvehiculos(){
		return VehiculoDAO.getList();
	}
	
	public List<Vehiculo> buscarCategoria(String categoria){
		return VehiculoDAO.getCategoria(categoria);
	}

	public List<Vehiculo> listarDisponibilidad(){
		String disponibilidad="disponible";
		return VehiculoDAO.getVehiculosDisponibilidad(disponibilidad);
	}
}
