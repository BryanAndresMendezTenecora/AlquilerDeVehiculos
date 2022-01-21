package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
import ups.edu.ec.AlquilerAutoServer.on.DevolucionONLocal;
import ups.edu.ec.AlquilerAutoServer.on.FacturaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PedidoON;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;


@Named
@RequestScoped
public class probandoBean {
	
	private String iniciar;

	@Inject
	private PersonaONLocal personaON;
	
	@Inject
	private PedidoONLocal pedidoON;
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private DevolucionONLocal devolucionON;
	
	
	
	public String getIniciar() {
		return iniciar;
	}



	public void setIniciar(String iniciar) {
		this.iniciar = iniciar;
	}



	public Persona InsertarPersona(String cedula) {
		Persona persona= new Persona();
		persona.setCedula(cedula);
		try {
			//personaON.insertarPersona(persona);
			persona=personaON.buscarPersona(cedula);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return persona;
	}
	
	public pedidoCabecera InsertarPedido(int codigo, Persona persona) {
		pedidoCabecera pedido= new pedidoCabecera();
		pedido.setId(codigo);
		pedido.setPersona(persona);
		
		
		try {
			//pedidoON.insertarpedidoCabecera(pedido);
			pedido=pedidoON.buscarpedidoCabecera(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pedido;
	}

	public Factura insertarFactura(int codigo, pedidoCabecera pedido) {
		Factura factura= new Factura();
		factura.setId(codigo);
		factura.setPedido(pedido);
		
		try {
			//facturaON.insertarFactura(factura);
			factura=facturaON.buscarFactura(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return factura;
		
	}
	
	public Devolucion insertarDevolucion(int codigo, Factura factura) {
		Devolucion devolucion= new Devolucion();
		devolucion.setId(codigo);
		devolucion.setFactura(factura);
		
		try {
			devolucionON.insertarDevolucion(devolucion);
			devolucion=devolucionON.buscarDevolucion(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return devolucion;
		
	}
	
	
	public void pro() {
		System.out.println("Entro");
		Persona p;
		pedidoCabecera pe;
		Factura f;
		Devolucion d;
		String cedula="01080";
		//for(int i=4; i<6; i++) {
		p=InsertarPersona(cedula);
		pe=InsertarPedido(7, p);
		f=insertarFactura(7, pe);
		d=insertarDevolucion(8, f);
		//}
	}
	
	public void recuperar() {
		String cedula="01080";
		Persona p= new Persona();
		
		try {
			p= personaON.buscarPersona(cedula);
			System.out.println(p.getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Devolucion> devoluciones=devolucionON.getAntecedentes(p);
		//System.out.println(devoluciones.size());
		for(Devolucion elenento:devoluciones) {
			System.out.println("Devoluciones Segun Cedula:" +elenento.getId());
		}
	}

}