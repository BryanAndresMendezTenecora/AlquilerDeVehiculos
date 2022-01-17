package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.CategoriaDAO;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;

@Stateless
public class CategoriaON implements CategoriaONLocal{
	@Inject
	private CategoriaDAO categoriaDAO;
	
	public void insertarCategoria(Categoria categoria) throws Exception {
		categoriaDAO.insert(categoria);
	}
	
	
	public void actualizarCategoria(Categoria categoria) throws Exception {
		categoriaDAO.update(categoria);
	}
	
	public Categoria buscarCategoria(int id) throws Exception {
		return categoriaDAO.read(id);
	}
	
	public void eliminarCategoria(int id) throws Exception {
		categoriaDAO.delete(id);
	}
	public List<Categoria> getCategorias(){
		return categoriaDAO.getList();
	}
}
