package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoON;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

@Named
@RequestScoped
public class VehiculoBean {
	
	@Inject
	private VehiculoONLocal vehiculoON;
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	private Vehiculo vehiculo;
	private List<Vehiculo> vehiculos;
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	@PostConstruct
	public void init() {
		vehiculos= vehiculoON.getvehiculos();
	}
	
	public String guardar() {

		System.out.println("Guardando " + this.vehiculo.getMarca());

		/*
		 * Persona p= new Persona(); p.setCedula(this.cedula); p.setNombre(this.nombre);
		 * p.setDireccion(this.direccion);
		 */
		try {
			vehiculoON.insertarVehiculo(this.vehiculo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return "listado-personas?faces-redirect=true";
		return null;
	}
	
	
	public String buscarPorCategoria(String categoria){
		try {
			Categoria cate= categoriaON.buscarNombre(categoria);
			this.vehiculos=vehiculoON.buscarCategoria(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void listarDisponibilidad() {
		this.vehiculos=vehiculoON.getvehiculos();
		
	}

}
