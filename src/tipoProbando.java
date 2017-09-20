import master.PantallaGeneral;
import Elementos.*;
import anotaciones.*;

public class tipoProbando {
	public static void main (String[] arr){
		
	
	PantallaGeneral nuevaPantalla = new PantallaGeneral();
	nuevaPantalla.crearPantalla();
	
	
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
