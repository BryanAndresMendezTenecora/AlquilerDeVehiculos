package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.ec.AlquilerAutoServer.modelo.MetodoDePago;
import ups.edu.ec.AlquilerAutoServer.modelo.Persona;
import ups.edu.ec.AlquilerAutoServer.on.MetodoDePagoONLocal;
import ups.edu.ec.AlquilerAutoServer.on.PersonaONLocal;



@Named
@RequestScoped
public class MetodoDePagoBean implements Serializable{
	@Inject
	private MetodoDePagoONLocal pagosON; 		// Injección al servidor mediante los objetos ON del metodo.
	private MetodoDePago pago = new MetodoDePago();		//Declaramiento de un objeto MetodoDePago para guardar la información de la tarjeta
	private List<MetodoDePago> metodosPagos;		// Declaración de una lista de tipo MetodoDePago para guardar todos los metodos existentes.

	private int codigo;   //Atributo que contiene un dato tipo int para el codigo que buscara los objetos MetodoDePago
	
	private Date date;  // Atributo donde se le guardara la información de la fecha actual

	/**
	 * Recuperación de un objeto tipo Date para la fecha actual.
	 * @return devuelve un objeto tipo Date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Asigna un objeto tipo Date.
	 * @param El parámentro date tendra información de la fecha actual
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Se encarga de recuperar todos los objetos tipo MetodoDePago.
	 */
	@PostConstruct
	public void init() {
		this.loadPagos();
	}

	/**
	 * Recuperación de un objeto tipo MetodoDePago.
	 * @return devuelve un objeto tipo MetodoDePago.
	 */
	public MetodoDePago getPago() {
		return pago;
	}

	/**
	 * Asigna un objeto tipo MetodoDePago.
	 * @param El parámetro pago se asignara al objeto.
	 */
	public void setmetodoPago(MetodoDePago pago) {
		this.pago = pago;
	}

	/**
	 * Recuperación de una lista tipo MetodoDePago.
	 * @return devuelve una lista de tipo MetodoDePago
	 */
	public List<MetodoDePago> getPagos() {
		return metodosPagos;
	}

	/**
	 * Asigna una lista de metodos pagos
	 * @param metodosPagos es el parametro que contiene todos los metodos de pago.
	 */
	public void setPagos(List<MetodoDePago> metodosPagos) {
		this.metodosPagos = metodosPagos;
	}

	/**
	 * Método que insertara o actualizara el objeto metodo de pago.
	 * @return Me permite la navegación a otra página.
	 */
	public String guardar() {

		System.out.println("Guardando " + this.pago.getNombrepropietario());

		try {
			this.getPago().setEstado("Activo");
			pagosON.guardar(this.pago);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarPago?faces-redirect=true";
	}

	/**
	 * Permita la edición del objeto mediante un código que es la llave la primaria.
	 * @param codigo es el parámetro, pertenece a una llave primaria.
	 * @return Me permite la navegación a otra página.
	 */
	public String editar(int codigo) {
		System.out.println(codigo);
		return "crear-pago?faces-redirect=true&id=" + codigo;
	}

	/**
	 * Recuperación de un dato
	 * @return devuelve un dato tipo int.
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Asigna un dato a un objeto.
	 * @param El parámetro codigo que se asignara al objeto 
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Recuperación de uan lista sobre los metodo de pago
	 */
	private void loadPagos() {
		try {
			this.metodosPagos = pagosON.getMetodoPagos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Metodo que se encarga de recuperar un Objeto de método de pago.
	 */
	public void loadData() {
		if(codigo==0)
			return;
		
		MetodoDePago p;
		try {
			p = pagosON.getPago(codigo);
			pago=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que me permite hacer la edición a un objeto 
	 */
	public void loadDataEditar() {
		MetodoDePago p;
		try {
			p = pagosON.getPago(pago.getId());
			pago=p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Permite la edición a un objeto, se actualizara el estado del objeto.
	 * a eliminado
	 * @param idTar, es la llave primaria del objeto a buscar.
	 * @return Me permite la navegación a otra página.
	 */

	public String eliminar(int idTar) {
	
		try {
			pago=pagosON.buscarMetodoPago(idTar);
			pago.setEstado("ELIMIANDO");
			pagosON.actualizarMetodoPago(this.pago);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarPago?faces-redirect=true";
	}

}
