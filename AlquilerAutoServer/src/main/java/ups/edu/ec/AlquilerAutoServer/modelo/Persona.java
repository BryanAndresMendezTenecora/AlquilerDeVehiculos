package ups.edu.ec.AlquilerAutoServer.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo que sirve como entidad para cliente/Administrador
 * 
 * @author Bryan Mendez
 * @author Braulio Astudillo
 * @author Juan Boni
 *
 */
@Entity
@Table(name = "TBL_Persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "per_cedula")
	private String cedula; // Clave primaria de Persona
	private String nombre; // Nombre de la persona
	private String apellido; // Apellido de la persona
	private String direccion; // Direccion de la persona
	private String telefono; // Telefono de la persona
	private String estado; // Estado de la persona(Activo,Inactivo)
	private String email; // Correo electronico de la persona
	private String password; // contrasena unica d ela persona
	private String rol; // rol de la persona (administrador,cliente)

	/**
	 * Devuelve la cedula de esa persona
	 * 
	 * @return devuelve la cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Asigna la cedula de la persona
	 * 
	 * @param recibe la cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Devuelve Nombre de la persona
	 * 
	 * @return devuelve el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el nombre de la persona
	 * 
	 * @param recibe nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve apellido de la persona
	 * 
	 * @return devuelve apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Asigna apellido de la persona
	 * 
	 * @param recibe el apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve la direccion de la persona
	 * 
	 * @return devuelve direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Asigna direccion de la persona
	 * 
	 * @param recibe direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el telefono de la persona
	 * 
	 * @return devuelve telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Asigna el telefono de la persona
	 * 
	 * @param recibe telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve el estado de la persona
	 * 
	 * @return devuelve estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Asigna estado de la persona
	 * 
	 * @param recibe estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve email de la persona
	 * 
	 * @return devuelve email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Asigna el email de la persona
	 * 
	 * @param recibe email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve el password de la persona
	 * 
	 * @return devuelve password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Asigna el password de la persona
	 * 
	 * @param recibe password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Devuelve rol de la persona
	 * 
	 * @return devuelve rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Asigna rol de la persona
	 * 
	 * @param recibe rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

}
