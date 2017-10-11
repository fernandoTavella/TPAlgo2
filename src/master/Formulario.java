package master;

import anotaciones.AnteriorAnnotation;
import anotaciones.BotonAnnotation;
import anotaciones.FForm;
import anotaciones.IInput;
import anotaciones.PPassword;
import anotaciones.RadioButton;
import anotaciones.SiguienteAnnotation;
import anotaciones.TTextArea;
import master.PantallaGeneral;

@FForm(title="Demostracion")
public class Formulario 
{
		@TTextArea(label="Text Area")
		private String msjFinal;
		
		@IInput(label="Usuario")
		private String user;
		
		@PPassword(label="Contraseña")
		private String password;
		
		//@TTextArea(label="input aca")
		public void showAnottation(){}
		
		@BotonAnnotation(nombre = "botonazo",posHorizontal=1, posVertical=2, ancho=2, largo=1)
		private String nombre;

		@SiguienteAnnotation(nombre= "sig")
		private String name;
		
		@AnteriorAnnotation(nombre="ant")
		private String nombr;
		
		@RadioButton(nombre = "es alumno")
		private boolean ban;
		
		public void mostrarRadio(){
			
		}
}
