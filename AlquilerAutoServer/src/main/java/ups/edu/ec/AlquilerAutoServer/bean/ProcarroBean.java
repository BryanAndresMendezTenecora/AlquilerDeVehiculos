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


@Named
@SessionScoped
public class ProcarroBean implements Serializable {

	
	@Inject
	private PedidoONLocal pedidoON;
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private VehiculoONLocal vehiculoON;
	
	@Inject 
	private MetodoDePagoONLocal metodoON;
	
	@Inject
	private CategoriaONLocal categoriaON;
	
	@Inject
	private PersonaONLocal personaON;
	
	//@Inject

	//private LoginBean loginBean;
	
	private int cont=1;
	
	private Factura factura= new Factura();
	
	private pedidoCabecera cabecera = new pedidoCabecera();
	
	private MetodoDePago metodo= new MetodoDePago();
	

	private Categoria categoria=new Categoria();
	
	private Persona persona= new Persona();
	
	private Detalle detalle;
	
	private Date fechaActual= new Date();
	
	private Date fechaEntrega= new Date();
	
	private List<Detalle> detalles= new ArrayList<Detalle>();
	private List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
	private List<MetodoDePago> metodos= new ArrayList<MetodoDePago>();
	private List<Categoria> categorias= new ArrayList<Categoria>();
	private int listado=0;
	
	
	
	private FacesContext facesContext;
	
	public pedidoCabecera getCabecera() {
		return cabecera;
	}


	public void setCabecera(pedidoCabecera cabecera) {
		this.cabecera = cabecera;
	}


