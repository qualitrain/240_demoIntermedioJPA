package qtx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DIR_DIRECCION")
public class Direccion {
	@Id
	@Column(name="DIR_ID")
	private int idPersona;
	@Column(name="DIR_CALLE", length=50, nullable=false)
	private String calle;
	@Column(name="DIR_NUM_EXT", length=20, nullable=false)
	private String numExt;
	@Column(name="DIR_NUM_INT", length=20, nullable=false)
	private String numInt;
	@Column(name="DIR_COLONIA", length=50, nullable=false)
	private String colonia;
	
	public Direccion(int idPersona, String calle, String numExt, String numInt, String colonia) {
		this.idPersona = idPersona;
		this.calle = calle;
		this.numExt = numExt;
		this.numInt = numInt;
		this.colonia = colonia;
	}

	public Direccion() {
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumExt() {
		return numExt;
	}

	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}

	public String getNumInt() {
		return numInt;
	}

	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	@Override
	public String toString() {
		return "Direccion [idPersona=" + idPersona + ", calle=" + calle + ", numExt=" + numExt + ", numInt=" + numInt
				+ ", colonia=" + colonia + "]";
	}

}
