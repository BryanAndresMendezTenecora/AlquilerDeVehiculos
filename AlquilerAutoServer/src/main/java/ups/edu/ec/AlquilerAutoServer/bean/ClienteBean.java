package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;



@Named
@RequestScoped
public class ClienteBean {
	@Inject
	private PersonaONLocal clientesON;
	private Persona persona = new Persona();
	private List<Persona> clientes;

	private String cedula;

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
		if(cedula==null)
			return;
		
		Persona p;
		try {
			p = clientesON.getCliente(cedula);
			persona=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void loadDataEditar() {
		Persona p;
		try {
			p = clientesON.getCliente(persona.getCedula());
			persona=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//#String ced=c
	public String eliminar(String cedula) {
	
		try {
			/*
			this.persona.setCedula(cedula);
			this.persona.setNombre(nombre);
			this.persona.setApellido(apellido);
			this.persona.setDireccion(direccion);
			this.persona.setEmail(email);
			this.persona.setPassword(password);
			this.persona.setRol(rol);
			this.persona.setTelefono(telefono);
			this.persona.setEstado("Inactivo");
			*/
			persona=clientesON.buscarPersona(cedula);
			persona.setEstado("ELIMINADO");
			clientesON.actualizarPersona(this.persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarPersona?faces-redirect=true";
	}

}
