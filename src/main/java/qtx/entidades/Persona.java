package qtx.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="PER_PERSONA")
public class Persona {
	@Id
	@Column(name="PER_ID")
	private int idPersona;
	@Column(name="PER_NOMBRE", nullable=false, length=60)
	private String nombre;
	@Column(name="PER_PROFESION", length=80)
	private String profesion;
	
	@Column(name="PER_FEC_NAC")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Column(name="PER_ID_FISCAL", unique=true, length=25)
	private String rfc;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PER_ID", referencedColumnName="DIR_ID")
	private Direccion direccion;
	
	@Embedded
	private NombreCompleto nombreCompleto;
	
	@Transient
	private int edad;
	
	@OneToOne(mappedBy="asignadoA")
	private LugarEstacionamiento estacionamiento;
	
	//Se harán en cascada las operaciones de merge y persist
	@OneToMany(mappedBy="amo",cascade= {CascadeType.PERSIST,CascadeType.MERGE })
	private Set<Mascota> mascotas;
	
	public Persona(int idPersona, String nombre, String profesion, Date fechaNacimiento, String rfc,
			NombreCompleto nombreCompleto, int edad) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.profesion = profesion;
		this.fechaNacimiento = fechaNacimiento;
		this.rfc = rfc;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.mascotas = new HashSet<Mascota>();
	}
	public Persona() {
		this.mascotas = new HashSet<Mascota>();		
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String direccion) {
		this.profesion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public NombreCompleto getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(NombreCompleto nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", profesion=" + profesion
				+ ", fechaNacimiento=" + fechaNacimiento + ", rfc=" + rfc + "\nDireccion=" + direccion
				+ "\nNombreCompleto=" + nombreCompleto + ", edad=" + edad + 
				"\nMascotas"+ mascotas + "]";
	}
	public LugarEstacionamiento getEstacionamiento() {
		return estacionamiento;
	}
	public void setEstacionamiento(LugarEstacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
	public Set<Mascota> getMascotas() {
		return mascotas;
	}
	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}


}
