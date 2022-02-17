package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.DevolucionONLocal;
import ups.edu.ec.AlquilerAutoServer.on.FacturaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;

@Named
@ViewScoped
public class AntecedentesBean implements Serializable {

	private Persona persona = new Persona(); 	// Instancia de un objeto Persona, se recuperara la información de un registro de persona 
	private List<Devolucion> devoluciones= new ArrayList<Devolucion>(); //Instancia de una lista tipo Devolucion, para listar los registros de la persona seleccionada
	
	@Inject
	private PersonaONLocal personaON; 	//Inyeción al servidor mediante el objeto de negocio tipo Persona
	
	@Inject
	private PedidoONLocal pedidoON; //Inyeción al servidor mediante el objeto de negocio tipo Pedido
	
	@Inject
	private FacturaONLocal facturaON;		//Inyeción al servidor mediante el objeto de negocio tipo Factura
	
	@Inject
	private DevolucionONLocal devolucionON;  //Inyeción al servidor mediante el objeto de negocio tipo devolución

	/**
	 * Recuperación de un Objeto Persona
	 * @return devuelve un objeto
	 */
	public Persona getPersona() {
		return persona;
	}
	
	/**
	 * Asigna un Objeto Persona
	 * @param El parámetro persona sera asignado a un objeto.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Recuperación de una lista tipo Devoluciones.
	 * @return devuelve una lista
	 */
	public List<Devolucion> getDevoluciones() {
		return devoluciones;
	}

	/**
	 * Asigna una lista tipo Devoluciones
	 * @param El parámetro devoluciones sera asignado a un objeto.
	 */
	public void setDevoluciones(List<Devolucion> devoluciones) {
		this.devoluciones = devoluciones;
	}
	
	
	/**
	 *  Recupera los Antecendetes de las personas que hayan realizado
	 *  alquileres al negocio.
	 */
	public void recuperarAntecedentes() {
		
		try {
			persona= personaON.buscarPersona(persona.getCedula());
			System.out.println(persona.getCedula());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		devoluciones=devolucionON.getAntecedentes(persona);
		//System.out.println(devoluciones.size());
		for(Devolucion elenento:devoluciones) {
			System.out.println("Devoluciones Segun Cedula:" +elenento.getId());
		}
		
	}
	
	/**
	 * Navegación entre las páginas.
	 * @return Navegación a la página carrito.
	 */
	public String paginaInicio() {
		return "pro-carro-test?faces-redirect=true";
	}
	
}
