
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

public class Prueba {
	
	public static void main (String[] arr){

		//Muestra en base a los metodos de la clase
//	  Method[] methods = ShowAnotacion.class.getMethods();
//	  for (Method m : methods){
//	          if (m.isAnnotationPresent(TTextArea.class))
//	      {
//	        	  TTextArea ta = m.getAnnotation(TTextArea.class);
//	          System.out.println(ta.label());
//	      }
//	  }
		
		//Muestra en base a los atributos de la clase
		Field[] fields = ShowAnotacion.class.getDeclaredFields();
		
		JFrame frame = new JFrame("Test");
		frame.setLayout(new GridLayout(5,1));
		
		JButton boton = new JButton("boton");
		Field[] b1 = MostrarBoton.class.getDeclaredFields();
			
		for(Field b : b1){
			if (b.isAnnotationPresent(BotonAnnotation.class)){
				BotonAnnotation botonazo = b.getAnnotation(BotonAnnotation.class);
				boton.setVisible(true);
				float posicionX = botonazo.posHorizontal();
				float posicionY= botonazo.posVertical();
				int ancho = botonazo.ancho();
				int largo = botonazo.largo();
				String nombre = botonazo.nombre();
				Dimension tamaño= new Dimension(ancho,largo);
				boton.setAlignmentX(posicionX);
				boton.setAlignmentY(posicionY);
				boton.setSize(tamaño);
				boton.setLabel(nombre);
				frame.getContentPane().add(boton);
				
				
				
			}
		}
				
		for(Field f : fields){
		      if (f.isAnnotationPresent(TTextArea.class)){
		    	  TTextArea ta = f.getAnnotation(TTextArea.class);
				  frame.setVisible(true);
				  frame.setSize(2200,200);
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  
				  
				  JLabel lbl = new JLabel(ta.label());
				  frame.getContentPane().add(lbl);
				  
				  
				  JTextArea text = new JTextArea();
				  text.setVisible(true);
//				  text.setEditable(false);
				  text.setLocation(0,20);
//				  text.setText(ta.label());
				  
				  frame.getContentPane().add(new JScrollPane(text));
				  
				  System.out.println(ta.label());
		      }
		}
		
		
		JRadioButton radioButton = new JRadioButton("radio");
		Field[] bandera = MostrarRadio.class.getDeclaredFields();
		
		for(Field ban : bandera){
		      if (ban.isAnnotationPresent(RadioButtonAnnotation.class)){
		    	  RadioButtonAnnotation radio = ban.getAnnotation(RadioButtonAnnotation.class);
				  ban.setAccessible(true);
				  String nombre = radio.nombre();
				  radioButton.setLabel(nombre);
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  frame.getContentPane().add(radioButton);
		      }
		}  
	}
}

class ShowAnotacion{
	
	@TTextArea(label="ahora se ve en base al field")
	private String probando;
	
	//@TTextArea(label="input aca")
	public void showAnottation(){}
	

}

class MostrarBoton {
	@BotonAnnotation(nombre = "botonazo",posHorizontal=1, posVertical=2, ancho=2, largo=1)
	private int a;
	
	public void mostrarBoton(){}
	
}

class MostrarRadio {
	@RadioButtonAnnotation(nombre = "radio button")
	private boolean ban;
	
	public void mostrarRadio(){}
	
}
