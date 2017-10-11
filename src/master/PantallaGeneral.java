package master;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Elementos.BotonSubmit;
import anotaciones.BotonAnnotation;
import anotaciones.RadioButtonAnnotation;
import anotaciones.TTextArea;


public class PantallaGeneral extends Component{
	
	static JFrame frame = null;
	
	public static void crearPantalla(String nombreClase) throws ClassNotFoundException {
		
		Class<?> cls = Class.forName(nombreClase);
		
		
		JFrame frame = new JFrame("Test");
		frame.setLayout(new GridLayout(5,1));
		frame.setVisible(true);
		frame.setSize(2200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void agregarElemento(PantallaGeneral nuevoElemento){
		Field[] campos = TestGral.class.getDeclaredFields();
		nuevoElemento.inicializar(campos);
		frame.getContentPane().add(nuevoElemento);
		
	}
	
	public void inicializar(Field[] campos){}
	
						
	}
	