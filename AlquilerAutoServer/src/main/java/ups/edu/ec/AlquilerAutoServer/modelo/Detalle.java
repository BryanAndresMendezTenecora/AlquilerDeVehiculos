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

@Entity
@Table(name = "TBL_detalle")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "det_id")
	//@SequenceGenerator(name = "id_det_seq", sequenceName = "ID_DET_SEQ", initialValue = 1, allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_det_seq")
	private int id;
	private int cantidad;
	private double total;
	@OneToOne
	@JoinColumn(name = "veh_id")
	private Vehiculo vehiculo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	

}
