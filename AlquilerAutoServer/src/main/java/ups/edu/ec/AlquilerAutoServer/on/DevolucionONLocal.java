package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;


import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
@Local
public interface DevolucionONLocal {
	public void insertarDevolucion(Devolucion devolucion) throws Exception;
	public void actualizarDevolucion(Devolucion devolucion) throws Exception;
	public Devolucion buscarDevolucion(int id) throws Exception;
	public void eliminarDevolucion(int id) throws Exception;
	public List<Devolucion> getDevolucions();
	public List<Devolucion> getAntecedentes(Persona cedula);
}
