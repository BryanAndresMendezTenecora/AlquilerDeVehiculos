package ups.edu.ec.AlquilerAutoServer.services;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Clase en donde se definen los permisos para el consumo de los servicios desde
 * un cliente angular Se implementa una interfaz de extensión para la
 * exploración del servidor
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {
	@Override
	/**
	 * clase mutable que proporciona información específica de la respuesta para el
	 * filtro, como encabezados de mensajes, entidades de mensajes o propiedades del
	 * ámbito de la solicitud.
	 *
	 */
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

}
