package qtx.test;

import java.util.Date;
import java.util.GregorianCalendar;

import qtx.entidades.Direccion;
import qtx.entidades.Mascota;
import qtx.entidades.NombreCompleto;
import qtx.entidades.Persona;
import qtx.entidades.TipoMascota;
import qtx.persistencia.GestorPersistencia;

public class TestInsercion {

	public static void main(String[] args) {
		GestorPersistencia gp = new GestorPersistencia();
		Persona nuevaPersona = getPersona();
		Direccion nuevaDireccion = getDireccion();
		agregarMascotas(nuevaPersona);
		nuevaPersona.setDireccion(nuevaDireccion);
		if(gp.insertarPersona(nuevaPersona) == true)
			System.out.println("Persona insertada");
		else
			System.out.println("Ha fallado la insercion");

	}

	private static Direccion getDireccion() {
		Direccion dir = new Direccion(2,"Av de los Insurgentes","2005","902A","San Angel Inn");
		return dir;
	}

	private static Persona getPersona() {
		Date fecNac = new GregorianCalendar(1991,1,25).getTime();
		NombreCompleto nombreCompleto = new NombreCompleto("Jorge", "Arturo", "Madrigal", "Chavez");
		Persona persona = new Persona(102,"Jorge Arturo Madrigal Chavez", "Ing en Sistemas",
				  fecNac, "MACJ920225RT7", nombreCompleto, 0);
		return persona;
	}
	
	private static void agregarMascotas(Persona p){
		p.getMascotas().add(new Mascota(100,"Firulais",TipoMascota.PERRO,p));
		p.getMascotas().add(new Mascota(101,"Felix",TipoMascota.GATO,p));
		p.getMascotas().add(new Mascota(102,"Stuart",TipoMascota.HAMSTER,p));
	}

}
