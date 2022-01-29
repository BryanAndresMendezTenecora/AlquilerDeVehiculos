package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;
import java.io.Serializable;

@Named
//@ManagedBean
//@RequestScoped
@SessionScoped

public class LoginBean implements Serializable {
	@Inject
	private PersonaONLocal clientesON;
	private Persona persona = new Persona();
	private List<Persona> clientes;
	private String email;
	private String password;
	private String cedula;
    private String mensajeErrorPassword;
    private String mensajeSalida = "";

    
	
	
	
	
	public PersonaONLocal getClientesON() {
		return clientesON;
	}

	public void setClientesON(PersonaONLocal clientesON) {
		this.clientesON = clientesON;
	}

	public String getMensajeSalida() {
		return mensajeSalida;
	}

	public void setMensajeSalida(String mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
	}

	public String getMensajeErrorPassword() {
		return mensajeErrorPassword;
	}

	public void setMensajeErrorPassword(String mensajeErrorPassword) {
		this.mensajeErrorPassword = mensajeErrorPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@PostConstruct
	public void init() {
		this.loadClientes();
	}

	/*
	 * private String cedula; private String nombre; private String direccion;
	 * 
	 * public String getCedula() { return cedula; }
	 * 
	 * public void setCedula(String cedula) { this.cedula = cedula; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public void setNombre(String nombre) { this.nombre = nombre; }
	 * 
	 * public String getDireccion() { return direccion; }
	 * 
	 * public void setDireccion(String direccion) { this.direccion = direccion; }
	 * 
	 */

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getClientes() {
		return clientes;
	}

	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}

	public String guardar() {

		System.out.println("Guardando " + this.persona.getNombre());

		/*
		 * Persona p= new Persona(); p.setCedula(this.cedula); p.setNombre(this.nombre);
		 * p.setDireccion(this.direccion);
		 */
		try {
			this.persona.setEstado("Activo");
			clientesON.guardar(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarPersona?faces-redirect=true";
	}

	public String editar(String cedula) {
		System.out.println(cedula);
		return "persona?faces-redirect=true&id=" + cedula;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		System.out.println("set " + cedula);
		this.cedula = cedula;
	}

	private void loadClientes() {
		try {
			this.clientes = clientesON.getPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadData() {
		if (cedula == null)
			return;

		Persona p;
		try {
			p = clientesON.getCliente(cedula);
			persona = p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadDataEditar() {
		Persona p;
		try {
			p = clientesON.getCliente(persona.getCedula());
			persona = p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public String Logeo() { System.out.println(); try {
	 * clientesON.getLogin(this.persona); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return
	 * "listarPersona?faces-redirect=true"; }
	 */

	public String iniciarSesion() {
		try {
			this.persona = clientesON.getLogin(this.persona);
			if (this.persona.getCedula() != null) {
				this.mensajeSalida = "Logeo Exitoso para: " + this.persona.getEmail();
				System.out.println("Logeo Exitoso");
				return "listarPersona?faces-redirect=true";
				
			} else {
				this.mensajeSalida = "Email y/o incorrectos";
				System.out.println("Logeo Fallido");
				return this.mensajeSalida;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	public String ComprobarSesion() {
		System.out.println("Correo:" + this.persona.getEmail());
		System.out.println("Password:" + this.persona.getPassword());
		return "Existe";
	}

	public void validarPassword(AjaxBehaviorEvent evento) {
		if (this.persona.getPassword().length() < 6) {
			mensajeErrorPassword = "La contraseña tiene que tener como minimo 6 caracteres";
		} else {
			if (this.persona.getPassword().length() > 15) {
				mensajeErrorPassword = "La contraseña puede tener como maximo 15 caracteres";
			} else {
				mensajeErrorPassword = "";
			}
		}
	}
	
	
	public void mensaje() {
		if ("".equals(this.persona.getEmail())) {
			this.mensajeSalida = "";
		}
		else {
			this.mensajeSalida = "Bienvenido " + this.persona.getEmail();
		}
	}
	
	public String verificarSesion() {
		System.out.println("entro a funcion verificar sesion");
		try {
			this.persona = clientesON.getLogin(this.persona);
			if (this.persona.getCedula() != null) {
				this.mensajeSalida = "---->>>Esta logueado: " + this.persona.getEmail();
				System.out.println("--------->>>>>>>>>Iniciado sesion<<<<<<<<<<<<----------");
				return mensajeSalida;
				
			} else {
				
				System.out.println("--------------->>>>>>>>no esta logueado<<<<<<<<<<<<<");
				return "LoginP?faces-redirect=true";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	  }
	
	
	//do by domenica
	public String iniciarSesionD() {
	    String redireccion = null;
	    try {
	    	persona = clientesON.readUsuario(persona.getCedula());
	      if (persona != null) {
	        if (persona.getRol().equals("Administrador")) {
	          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", persona);
	          redireccion = "listarPersona?faces-redirect=true";
	        } else if (persona.getRol().equals("Cliente")) {
	          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", persona);
	          redireccion = "LoginP.xhtml?faces-redirect=true";
	        } 
	      } else {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
	      } 
	    } catch (Exception e) {
	      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
	    } 
	    return redireccion;
	  }
	
	public void verificarSesionD() {
	    try {
	      Persona us = (Persona)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid");
	      if (us == null) {
	    	  FacesContext.getCurrentInstance().getExternalContext().redirect("../../permisos-insuficientes.xhtml");  
	      }
	        
	    } catch (Exception exception) {}
	  }
	
	 public String cerrarSesionD() {
		    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		    return "LoginP?faces-redirect=true";
		  }
	 
	 public static void removeSessionScopedBean(String beanName) 
	 {
	     FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(beanName);
	 }

}
