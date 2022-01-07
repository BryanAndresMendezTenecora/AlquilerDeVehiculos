package ups.edu.ec.AlquilerAutoServer.modeo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo {
	@Id
	private int placa;
	private String marca;
	private String color;
	private int numPuertas;

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
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

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

}
