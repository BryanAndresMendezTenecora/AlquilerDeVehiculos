package ups.edu.ec.AlquilerAutoServer.services;

import java.util.ArrayList;
import java.util.List;

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

import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.on.ComentarioONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

/**
 * Servicios para Comentario Se indica el path o la ruta para el servicio
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Path("comentario")
public class ComentarioServiceRest {
	@Inject
	private ComentarioONLocal comentarioON; // Se inyecta el objeto de acceso a datos de Comentario

	/**
	 * Servicio RESTful para insertar comentarios a vehiculos El método anotado
	 * responde a solicitudes HTTP PUT. Se define el tipo o medio de consumo json
	 * 
	 * @param comentario recibe el objeto comentario
	 * @return un mensaje de confirmacion del servicio
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearComentario(Comentario comentario) {
		Mensaje msj = new Mensaje();

		try {

			comentarioON.insertarComentario(comentario);
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
	 * Servicio RESTful para listar comentarios de vehiculos El método anotado
	 * responde a solicitudes HTTP GET Se define el tipo o medio de consumo json
	 * 
	 * @return devuelve una lista de comentarios
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comentario> getComentarios() {
		try {
			return comentarioON.getComentarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Servicio RESTful para devuelve una lista de comentarios a buscar por id El
	 * método anotado responde a las solicitudes HTTP POST Se define el tipo o medio
	 * de consumo json
	 * 
	 * @param id recibe el id del comentario
	 * @return devuelve una lista de comentarios
	 */
	@POST
	@Path("buscarComentario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comentario> getComentarioVehiculo(int id) {
		System.out.println("este es nombre q llega ------->=" + id);
		List<Comentario> listComentario = new ArrayList<Comentario>();
		List<Comentario> nuevalistaobtenida = new ArrayList<Comentario>();
		try {
			listComentario = comentarioON.getComentarios();
			for (Comentario comentario : listComentario) {
				if (comentario.getVehiculo().getId() == id) {
					nuevalistaobtenida.add(comentario);
				} else {
					System.out.println("-> ");
				}

			}
			return nuevalistaobtenida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
