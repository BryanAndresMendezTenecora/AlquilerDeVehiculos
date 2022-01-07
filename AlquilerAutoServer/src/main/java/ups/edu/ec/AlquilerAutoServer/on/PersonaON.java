package ups.edu.ec.AlquilerAutoServer.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.AlquilerAutoServer.dao.PersonaDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;

@Stateless
public class PersonaON {

	@Inject
	private PersonaDAO personaDAO;
	
	public void insertarPersona(Persona persona) throws Exception {
		personaDAO.insert(persona);
	}
	
	
	public void actualizarPersona(Persona persona) throws Exception {
		personaDAO.update(persona);
	}
	
	public Persona buscarPersona(String cedula) throws Exception {
		return personaDAO.read(cedula);
	}
	
	public void eliminarPersona(String cedula) throws Exception {
		personaDAO.delete(cedula);
	}
}
