package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
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
	
	private Vehiculo vehiculo = new Vehiculo();
	private Categoria categoria= new Categoria();
	private List<Vehiculo> vehiculos;
	private List<Categoria> categorias;
	private int codigo;
	private List<SelectItem> listCategorias;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		System.out.println("set " + codigo);
		this.codigo = codigo;
	}
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
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	@PostConstruct
	public void init() {
		vehiculo = new Vehiculo();
		vehiculo.setCategoria(new Categoria());
		try {
			vehiculos= vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.loadVehiculos();
	}
	
	public String guardar() {

		System.out.println("Guardando " + this.vehiculo.getMarca());

		/*
		 * Persona p= new Persona(); p.setCedula(this.cedula); p.setNombre(this.nombre);
		 * p.setDireccion(this.direccion);
		 */
		try {
			
			this.vehiculo.setEstado("Activo");
			vehiculoON.guardar(this.vehiculo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarVehiculo?faces-redirect=true";
		
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
		try {
			this.vehiculos=vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String editar(int codigo) {
		System.out.println(codigo);
		return "crear-vehiculo?faces-redirect=true&id=" + codigo;
	}
	
	
	private void loadVehiculos() {
		try {
			this.vehiculos = vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadData() {
		if(codigo==0)
			return;
		
		Vehiculo p;
		try {
			p = vehiculoON.getVehiculo(codigo);
			vehiculo=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadDataEditar() {
		Vehiculo p;
		try {
			p = vehiculoON.getVehiculo(vehiculo.getId());
			vehiculo=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<SelectItem> getListCategorias() {
		this.listCategorias =new  ArrayList<SelectItem>();
		List<Categoria> c =categoriaON.listarcategorias();
		listCategorias.clear();
		for (Categoria cat:c) {
			SelectItem categoriaitem =new SelectItem(cat.getId(),cat.getNombre());
			this.listCategorias.add(categoriaitem);
		}
		return listCategorias;
	}
	
	
	//Hola
}
