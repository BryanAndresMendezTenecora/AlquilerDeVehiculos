package ups.edu.ec.AlquilerAutoServer.on;

import javax.ejb.Remote;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;

@Remote
public interface PersonaONRemote {

	public void insertarPersona(Persona persona) throws Exception;
	public void actualizarPersona(Persona persona) throws Exception;
	public Persona buscarPersona(String cedula) throws Exception;
	public void eliminarPersona(String cedula) throws Exception;
}
