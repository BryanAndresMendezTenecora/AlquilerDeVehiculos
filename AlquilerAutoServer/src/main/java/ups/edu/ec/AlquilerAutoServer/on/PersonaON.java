package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import ups.edu.ec.AlquilerAutoServer.dao.PersonaDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Objeto de negocio de persona
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */

@Stateless
public class PersonaON implements PersonaONLocal, PersonaONRemote {

	@Inject
	private PersonaDAO personaDAO;// Se inyecta el objeto acceso a dato de vehiculo

	/**
	 * Metodo para insertar persona
	 * 
	 * @param recibe objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void insertarPersona(Persona persona) throws Exception {
		persona.setApellido(persona.getApellido().toUpperCase());
		persona.setDireccion(persona.getDireccion().toUpperCase());
		persona.setNombre(persona.getNombre().toUpperCase());
		persona.setEstado(persona.getEstado().toUpperCase());
		personaDAO.insert(persona);
	}

	/**
	 * Metodo actualizar persona
	 * 
	 * @param recibe objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarPersona(Persona persona) throws Exception {
		persona.setApellido(persona.getApellido().toUpperCase());
		persona.setDireccion(persona.getDireccion().toUpperCase());
		persona.setNombre(persona.getNombre().toUpperCase());
		persona.setEstado(persona.getEstado().toUpperCase());
		personaDAO.update(persona);
	}

	/**
	 * Metodo buscar persona por cedula
	 * 
	 * @param recibe cedula de persona
	 * @return devuelve objeto persona encontrada
	 * @throws Exception para capturar excepciones
	 */
	public Persona buscarPersona(String cedula) throws Exception {
		if (cedula.length() == 10) {
			return personaDAO.read(cedula);
		} else {
			return null;
		}
	}

	/**
	 * Metodo eliminar persona
	 * 
	 * @param recibe cedula de persona
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarPersona(String cedula) throws Exception {
		personaDAO.delete(cedula);
	}

	/**
	 * Metodo listar personas
	 * 
	 * @return devuelve lista de personas
	 * @throws Exception para capturar excepciones
	 */
	public List<Persona> getPersonas() throws Exception {
		return personaDAO.getList();
	}

	/**
	 * Metodo buscar persona
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve objeto persona encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Persona getCliente(String cedula) throws Exception {
		return personaDAO.read(cedula);
	}

	/**
	 * Metodo guardar persona
	 * 
	 * @param recibe p como objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(Persona p) throws Exception {
		p.setApellido(p.getApellido().toUpperCase());
		p.setDireccion(p.getDireccion().toUpperCase());
		p.setNombre(p.getNombre().toUpperCase());
		p.setEstado(p.getEstado().toUpperCase());
		if (personaDAO.read(p.getCedula()) == null)
			personaDAO.insert(p);
		else
			personaDAO.update(p);
	}

	/**
	 * Metodo consultar contrato
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve lista de pedidos encontrados por cedula persona
	 * @throws Exception para capturar excepciones
	 */
	public List<pedidoCabecera> consultarContrato(String cedula) throws Exception {
		return personaDAO.getContratos(cedula);
	}

	/**
	 * Metodo login
	 * 
	 * @param recibe objeto persona
	 * @return devuelve objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public Persona getLogin(Persona persona) throws Exception {
		List<Persona> usuarios = personaDAO.getIniciarSesion(persona);
		Persona respuesta = new Persona();
		for (Persona elemento : usuarios) {
			respuesta.setCedula(elemento.getCedula());
			respuesta.setNombre(elemento.getNombre());
			respuesta.setApellido(elemento.getApellido());
			respuesta.setDireccion(elemento.getDireccion());
			respuesta.setTelefono(elemento.getTelefono());
			respuesta.setEstado(elemento.getEstado());
			respuesta.setEmail(elemento.getEmail());
			respuesta.setPassword(elemento.getPassword());
			respuesta.setRol(elemento.getRol());
		}

		return respuesta;

	}

	/**
	 * Metodo buscar usuario
	 * 
	 * @param recibe usuario de persona
	 * @return devuelve objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public Persona readUsuario(String usuario) throws Exception {
		Persona per = personaDAO.read(usuario);
		return per;
	}
}
