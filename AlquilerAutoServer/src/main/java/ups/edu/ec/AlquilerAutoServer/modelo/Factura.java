package ups.edu.ec.AlquilerAutoServer.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Factura")
public class Factura {
	@Id
	@Column(name = "fac_id")
	private int id;
	private double total;
	private pedidoCabecera pedido;
	private String estado;
	private TarjetaCredito tarjetacredito;
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
	public TarjetaCredito getTarjetacredito() {
		return tarjetacredito;
	}
	public void setTarjetacredito(TarjetaCredito tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

}
