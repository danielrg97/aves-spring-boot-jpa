package co.com.ias.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TONT_PAISES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pais implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CDPAIS", length=3)
	private String codigo;
	
	@Column(name="DSNOMBRE", length=100)
	private String nombre;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference(value="zona")
	private Zona zona; 
		
	@ManyToMany(mappedBy = "paises", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonBackReference
	private List<Ave> aves;

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

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public List<Ave> getAves() {
		return aves;
	}

	public void setAves(List<Ave> aves) {
		this.aves = aves;
	}

}
