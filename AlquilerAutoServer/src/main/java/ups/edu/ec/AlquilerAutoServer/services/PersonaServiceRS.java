package ups.edu.ec.AlquilerAutoServer.services;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

@Path("personas")
public class PersonaServiceRS {

	@Inject
	private VehiculoONLocal vehiculoON;
	
	
	@GET
	@Path("/catalogo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehiculo> getCatalogo(){
		
		try {
			List<Vehiculo> vehiculos= vehiculoON.getvehiculos();
			return vehiculos;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
	}
	
	@GET
	@Path("/contratos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContratoTemp> getContratos(Persona persona){
		
		return null;
		
		
	}
	
	
	
}
