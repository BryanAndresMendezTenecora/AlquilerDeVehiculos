package ups.edu.ec.AlquilerAutoServer.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;

/**
 * Bean para la gestión de la persona
 * @author Bryan Méndez,Juan Boni,Braulio Astudillo
 *
 */

@Named
@RequestScoped
public class ClienteBean {
	@Inject
	private PersonaONLocal clientesON; 		// Inyección al servidor mediante el objeto de negocio de clientes
	private Persona persona = new Persona(); // Instancia de un objeto persona, se guardara los registros de persona
	private List<Persona> clientes;		//Declaración de una lista de tipo Persona, se recolectaran los registros de persona 

	private String cedula;				//Declaración de un dato caracter.
	
	/**
	 * Al iniciar la página JSF, se activara este método
	 * que trae todas las personas en una lista
	 */
	@PostConstruct
	public void init() {
		this.loadClientes();
	}

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
	 * Recuperación de una lista tipo Persona
	 * @return devuelve una lista que contiene datos de el objeto persona
	 */
	public List<Persona> getClientes() {
		return clientes;
	}
	
	/**
	 * Asigna una lista tipo Persona
	 * @param clientes ,se asignara a un objeto
	 */
	public void setClientes(List<Persona> clientes) {
		this.clientes = clientes;
	}

	/**
	 * Hace la insercción del objeto persona a la base de datos
	 * @return Navegación a la página listar persona.
	 */
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

	/**
	 * Metodo para la actualización del objeto seleccionado,
	 * la selección de le hace por una llave primaria.
	 * @param id es la llave primaria.
	 * @return Navegación a la página Persona
	 */
	public String editar(String cedula) {
		System.out.println(cedula);
		return "persona?faces-redirect=true&id=" + cedula;
	}
	
	/**
	 * Recuperación de un tipo caracter
	 * @return devuelve un caracter
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Asigna un tipo de variable string al objeto
	 * @param cedula, es la llave primaria
	 */
	public void setCedula(String cedula) {
		System.out.println("set " + cedula);
		this.cedula = cedula;
	}

	/**
	 * Recupera todos los registros de persona
	 */
	private void loadClientes() {
		try {
			this.clientes = clientesON.getPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para recuperar una person mediante una llave primaria
	 */
	
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
	
	
	/**
	 * Metodo para la actualización de la persona, se necesita
	 * primero la recuperación de la persona.
	 */
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
	

	/**
	 * Metodo que elimina una persona, esta funcionalidad
	 * funciona con la actualización, el atributo a cambiar sera el
	 * estado.
	 * @param id
	 * @return Navegación a la página listar persona.
	 */
	public String eliminar(String cedula) {
	
		try {
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
