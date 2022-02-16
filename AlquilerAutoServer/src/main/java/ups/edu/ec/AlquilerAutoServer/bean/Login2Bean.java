package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;

@Named
@ViewScoped
public class Login2Bean implements Serializable {

	
	private Persona persona = new Persona();
	
	@Inject
	private PersonaONLocal personaON;
	
	
	
	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



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
	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
}
