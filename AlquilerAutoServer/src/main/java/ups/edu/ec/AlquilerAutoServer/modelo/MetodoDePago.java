package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Modelo que servira como entidad para el metodo de pago
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_MetodoPago")
public class MetodoDePago implements Serializable {
	private static final long serialVersionUID = 1L; // Numero de versión
	@Id
	@Column(name = "tar_id")
	@SequenceGenerator(name = "id_met_seq", sequenceName = "ID_MET_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_met_seq")
	private int id; // LLava primaria de la tarjeta

	private String tipo; // Tipo de tarjeta
	private String numero; // Numero de la tarjeta
	private String nombrepropietario; // Nombre del titular de la tarjeta
	private String fechavencimiento; // Fecha de vencimiento de la tarjeta
	private int codigoseguridad; // Codigo CVV de la tarjeta
	private String direccion; // Direccion para facturacion
	private String codigoPostal; // Codigo postal para la facturacion
	private String estado; // Estado de la tarjeta (Activo, Inactivo)

	/**
	 * Devuelve el id del método de pago
	 * 
	 * @return devuelve la clave primaria
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna el id del método de pago
	 * 
	 * @param recibe el codigo
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el tipo del método de pago
	 * 
	 * @return devuelve el tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Asigna el tipo del método de pago
	 * 
	 * @param tipo recibe el tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve el nombre del titular del método de pago
	 * 
	 * @return devuelve el nombre
	 */
	public String getNombrepropietario() {
		return nombrepropietario;
	}

	/**
	 * Asigna el nombre del titular del método de pago
	 * 
	 * @param nombrepropietario recibe el nombre
	 */
	public void setNombrepropietario(String nombrepropietario) {
		this.nombrepropietario = nombrepropietario;
	}

	/**
	 * Devuelve la fecha de vencimiento del metodo de paago
	 * 
	 * @return devuelve la fecha de vigencia
	 */
	public String getFechavencimiento() {
		return fechavencimiento;
	}

	/**
	 * Asigna la fecha de vencimiento del metodo de pago
	 * 
	 * @param fechavencimiento recibe la fecha de vencimiento
	 */
	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	/**
	 * Devuelve el codigo CVV del metodo de pago
	 * 
	 * @return devuelve el codigo CVV
	 */
	public int getCodigoseguridad() {
		return codigoseguridad;
	}

	/**
	 * Asigna el codigo CVV del metodo de pago
	 * 
	 * @param codigoseguridad recibe el codigo CVV
	 */
	public void setCodigoseguridad(int codigoseguridad) {
		this.codigoseguridad = codigoseguridad;
	}

	/**
	 * Devuelve la direccion del metodo de pago
	 * 
	 * @return devuelve la direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Asigna la direccion de facturacion del metodo de pago
	 * 
	 * @param direccion recibe la direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el codigo postal para la facturacion del metodo de pago
	 * 
	 * @return devuelve el codigo postal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * Asigna el codigo postal del metodo de pago
	 * 
	 * @param codigoPostal recibe el codigo postal
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * Devuelve el estado del metodo de pago
	 * 
	 * @return devuelve el estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Asigna el estado del metodo de pago
	 * 
	 * @param estado recibe el estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve el numero del metod de pago
	 * 
	 * @return devuelve el numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Asigna el numero del metodo de pago
	 * 
	 * @param numero recibe el numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
