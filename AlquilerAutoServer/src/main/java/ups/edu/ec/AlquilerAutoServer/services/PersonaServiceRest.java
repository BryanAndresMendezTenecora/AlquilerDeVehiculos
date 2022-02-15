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

@Path("personas")
public class PersonaServiceRest {
	@Inject
	private PersonaONLocal personaON;
	//@QueryParam=parametros en la web
	@GET
	@Path("suma")
	@Produces(MediaType.APPLICATION_JSON)
	public double suma(@QueryParam("a") double a ,@QueryParam("b") double b) {
		
		return a+b;
	}
	
	
	@POST
	@Path("autorizar")
	@Produces(MediaType.APPLICATION_JSON)
	public String autorizarfactura(@QueryParam("xml") String facturaxml) {
		//autorizacion
		return "Felicidades";
	}
	
	
	//formparam se utiliza en post put
	//query param se utiliza en get
	@POST
	@Path("tranferir")
	@Produces(MediaType.APPLICATION_JSON)
	public String tranferir(@FormParam("cuenta") String numerocuenta, @FormParam("banco") String banco) {
		//logica
		
		return null;
	}
	
	//los q se pegan a un crud , crear actualizar eliminar no se manjea un path 
	
	//enviar tranferiri algo
	// en el caso de q en el paraemtro sea un objeto entonce se debe afirmar en q formato se va consumir
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/json")
	public Mensaje crearPaciente(Persona contacto) {
		Mensaje msj=new Mensaje();
		
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
	//Produces:formato en cual va a devolver
	
	//GET:obtener algo , devuelve algo
	// este metodo no tiene parametro no lleva ninguna anotacion
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Persona> getPersonas(){
		try {
			return personaON.getPersonas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public status login(String nombre){
		System.out.println("este es nombre q llega ------->="+nombre);
		List<Persona> listadopersonas=new ArrayList<Persona>();
		
		status st=new status();
		try {
			listadopersonas=personaON.getPersonas();
			for (Persona persona : listadopersonas) {
				if (persona.getEmail().equals(nombre)) {
					//nuevalistaobtenida.add(vehiculo);
					System.out.println("persona encontrada");
					st.setStatus("oK");
					result re=new result();
					re.setToken("2345dgsd221342134sfashuy");
					st.setResult(re);
					
					return st;
				} else {
					System.out.println("-> ");
					st.setStatus("error");
					result re=new result();
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
	
	
	@GET
	@Path("loginP")
	@Produces(MediaType.APPLICATION_JSON)
	public status loginP(@QueryParam("email") String email,@QueryParam("password") String password){
		System.out.println("este es nombre q llega ------->="+password);
		List<Persona> listadopersonas=new ArrayList<Persona>();
		
		status st=new status();
		try {
			listadopersonas=personaON.getPersonas();
			for (Persona persona : listadopersonas) {
				if (persona.getEmail().equals(email) && persona.getPassword().equals(password)) {
					//nuevalistaobtenida.add(vehiculo);
					System.out.println("persona encontrada");
					st.setStatus("oK");
					result re=new result();
					re.setToken("2345dgsd221342134sfashuy");
					st.setResult(re);
					
					return st;
				} else {
					System.out.println("-> ");
					st.setStatus("error");
					result re=new result();
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
