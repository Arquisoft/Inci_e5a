package asw.dbManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
public class Agent {

	// Id generado automáticamente para diferenciar cada uno (para mapear)
	@Id
	@GeneratedValue
	private Long id;

	// Atributos del agent
	private String nombre;
	private String password;
	@Column(unique = true)
	private String email;
	private String ubicacion;
	private String identificador;
	private String kind;
	private int kindCode;
	
	@OneToMany(mappedBy="agent")
	private List<Incidence> listaIncidencias;
	


	/**
	 * Constructor vacío (ya que es para mapear)
	 */
	Agent() {
	}

	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param password
	 * @param email
	 * @param dNI
	 * @param kind
	 * @param kindCode
	 */
	public Agent(String nombre, String password, String email, String identificador, String ubicacion,
			String kind, int kindCode) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.identificador = identificador;
		this.ubicacion = ubicacion;
		this.kind = kind;
		this.kindCode = kindCode;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getKindCode() {
		return kindCode;
	}

	public void setKindCode(int kindCode) {
		this.kindCode = kindCode;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public List<Incidence> getListaIncidencias() {
		return listaIncidencias;
	}

	public void setListaIncidencias(List<Incidence> listaIncidencias) {
		this.listaIncidencias = listaIncidencias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email
				+ ", ubicacion=" + ubicacion + ", identificador=" + identificador + ", kind=" + kind + ", kindCode="
				+ kindCode + "]";
	}

	



}