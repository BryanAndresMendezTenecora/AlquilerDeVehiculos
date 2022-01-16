package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.AlquilerAutoServer.dao.DevolucionDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
@Stateless
public class DevolucionON implements DevolucionONLocal {
	@Inject
	private DevolucionDAO devolucionDAO;
	
	public void insertarDevolucion(Devolucion devolucion) throws Exception {
		devolucionDAO.insert(devolucion);
	}
	
	
	public void actualizarDevolucion(Devolucion devolucion) throws Exception {
		devolucionDAO.update(devolucion);
	}
	
	public Devolucion buscarDevolucion(int id) throws Exception {
		return devolucionDAO.read(id);
	}
	
	public void eliminarDevolucion(int id) throws Exception {
		devolucionDAO.delete(id);
	}
	public List<Devolucion> getDevolucions(){
		return devolucionDAO.getList();
	}
}
