package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Modelo que servira como entidad para vehiculo
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_PedidoCabecera")
public class pedidoCabecera implements Serializable {
	private static final long serialVersionUID = 1L; // Numero de versión
	@Id
	@Column(name = "ped_id")
	@SequenceGenerator(name = "id_ped_seq", sequenceName = "ID_PED_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_ped_seq")
	private int id; // Llave primaria de vehiculo
	@OneToOne
	@JoinColumn(name = "per_cedula")
	private Persona persona; // Persona que realiza el pedido
	private String fecha; // fecha de emision del pedido
	private String fechaentrega; // fecha de entrega del pedido
	private String estado; // Estado del pedido (Emision, Finalizado)
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "ped_id")
	private List<Detalle> detalles; // Lista de detalles del pedido

	/**
	 * Devuelve el id del pedido
	 * 
	 * @return devuelve el id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna el id al pedido
	 * 
	 * @param id recibe el id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve la persona que realiza el pedido
	 * 
	 * @return devuelve la persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Asigna la persona que realiza el pedido
	 * 
	 * @param persona recibe la persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Devuelve la fecha de emision del pedido
	 * 
	 * @return devuelve la fecha de emision
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Asigna la fecha de emision del pedido
	 * 
	 * @param fecha recibe la fecha de emision
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve la fecha de entrega del pedido
	 * 
	 * @return devuelve la fecha de entrega
	 */
	public String getFechaentrega() {
		return fechaentrega;
	}

	/**
	 * Asigna la fecha de entrega del pedido
	 * 
	 * @param fechaentrega recibe la fecha de entrega
	 */
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	/**
	 * Devuelve el estado del pedido
	 * 
	 * @return devuelve el estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Asigna el estado al pedido
	 * 
	 * @param estado recibe el estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve una lista de detalles del pedido
	 * 
	 * @return devuelve los detalles
	 */
	public List<Detalle> getDetalles() {
		return detalles;
	}

	/**
	 * Asigna una lista de detalles al pedido
	 * 
	 * @param detalles recibe los detalles
	 */
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

}
