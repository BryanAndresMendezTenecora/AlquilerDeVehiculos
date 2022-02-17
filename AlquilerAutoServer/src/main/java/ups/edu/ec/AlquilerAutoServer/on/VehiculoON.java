package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.VehiculoDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;

/**
 * Objeto de negocio de vehiculo
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Stateless
public class VehiculoON implements VehiculoONLocal {

	@Inject
	private VehiculoDAO VehiculoDAO;// Se inyecta el objeto acceso a dato de vehiculo

	/**
	 * metodo para insertar vehiculo
	 * 
	 * @param Vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void insertarVehiculo(Vehiculo Vehiculo) throws Exception {
		Vehiculo.setMarca(Vehiculo.getMarca().toUpperCase());
		Vehiculo.setModelo(Vehiculo.getModelo().toUpperCase());
		Vehiculo.setEstado(Vehiculo.getEstado().toUpperCase());
		VehiculoDAO.insert(Vehiculo);
	}

	/**
	 * metodo actualizar de vehiculo
	 * 
	 * @param recive objeto Vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void actualizarVehiculo(Vehiculo Vehiculo) throws Exception {
		Vehiculo.setMarca(Vehiculo.getMarca().toUpperCase());
		Vehiculo.setModelo(Vehiculo.getModelo().toUpperCase());
		Vehiculo.setEstado(Vehiculo.getEstado().toUpperCase());
		VehiculoDAO.update(Vehiculo);
	}

	/**
	 * metodo para buscar vehiculo
	 * 
	 * @param recibe id del vehiculo
	 * @return devuelve objeto vehiculo encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Vehiculo buscarVehiculo(int id) throws Exception {
		return VehiculoDAO.read(id);
	}

	/**
	 * Metodo para eliminar vehiculo
	 * 
	 * @param recibe id del vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void eliminarVehiculo(int id) throws Exception {
		VehiculoDAO.delete(id);
	}

	/**
	 * Metodo para listar vehiculos
	 * 
	 * @return devuelve una lista de vehiculos
	 * @throws Exception para capturar excepciones
	 */
	public List<Vehiculo> getvehiculos() throws Exception {
		return VehiculoDAO.getList();
	}

	/**
	 * Metodo de buscar categoria del vehiculo
	 * 
	 * @param recibe nombre de categoria
	 * @return devuelve una lista de categorias encontradas
	 */
	public List<Vehiculo> buscarCategoria(String categoria) {
		return VehiculoDAO.getCategoria(categoria);
	}

	/**
	 * Metodo para listar vehiculos disponibles
	 * 
	 * @return devuelve lista de vehiculo
	 * @throws Exception
	 */
	public List<Vehiculo> listarDisponibilidad() throws Exception {
		String disponibilidad = "disponible";
		return VehiculoDAO.getVehiculosDisponibilidad(disponibilidad);
	}

	/**
	 * Metodo para encontrar vehiculo por su id
	 * 
	 * @param recibe codigo del vehiculo
	 * @return devuelve un objeto vehiculo encontrado
	 * @throws Exception para capturar excepciones
	 */
	public Vehiculo getVehiculo(int codigo) throws Exception {
		return VehiculoDAO.read(codigo);
	}

	/**
	 * Metodo para guardar vehiculo
	 * 
	 * @param recibe p como objeto vehiculo
	 * @throws Exception para capturar excepciones
	 */
	public void guardar(Vehiculo vehiculo) throws Exception {
		System.out.println("ON: C-VEHI: " + vehiculo.getId());
		vehiculo.setMarca(vehiculo.getMarca().toUpperCase());
		vehiculo.setModelo(vehiculo.getModelo().toUpperCase());
		vehiculo.setEstado(vehiculo.getEstado().toUpperCase());
		if (VehiculoDAO.read(vehiculo.getId()) == null) {
			System.out.println(" V:Entro al INSERTAR");
			VehiculoDAO.insert(vehiculo);
		} else {
			VehiculoDAO.update(vehiculo);
			System.out.println("V:Entro al UPDATE");
		}
	}

	/**
	 * Metodo para listar categorias
	 * 
	 * @return devuelve una lista de categorias
	 */
	public List<Categoria> listarcategorias() {

		return VehiculoDAO.listarcategorias();
	}

	/**
	 * Metodo de listar vehiculos por su id
	 * 
	 * @param recibe codigo del vehiculo
	 * @return devuelve una lista de vehiculos
	 */
	public List<Vehiculo> getlistadoVehiculos(int codigo) {
		if (codigo == 1) {
			return VehiculoDAO.getVehiculosPrecioMayorMenor();
		} else if (codigo == 2) {
			return VehiculoDAO.getVehiculosPrecioMenorMayor();
		} else if (codigo == 3) {
			return VehiculoDAO.getVehiculosNombreAZ();
		} else if (codigo == 4) {
			return VehiculoDAO.getVehiculosModeloZA();
		}
		return VehiculoDAO.getList();
	}

	/**
	 * Metodo para listar vehiculos por categoria
	 * 
	 * @param recibe objeto categoria
	 * @return devuelve una lista de vehiculos
	 */
	public List<Vehiculo> getListaVehiculoCategoria(Categoria categoria) {
		return VehiculoDAO.getVehiculosCategoria(categoria);
	}

	/**
	 * Metodo para listar vehiculos por estado
	 * 
	 * @param recibe estado del vehiculo
	 * @return devuelve lista de vehiculos por estado
	 */
	public List<Vehiculo> getListaVehiculoEstado(String estado) {
		return VehiculoDAO.getVehiculosEstado(estado);
	}

}
