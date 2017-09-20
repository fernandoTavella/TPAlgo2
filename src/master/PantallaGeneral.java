package master;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import anotaciones.BotonAnnotation;
import anotaciones.RadioButtonAnnotation;
import anotaciones.TTextArea;


public class PantallaGeneral {

	public static void crearPantalla() {
		
		JFrame frame = new JFrame("Test");
		frame.setLayout(new GridLayout(5,1));
		frame.setVisible(true);
		frame.setSize(2200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void agregarElemento(PantallaGeneral nuevoElemento){
		
		
		
		Field[] campos = ShowAnotacion.class.getDeclaredFields();
		nuevoElemento.inicializar(campos);
		frame.getContentPane().add(nuevoElemento);
		
		
	}
	
	public static void inicializar(Field[] campos){}
	
}