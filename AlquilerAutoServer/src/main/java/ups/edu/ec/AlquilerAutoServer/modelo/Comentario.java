package ups.edu.ec.AlquilerAutoServer.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_comentario")
public class Comentario {
	@Id
	@Column(name = "com_id")
	private int id;
	private String descripcion;
	private int calificacion;
	private Persona persona;
	private Vehiculo vehixulo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Vehiculo getVehixulo() {
		return vehixulo;
	}
	public void setVehixulo(Vehiculo vehixulo) {
		this.vehixulo = vehixulo;
	}
	

}
