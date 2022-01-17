package ups.edu.ec.AlquilerAutoServer.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.AlquilerAutoServer.modelo.Categoria;
import ups.edu.ec.AlquilerAutoServer.modelo.Comentario;
import ups.edu.ec.AlquilerAutoServer.modelo.Detalle;
import ups.edu.ec.AlquilerAutoServer.modelo.Devolucion;
import ups.edu.ec.AlquilerAutoServer.modelo.Factura;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.modelo.TarjetaCredito;
import ups.edu.ec.AlquilerAutoServer.modelo.Vehiculo;
import ups.edu.ec.AlquilerAutoServer.modelo.pedidoCabecera;
import ups.edu.ec.AlquilerAutoServer.on.CategoriaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.ComentarioONLocal;
import ups.edu.ec.AlquilerAutoServer.on.DevolucionONLocal;
import ups.edu.ec.AlquilerAutoServer.on.FacturaONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PedidoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONlocal;
import ups.edu.ec.AlquilerAutoServer.on.TarjetacreditoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.VehiculoONLocal;

/**
 * Servlet implementation class vistaprincipal
 */
@WebServlet("/vistaprincipal")
public class vistaprincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CategoriaONLocal categoriaONL;
	@Inject
	private VehiculoONLocal vehiculoONL;
	@Inject
	private PersonaONlocal personaONL;
	@Inject
	private PedidoONLocal pedidoONL;
	@Inject
	private TarjetacreditoONLocal tarjetacreditoONL;
	@Inject
	private FacturaONLocal facturaONL;
	@Inject
	private DevolucionONLocal devolucionONL;
	@Inject
	private ComentarioONLocal comentarioONL; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vistaprincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//insertando Persona
		Persona per=new Persona();
		per.setCedula("0302882725");
		per.setNombre("Juan");
		per.setApellido("Boni");
		per.setDireccion("azogues");
		per.setTelefono("3022207");
		per.setEstado("NN");
		per.setEmail("juanbny85@gmail.com");
		per.setPassword("patito.local");
		per.setRol("User");
		try {
			personaONL.insertarPersona(per);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//insertando categoria
		Categoria cat=new Categoria();
		cat.setId(1);
		cat.setNombre("Auto");
		try {
			categoriaONL.insertarCategoria(cat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//insertando vehiculo
		Vehiculo veh=new Vehiculo();
		veh.setId(1);
		veh.setMarca("Toyota");
		veh.setModelo("Yaris");
		veh.setStock(10);
		veh.setEstado("disponible");
		//-----inserto categoria existente
		veh.setCategoria(cat);
		try {
			vehiculoONL.insertarVehiculo(veh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//haciendo pedido de auto
		pedidoCabecera ped=new pedidoCabecera();
		ped.setId(1);
		ped.setPersona(per);
		ped.setFecha("16/1/2022");
		ped.setEstado("NN");
		//detalles
		Detalle det=new Detalle();
		det.setId(1);
		det.setCantidad(1);
		det.setTotal(1000.0);
		det.setVehiculo(veh);
		ArrayList<Detalle> detalles=new ArrayList<Detalle>();
		detalles.add(det);
		ped.setDetalles(detalles);
		try {
			pedidoONL.insertarpedidoCabecera(ped);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//insertar datos Tarjeta
		TarjetaCredito tar=new TarjetaCredito();
		tar.setId(1);
		tar.setTipo("debito");
		tar.setNombrepropietario("juan boni");
		tar.setFechavencimiento("12/2025");
		tar.setCodigoseguridad(8511);
		tar.setBanco("Pichicha");
		try {
			tarjetacreditoONL.insertarTarjetaCredito(tar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-----Factura de la alquiler
		Factura fac=new Factura();
		fac.setId(1);
		fac.setTotal(1000.0);
		fac.setPedido(ped);
		fac.setEstado("NN");
		fac.setTarjetacredito(tar);	
		try {
			facturaONL.insertarFactura(fac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//devolucion
		Devolucion dev=new Devolucion();
		dev.setId(1);
		dev.setFecha("1/1/2022");
		dev.setFactura(fac);
		dev.setAntecedente("se encuentra en buen estado");
		
		try {
			devolucionONL.insertarDevolucion(dev);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//hacer comentario
		Comentario com=new Comentario();
		com.setId(1);
		com.setCalificacion(10);
		com.setDescripcion("un excelente servicio");
		com.setPersona(per);
		com.setVehiculo(veh);
		
		try {
			comentarioONL.insertarComentario(com);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
