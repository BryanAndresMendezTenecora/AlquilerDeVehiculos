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
@Table(name = "TBL_devolucion")
public class Devolucion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "deb_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_dev_seq")
	@SequenceGenerator(name = "id_dev_seq", sequenceName = "ID_DEV_SEQ", initialValue = 1, allocationSize = 1)
	private int id;
	private String fecha;
	private String antecedente;
	@OneToOne
	@JoinColumn(name = "fac_id")
	private Factura factura;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getAntecedente() {
		return antecedente;
	}
	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
}
