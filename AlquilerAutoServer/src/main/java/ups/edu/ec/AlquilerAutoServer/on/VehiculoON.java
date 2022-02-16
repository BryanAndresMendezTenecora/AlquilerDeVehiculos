package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.VehiculoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;


@Stateless
public class VehiculoON implements VehiculoONLocal{
	
	
	@Inject
	private VehiculoDAO VehiculoDAO;
	
	
	public void insertarVehiculo(Vehiculo Vehiculo) throws Exception {
		Vehiculo.setMarca(Vehiculo.getMarca().toUpperCase());
		Vehiculo.setModelo(Vehiculo.getModelo().toUpperCase());
		Vehiculo.setEstado(Vehiculo.getEstado().toUpperCase());
		VehiculoDAO.insert(Vehiculo);
	}
	
	public void actualizarVehiculo(Vehiculo Vehiculo) throws Exception {
		Vehiculo.setMarca(Vehiculo.getMarca().toUpperCase());
		Vehiculo.setModelo(Vehiculo.getModelo().toUpperCase());
		Vehiculo.setEstado(Vehiculo.getEstado().toUpperCase());
		VehiculoDAO.update(Vehiculo);
	}
	
	public Vehiculo buscarVehiculo(int id) throws Exception {
		return VehiculoDAO.read(id);
	}
	
	public void eliminarVehiculo(int id) throws Exception {
		VehiculoDAO.delete(id);
	}
	public List<Vehiculo> getvehiculos() throws Exception{
		return VehiculoDAO.getList();
	}
	
	public List<Vehiculo> buscarCategoria(String categoria){
		return VehiculoDAO.getCategoria(categoria);
	}

	public List<Vehiculo> listarDisponibilidad() throws Exception{
		String disponibilidad="disponible";
		return VehiculoDAO.getVehiculosDisponibilidad(disponibilidad);
	}
	
	public Vehiculo getVehiculo(int codigo) throws Exception {
		return VehiculoDAO.read(codigo);
	}
	
	
	public void guardar(Vehiculo vehiculo) throws Exception {
		System.out.println("ON: C-VEHI: "+vehiculo.getId());
		vehiculo.setMarca(vehiculo.getMarca().toUpperCase());
		vehiculo.setModelo(vehiculo.getModelo().toUpperCase());
		vehiculo.setEstado(vehiculo.getEstado().toUpperCase());
		if (VehiculoDAO.read(vehiculo.getId()) == null) {
			System.out.println(" V:Entro al INSERTAR");
			VehiculoDAO.insert(vehiculo);
		}else {
			VehiculoDAO.update(vehiculo);
			System.out.println("V:Entro al UPDATE");
		}
	}
	public List<Categoria> listarcategorias(){
		return VehiculoDAO.listarcategorias();
	}
	
	public List<Vehiculo> getlistadoVehiculos(int codigo){
		if(codigo == 1) {
			return VehiculoDAO.getVehiculosPrecioMayorMenor();
		}else if(codigo == 2) {
			return VehiculoDAO.getVehiculosPrecioMenorMayor();
		}else if(codigo == 3) {
			return VehiculoDAO.getVehiculosNombreAZ();
		}else if(codigo == 4) {
			return VehiculoDAO.getVehiculosModeloZA();
		}
		return VehiculoDAO.getList();
	}
	
	public List<Vehiculo> getListaVehiculoCategoria(Categoria categoria){
		return VehiculoDAO.getVehiculosCategoria(categoria);
	}
	
	public List<Vehiculo> getListaVehiculoEstado(String estado){
		return VehiculoDAO.getVehiculosEstado(estado);
	}
}
