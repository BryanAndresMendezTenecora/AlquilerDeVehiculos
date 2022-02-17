package ups.edu.ec.AlquilerAutoServer.on;

import javax.ejb.Remote;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;

/**
 * Interfaz Remote del objeto de negocio de persona
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Remote
public interface PersonaONRemote {

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
	 * Declaracion del metodo para buscar persona
	 * 
	 * @param recibe cedula de la persona
	 * @return devuelve objeto persona encontrada
	 * @throws Exception para capturar excepciones
	 */
	public Persona buscarPersona(String cedula) throws Exception;

	/**
	 * Declaracion del metodo eliminar persona
	 * 
	 * @param recibe cedula de la persona
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarPersona(String cedula) throws Exception;
}
