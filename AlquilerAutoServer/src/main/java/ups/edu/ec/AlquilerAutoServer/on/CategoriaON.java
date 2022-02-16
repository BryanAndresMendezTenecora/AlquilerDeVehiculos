package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.CategoriaDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;

@Stateless
public class CategoriaON implements CategoriaONLocal{
	@Inject
	private CategoriaDAO categoriaDAO;
	
	public void insertarCategoria(Categoria categoria) throws Exception {
		/*String estado=categoria.getEstado().toUpperCase();
		String nombre=categoria.getNombre().toUpperCase();
		categoria.setNombre(nombre);
		categoria.setEstado(estado);
		*/
		categoria.setEstado(categoria.getEstado().toUpperCase());
		categoria.setNombre(categoria.getNombre().toUpperCase());
		categoriaDAO.insert(categoria);
	}
	
	
	public void actualizarCategoria(Categoria categoria) throws Exception {
		String estado=categoria.getEstado().toUpperCase();
		String nombre=categoria.getNombre().toUpperCase();
		categoria.setNombre(nombre);
		categoria.setEstado(estado);
		categoriaDAO.update(categoria);
	}
	
	public Categoria buscarCategoria(int id) throws Exception {
		return categoriaDAO.read(id);
	}
	
	public void eliminarCategoria(int id) throws Exception {
		categoriaDAO.delete(id);
	}
	public List<Categoria> getCategorias() {
		return categoriaDAO.getList();
	}
	
	public Categoria buscarNombre(String categoria) throws Exception{
		categoria.toUpperCase();
		return categoriaDAO.buscarNombre(categoria);
	}
	public Categoria getCategoria(int id) throws Exception {
		return categoriaDAO.read(id);
	}
	
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
	
	public List<Categoria> listarcategorias(){
		
		return categoriaDAO.listarcategorias();
	}
	
	
	
	
}
