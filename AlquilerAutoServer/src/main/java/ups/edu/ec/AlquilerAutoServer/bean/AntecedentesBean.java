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

	private Persona persona = new Persona();
	private List<Devolucion> devoluciones= new ArrayList<Devolucion>();
	
	@Inject
	private PersonaONLocal personaON;
	
	@Inject
	private PedidoONLocal pedidoON;
	
	@Inject
	private FacturaONLocal facturaON;
	
	@Inject
	private DevolucionONLocal devolucionON;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Devolucion> getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(List<Devolucion> devoluciones) {
		this.devoluciones = devoluciones;
	}
	
	
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
	
	public String paginaInicio() {
		return "pro-carro-test?faces-redirect=true";
	}
	
}
