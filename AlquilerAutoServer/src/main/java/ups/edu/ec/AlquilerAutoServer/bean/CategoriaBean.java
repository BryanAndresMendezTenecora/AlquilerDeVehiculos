package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaON;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;

@Named
@RequestScoped
public class CategoriaBean {
	@Inject
	private CategoriaONLocal categoriaON;
	private Categoria categoria=new Categoria();
	private List<Categoria> categorias;
	private int id;
	private  String nombre;
	
	@PostConstruct
	public void init() {
		this.loadcategorias();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String guardar() {

		System.out.println("Guardando " + this.categoria.getNombre());

		try {
			categoriaON.guardar(this.categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return "listado-personas?faces-redirect=true";
		return "listarCategoria?faces-redirect=true";
	}
	
	public void loadcategorias() {
		this.categorias = categoriaON.getCategorias();
	}
	public String editar(int id) {
		System.out.println(id);
		return "Categoria?faces-redirect=true&id=" + id;
	}
	public void loadData() {
		if(id==0)
			return;
		
		Categoria p;
		try {
			p = categoriaON.getCategoria(id);
			categoria=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void loadDataEditar() {
		Categoria p;
		try {
			p = categoriaON.getCategoria(categoria.getId());
			categoria=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
