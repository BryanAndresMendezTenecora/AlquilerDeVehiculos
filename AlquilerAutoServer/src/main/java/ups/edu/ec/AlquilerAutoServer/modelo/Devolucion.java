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
 * Modelo que sirve como entidad para Devolucion
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_devolucion")
public class Devolucion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "deb_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_dev_seq")
	@SequenceGenerator(name = "id_dev_seq", sequenceName = "ID_DEV_SEQ", initialValue = 1, allocationSize = 1)
	private int id;// Clave primaria de la devolucion
	private String fecha;// Fecha de la factura
	private String antecedente; // Antecedente del vehiculo al devolver
	@OneToOne
	@JoinColumn(name = "fac_id")
	private Factura factura;// Factura de la devolucion

	/**
	 * Devuelve id de la devolucion
	 * 
	 * @return devuelve id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna id de la devolucion
	 * 
	 * @param recibe id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve fecha de la devolucion
	 * 
	 * @return devuelve fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Asigna Fecha de la devolucion
	 * 
	 * @param recibe fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Devuelve antecedente de la devolucion
	 * 
	 * @return devuelve antecedente
	 */
	public String getAntecedente() {
		return antecedente;
	}

	/**
	 * Asigna antecedente de la devolucion
	 * 
	 * @param recibe antecedente
	 */
	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}

	/**
	 * Devuelve Factura de la devolucion
	 * 
	 * @return devuelve factura
	 */
	public Factura getFactura() {
		return factura;
	}

	/**
	 * Asigna Factura de la devolucion
	 * 
	 * @param recibe factura
	 */
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
