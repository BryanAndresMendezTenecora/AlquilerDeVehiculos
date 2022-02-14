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

@Entity
@Table(name = "TBL_Factura")
public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "fac_id")
	@SequenceGenerator(name = "id_fac_seq", sequenceName = "ID_FAC_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_fac_seq")
	private int id;
	private double total;
	@OneToOne
	@JoinColumn(name = "ped_id")
	private pedidoCabecera pedido;
	private String estado;
	@OneToOne
	@JoinColumn(name = "tar_id")
	private MetodoDePago tarjetacredito;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public pedidoCabecera getPedido() {
		return pedido;
	}
	public void setPedido(pedidoCabecera pedido) {
		this.pedido = pedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public MetodoDePago getTarjetacredito() {
		return tarjetacredito;
	}
	public void setTarjetacredito(MetodoDePago tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

}
