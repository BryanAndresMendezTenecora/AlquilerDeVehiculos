package ups.edu.ec.AlquilerAutoServer.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class FechaBean implements Serializable  {
	private Date fecha= new Date();
	private Date fechaEntrega= new Date();
	
	
	
	
	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public void imprimirFechar() {
		System.out.println(fecha);
		System.out.println(fechaEntrega);
	}
	
	
}
