package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "TBL_MetodoPago")
public class MetodoDePago implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "tar_id")
	@SequenceGenerator(name = "id_met_seq", sequenceName = "ID_MET_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_met_seq")
	private int id;
	
	private String tipo;
	private String numero;
	private String nombrepropietario;
	private String fechavencimiento;
	private int codigoseguridad;
	private String direccion;
	private String codigoPostal;
	private String estado;
	//private String banco;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
