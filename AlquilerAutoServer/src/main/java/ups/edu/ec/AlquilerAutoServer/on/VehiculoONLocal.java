package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
@Local
public interface VehiculoONLocal {

	public void insertarVehiculo(Vehiculo Vehiculo) throws Exception;
	public void actualizarVehiculo(Vehiculo Vehiculo) throws Exception;
	public Vehiculo buscarVehiculo(int id) throws Exception;
	public void eliminarVehiculo(int id) throws Exception;
	public List<Vehiculo> getvehiculos();
}
