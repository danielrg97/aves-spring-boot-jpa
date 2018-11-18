package co.com.ias.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TONT_ZONAS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Zona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CDZONA", length=3)
	private String codigo;
	
	@Column(name="DSNOMBRE", length=45)
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="zona")
	@JsonManagedReference(value="zona")
	private List<Pais> paises;
	
	public Zona() {
		paises = new ArrayList<Pais>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	
}
