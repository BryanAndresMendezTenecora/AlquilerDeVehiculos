package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Modelo que sirve como entidad para comentario
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_comentario")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "com_id")
	@SequenceGenerator(name = "id_com_seq", sequenceName = "ID_COM_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_com_seq")
	private int id;// llave primaria del comentario
	private String descripcion;// Descripcion del comentario
	private int calificacion;// Calificacion del comentario
	@OneToOne
	@JoinColumn(name = "per_cedula")
	private Persona persona; // Persona que realiza el comentario
	@OneToOne
	@JoinColumn(name = "veh_id")
	private Vehiculo vehiculo; // Vehiculo al cual se realiza el comentario

	/**
	 * Devuelve id del comentario
	 * 
	 * @return devuelve id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna el id del comentario
	 * 
	 * @param recibe id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve descripcion del comentario
	 * 
	 * @return devuelve comentario
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Asigna Descripcion del comentario
	 * 
	 * @param recibe descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve Calificacion del comentario
	 * 
	 * @return devuelve comentario
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * Asigna calificacion al vehiculo
	 * 
	 * @param recibe calificacion
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Devuelve Persona del Comentario
	 * 
	 * @return recibe comentario
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Asigna persona del comentario
	 * 
	 * @param recibe persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Devuelve Vehiculo del comentario
	 * 
	 * @return devuelve vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Asigna Vehiculo del comentario
	 * 
	 * @param recibe vehiculo
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
