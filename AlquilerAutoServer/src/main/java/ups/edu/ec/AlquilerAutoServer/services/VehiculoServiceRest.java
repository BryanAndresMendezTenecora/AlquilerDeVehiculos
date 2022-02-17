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
import ups.edu.ec.AlquilerAutoServer.on.ComentarioON;
import ups.edu.ec.AlquilerAutoServer.on.ComentarioONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

/**
 * Servicio Rest pedido
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Path("vehiculos")
public class VehiculoServiceRest {

	@Inject
	private VehiculoONLocal vehiculoON; // Se inyecta Objeto negocio local de vehiculo

	/**
	 * Servicio Rest para crear paciente
	 * 
	 * @param recibe parametro objeto contacto
	 * @return objeto mensaje de confirmacion
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearPaciente(Vehiculo contacto) {
		Mensaje msj = new Mensaje();

		try {
			contacto.setEstado("Activo");
			vehiculoON.insertarVehiculo(contacto);
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
	 * Servicio Rest para listar vehiculos
	 * 
	 * @return Devuelve una lista de vehiculos o null
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehiculo> getVehiculos() {
		try {
			return vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Servicio Rest para buscar vehiculos pos categoria o marca
	 * 
	 * @param recibe nombre que puede ser nombre de la categoria o marca de vehiculo
	 * @return devuelve una lista de vehiculos por el parametro ingresado
	 */
	@POST
	@Path("buscarC")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehiculo> getvehiculobuscqueda(String nombre) {
		System.out.println("este es nombre q llega ------->=" + nombre);
		List<Vehiculo> listvehiculo = new ArrayList<Vehiculo>();
		List<Vehiculo> nuevalistaobtenida = new ArrayList<Vehiculo>();
		try {
			listvehiculo = vehiculoON.getvehiculos();
			for (Vehiculo vehiculo : listvehiculo) {
				if (vehiculo.getCategoria().getNombre().equals(nombre) || vehiculo.getMarca().equals(nombre)) {
					nuevalistaobtenida.add(vehiculo);
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

	/*
	 * 
	 * @GET
	 * 
	 * @Path("buscarM")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Vehiculo>
	 * getvehiculobuscquedaM(@QueryParam("nombre") String nombre){
	 * System.out.println("este es nombre q llega ------->="+nombre); List<Vehiculo>
	 * listvehiculo=new ArrayList<Vehiculo>(); List<Vehiculo> nuevalistaobtenida=new
	 * ArrayList<Vehiculo>(); try { listvehiculo=vehiculoON.getvehiculos(); for
	 * (Vehiculo vehiculo : listvehiculo) { if (vehiculo.getMarca().equals(nombre))
	 * { nuevalistaobtenida.add(vehiculo); } else { System.out.println("-> "); }
	 * 
	 * } return nuevalistaobtenida; } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); return null; }
	 * 
	 * }
	 */

}
