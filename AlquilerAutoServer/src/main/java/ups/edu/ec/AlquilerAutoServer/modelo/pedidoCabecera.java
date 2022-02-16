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

@Entity
@Table(name = "TBL_PedidoCabecera")
public class pedidoCabecera implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ped_id")
	@SequenceGenerator(name = "id_ped_seq", sequenceName = "ID_PED_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_ped_seq")
	private int id;
	@OneToOne
	@JoinColumn(name = "per_cedula")
	private Persona persona;
	private Date fecha;
	private Date fechaentrega;
	private String estado;
	@OneToMany(cascade = CascadeType.PERSIST ,fetch = FetchType.EAGER)
	@JoinColumn(name = "ped_id")
	private List<Detalle> detalles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	
}
