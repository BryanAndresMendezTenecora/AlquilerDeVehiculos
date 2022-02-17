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
	 * Recuperación de un objeto tipo Date para la fecha actual
	 * @return devuelve un objeto tipo Date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	@PostConstruct
	public void init() {
		this.loadPagos();
	}


	public MetodoDePago getPago() {
		return pago;
	}

	public void setmetodoPago(MetodoDePago pago) {
		this.pago = pago;
	}

	public List<MetodoDePago> getPagos() {
		return metodosPagos;
	}

	public void setPagos(List<MetodoDePago> metodosPagos) {
		this.metodosPagos = metodosPagos;
	}

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

	public String editar(int codigo) {
		System.out.println(codigo);
		return "crear-pago?faces-redirect=true&id=" + codigo;
	}

	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		System.out.println("set " + codigo);
		this.codigo = codigo;
	}

	private void loadPagos() {
		try {
			this.metodosPagos = pagosON.getMetodoPagos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
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
	
	//#String ced=c
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
