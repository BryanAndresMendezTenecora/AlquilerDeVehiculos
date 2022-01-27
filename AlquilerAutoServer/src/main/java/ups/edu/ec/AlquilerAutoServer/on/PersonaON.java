package ups.edu.ec.AlquilerAutoServer.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import ups.edu.ec.AlquilerAutoServer.dao.PersonaDAO;
import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;

@Stateless
public class PersonaON implements PersonaONLocal, PersonaONRemote{

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
	public List<Persona> getPersonas() throws Exception {
		return personaDAO.getList();
	}
	
	public Persona getCliente(String cedula) throws Exception {
		return personaDAO.read(cedula);
	}
	
	
	
	
	public void guardar(Persona p) throws Exception {
		if (personaDAO.read(p.getCedula()) == null)
			personaDAO.insert(p);
		else
			personaDAO.update(p);
	}
	
	
	public List<pedidoCabecera>  consultarContrato(String cedula) throws Exception{
		return personaDAO.getContratos(cedula);
	}
	
	
	public Persona getLogin(Persona persona) throws Exception {
		List<Persona> usuarios =personaDAO.getIniciarSesion(persona);
		Persona respuesta= new Persona();
		for(Persona elemento: usuarios) {
			respuesta.setCedula(elemento.getCedula());
			respuesta.setNombre(elemento.getNombre());
			respuesta.setApellido(elemento.getApellido());
			respuesta.setDireccion(elemento.getDireccion());
			respuesta.setTelefono(elemento.getTelefono());
			respuesta.setEstado(elemento.getEstado());
			respuesta.setEmail(elemento.getEmail());
			respuesta.setPassword(elemento.getPassword());
			respuesta.setRol(elemento.getRol());
		}
		
		return respuesta;
		
	}
	//by domenica
	public Persona readUsuario(String usuario) throws Exception {
	    Persona per = personaDAO.read(usuario);
	    return per;
	  }
}
