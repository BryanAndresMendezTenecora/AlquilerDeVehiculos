package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaON;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;

@Named
@RequestScoped
public class CategoriaBean {
	@Inject
	private CategoriaONLocal categoriaON;
	private Categoria categoria=new Categoria();
	private List<Categoria> categorias;
	
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
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String guardar() {

		System.out.println("Guardando " + this.categoria.getNombre());

		try {
			categoriaON.insertarCategoria(this.categoria);
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
	
}
