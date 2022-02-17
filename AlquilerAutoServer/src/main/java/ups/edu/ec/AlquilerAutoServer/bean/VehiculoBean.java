package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.ComentarioONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoON;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

/**
 * Bean para la gestion del Vehículo
 * @author Bryan,Braulio,Juan
 *
 */
@Named
@RequestScoped
public class VehiculoBean implements Serializable {
	
	@Inject
	private VehiculoONLocal vehiculoON; //Inyección al servidor al objeto negocio de Vehículo.
	
	@Inject
	private CategoriaONLocal categoriaON; //Inyección al servidor al objeto negocio de Categoría.
	
	@Inject 
	private ComentarioONLocal comentarioON; //Inyección al servidor al objeto negocio de Comentario.
	
	private Vehiculo vehiculo = new Vehiculo();			//Instancia del objeto vehículo para guardar registros de vehículos.
	private Categoria categoria= new Categoria();		//Instancia del objeto categoria para guardar registros de categorias.
	private Comentario comentario= new Comentario();	//Instancia del objeto comentario para guardar registros de comentarios.
	private List<Comentario> comentarios= new ArrayList<Comentario>();		//Instancia de una lista de tipo comentario para guardar varios registros de comentarios .
	private List<Vehiculo> vehiculos;					//Declaración del objeto vehículo para guardar registros de vehículos.
	private List<Categoria> categorias = new ArrayList<Categoria>() ;	//Instancia de una lista tipo categoria para guardar registros de categorias.
	private int codigo;									//Declaración del dato entero que se guardara las claves primarias.
	private List<SelectItem> listCategorias;			//Instancia del objeto vehículo para guardar registros de vehículos.
	
	/**
	 * Recuperación de un dato entero
	 * @return devuelve un dato entero
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * Asigna un dato entero
	 * @param codigo, se asignara a un dato entero.
	 */
	public void setCodigo(int codigo) {
		System.out.println("set " + codigo);
		this.codigo = codigo;
	}
	
