package ups.edu.ec.AlquilerAutoServer.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TBL_tarjetacredito")
public class TarjetaCredito {
	@Id
	@Column(name = "tar_id")
	private int id;
	private String tipo;
	private String nombrepropietario;
	private String fechavencimiento;
	private int codigoseguridad;
	private String banco;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombrepropietario() {
		return nombrepropietario;
	}
	public void setNombrepropietario(String nombrepropietario) {
		this.nombrepropietario = nombrepropietario;
	}
	public String getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public int getCodigoseguridad() {
		return codigoseguridad;
	}
	public void setCodigoseguridad(int codigoseguridad) {
		this.codigoseguridad = codigoseguridad;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	

}
