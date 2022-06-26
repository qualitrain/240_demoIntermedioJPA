package qtx.test;

import qtx.entidades.Persona;
import qtx.persistencia.GestorPersistencia;

public class TestBorrado {

	public static void main(String[] args) {
		GestorPersistencia gp = new GestorPersistencia();
		Persona persona = gp.getPersonaXID(1);
		System.out.println(persona);
		if(gp.eliminarPersona(persona)==true)
			System.out.println("Eliminación exitosa");
		else
			System.out.println("Ha fallado la eliminación");

	}

}
