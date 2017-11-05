package master;
import javax.swing.JFrame;

import master.PantallaCreator;

public class Ejemplo
{
	public static void main (String[] agrs) throws Exception{
		PantallaCreator builder = new PantallaCreator();
		builder.crearPantalla("algoii.tp.db.AlumnosDB");
		//builder.crearPantalla("algoii.tp.db.Alumno");
		//builder.crearPantalla("master.Formulario");
	}
}
