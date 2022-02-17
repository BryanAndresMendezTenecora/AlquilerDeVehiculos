package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

/**
 * Interfaz local del objeto de negocios de vehiculo
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface VehiculoONLocal {
	/**
	 * Declaracion del metodo para insertar vehiculo
	 * 
	 * @param recibe objeto Vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void insertarVehiculo(Vehiculo Vehiculo) throws Exception;

	/**
	 * Declaracion del metodo actualizar de vehiculo
	 * 
	 * @param recive objeto Vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarVehiculo(Vehiculo Vehiculo) throws Exception;

	/**
	 * Declaracion del metodo para buscar vehiculo
	 * 
	 * @param recibe id del vehiculo
	 * @return devuelve objeto vehiculo encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Vehiculo buscarVehiculo(int id) throws Exception;

	/**
	 * Declaracion Metodo para eliminar vehiculo
	 * 
	 * @param recibe id del vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarVehiculo(int id) throws Exception;

	/**
	 * Declaracion del Metodo para listar vehiculos
	 * 
	 * @return devuelve una lista de vehiculos
	 * @throws Exception para capturar excepciones
	 */
	public List<Vehiculo> getvehiculos() throws Exception;

	/**
	 * Declaracion Declaracion del metodo de buscar categoria del vehiculo
	 * 
	 * @param recibe nombre de categoria
	 * @return devuelve una lista de categorias encontradas
	 */
	public List<Vehiculo> buscarCategoria(String categoria);

	/**
	 * Declaracion Metodo para encontrar vehiculo por su id
	 * 
	 * @param recibe codigo del vehiculo
	 * @return devuelve un objeto vehiculo encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Vehiculo getVehiculo(int codigo) throws Exception;

	/**
	 * Declaracion Metodo para guardar vehiculo
	 * 
	 * @param recibe p como objeto vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(Vehiculo p) throws Exception;

	/**
	 * Declaracion del metodo para listar categorias
	 * 
	 * @return devuelve una lista de categorias
	 */
	public List<Categoria> listarcategorias();

	/**
	 * Declaracion del metodo de listar vehiculos por su id
	 * 
	 * @param recibe codigo del vehiculo
	 * @return devuelve una lista de vehiculos
	 */
	public List<Vehiculo> getlistadoVehiculos(int codigo);

	/**
	 * Declaracion del metodo para listar vehiculos por categoria
	 * 
	 * @param recibe objeto categoria
	 * @return devuelve una lista de vehiculos
	 */
	public List<Vehiculo> getListaVehiculoCategoria(Categoria categoria);

	/**
	 * Declaracion de metodo para listar vehiculos por estado
	 * 
	 * @param recibe estado del vehiculo
	 * @return devuelve lista de vehiculos por estado
	 */
	public List<Vehiculo> getListaVehiculoEstado(String estado);

}
