package qtx.test;

import qtx.entidades.LugarEstacionamiento;
import qtx.entidades.Persona;
import qtx.persistencia.GestorPersistencia;

public class TestConsultaEstacionamientoXid {

	public static void main(String[] args) {
		GestorPersistencia gp = new GestorPersistencia();
		LugarEstacionamiento estacionamientoI = gp.getEstacionamientoXID(302);
		System.out.println(estacionamientoI);
		gp.cerrar();
	}

}
