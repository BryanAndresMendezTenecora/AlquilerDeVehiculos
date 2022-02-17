package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Detalle;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.FacturaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.MetodoDePagoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

/**
 * Bean para la gestión del carrito,pedido,factura
 * @author Bryan Mendez, Juan Boni, Braulio Astudillo
 *
 */
@Named
@SessionScoped
public class ProcarroBean implements Serializable {

	
	@Inject
	private PedidoONLocal pedidoON; 		//Inyección al servidor mediante el objeto ON Pedido.
	
	@Inject
	private FacturaONLocal facturaON;		//Inyección al servidor mediante el objeto de negocio de factura.
	
	@Inject
	private VehiculoONLocal vehiculoON;			//Inyección al servidor mediante el objeto de negocio de vehículo.
	
	@Inject 
	private MetodoDePagoONLocal metodoON; 		//Inyección al servidor mediante el objeto de negocio de metodo de pago.
	
	@Inject
	private CategoriaONLocal categoriaON;		//Inyección al servidor mediante el objeto de negocio de categria.
	
	@Inject
	private PersonaONLocal personaON;			//Inyección al servidor mediante el objeto de negocio de persona.
		
	
	private int cont=1;				//Instancia de un dato tipo int, que servira de contador.
	
	private Factura factura= new Factura();		//Instancia de un dato tipo Factura, se guardara información de la factura a tratar.
	
	private pedidoCabecera cabecera = new pedidoCabecera(); //Instancia de un dato tipo Pedido, se guardara información del Pedido a tratar.
	
	private MetodoDePago metodo= new MetodoDePago(); //Instancia de un dato tipo Metodo de Pago, se guardara información del metodo de pago a tratar.
	
	private Categoria categoria=new Categoria(); //Instancia de un dato tipo Categoria, se guardara información de la categoria a tratar.
	
	private Persona persona= new Persona(); //Instancia de un dato tipo Persona, se guardara información de la persona a tratar.
	
	private Detalle detalle; //Declaración de un dato tipo detalle, se guardara información del detalla a tratar para su inserción a una lista.
		
	private List<Detalle> detalles= new ArrayList<Detalle>(); //Instancia de una lista tipo Detalle, para agregar los detalles del pedido 
	
	private List<Vehiculo> vehiculos= new ArrayList<Vehiculo>(); //Instancia de una lista tipo Vehiculo, para recuperar todos los vehículos existentes.
	
	private List<MetodoDePago> metodos= new ArrayList<MetodoDePago>(); //Instancia de una lista tipo metodo de pagos, para recuperar todos los metodos de pagos existentes.
	
	private List<Categoria> categorias= new ArrayList<Categoria>(); //Instancia de una lista tipo categoria, para recuperar todos los categoria existentes.
	
	private int listado=0; //Instancia de un dato tipo int para los tipos de listados que puede tener el catálogo.
	
	private FacesContext facesContext; //Para la gestion de los beans.
	
	private List<pedidoCabecera> pedidos= new ArrayList<pedidoCabecera>(); // Instancia de una lista de pedidos. 
	
	
	/**
	 * Recuperación de un objeto tipo Pedido.
	 * @return devuelve un objeto.
	 */
	public pedidoCabecera getCabecera() {
		return cabecera;
	}
	
	/**
	 * Asigna un objeto tipo Pedido.
	 * @param El parametro cabecera sera asignado a un Objeto.
	 */
	public void setCabecera(pedidoCabecera cabecera) {
		this.cabecera = cabecera;
	}

	/**
	 * Recuperación de un objeto tipo Detalle
	 * @return devuelve un objeto.
	 */
	public Detalle getDetalle() {
		return detalle;
	}

