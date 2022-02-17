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

@Named
@ViewScoped
public class DevolucionBean implements Serializable {

	private Devolucion devolucion= new Devolucion();
	private Factura factura= new Factura();
	private pedidoCabecera pedido= new pedidoCabecera();
	private List<Factura> facturas= new ArrayList<Factura>();
	private List<pedidoCabecera> pedidos= new ArrayList<pedidoCabecera>();
	private Persona persona= new Persona();
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private PersonaONLocal personaON;
	
	@Inject
	private PedidoONLocal pedidoON;
	
	@Inject
	private DevolucionONLocal devolucionON;
	
	@Inject
	private VehiculoONLocal vehiculoON;
	
	public Devolucion getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	public List<pedidoCabecera> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<pedidoCabecera> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void listarFactura() {
		System.out.println("Persona: "+persona.getCedula());
		pedidos=pedidoON.getPedidosCedula(persona);
		System.out.println("Lista Pedidos: "+pedidos.size());
		facturas=facturaON.getFacturasPedidos(pedidos);
		System.out.println("Lista Facturas: "+facturas.size());
	}
	
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
	
	public void componente() {
		System.out.println("Componente");
	}
	
	public String facturar(int codigo) {
		System.out.println("CF:"+codigo);
		try {
			factura=facturaON.buscarFactura(codigo);
			//factura.setEstado("FINALIZADO");
			//pedidoCabecera pedido= new pedidoCabecera();
			//pedido=factura.getPedido();
			//pedido.setEstado("FINALIZADO");
			//pedidoON.actualizarpedidoCabecera(pedido);
			//factura.setPedido(pedido);
			//facturaON.actualizarFactura(factura);
			//factura.setPedido(factura.getPedido().setEstado("FINALIZADO"));
			System.out.println("Pagina DET-DEVOLUCION");
			return "det-devolucion?faces-redirect=true&id="+factura.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void recuperarFactura() {
		try {
			factura=facturaON.buscarFactura(factura.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
