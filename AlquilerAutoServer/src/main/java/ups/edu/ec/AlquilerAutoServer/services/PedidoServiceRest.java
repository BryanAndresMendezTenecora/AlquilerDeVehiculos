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

@Path("pedido")
public class PedidoServiceRest {
	@Inject
	private PedidoONLocal pedidoON;
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearPedido(pedidoCabecera pedido) {
		Mensaje msj=new Mensaje();
		
		try {
			
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
	
	//Produces:formato en cual va a devolver
	
	//GET:obtener algo , devuelve algo
	// este metodo no tiene parametro no lleva ninguna anotacion
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pedidos")
	public  List<pedidoCabecera> getPedidos(){
		try {
			return pedidoON.getpedidoCabeceras();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	@POST
	@Path("buscarP")
	@Produces(MediaType.APPLICATION_JSON)
	public List<pedidoCabecera> getPedidosRealizados(String nombre){
		System.out.println("este es nombre q llega ------->="+nombre);
		List<pedidoCabecera> listPedido=new ArrayList<pedidoCabecera>();
		List<pedidoCabecera> nuevalistaobtenida=new ArrayList<pedidoCabecera>();
		try {
			listPedido=pedidoON.getpedidoCabeceras();
			for (pedidoCabecera pedido : listPedido) {
				if (pedido.getPersona().getNombre().equals(nombre) || pedido.getPersona().getCedula().equals(nombre) ) {
					nuevalistaobtenida.add(pedido);
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