	public Detalle getDetalle() {
		return detalle;
	}






	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}



	public List<Detalle> getDetalles() {
		return detalles;
	}



	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}


	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}



	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}




	
	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	

	public MetodoDePago getMetodo() {
		return metodo;
	}


	public void setMetodo(MetodoDePago metodo) {
		this.metodo = metodo;
	}

	

	public List<MetodoDePago> getMetodos() {
		return metodos;
	}


	public void setMetodos(List<MetodoDePago> metodos) {
		this.metodos = metodos;
	}


	

	public int getListado() {
		return listado;
	}


	public void setListado(int listado) {
		this.listado = listado;
	}
	
	


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public Date getFechaActual() {
		return fechaActual;
	}


	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	
	

	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	@PostConstruct
	public void init() {
		//System.out.println("Hello");
		try {
			vehiculos=vehiculoON.getvehiculos();
			metodos=metodoON.getMetodoPagos();
			categorias=categoriaON.getCategorias();
			System.out.println("----------------------");
			System.out.println(factura.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void recuperarPersona() {
		try {
			persona=personaON.buscarPersona(persona.getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PERSONA: "+persona.getCedula()+" : "+persona.getNombre());
	}
	
	public void agregarDetalle(int codigo) {
		//facesContext=FacesContext.getCurrentInstance();
		//Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		//int codigo = Integer.parseInt((String) parametros.get("pasar"));
		System.out.println("CODIGO VEHICULO: "+codigo);
		Vehiculo vehiculo= recuperarVehiculo(codigo);
		//if(vehiculo.getEstado().toUpperCase() =="DISPONIBLE") {
			//System.out.println("Entro a DISPONIBLE");
			detalle= new Detalle();
			detalle.setId(cont);
			detalle.setVehiculo(vehiculo);
			detalle.setCantidad(1);
			detalle.setTotal(0.0);
			detalles.add(detalle);
			//System.out.println(codigo);
			cont=cont+1;
			//System.out.println(detalles.size());
			//System.out.println("Detalle: "+detalle.getId());
		//}
	}
	
	
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
	
	public String agregarPedido() {
		System.out.println(detalles.size());
		return "pedido?faces-redirect=true";
	}
	
	public String paginaDetalle() {
		return "pro-det?faces-redirect=true";
	}
	
	
	public void eliminarBeanCarro() {
		String beanName="ProcarroBean";
	    System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap());
	    System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("procarroBean"));
	    System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProcarroBean"));
	    System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProcarroBean.java"));
	    System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("procarroBean.java"));
	    facesContext=FacesContext.getCurrentInstance();
		Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		String pro = (String) parametros.get("co");
		//ProcarroBean pr = (ProcarroBean) pro; 
		System.out.println("Pro: "+pro);
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap());
	    System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(pro));
	    
	 }
	
	public void comprobarBean() {
		if(detalles != null) {
			System.out.println("Detalles T:"+detalles.size());
		}
	}
	
	
	public String paginaInicio() {
		return "pro-carro?faces-redirect=true";
	}
	
	
	public String eliminarBean() {
		    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		    return "pro-carro?faces-redirect=true";
	}
	
	
	public void eliminarDetalle() {
		facesContext=FacesContext.getCurrentInstance();
		Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		int codigo = Integer.parseInt((String) parametros.get("eliminar_detalle"));
		
	}
	
	
	public void actualizarDetalle() {
		facesContext=FacesContext.getCurrentInstance();
		Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		int codigo = Integer.parseInt((String) parametros.get("actualizar_detalle"));
		
		for(Detalle elemento: detalles) {
			System.out.println("CD: "+elemento.getId()+" Cantidad:"+elemento.getCantidad());
		}
	}
	
	public String confirmarPedido() {
		System.out.println("CABECERA ANTES:"+cabecera.getId());
		cabecera.setEstado("En Emision");
		detalles=vehiculoContratado(detalles);
		cabecera.setDetalles(detalles);
		//cabecera.setPersona(loginBean.getPersona());
		cabecera.setPersona(persona);
		//cabecera.setFecha(fechaActual);
		//cabecera.setFechaentrega(fechaEntrega);
		//cabecera.setPersona(null);
		try {
			pedidoON.insertarpedidoCabecera(cabecera);
			System.out.println("CABECERA DESPUES:"+cabecera.getId());
			return "factura?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//System.out.println(loginBean.getPersona().getCedula());
		//this.paginaFactura();
	}
	
	public String paginaFactura() {
		return "factura?faces-redirect=true";
	}
	
	public String confirmarFactura() {
		String cedula=persona.getCedula();
		double total=0.0;
		for(Detalle elemento: detalles) {
			double pagar=elemento.getTotal();
			total=total+pagar;
		}
		
		int codigo= metodo.getId();
		try {
			MetodoDePago metodo=metodoON.buscarMetodoPago(codigo);
			pedidoCabecera cabe=pedidoON.buscarpedidoCabecera(cabecera.getId());
			factura.setEstado("Emision");
			//factura.setPedido(cabecera);
			factura.setTarjetacredito(metodo);
			factura.setPedido(cabe);
			factura.setTotal(total);
			//System.out.println(factura.getTarjetacredito().getTipo());
			//System.out.println("CF: "+factura.getId());
			facturaON.insertarFactura(factura);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		    return "pro-carro-test?faces-redirect=true&id="+cedula;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		//System.out.println("Cabecera:"+cabecera.getId());
		//System.out.println("Metodo C: "+metodo.getId());
		//System.out.println("Metodo C:"+mt);
		
	}
	
	
	public void insertarTarjeta() {
		metodo.setId(1);
		metodo.setTipo("Tarjeta Credito");
		try {
			metodoON.insertarMetodoPago(metodo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarDetalles() {
		System.out.println("Entro Listar Detalles: "+detalles.size());
		for(Detalle elemento:detalles) {
			System.out.println("Marca: "+elemento.getVehiculo().getMarca()+ "Modelo: "+elemento.getVehiculo().getModelo());
		}
	}
	
	public void numeroDetalle(int codigo) {
		System.out.println("ND: "+codigo);
	}
	
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
	
	
	public String visualizarVehiculo(int codigo) {
		System.out.println("CODIGO VEHICULO"+codigo);
		return "visualizacion?faces-redirect=true&id="+codigo;
	}
	

	public String paginaPedido() {
		return "pedido?faces-redirect=true";
	}
	
	public void listadoVehiculos() {
		System.out.println("Entro a los LISTADOS");
		System.out.println("LISTA C: "+listado);
		vehiculos=vehiculoON.getlistadoVehiculos(listado);
		for(Vehiculo elemento: vehiculos) {
			System.out.println("CV: "+elemento.getId()+" PRECIO: "+elemento.getPrecio()+" MODELO: "+elemento.getModelo());
		}
	}
	
	public String paginaOrdenar(int codigo) {
		return "pro-carro-ordenar?faces-redirect=true?&id="+codigo;
	}
	
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
	
	public String cerrarSesion() {
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "Login?faces-redirect=true";
	}
}
