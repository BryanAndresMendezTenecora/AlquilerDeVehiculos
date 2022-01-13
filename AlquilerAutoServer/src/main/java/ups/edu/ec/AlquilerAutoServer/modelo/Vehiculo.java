package ups.edu.ec.AlquilerAutoServer.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo {

	@Id
	private int codigo;
	private String marca;
	private String color;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
