package ups.edu.ec.AlquilerAutoServer.bean;

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
public class MetodoDePagoBean {
	@Inject
	private MetodoDePagoONLocal pagosON;
	private MetodoDePago pago = new MetodoDePago();
	private List<MetodoDePago> metodosPagos;

	private int codigo;
	
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@PostConstruct
	public void init() {
		this.loadPagos();
	}

	/*
	 * private String cedula; private String nombre; private String direccion;
	 * 
	 * public String getCedula() { return cedula; }
	 * 
	 * public void setCedula(String cedula) { this.cedula = cedula; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public void setNombre(String nombre) { this.nombre = nombre; }
	 * 
	 * public String getDireccion() { return direccion; }
	 * 
	 * public void setDireccion(String direccion) { this.direccion = direccion; }
	 * 
	 */

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

		/*
		 * Persona p= new Persona(); p.setCedula(this.cedula); p.setNombre(this.nombre);
		 * p.setDireccion(this.direccion);
		 */
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
	public String eliminar(int idTar, String tipo, String numero, String propietario, String fechaVen, int codSeg, String direccion, String codPostal) {
	
		try {
			this.pago.setId(idTar);
			this.pago.setTipo(tipo);
			this.pago.setNumero(numero);
			this.pago.setNombrepropietario(propietario);
			this.pago.setFechavencimiento(fechaVen);
			this.pago.setCodigoseguridad(codSeg);
			this.pago.setDireccion(direccion);
			this.pago.setCodigoPostal(codPostal);
			this.pago.setEstado("Inactivo");
			pagosON.actualizarMetodoPago(this.pago);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listarPago?faces-redirect=true"+ codigo;
	}

	
	public String paginaInicio() {
		return "pro-carro?faces-redirect=true";
	}
}
