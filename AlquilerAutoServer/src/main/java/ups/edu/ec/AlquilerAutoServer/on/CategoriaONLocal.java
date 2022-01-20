package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
@Local
public interface CategoriaONLocal {
	public void insertarCategoria(Categoria categoria) throws Exception;
	public void actualizarCategoria(Categoria categoria) throws Exception;
	public Categoria buscarCategoria(int id) throws Exception;
	public void eliminarCategoria(int id) throws Exception;
	public List<Categoria> getCategorias();
	public Categoria buscarNombre(String categoria) throws Exception;
	public Categoria getCategoria(int id) throws Exception;
	
	public void guardar(Categoria p) throws Exception;
	
	public List<Categoria> listarcategorias();
	
}
