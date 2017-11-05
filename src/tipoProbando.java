import master.PantallaCreator;
import Elementos.*;
import anotaciones.*;

public class tipoProbando {

	
	public static void main (String[] arr) throws Exception{
	
	
	PantallaCreator nuevaPantalla = new PantallaCreator();
	try {
		PantallaCreator.crearPantalla("TestGral");
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
