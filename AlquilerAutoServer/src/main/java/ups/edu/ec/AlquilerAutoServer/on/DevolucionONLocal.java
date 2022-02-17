package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;

/**
 * Interfaz local del objeto de negocio Devolucion
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface DevolucionONLocal {
	/**
	 * Declaracion del metodo Insertar devolucion
	 * 
	 * @param devolucion recibe el objeto devolucion
	 * @throws Exception para capturar excepciones
	 */
	public void insertarDevolucion(Devolucion devolucion) throws Exception;

	/**
	 * Declaracion del metodo actualizar devolucion
	 * 
	 * @param devolucion recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarDevolucion(Devolucion devolucion) throws Exception;

	/**
	 * Declaracion del metodo buscar Devolucion
	 * 
	 * @param id recibe el id de la devolucion
	 * @return devuelve el objeto devolucion encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Devolucion buscarDevolucion(int id) throws Exception;

	/**
	 * Declaracion del metodo eliminar Devolucion
	 * 
	 * @param id recibe el id de la devolucion
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarDevolucion(int id) throws Exception;

	/**
	 * Declaracion del Metodo que devuelve una lista de devoluciones
	 * 
	 * @return devuelve la lista
	 */
	public List<Devolucion> getDevolucions();

	/**
	 * Declaracion del Metodo que devuelve una lista de devoluciones por cedula de
	 * la persona
	 * 
	 * @param cedula recibe el objeto
	 * @return devuelve una lista
	 */
	public List<Devolucion> getAntecedentes(Persona cedula);
}
