package qtx.test;

import qtx.entidades.Persona;
import qtx.persistencia.GestorPersistencia;

public class TestConsultaXid {

	public static void main(String[] args) {
		GestorPersistencia gp = new GestorPersistencia();
		Persona personaI = gp.getPersonaXID(1);
		System.out.println(personaI);
		System.out.println("tiene asignado el lugar:"+ personaI.getEstacionamiento());
		gp.cerrar();
	}

}
