package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;

/**
 * Interfaz local del objeto de negocio Categoria
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Local
public interface CategoriaONLocal {
	/**
	 * Declaracion del metodo Insertar Categoria
	 * 
	 * @param categoria recibe el objeto categoria
	 * @throws Exception para capturar excepciones
	 */
	public void insertarCategoria(Categoria categoria) throws Exception;

	/**
	 * Declaracion del metodo actualizar Categoria
	 * 
	 * @param categoria recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarCategoria(Categoria categoria) throws Exception;

	/**
	 * Declaracion del metodo buscar Categoria
	 * 
	 * @param id recibe el id de la categoria
	 * @return devuelve el objeto categoria encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Categoria buscarCategoria(int id) throws Exception;

	/**
	 * Declaracion del metodo eliminar Categoria
	 * 
	 * @param id recibe el id de la categoria
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarCategoria(int id) throws Exception;

	/**
	 * Declaracion del metodo que devuelve una lista de categorias
	 * 
	 * @return devuelve la lista
	 */
	public List<Categoria> getCategorias();

	/**
	 * Declaracion del metodo que devuelve una lista de categorias por nombre
	 * 
	 * @param categoria recibe el nombre
	 * @return devuelve la lista
	 * @throws Exception para capturar excepciones
	 */
	public Categoria buscarNombre(String categoria) throws Exception;

	/**
	 * Declaracion del metodo que devuelve una lista de categorias por id
	 * 
	 * @param id recibe el id
	 * @return devuelve la lista
	 * @throws Exception para capturar excepciones
	 */
	public Categoria getCategoria(int id) throws Exception;

	/**
	 * Declaracion del metodo para guardar o actualizar una categoria
	 * 
	 * @param p recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(Categoria p) throws Exception;

	/**
	 * Declaracion del metodo que devuelve una lista de categorias
	 * 
	 * @return devuelve una lista
	 */
	public List<Categoria> listarcategorias();

}
