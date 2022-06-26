package qtx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EST_ESTACIONAMIENTO")
public class LugarEstacionamiento {
	@Id
	@Column(name="EST_NUM_LUGAR")
	private int numLugar;
	@Column(name="EST_EDIFICIO", nullable=false, length=60)
	private String edificio;
	@Column(name="EST_PISO", nullable=false, length=30)
	private String piso;
	@Column(name="EST_COORDENADAS", nullable=false, length=50)
	private String coordenadas;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EST_ASIGNADO_A", referencedColumnName="PER_ID")
	private Persona asignadoA;
	
	public LugarEstacionamiento(int numLugar, String edificio, String piso, String coordenadas, Persona asignadoA) {
		this.numLugar = numLugar;
		this.edificio = edificio;
		this.piso = piso;
		this.coordenadas = coordenadas;
		this.asignadoA = asignadoA;
	}

	public LugarEstacionamiento() {
	}

	public int getNumLugar() {
		return numLugar;
	}

	public void setNumLugar(int numLugar) {
		this.numLugar = numLugar;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Persona getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(Persona asignadoA) {
		this.asignadoA = asignadoA;
	}

	@Override
	public String toString() {
		return "LugarEstacionamiento [numLugar=" + numLugar + ", edificio=" + edificio + ", piso=" + piso
				+ ", coordenadas=" + coordenadas + "]" + " Asignado a " + this.asignadoA.getNombre();
	}

}
