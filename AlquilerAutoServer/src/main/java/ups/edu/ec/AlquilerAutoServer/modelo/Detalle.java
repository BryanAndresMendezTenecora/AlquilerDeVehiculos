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
 * Modelo que sirve como entidad para Detalle
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_detalle")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "det_id")
	private int id;// llave primaria de detalle
	private int cantidad;// cantidad del detalle
	private double total;// total de ese detalle
	@OneToOne
	@JoinColumn(name = "veh_id")
	private Vehiculo vehiculo; // detalle del vehiculo

	/**
	 * Devuelve la clave primaria de detalle
	 * 
	 * @return devuelve clave primaria
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna clave primaria del detalle
	 * 
	 * @param recibe id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve catidad del detalle
	 * 
	 * @return devuelve cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Asigna cantidad del detalle
	 * 
	 * @param recibe cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Devuelve total del detalle
	 * 
	 * @return devuelve total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Asigna total del detalle
	 * 
	 * @param recibe total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Devuelve vehiculo del detalle
	 * 
	 * @return devuelve vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Asigna vehiculo en el detalle
	 * 
	 * @param recibe vehiculo
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
