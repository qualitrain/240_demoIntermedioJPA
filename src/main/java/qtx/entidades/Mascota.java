package qtx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MAS_MASCOTA")
public class Mascota {
	@Id
	@Column(name="MAS_ID")
	private int numMascota;
	@Column(name="MAS_NOMBRE", length=20, nullable=false)
	private String nombre;
	@Column(name="MAS_TIPO", length=15, nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoMascota tipo;
	
	@ManyToOne
	@JoinColumn(name="MAS_ID_PER",referencedColumnName="PER_ID")
	private Persona amo;
	
	public Mascota(int numMascota, String nombre, TipoMascota tipo, Persona amo) {
		this.numMascota = numMascota;
		this.nombre = nombre;
		this.tipo = tipo;
		this.amo = amo;
	}

	public Mascota() {
	}

	public int getNumMascota() {
		return numMascota;
	}

	public void setNumMascota(int numMascota) {
		this.numMascota = numMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMascota getTipo() {
		return tipo;
	}

	public void setTipo(TipoMascota tipo) {
		this.tipo = tipo;
	}

	public Persona getAmo() {
		return amo;
	}

	public void setAmo(Persona amo) {
		this.amo = amo;
	}

	@Override
	public String toString() {
		return "\nMascota [numMascota=" + numMascota + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
	
}
