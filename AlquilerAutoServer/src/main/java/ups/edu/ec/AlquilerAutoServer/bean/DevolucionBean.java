package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Detalle;
import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
import ups.edu.ec.AlquilerAutoServer.on.DevolucionONLocal;
import ups.edu.ec.AlquilerAutoServer.on.FacturaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PedidoON;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;
/**
 * Bean para la gestion de la devolución
 * @author Bryan Méndez, Juan Boni, Braulio Astudillo
 *
 */
@Named
@ViewScoped
public class DevolucionBean implements Serializable {

	private Devolucion devolucion= new Devolucion();		//Instancia del objeto Devolución para insertar en la base de datos. 
	private Factura factura= new Factura();					//Instancia del objeto Factura para hacer la devolucion por su id.
	private pedidoCabecera pedido= new pedidoCabecera();	//Instancia del objeto PedidoCabecera para guardar la información que contiene la factura mediante un atributo.
	private List<Factura> facturas= new ArrayList<Factura>();	//Instancia de una lista de Facturas que seran de un cliente específico.
	private List<pedidoCabecera> pedidos= new ArrayList<pedidoCabecera>(); // Instancia de una lista de PedidoCabecera de un cliente específico.
	private Persona persona= new Persona();					//Instancia un objeto Persona para guardar la información del cliente.
	
	@Inject
	private FacturaONLocal facturaON; 	//Injección al servidor al objeto ON de Factura.
	
	@Inject
	private PersonaONLocal personaON; //Injección al servidor al objeto ON de Persona.
	
	@Inject
	private PedidoONLocal pedidoON;		//Injección al servidor al objeto ON de Pedido.
	
	@Inject
	private DevolucionONLocal devolucionON; //Injección al servidor al objeto de Devolución.
	
	@Inject
	private VehiculoONLocal vehiculoON; // Injección  al servidor al objeto ON de Vehículo.
	
	/**
	 * Recuperación de un Objeto Devolución
	 * @return devuelve un tipo de dato Devolucion
	 */
	public Devolucion getDevolucion() {
		return devolucion;
	}
	
	/**
	 * Asigna un Objeto devolución
	 * @param El parámetro devolucion que se asignara
	 */
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	/**
	 * Recuperación de un Objeto Factura
	 * @return devuelve un tipo de dato Factura
	 */
	public Factura getFactura() {
		return factura;
	}

	/**
	 * Asigna un objeto Factura
	 * @param El parámetro factura que se asignara al Objeto
	 */
	public void setFactura(Factura factura) {
		this.factura = factura;
	
	}
	
	/**
	 * Recuperación de un Objeto Persona
	 * @return devuelve un tipo de dato Persona
	 */
	public Persona getPersona() {
		return persona;
	}
	
	/**
	 * Asigna un objeto Persona
	 * @param El parámetro persona que se asignara al Objeto
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * Recuperación de una lista tipo Factura
	 * @return devuelve una lista tipo Factura
	 */
	public List<Factura> getFacturas() {
		return facturas;
	}
	
	/**
	 * Asigna una lista tipo Factura
	 * @param El parámetro facturas que se asignara a una lista del Objeto
	 */
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	/**
	 * Recuperación de una lista tipo pedidoCabecera
	 * @return devuelve una lista tipo pedidoCabecera
	 */
	public List<pedidoCabecera> getPedidos() {
		return pedidos;
	}
	
	/**
	 * Asigna una lista tipo pedidoCabecera
	 * @param El parámetro pedidos que se asignara a una lista del Objeto
	 */
	public void setPedidos(List<pedidoCabecera> pedidos) {
		this.pedidos = pedidos;
	}
	
	/**
	 * Recuperación de una lista de pedidos mediante la cédula de la persona y
	 * una lista de facturas mediante la lista de pedido obtenida
	 */
	public void listarFactura() {
		System.out.println("Persona: "+persona.getCedula());
		pedidos=pedidoON.getPedidosCedula(persona);
		System.out.println("Lista Pedidos: "+pedidos.size());
		facturas=facturaON.getFacturasPedidos(pedidos);
		System.out.println("Lista Facturas: "+facturas.size());
	}
	
	/**
	 * Busca la factura mediante la llave primaria, el resultado obtenido
	 * se le agregara a una lista tipo factura
	 */
	public void buscarFactura() {
		try {
			factura=facturaON.buscarFactura(factura.getId());
			List<Factura> factencontrada=new ArrayList<Factura>();
			factencontrada.add(factura);
			facturas=factencontrada;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Recupera una factura mediante el codigo recibido, en este caso sera
	 * la factura que desea realizar la devolución.
	 * @param El parámetro codigo es para recuperar una factura.  
	 * @return Permite la navegación a otra página.
	 */
	public String facturar(int codigo) {
		System.out.println("CF:"+codigo);
		try {
			factura=facturaON.buscarFactura(codigo);
			System.out.println("Pagina DET-DEVOLUCION");
			return "det-devolucion?faces-redirect=true&id="+factura.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Recupera una factura mediante una llave primaria
	 */
	public void recuperarFactura() {
		try {
			factura=facturaON.buscarFactura(factura.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Permite la inserción de un Objeto Devolucion pero antes se
	 * actualiza los estados de los objetos involucrados con el objeto a insertar. 
	 * @return Permite la navegación a otra página.
	 */
	public String insertarDevolucion() {
		pedido=factura.getPedido();
		pedido.setEstado("FINALIZADO");
		
		try {
			pedidoON.actualizarpedidoCabecera(pedido);
			factura.setEstado("FINALIZADO");
			factura.setPedido(pedido);
			facturaON.actualizarFactura(factura);
			devolucion.setFactura(factura);
			vehiculoDevolver();
			devolucionON.insertarDevolucion(devolucion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "pro-carro-test?faces-redirect=true";
	}
	
	/**
	 * Devuelve los vehiculos arrendados de la factura, sera
	 * actualizado cada objeto que se encuentra en esta lista, el atributo
	 * a actualizar es el estado. 
	 */
	public void vehiculoDevolver() {
		List<Detalle> detalles=factura.getPedido().getDetalles();
		for(Detalle elemento:detalles) {
			Vehiculo v=elemento.getVehiculo();
			try {
				v.setEstado("DISPONIBLE");
				vehiculoON.actualizarVehiculo(v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Finalizo la DEVOLUCION");
	}
}
