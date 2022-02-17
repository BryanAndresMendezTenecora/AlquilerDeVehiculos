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
 * Modelo que servira como entidad para vehiculo
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_vehiculo")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L; // Numero de versión
	@Id
	@Column(name = "veh_id")
	@SequenceGenerator(name = "id_veh_seq", sequenceName = "ID_VEH_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_veh_seq")
	private int id; // Llave primaria de vehiculo
	private String estado; // Estado del vehiculo (disponible, alquilado, mantenimiento, eliminado)
	private String modelo; // Modelo del vehiculo
	private String marca; // Marca del vehiculo
	private int stock; // Stock del vehiculo
	private double precio; // Precio del vehiculo

	@OneToOne
	@JoinColumn(name = "cat_id")
	private Categoria categoria; // Categoria del vehiculo

	/**
	 * Devuelve el id del vehiculo
	 * 
	 * @return devuelve la clave primaria
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna el id del vehículo
	 * 
	 * @param id recibe el codigo
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el estado del vehículo
	 * 
	 * @return devuelve el estado (disponible, alquilado, mantenimiento, eliminado)
	 */
	public String getEstado() {
		return estado; // estado de ese vehiculo
	}

	/**
	 * Asigna el estado del vehículo
	 * 
	 * @param estado recibe el estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve el modelo del vehículo
	 * 
	 * @return devuelve el modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Asigna el modelo del vehículo
	 * 
	 * @param modelo recibe el modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Devuelve la marca del vehículo
	 * 
	 * @return devuelve la marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Asigna la marca del vehículo
	 * 
	 * @param marca recibe la marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve el stock del vehículo
	 * 
	 * @return devuelve el stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Asigna el stock al vehículo
	 * 
	 * @param stock recibe el stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Devuelve la categoria del vehículo
	 * 
	 * @return devuelve la categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Asigna la categoria del vehiculo
	 * 
	 * @param categoria recibe la categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Devuelve el precio del vehículo
	 * 
	 * @return devuelve el precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Asigna el precio del vehículo
	 * 
	 * @param precio recibe el precio del vehiculo
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
