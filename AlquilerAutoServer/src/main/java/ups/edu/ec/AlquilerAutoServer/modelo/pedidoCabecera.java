package ups.edu.ec.AlquilerAutoServer.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pedidoCabecera {

	@Id
	private int codigo;
	private String fecha;
	private String estado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
