package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaON;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;

@Named
@RequestScoped
public class CategoriaBean implements Serializable{
	@Inject
	private CategoriaONLocal categoriaON; 			//Inyección al servidor mediante los onjetos de negocio de Categoria.
	private Categoria categoria=new Categoria();	//Instancia de un objeto tipo Categoria
	private List<Categoria> categorias;				//Declaración de una lista de tipo Categoria
	private int id;									//Declaración de un dato entero para guardar las llaves primarias
	private  String nombre;							//Declaración de un dato string
	private List<SelectItem> listCategorias; 		//Declaración de una lista, para recorrer las categorias
	

	/**
	 * Al iniciar la página JSF, se activara este método
	 * que trae todas las categorias en una lista
	 */
	@PostConstruct
	public void init() {
		this.loadcategorias();
	}
	/**
	 * Recuperación de un Objeto Categoria
	 * @return devuelve un objeto
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	
	/**
	 * Asigna un Objeto Categoria
	 * @param categoria, se asignara a un objeto
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	/**
	 * Recuperación de un dato entero
	 * @return devuelve un dato entero.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Asigna un dato entero
	 * @param id, se asignara un dato entero.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Recuperación de un dato string
	 * @return devuelve un dato relacionado al nombre de la categoria
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Asigna un dato string
	 * @param nombre, se asignara a un dato tipo caracter
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *  Recuperación de una lista tipo categoria
	 * @return devuelve una lista que contiene datos de el objeto categoria
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * Asigna una lista tipo Categoria
	 * @param categorias, se asignara a un objeto
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * Hace la insercción del objeto categoria a la base de datos
	 * @return Navegación a la página listar categoria.
	 */
	public String guardar() {

		System.out.println("Guardando " + this.categoria.getNombre());
		System.out.println("Categoria: "+categoria.getEstado()+" --- "+categoria.getNombre());
		try {
			//this.categoria.setEstado("Activo");
			categoriaON.guardar(this.categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return "listado-personas?faces-redirect=true";
		return "listarCategoria?faces-redirect=true";
	}
	
	
	/**
	 * Recupera todos los registros de categorias
	 */
	public void loadcategorias() {
		this.categorias = categoriaON.getCategorias();
	}
	/**
	 * Metodo para la actualización del objeto seleccionado,
	 * la selección de le hace por una llave primaria.
	 * @param id es la llave primaria.
	 * @return Navegación a la página Categoria
	 */
	public String editar(int id) {
		System.out.println(id);
		return "Categoria?faces-redirect=true&id=" + id;
	}
	
	/**
	 * Metodo para recuperar una categoría mediante una llave primaria
	 */
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
	
	/**
	 * Metodo para la actualización de la categoria, se necesita
	 * primero la recuperación de la categoría.
	 */
	
	public void loadDataEditar() {
		Categoria p;
		try {
			categoria = categoriaON.getCategoria(categoria.getId());
			//categoriaON.actualizarCategoria(categoria);
			//categoria=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo para recorre la lista de categorias
	 * @return devuelve una lista tipo categorias
	 */
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
	
	/**
	 * Metodo que elimina una categoria, esta funcionalidad
	 * funciona con la actualización, el atributo a cambiar sera el
	 * estado.
	 * @param id
	 * @return Navegación a la página listar categoria.
	 */
	public String eliminarcategoria(int id) {
		
		try {
			categoria=categoriaON.buscarCategoria(id);
			categoria.setEstado("ELIMINADO");
			categoriaON.actualizarCategoria(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listarCategoria?faces-redirect=true";
	}

	
	
	
	
}
