package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
@Local
public interface PersonaONLocal {
	public void insertarPersona(Persona persona) throws Exception;
	public void actualizarPersona(Persona persona) throws Exception;
	public Persona buscarPersona(String cedula) throws Exception;
	public void eliminarPersona(String cedula) throws Exception;
	public List<Persona> getPersonas() throws Exception;
	public Persona getCliente(String cedula) throws Exception ;
	public void guardar(Persona p) throws Exception;
	public List<pedidoCabecera>  consultarContrato(String cedula) throws Exception;
	public Persona getLogin(Persona persona) throws Exception;
	public Persona readUsuario(String usuario) throws Exception;
}
