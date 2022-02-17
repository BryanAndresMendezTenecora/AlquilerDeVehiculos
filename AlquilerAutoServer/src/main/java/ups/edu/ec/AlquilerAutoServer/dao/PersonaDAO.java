package ups.edu.ec.AlquilerAutoServer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Objeto de acceso a datos para persona
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class PersonaDAO {
	@PersistenceContext
	private EntityManager em; // Para el contexto de persistencia

	/**
	 * Metodo para insertar persona con sus respectivas validaciones
	 * 
	 * @param recibe objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void insert(Persona persona) throws Exception {
		String cedula = persona.getCedula();
		boolean bcedula = verificarCedula(cedula);
		boolean bcorreo = verificarCorreo(persona.getEmail());
		boolean blongcontra = longitudContrasena(persona.getPassword());
		if (bcedula && bcorreo && blongcontra) {
			String apellido = this.mayuscula(persona.getApellido());
			String nombre = mayuscula(persona.getNombre());
			String direccion = mayuscula(persona.getDireccion());
			String estado = mayuscula(persona.getEstado());
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setDireccion(direccion);
			persona.setEstado(estado);
			em.persist(persona);
		} else {
			System.out.println("ERROR NO CUMPLE REQUISITOS PERSONA");
			System.out.println("Verificacion cedula:" + bcedula);
			System.out.println("Verificacion correo:" + bcorreo);
			System.out.println("Verificacion contra:" + blongcontra);
		}

	}

	/**
	 * Metodo para actulizar persona
	 * 
	 * @param recibe objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void update(Persona persona) throws Exception {
		em.merge(persona);
	}

	/**
	 * Metodo para buscar persona
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve objeto persona encontrada
	 * @throws Exception para capturar excepciones
	 */
	public Persona read(String cedula) throws Exception {
		Persona p = em.find(Persona.class, cedula);
		return p;
	}

	/**
	 * Metodo para eliminar la persona
	 * 
	 * @param recibe cedula de la persona
	 * @throws Exception para capturar excepciones
	 */
	public void delete(String cedula) throws Exception {
		Persona p = em.find(Persona.class, cedula);
		em.remove(p);
	}

	/*
	 * public List<Persona> getPersonas() throws Exception{ String
	 * jpql2="SELECT p FROM Persona p";
	 * 
	 * //nombre= nombre+"%"; Query query= em.createQuery(jpql2, Persona.class);
	 * //query.setParameter(1, nombre);
	 * 
	 * List<Persona> personas=query.getResultList(); return personas; }
	 */
	/**
	 * Metodo para listar las personas
	 * 
	 * @return devuelve una lista de personas
	 */
	public List<Persona> getList() {
		List<Persona> listado = new ArrayList<Persona>();
		String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);
		listado = query.getResultList();
		return listado;
	}

	/**
	 * Metodo para iniciar session
	 * 
	 * @param recibe objeto persona
	 * @return devuelve objeto persona encontrada
	 */
	public List<Persona> getIniciarSesion(Persona persona) {
		String correo = persona.getEmail();
		String contrasena = persona.getPassword();
		String jpql2 = "SELECT p FROM Persona p" + " WHERE email LIKE ?1 AND password LIKE ?2";

		// correo = correo + "%";
		// contrasena= contrasena+"%";
		Query query = em.createQuery(jpql2, Persona.class);
		query.setParameter(1, correo);
		query.setParameter(2, contrasena);

		// Object usuarios = query.getSingleResult();
		List<Persona> personas = query.getResultList();
		// Usuario resultado = (Usuario) usuarios;

		// List<Rol> roles = query.getResultList();
		return personas;
	}

	/**
	 * Metodo para listar los pedidos por contrato de persona
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve lista de pedidos
	 */
	public List<pedidoCabecera> getContratos(String cedula) {
		List<pedidoCabecera> pedidos = new ArrayList<pedidoCabecera>();
		String jpql = "SELECT p FROM pedidoCabecera p WHERE persona= ?1";
		Query query = em.createQuery(jpql, pedidoCabecera.class);
		query.setParameter(1, cedula);
		pedidos = query.getResultList();
		return pedidos;
	}

	/**
	 * Metodo para verificar la longitud de la cedula
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve true(si cumple) o false(no cumple)
	 */
	public boolean verificarCedula(String cedula) {
		if (cedula.length() == 10) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo para transformar letras a mayusculas
	 * 
	 * @param recibe dato
	 * @return devuelve dato transformado a mayusculas
	 */
	public String mayuscula(String dato) {
		String mayus = dato.toUpperCase();
		return mayus;
	}

	/**
	 * Metodo para verificar correo
	 * 
	 * @param recibe correo de la persona
	 * @return devuelve true(si cumple) o false(no cumple)
	 */
	public boolean verificarCorreo(String correo) {
		boolean arroba = correo.contains("@");
		boolean punto = correo.contains(".");
		if (arroba == true && punto == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para verificar la longitud de la contrasena
	 * 
	 * @param recibe contrasena de la persona
	 * @return devuelve true(si cumple) o false(no cumple)
	 */
	public boolean longitudContrasena(String contra) {
		if (contra.length() > 3) {
			return true;
		} else {
			return false;
		}
	}

}
