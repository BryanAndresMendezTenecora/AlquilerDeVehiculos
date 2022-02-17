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

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;

/**
 * Servicios para Pedido. Se indica el path o la ruta para el servicio
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Path("pedido")
public class PedidoServiceRest {
	@Inject
	private PedidoONLocal pedidoON; // Se inyecta el objeto de acceso a datos de Comentario

	/**
	 * Servicio RESTful para insertar pedido de vehiculos El método anotado responde
	 * a solicitudes HTTP PUT. Se define el tipo o medio de consumo json
	 * 
	 * @param pedido recibe el objeto pedido
	 * @return un mensaje de confirmacion del servicio
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearPedido(pedidoCabecera pedido) {
		Mensaje msj = new Mensaje();

		try {
			pedido.setEstado("EMISION");
			pedidoON.insertarpedidoCabecera(pedido);
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
	 * Servicio RESTful para listar pedidos de vehiculos. El método anotado responde
	 * a solicitudes HTTP GET. Se define el tipo o medio de consumo json
	 * 
	 * @return devuelve una lista de pedidos
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pedidos")
	public List<pedidoCabecera> getPedidos() {
		try {
			return pedidoON.getpedidoCabeceras();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Servicio RESTful para devuelve una lista de pedidos a buscar por la cedula y
	 * el nombre. El método anotado responde a las solicitudes HTTP POST. Se define
	 * el tipo o medio de consumo json
	 * 
	 * @param nombre recibe la cedula o el nombre de la persona
	 * @return devuelve una lista de pedidos
	 */
	@POST
	@Path("buscarP")
	@Produces(MediaType.APPLICATION_JSON)
	public List<pedidoCabecera> getPedidosRealizados(String nombre) {
		System.out.println("este es nombre q llega ------->=" + nombre);
		List<pedidoCabecera> listPedido = new ArrayList<pedidoCabecera>();
		List<pedidoCabecera> nuevalistaobtenida = new ArrayList<pedidoCabecera>();
		try {
			listPedido = pedidoON.getpedidoCabeceras();
			for (pedidoCabecera pedido : listPedido) {
				if (pedido.getPersona().getNombre().equals(nombre) || pedido.getPersona().getCedula().equals(nombre)) {
					nuevalistaobtenida.add(pedido);
				} else {
					System.out.println("-> ");
				}

			}
			return nuevalistaobtenida;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
