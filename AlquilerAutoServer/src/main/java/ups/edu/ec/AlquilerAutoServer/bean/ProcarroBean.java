package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Detalle;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
import ups.edu.ec.AlquilerAutoServer.on.FacturaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
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
	
	private int cont=1;
	
	private pedidoCabecera cabecera = new pedidoCabecera();
	
	private Detalle detalle;
	
	private List<Detalle> detalles= new ArrayList<Detalle>();
	private List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
	
	
	
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




	
	@PostConstruct
	public void init() {
		//System.out.println("Hello");
		try {
			vehiculos=vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void agregarDetalle() {
		facesContext=FacesContext.getCurrentInstance();
		Map<String, String> parametros=facesContext.getExternalContext().getRequestParameterMap();
		int codigo = Integer.parseInt((String) parametros.get("pasar"));
		Vehiculo vehiculo= recuperarVehiculo(codigo);
		detalle= new Detalle();
		detalle.setId(cont);
		detalle.setVehiculo(vehiculo);
		detalles.add(detalle);
		System.out.println(codigo);
		cont=cont+1;
		System.out.println(detalles.size());
		System.out.println("Detalle: "+detalle.getId());
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
	
	public void agregarPedido() {
		System.out.println(detalles.size());
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
	
}
