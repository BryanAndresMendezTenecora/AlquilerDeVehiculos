package ups.edu.ec.AlquilerAutoServer.services;

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
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

@Path("vehiculos")
public class VehiculoServiceRest {
	@Inject
	private VehiculoONLocal vehiculoON;
	
	
	
	
	
	
	
	//los q se pegan a un crud , crear actualizar eliminar no se manjea un path 
	
	//enviar tranferiri algo
	// en el caso de q en el paraemtro sea un objeto entonce se debe afirmar en q formato se va consumir
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearPaciente(Vehiculo contacto) {
		Mensaje msj=new Mensaje();
		
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
	//Produces:formato en cual va a devolver
	
	//GET:obtener algo , devuelve algo
	// este metodo no tiene parametro no lleva ninguna anotacion
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Vehiculo> getVehiculos(){
		try {
			return vehiculoON.getvehiculos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	

}
