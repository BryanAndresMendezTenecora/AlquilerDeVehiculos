package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Modelo que sirve como entidad para categoria
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "id_cat_seq", sequenceName = "ID_CAT_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_cat_seq")
	@Column(name = "cat_id")
	private int id; // Clave primaria de categoria
	private String nombre;// Nombre de la categoria
	private String estado;// Estado de la categoria

	/**
	 * Devuelve id de la categoria
	 * 
	 * @return devuelve id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna id de la categoria
	 * 
	 * @param recibe id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve nombre de la categoria
	 * 
	 * @return devuelve nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna nombre de la categoria
	 * 
	 * @param recibe nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve Estado de la categoria
	 * 
	 * @return devuelve categoria
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Asigna estado de la categoria
	 * 
	 * @param recibe estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
