package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;

/**
 * Bean gestión de login
 * @author Bryan Mendez,Juan Boni,Braulio Astudillo
 *
 */
@Named
@ViewScoped
public class LoginBean implements Serializable {

	
	private Persona persona = new Persona();  //Instancia de un objeto persona, para guardar los registros de persona
	
	@Inject
	private PersonaONLocal personaON;		//Inyección al servidor mediante el objeto de negocio de persona
	
	
	/**
	 * Recuperación de un Objeto Persona
	 * @return devuelve un objeto
	 */
	
	public Persona getPersona() {
		return persona;
	}

	
	/**
	 * Asigna un Objeto Persona
	 * @param persona, se asignara a un objeto
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Este metodo se encarga de verificar si la
	 * persona ingresada en los campos existen.
	 * @return Navegación a la página carrito
	 */
	public String iniciarSesion() {
		try {
			persona=personaON.getLogin(persona);
			if(persona.getCedula() != null) {
				System.out.println("Logeo exitoso: "+persona.getCedula());
				return "pro-carro-test?faces-redirect=true&id="+persona.getCedula();
			}else {
				return "Login?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Login?faces-redirect=true";
		}
	}
	
	/**
	 * Metodo que se encarga de cerrarSesion, elimina
	 * los beans existentes
	 */
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
}
