package master;

import java.util.Hashtable;

import algoii.tp.db.Alumno;
import anotaciones.AnteriorAnnotation;


import anotaciones.BotonAnnotation;
import anotaciones.FForm;
import anotaciones.HHashMap;
import anotaciones.IInput;
import anotaciones.PPassword;
import anotaciones.RadioButton;
import anotaciones.Siguiente;
import anotaciones.TTextArea;
import master.PantallaCreator;


// boton siguiente va a mandar los campos de la clase CONTINUACION, que sera otra pantalla del usuario
@Siguiente(next="continuacion")
@FForm(title="Inicio de sesión")
public class Formulario 
{
		@TTextArea(label="Text Area")
		private String msjFinal;
		
		@IInput(label="Usuario",editable=false)
		private String user;
		
		@HHashMap(label="Alumnos")
		private static Hashtable<Integer,Alumno> alumnos;
		
		@PPassword(label="Contraseña")
		private String password;
		
		//@TTextArea(label="input aca")
		public void showAnottation(){}
		
		@BotonAnnotation(nombre = "botonazo",posHorizontal=1, posVertical=2, ancho=2, largo=1)
		private String nombre;

		@AnteriorAnnotation(nombre="ant")
		private String nombr;
		
		@RadioButton(nombre = "es alumno")
		private boolean ban;
		
		public void mostrarRadio(){
			
		}

}
