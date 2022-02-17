package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.CategoriaDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;

/**
 * Objeto de negocio de Categoria 
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class CategoriaON implements CategoriaONLocal{
	@Inject //Se inyecta el objeto de acceso a datos de categoria
	private CategoriaDAO categoriaDAO;
	
	/**
	 * Metodo Insertar Categoria
	 * @param categoria recibe el objeto categoria
	 * @throws Exception para capturar excepciones
	 */
	public void insertarCategoria(Categoria categoria) throws Exception {
		categoria.setEstado(categoria.getEstado().toUpperCase());
		categoria.setNombre(categoria.getNombre().toUpperCase());
		categoriaDAO.insert(categoria);
	}
	
	/**
	 * Metodo actualizar Categoria
	 * @param categoria recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarCategoria(Categoria categoria) throws Exception {
		String estado=categoria.getEstado().toUpperCase();
		String nombre=categoria.getNombre().toUpperCase();
		categoria.setNombre(nombre);
		categoria.setEstado(estado);
		categoriaDAO.update(categoria);
	}
	
	/**
	 * Metodo buscar Categoria
	 * @param id recibe el id de la categoria
	 * @return devuelve el objeto categoria encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Categoria buscarCategoria(int id) throws Exception {
		return categoriaDAO.read(id);
	}
	
	
	/**
	 * Metodo eliminar Categoria
	 * @param id recibe el id de la categoria
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarCategoria(int id) throws Exception {
		categoriaDAO.delete(id);
	}
	
	/**
	 * Metodo que devuelve una lista de categorias
	 * 
	 * @return devuelve la lista
	 */
	public List<Categoria> getCategorias() {
		return categoriaDAO.getList();
	}
	
	
	/**
	 * Metodo que devuelve una lista de categorias por nombre
	 * 
	 * @param categoria recibe el nombre
	 * @return devuelve la lista
	 * @throws Exception para capturar excepciones
	 */
	public Categoria buscarNombre(String categoria) throws Exception{
		categoria.toUpperCase();
		return categoriaDAO.buscarNombre(categoria);
	}
	
	/**
	 * Metodo que devuelve una lista de categorias por id
	 * 
	 * @param id recibe el id
	 * @return devuelve la lista
	 * @throws Exception para capturar excepciones
	 */
	public Categoria getCategoria(int id) throws Exception {
		return categoriaDAO.read(id);
	}
	
	
	/**
	 * Metodo para guardar o actualizar una categoria
	 * @param p recibe el objeto
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(Categoria p) throws Exception {
		System.out.println("ON: CO-CATE"+p.getId());
		p.setEstado(p.getEstado().toUpperCase());
		p.setNombre(p.getNombre().toUpperCase());
		if (categoriaDAO.read(p.getId()) == null) {
			System.out.println("Entro al INSERT");
			categoriaDAO.insert(p);
		}else {
			System.out.println("Entro al UPDATE");
			categoriaDAO.update(p);
		}
			
	}
	
	
	/**
	 * Metodo que devuelve una lista de categorias
	 * @return devuelve una lista
	 */
	public List<Categoria> listarcategorias(){
		
		return categoriaDAO.listarcategorias();
	}
	
	
	
	
}
