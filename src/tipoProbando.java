import master.PantallaGeneral;
import Elementos.*;
import anotaciones.*;

public class tipoProbando {
<<<<<<< HEAD
	public static void main (String[] arr) {
=======
	public static void main (String[] arr) throws ClassNotFoundException{
>>>>>>> 13988202c118099fbcc909e9aabe6f6513e6c841
		
	
	PantallaGeneral nuevaPantalla = new PantallaGeneral();
	try {
		PantallaGeneral.crearPantalla("TestGral");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	BotonSubmit nuevoBoton = new BotonSubmit();
	
	nuevaPantalla.agregarElemento(nuevoBoton);
	
	
/*
	@BotonAnnotation(nombre = "botonazo",posHorizontal=1, posVertical=2, ancho=2, largo=1)
	public void mostrarBoton(){
		System.out.println("boton click");
	}
*/

}
}
