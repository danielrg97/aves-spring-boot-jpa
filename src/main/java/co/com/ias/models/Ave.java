package co.com.ias.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TONT_AVES")
public class Ave implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CDAVE", length=5)
	private String codigo;
	
	@Column(name="DSNOMBRE_COMUN", length=100)
	private String nombreComun;
	
	@Column(name="DSNOMBRE_CIENTIFICO", length=200)
	private String nombreCientifico;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TONT_AVES_PAIS", joinColumns = @JoinColumn(name = "CDAVE", referencedColumnName = "CDAVE"), 
    inverseJoinColumns = @JoinColumn(name = "CDPAIS", referencedColumnName = "CDPAIS"))
	@JsonIgnore	
	@JsonManagedReference
	private List<Pais> paises;
	
	@Column(name="IS_REMOVE")
	private Boolean isRemove;
	
	@Transient
	private String codigoPais;
	
	public Ave() {
		this.paises = new ArrayList<Pais>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreComun() {
		return nombreComun;
	}
	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	public List<Pais> getPaises() {
		return paises;
	}
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	public void addPais(Pais pais) {
		this.paises.add(pais);
	}
	public Boolean getIsRemove() {
		return isRemove;
	}
	public void setIsRemove(Boolean isRemove) {
		this.isRemove = isRemove;
	}
}