	/**
	 * Recuperación de un Objeto Vehículo
	 * @return devuelve un objeto
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	/**
	 * Asigna un Objeto Vehiculo
	 * @param vehiculo, se asignara a un objeto
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	/**
	 * Recuperación de una lista tipo Vehículo
	 * @return devuelve una lista de un tipo específico.
	 */
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	/**
	 * Asigna una lista que contiene objetos vehículos.
	 * @param vehiculos, este parámetro se asignara a un objeto.
	 */
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	/**
	 * Recuperación de una lista tipo Categoria
	 * @return devuelve una lista de un tipo específico.
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}
	/**
	 * Asigna una lista que contiene objetos categorias.
	 * @param categorias, este parámetro se asignara a un objeto
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	/**
	 * Recuperación de un dato tipo Categoria
	 * @return devuelve un objeto de un tipo específico
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * Asigna un Objeto tipo Categoria
	 * @param categoria, se asignara a un objeto
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	/**
	 * Recuperación un Objeto tipo Comentario
	 * @return devuelve un objeto de un tipo específico
	 */
	public Comentario getComentario() {
		return comentario;
	}
	/**
	 * Asigna un objeto tipo comentario
	 * @param comentario, se asignara a un objeto
	 */
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	/**
	 * Recuperación una lista de tipo Comentarios
	 * @return devuelve una lista de un tipo específico.
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	/**
	 * Añade una lista de tipo Comentario
	 * @return comentarios, se asignara a un objeto
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	/**
	 * Se recupera una lista de vehiculos y categorias desde la base de datos
	 */
	@PostConstruct
	public void init() {
		try {
			vehiculos= vehiculoON.getvehiculos();
			categorias=categoriaON.getCategorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.loadVehiculos();
	}
	
	/**
	 * Este metodo permita la insercción del vehiculo si no existe, o al contrario
	 * si el vehiculo existe, solo le actualizara
	 * @return
	 */
	
	public String guardar() {

		System.out.println("Guardando " + this.vehiculo.getMarca());
		try {

			categoria=categoriaON.buscarCategoria(categoria.getId());
			//System.out.println();
			this.vehiculo.setCategoria(categoria);

			vehiculoON.guardar(this.vehiculo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarVehiculo?faces-redirect=true";
		
	}
	
	/**
	 * Metodo que busca el vehículo mediante categoria
	 * @param categoria, esta variable permitira encontrar por el nombre
	 */
	public void buscarPorCategoria(String categoria){
		try {
			Categoria cate= categoriaON.buscarNombre(categoria);
			this.vehiculos=vehiculoON.buscarCategoria(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	/**
	 * Metodo que listara la disponibilidad de los vehiculos
	 */
	public void listarDisponibilidad() {
		try {
			this.vehiculos=vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Metodo que permitira realizar la actualizacion de un objeto mediante
	 * una llave primaria
	 * @param codigo, es la llave primaria
	 * @return Navegación a la página crear vehículo
	 */
	public String editar(int codigo) {
		System.out.println(codigo);
		return "crear-vehiculo?faces-redirect=true&id=" + codigo;
	}
	
	/**
	 * Metodo que recupera todos los registros de la tabla vehículos
	 */
	private void loadVehiculos() {
		try {
			this.vehiculos = vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que recupera un objeto especifico del registro del base de datos
	 * mediante una llave primaria
	 */
	public void loadData() {
		if(codigo==0)
			return;
		
		Vehiculo p;
		try {
			vehiculo = vehiculoON.getVehiculo(codigo);
			categoria=vehiculo.getCategoria();
			//vehiculo=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Metodo que se encarga de recuperar un vehículo
	 */
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
	
	/**
	 * Metodo para recorrer una lista, en este caso sería
	 * una lista de categorias 
	 * @return devuelve una lista
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
	 * Mediante la actualización del objeto, el estado será el atributo
	 * a enfocarse, porque cambiara a ELIMINADO
	 * @param codigo es una llave primaria
	 * @return Navegación a la página listar vehículo
	 */
	public String eliminar(int codigo) {
		System.out.println("eliminando " + this.vehiculo.getMarca());

		try {
			vehiculo=vehiculoON.buscarVehiculo(codigo);
			vehiculo.setEstado("ELIMINADO");
			vehiculoON.actualizarVehiculo(vehiculo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarVehiculo?faces-redirect=true";
		
	}
	/**
	 * Mediante una llave primaria, se recupera un Objeto Vehículo
	 */
	public void cargarVehiculo() {
		System.out.println("Entro el cargar");
		try {
			vehiculo=vehiculoON.buscarVehiculo(vehiculo.getId());
			System.out.println("RC VE:"+vehiculo.getId()+" -- "+vehiculo.getPrecio());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Mediante este método se permite hacer la inserción a la tabla
	 * de comentario
	 * @param persona
	 */
	public void insertarComentario(Persona persona) {
		//comentario.setPersona(loginBean.getPersona());
		comentario.setPersona(persona);
		comentario.setVehiculo(vehiculo);
		try {
			comentarioON.insertarComentario(comentario);
			listadoComentarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//comentario.setCalificacion(0);
		//comentario.setDescripcion("");
	}
	
	/**
	 * Recupera una lista de registros de la tabla comentarios, mediante
	 * la llave primaria de un vehículo
	 */
	public void listadoComentarios() {
		comentarios=comentarioON.getComentariosVehiculo(vehiculo);
		System.out.println("Lista comentarios"+comentarios.size());
	}

	/**
	 * Navegación entre páginas
	 * @return Navegación a la página carrito
	 */
	
	public String paginaInicio() {
		return "pro-carro?faces-redirect=true";
	}
	
	/**
	 * Recupera un listado mediante el atributo estado del objeto vehículo.
	 */
	public void listadoEstado() {
		vehiculos=vehiculoON.getListaVehiculoEstado(vehiculo.getEstado());
		for(Vehiculo elemento: vehiculos) {
			System.out.println("C-V:"+elemento.getId()+" Estado: "+elemento.getEstado());
		}
	}

}

	
