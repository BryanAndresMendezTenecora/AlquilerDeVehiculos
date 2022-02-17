package ups.edu.ec.AlquilerAutoServer.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.push.Push;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;

/**
 * Servicio Rest personas
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Path("personas")
public class PersonaServiceRest {
	@Inject
	private PersonaONLocal personaON; // Se inyecta Objeto negocio local de personas

	/**
	 * Servicio Rest para crear persona
	 * 
	 * @param recive contacto como objeto Persona
	 * @return devuelve mensaje de confirmacion
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearPaciente(Persona contacto) {
		Mensaje msj = new Mensaje();

		try {
			contacto.setEstado("Activo");
			personaON.insertarPersona(contacto);
			msj.setCodigo("01");
			msj.setMensaje("OK");
			return msj;
		} catch (Exception e) {
			// TODO: handle exception
			msj.setCodigo("99");
			msj.setMensaje("ERROR");
			return msj;
		}
	}

	/**
	 * Servicio Rest Listar personas
	 * 
	 * @return vevuelve lista de personas o null
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonas() {
		try {
			return personaON.getPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Servicio Rest login
	 * 
	 * @param recibe nombre como email de la persona
	 * @return devuelve status como confirmacion
	 */
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public status login(String nombre) {
		System.out.println("este es nombre q llega ------->=" + nombre);
		List<Persona> listadopersonas = new ArrayList<Persona>();

		status st = new status();
		try {
			listadopersonas = personaON.getPersonas();
			for (Persona persona : listadopersonas) {
				if (persona.getEmail().equals(nombre)) {
					// nuevalistaobtenida.add(vehiculo);
					System.out.println("persona encontrada");
					st.setStatus("oK");
					result re = new result();
					re.setToken("2345dgsd221342134sfashuy");
					st.setResult(re);

					return st;
				} else {
					System.out.println("-> ");
					st.setStatus("error");
					result re = new result();
					re.setError_id("200");
					re.setError_msg("El password es invalido");
					st.setResult(re);
					return st;
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;

	}

	/**
	 * Servicio Rest loginP
	 * 
	 * @param recibe email de la persona
	 * @param recibe password de la persona
	 * @return devuelve objeto status como confirmacion
	 */
	@GET
	@Path("loginP")
	@Produces(MediaType.APPLICATION_JSON)
	public status loginP(@QueryParam("email") String email, @QueryParam("password") String password) {
		System.out.println("este es nombre q llega ------->=" + password);
		List<Persona> listadopersonas = new ArrayList<Persona>();

		status st = new status();
		try {
			listadopersonas = personaON.getPersonas();
			for (Persona persona : listadopersonas) {
				if (persona.getEmail().equals(email) && persona.getPassword().equals(password)) {
					// nuevalistaobtenida.add(vehiculo);
					System.out.println("persona encontrada");
					st.setStatus("oK");
					result re = new result();
					re.setToken("2345dgsd221342134sfashuy");
					st.setResult(re);

					return st;
				} else {
					System.out.println("-> ");
					st.setStatus("error");
					result re = new result();
					re.setError_id("200");
					re.setError_msg("El password es invalido");
					st.setResult(re);
					return st;
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;

	}

}
