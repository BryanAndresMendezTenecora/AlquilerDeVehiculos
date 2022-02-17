package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Modelo que servira como entidad para la Factura
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_Factura")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L; // Numero de versión
	@Id
	@Column(name = "fac_id")
	@SequenceGenerator(name = "id_fac_seq", sequenceName = "ID_FAC_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_fac_seq")
	private int id; // Llave primaria de la factura
	private double total; // Total de los detalles de la factura
	@OneToOne
	@JoinColumn(name = "ped_id")
	private pedidoCabecera pedido; // Pedido a facturar
	private String estado; // Estado de la Factura (Emisión, Finalizado)
	@OneToOne
	@JoinColumn(name = "tar_id")
	private MetodoDePago tarjetacredito; // Metodo de pago para la facturacion

	/**
	 * Devuelve el id de la factura
	 * 
	 * @return devuelve el id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna el id a la factura
	 * 
	 * @param id recibe el id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el total de la factura
	 * 
	 * @return devuelve el total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Asigna el total a la factura
	 * 
	 * @param total recibe el total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Devuelve el pedido a facturar
	 * 
	 * @return recibe el pedido
	 */
	public pedidoCabecera getPedido() {
		return pedido;
	}

	/**
	 * Asigna el pedido a facturar
	 * 
	 * @param pedido recibe el pedido
	 */
	public void setPedido(pedidoCabecera pedido) {
		this.pedido = pedido;
	}

	/**
	 * Devuelve el estado de la factura
	 * 
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Asigna el estado a la factura
	 * 
	 * @param estado recibe el estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve el metodo de pago para facturar
	 * 
	 * @return devuelve el metodo de pago
	 */
	public MetodoDePago getTarjetacredito() {
		return tarjetacredito;
	}

	/**
	 * Asigna el metodo de pago para facturar
	 * 
	 * @param tarjetacredito recibe el metodo de pago
	 */
	public void setTarjetacredito(MetodoDePago tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

}
