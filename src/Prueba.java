
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import anotaciones.AnteriorAnnotation;
import anotaciones.BotonAnnotation;
import anotaciones.RadioButtonAnnotation;
import anotaciones.SiguienteAnnotation;
import anotaciones.TTextArea;

public class Prueba {
	
	public static void main (String[] arr){

		JFrame frame = new JFrame("Main");
		frame.setLayout(new GridLayout(5,1));
		frame.setVisible(true);
		frame.setSize(2200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Muestra en base a los atributos de la clase
		Field[] fields = ShowAnotacion.class.getDeclaredFields();
				
		for(Field f : fields){
		      if (f.isAnnotationPresent(TTextArea.class)){
		    	  TTextArea ta = f.getAnnotation(TTextArea.class);
		    	  JLabel lbl = new JLabel(ta.label());				  
				  frame.getContentPane().add(lbl);
				  JTextArea text = new JTextArea();
				  text.setVisible(true);
				  text.setLocation(0,20);
				  text.setSize(500,60);
				  frame.getContentPane().add(new JScrollPane(text));
		      }

		  	if (f.isAnnotationPresent(RadioButtonAnnotation.class)){
		    	  RadioButtonAnnotation radio = f.getAnnotation(RadioButtonAnnotation.class);
		  		  JRadioButton radioButton = new JRadioButton(radio.nombre());
				  f.setAccessible(true);
				  frame.getContentPane().add(radioButton);
		      }
		}
		//Muestra en base a los metodos de la clase
		  Field[] campos = ShowAnotacion.class.getDeclaredFields();
		  for (Field m : campos){
		          if (m.isAnnotationPresent(TTextArea.class)){}
				  	if (m.isAnnotationPresent(BotonAnnotation.class)){
						BotonAnnotation botonazo = m.getAnnotation(BotonAnnotation.class);
						JButton boton = new JButton(botonazo.nombre());
						boton.setVisible(true);
						float posicionX = botonazo.posHorizontal();
						float posicionY= botonazo.posVertical();
						int ancho = botonazo.ancho();
						int largo = botonazo.largo();
						Dimension tamaño= new Dimension(ancho,largo);
						boton.setAlignmentX(posicionX);
						boton.setAlignmentY(posicionY);
						boton.setSize(tamaño);
						boton.addActionListener(new ActionListener()
						{
							@Override
							public void actionPerformed(ActionEvent e)
							{
								System.out.println("show");
								
							}
						});
						frame.getContentPane().add(boton);
					}
		  }
	}
}

class ShowAnotacion{
	
	
	@TTextArea(label="Text Area")
	private String probando;
	
	//@TTextArea(label="input aca")
	public void showAnottation(){}
	
	@BotonAnnotation(nombre = "botonazo",posHorizontal=1, posVertical=2, ancho=2, largo=1)
	private String nombre;

	@SiguienteAnnotation(nombre= "sig")
	private String name;
	
	@AnteriorAnnotation(nombre="ant")
	private String nombr;
	
	@RadioButtonAnnotation(nombre = "es alumno")
	private boolean ban;
	
	public void mostrarRadio(){
		
	}
	
}