	/**
	 * Asigna un objeto tipo Detalle.
	 * @param El parámetro detalle sera asignado a un objeto.
	 */
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}


	/**
	 * Recuperación de una lista tipo detalle
	 * @return devuelve una lista en especifica. 
	 */
	public List<Detalle> getDetalles() {
		return detalles;
	}

	/**
	 * Asigna una lista tipo detalle
	 * @param El parámetro detalles sera asignado a un objeto.
	 */
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	/**
	 * Recuperación de una lista tipo vehículo
	 * @return devuelve una lista en especifica.
	 */

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	/**
	 * Asigna una lista tipo vehiculo
	 * @param El parámetro vehiculos sera asignado a un objeto.
	 */
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}



	/**
	 * Recuperación de un objeto tipo Factura
	 * @return devuelve un objeto.
	 */
	public Factura getFactura() {
		return factura;
	}

	
	/**
	 * Asigna un objeto tipo Factura
	 * @param El parámetro factura sera asignado a un objeto.
	 */
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	
	/**
	 * Recuperación de un objeto tipo metodo de pago
	 * @return devuelve un objeto
	 */
	public MetodoDePago getMetodo() {
		return metodo;
	}

	/**
	 * Asigna un objeto tipo Metodo de pago
	 * @param El parámetro metodo sera asignado a un objeto
	 */
	public void setMetodo(MetodoDePago metodo) {
		this.metodo = metodo;
	}

	
	/**
	 * Recuperación de una lista que contiene objetos métodos de apgo
	 * @return devuelve un objeto
	 */
	public List<MetodoDePago> getMetodos() {
		return metodos;
	}

	
	/**
	 * Asigna una lista de metodos de pago
	 * @param El parámetro metodos sera asignado a un objeto
	 */
	public void setMetodos(List<MetodoDePago> metodos) {
		this.metodos = metodos;
	}


	
	/**
	 * Recuperación de un dato entero.
	 * @return devuelve un dato.
	 */
	public int getListado() {
		return listado;
	}

	/**
	 * Asigna un dato entero
	 * @param El parámetro listado sera asignado al dato.
	 */
	public void setListado(int listado) {
		this.listado = listado;
	}
	
	
	/**
	 * Recuperación de una lista tipo de categorias
	 * @return devuelve una lista
	 */

	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * Asigna una lista tipo categoria.
	 * @param  El parámetro categorias sera asignado a un objeto.
	 */

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * Recuperación de un Objeto tipo Categoria
	 * @return devuelve un objeto
	 */
	public Categoria getCategoria() {
		return categoria;
	}


	/**
	 * Asigna un objeto tipo categoria
	 * @param El parámetro categoria sera asignado a un objeto
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

		
	/**
	 * Recuperación de un Objeto tipo Persona.
	 * @return devuelve un objeto.
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Asigna un objeto tipo persona.
	 * @param El parámetro persona sera asignado a un objeto.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 *  Se consulta a la base de datos, y se agregan los registros existentes
	 *  en cada respectiva lista, vehículos, metodos y catégorias. 
	 */
	
	
	@PostConstruct
	public void init() {
		//System.out.println("Hello");
		try {
			vehiculos=vehiculoON.getvehiculos();
			metodos=metodoON.getMetodoPagos();
			categorias=categoriaON.getCategorias();
			pedidos=pedidoON.getpedidoCabeceras();
			System.out.println("----------------------");
			System.out.println(factura.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<pedidoCabecera> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedidoCabecera> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * Metodo que se encarga de recuperar un registro de persona
	 * mediante una llave primaria.
	 */
	public void recuperarPersona() {
		try {
			persona=personaON.buscarPersona(persona.getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PERSONA: "+persona.getCedula()+" : "+persona.getNombre());
	}
	
	/**
	 * Se agrega los detalles del pedido en uan lista 
	 * @param El parámetro codigo es una llave primaria de los registros detalles, esto 
	 * da paso a la recuperación del registro.
	 */
	public void agregarDetalle(int codigo) {
		System.out.println("CODIGO VEHICULO: "+codigo);
		Vehiculo vehiculo= recuperarVehiculo(codigo);
			detalle= new Detalle();
			detalle.setId(cont);
			detalle.setVehiculo(vehiculo);
			detalle.setCantidad(1);
			detalle.setTotal(0.0);
			detalles.add(detalle);
			cont=cont+1;

	}
	
	/**
	 * Método encargado de buscar un objeto vehículo mediante
	 * una llave primaria enviada atravez de una página JSF
	 * @param El parámetro codigo es la llave primaria de vehículo
	 * @return Se envía el objeto recuperado.
	 */
	
	public Vehiculo recuperarVehiculo(int codigo) {
		Vehiculo vehiculo= new Vehiculo();
		try {
			vehiculo= vehiculoON.getVehiculo(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehiculo;
	}
	
	/**
	 * Metodo para navegar a otra página en este caso, en 
	 * la confirmación del pedido.
	 * @return
	 */
	public String agregarPedido() {
		System.out.println(detalles.size());
		return "pedido?faces-redirect=true";
	}
	
	
	/**
	 * Navegación entre páginas
	 * @return Navegación a la página de detalles.
	 */
	public String paginaDetalle() {
		return "pro-det?faces-redirect=true";
	}
	
	
	/**
	 * 	Navegación entre páginas
	 * @return Navegación a la página de Inicio
	 */
	public String paginaInicio() {
		return "pro-carro?faces-redirect=true";
	}
	
	
	/**
	 * Eliminación de un detalle que se encuentra en una lista.
	 */
	public void eliminarDetalle() {
		facesContext=FacesContext.getCurrentInstance();
		Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		int codigo = Integer.parseInt((String) parametros.get("eliminar_detalle"));
		
	}
	
	/**
	 * Actualización de un detalle que se encuentra en una lista.
	 */
	public void actualizarDetalle() {
		facesContext=FacesContext.getCurrentInstance();
		Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		int codigo = Integer.parseInt((String) parametros.get("actualizar_detalle"));
		
		for(Detalle elemento: detalles) {
			System.out.println("CD: "+elemento.getId()+" Cantidad:"+elemento.getCantidad());
		}
	}
	
	/**
	 * Metodo donde se confirma el pedido, se le inserta la persona y los detalles a este objeto
	 * despues lleva a cabo la inserción de este objeto.
	 * @return Navegación a la página factura.
	 */
	public String confirmarPedido() {
		System.out.println("CABECERA ANTES:"+cabecera.getId());
		cabecera.setEstado("EMISION");
		detalles=vehiculoContratado(detalles);
		cabecera.setDetalles(detalles);
		cabecera.setPersona(persona);
		try {
			pedidoON.insertarpedidoCabecera(cabecera);
			System.out.println("CABECERA DESPUES:"+cabecera.getId());
			return "factura?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Navegación entre páginas.
	 * @return Navegación a la página factura.
	 */
	public String paginaFactura() {
		return "factura?faces-redirect=true";
	}
	
	/**
	 * Metodo donde se inserta la factura, una ves insertado
	 * el pedido cabecera y sus detalles, se puede finalizar la factura
	 * donde se tiene que llenar el metodo de pago para la emisión de la factura.
	 * @return Navegación a la página carrito.
	 */
	public String confirmarFactura() {
		System.out.println("ENTRO A CONFIRMAR FACTURA");
		String cedula=persona.getCedula();
		double total=0.0;
		for(Detalle elemento: detalles) {
			double pagar=elemento.getTotal();
			total=total+pagar;
		}
		
		int codigo= metodo.getId();
		try {

			metodo.setNombrepropietario(cabecera.getPersona().getNombre());
			metodo.setEstado("ACTIVO");
			metodoON.guardar(metodo);
			pedidoCabecera cabe=pedidoON.buscarpedidoCabecera(cabecera.getId());
			factura.setEstado("EMISION");
			//factura.setPedido(cabecera);
			factura.setTarjetacredito(metodo);
			factura.setPedido(cabe);
			factura.setTotal(total);
			facturaON.insertarFactura(factura);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		    return "pro-carro-test?faces-redirect=true&id="+cedula;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	/**
	 * Metodo donde se inserta la factura, una ves insertado
	 * el pedido cabecera y sus detalles, se puede finalizar la factura
	 * donde se tiene que llenar el metodo de pago para la emisión de la factura.
	 * @return Navegación a la página carrito.
	 */
	public String confirFactura() {
		System.out.println("ENTRO A CONFIRMAR FACTURA");
		String cedula=persona.getCedula();
		double total=0.0;
		for(Detalle elemento: cabecera.getDetalles()) {
			double pagar=elemento.getTotal();
			total=total+pagar;
		}
		
		int codigo= metodo.getId();
		try {

			metodo.setNombrepropietario(cabecera.getPersona().getNombre());
			metodo.setEstado("ACTIVO");
			metodoON.guardar(metodo);
			pedidoCabecera cabe=pedidoON.buscarpedidoCabecera(cabecera.getId());
			factura.setEstado("EMISION");
			//factura.setPedido(cabecera);
			factura.setTarjetacredito(metodo);
			factura.setPedido(cabe);
			factura.setTotal(total);
			facturaON.insertarFactura(factura);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		    return "pro-carro-test?faces-redirect=true&id="+cedula;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	/**
	 * Se calcula el total de la lista detalles, esta lista contiene los vehículos
	 * con sus precios respectivos.
	 */
		
	public void calcularTotal() {
		/*for(Detalle elemento: detalles) {
			
		}*/
		for(int i=0;i<detalles.size();i++) {
			int cantidad=detalles.get(i).getCantidad();
			double precio=detalles.get(i).getVehiculo().getPrecio();
			double total=cantidad*precio;
			detalles.get(i).setTotal(total);
		}
		
	}
	
	/**
	 * Se visualiza el producto en este caso el vehículo
	 * con sus características
	 * @param codigo es una llave primaria 
	 * @return Navegación a la página de visualización.
	 */
	public String visualizarVehiculo(int codigo) {
		System.out.println("CODIGO VEHICULO"+codigo);
		return "visualizacion?faces-redirect=true&id="+codigo;
	}
	
	/**
	 * Navegación entre páginas
	 * @return Navegación a la página de pedido.
	 */
	public String paginaPedido() {
		return "pedido?faces-redirect=true";
	}
	
	/**
	 * Metodo que lista los vehiculos segun a lo que el
	 * usuario a elegido en la página.
	 */
	public void listadoVehiculos() {
		System.out.println("Entro a los LISTADOS");
		System.out.println("LISTA C: "+listado);
		vehiculos=vehiculoON.getlistadoVehiculos(listado);
		for(Vehiculo elemento: vehiculos) {
			System.out.println("CV: "+elemento.getId()+" PRECIO: "+elemento.getPrecio()+" MODELO: "+elemento.getModelo());
		}
	}
	
	/**
	 * Navegación entre páginas
	 * @return Navegación a la lista de pedidos
	 */
	public String paginaListaPedido() {
		
		return "lista-pedidos?faces-redirect=true";
	}
	
	/**
	 * Navegación entre páginas
	 * @param codigo Es una llave primaria para la busqueda de la cabecera.
	 * @return Navegación a la página factura
	 */
	public String paginaListaFactura(int codigo) {
		try {
			cabecera=pedidoON.buscarpedidoCabecera(codigo);
			List<Detalle> det=cabecera.getDetalles();
			for(int i=0; i<det.size();i++) {
				double precio=det.get(i).getVehiculo().getPrecio();
				det.get(i).setTotal(precio);
			}
			cabecera.setDetalles(det);
			pedidoON.actualizarpedidoCabecera(cabecera);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Fact-cliente?faces-redirect=true";
	}
	
	/**
	 * Navegación entre páginas
	 * @param codigo Se envía una llave primaria a la página destinada.
	 * @return Navegación a la página carrito
	 */
	public String paginaOrdenar(int codigo) {
		return "pro-carro-ordenar?faces-redirect=true?&id="+codigo;
	}
	
	/**
	 * Metodo que lista los vehículos mediante la categoria que tenga asignada
	 * 
	 */
	public void listadoVehiculosCategoria() {
		try {
			categoria=categoriaON.buscarCategoria(categoria.getId());
			vehiculos=vehiculoON.getListaVehiculoCategoria(categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Vehiculo elemento: vehiculos) {
			System.out.println("V C:"+elemento.getId()+" CATEGORIA: "+elemento.getCategoria().getNombre());
		}
	}
	
	/**
	 *Metodo que sirve para actualizar el estado del vehiculo que fue contratado
	 * el estado cambiara a ALQUILADO.
	 * @param det, es la lista de detalles que contiene los veh[iculos
	 * @return devuelve una lista
	 */
	public List<Detalle> vehiculoContratado(List<Detalle> det) {
		List<Detalle> actualizado= new ArrayList<Detalle>();
		for(Detalle elemento: det) {
			Vehiculo v= new Vehiculo();
			try {
				v=vehiculoON.buscarVehiculo(elemento.getVehiculo().getId());
				v.setEstado("ALQUILADO");
				vehiculoON.actualizarVehiculo(v);
				elemento.setVehiculo(v);
				//actualizado.add(elemento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return det;
	}
	
	/**
	 * Navegación entre páginas
	 * @return Navegación a la página Login
	 */
	public String cerrarSesion() {
		return "Login?faces-redirect=true";
	}
}
