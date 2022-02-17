package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;
import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

/**
 * Interfaz Local del objeto de negocio de persona
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface PersonaONLocal {

	/**
	 * Declaracion del metodo para insertar persona
	 * 
	 * @param recibe objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void insertarPersona(Persona persona) throws Exception;

	/**
	 * Declaracion del metodo actualizar persona
	 * 
	 * @param recibe objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarPersona(Persona persona) throws Exception;

	/**
	 * Declaracion del metodo buscar persona por cedula
	 * 
	 * @param recibe cedula de persona
	 * @return devuelve objeto persona encontrada
	 * @throws Exception para capturar excepciones
	 */
	public Persona buscarPersona(String cedula) throws Exception;

	/**
	 * Declaracion del metodo eliminar persona
	 * 
	 * @param recibe cedula de persona
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarPersona(String cedula) throws Exception;

	/**
	 * Declaracion del metodo listar personas
	 * 
	 * @return devuelve lista de personas
	 * @throws Exception para capturar excepciones
	 */
	public List<Persona> getPersonas() throws Exception;

	/**
	 * Declaracion del metodo buscar persona
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve objeto persona encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Persona getCliente(String cedula) throws Exception;

	/**
	 * Declaracion del metodo guardar persona
	 * 
	 * @param recibe p como objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(Persona p) throws Exception;

	/**
	 * Declaracion del metodo consultar contrato
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve lista de pedidos encontrados por cedula persona
	 * @throws Exception para capturar excepciones
	 */
	public List<pedidoCabecera> consultarContrato(String cedula) throws Exception;

	/**
	 * Declaracion del metodo login
	 * 
	 * @param recibe objeto persona
	 * @return devuelve objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public Persona getLogin(Persona persona) throws Exception;

	/**
	 * Declaracion del metodo buscar usuario
	 * 
	 * @param recibe usuario de persona
	 * @return devuelve objeto persona
	 * @throws Exception para capturar excepciones
	 */
	public Persona readUsuario(String usuario) throws Exception;
}
