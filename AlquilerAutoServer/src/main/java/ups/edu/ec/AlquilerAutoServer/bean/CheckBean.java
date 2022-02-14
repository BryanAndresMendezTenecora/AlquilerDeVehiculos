package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

@Named
@ViewScoped
public class CheckBean implements Serializable {

	private Categoria categoria= new Categoria();
	private List<Categoria> categorias= new ArrayList<Categoria>();
	private List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	@Inject
	private VehiculoONLocal vechiculoON;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	@PostConstruct
	public void init() {
		categorias=categoriaON.getCategorias();
	}
	
	
	public void imprimirId() {
		System.out.println("Entro");
		System.out.println("C-C: "+categoria.getId());
	}
}
