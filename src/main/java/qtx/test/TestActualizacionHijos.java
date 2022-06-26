package qtx.test;

import qtx.entidades.Mascota;
import qtx.entidades.Persona;
import qtx.entidades.TipoMascota;
import qtx.persistencia.GestorPersistencia;

public class TestActualizacionHijos {

	public static void main(String[] args) {
		GestorPersistencia gp = new GestorPersistencia();
		Persona persona = gp.getPersonaXID(2);
		System.out.println(persona);
		persona.setProfesion("Abogado");
		persona.getMascotas()
		       .add( new Mascota(99,"Macarrón", TipoMascota.HAMSTER, persona) );
		if(gp.actualizarPersona(persona) == true)
			System.out.println("Actualización exitosa");
		else
			System.out.println("Ha fallado la actualización");
	}

}
