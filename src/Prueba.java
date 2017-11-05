
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import anotaciones.AnteriorAnnotation;
import anotaciones.BotonAnnotation;
import anotaciones.RadioButton;
import anotaciones.TTextArea;

public class Prueba {
	
	public static void main (String[] arr){

		JFrame frame = new JFrame("Main");
		//Muestra en base a los atributos de la clase
		Field[] fields = ShowAnotacion.class.getDeclaredFields();
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(5,1));
		for(Field f : fields){
		      if (f.isAnnotationPresent(TTextArea.class)){
		    	  TTextArea ta = f.getAnnotation(TTextArea.class);
		    	  GridBagConstraints labelPosition = new GridBagConstraints();
		    	  GridBagConstraints textPosition = new GridBagConstraints();
		    	  JLabel lbl = new JLabel(ta.label());		
		    	  labelPosition.gridx = 0;
		    	  labelPosition.gridy = 0;
		    	  labelPosition.gridheight = 0;
		    	  labelPosition.gridwidth = 0;
				  panelInfo.add(lbl,labelPosition);
				  JTextArea text = new JTextArea();
				  text.setVisible(true);
				  textPosition.gridx = 0;
				  textPosition.gridy = 2;
				  textPosition.gridheight = 1;
				  textPosition.gridwidth = 2;
				  panelInfo.add(new JScrollPane(text),textPosition);
		      }
		      frame.setLayout(new GridLayout());
		      frame.setSize(1000,500);
		      frame.add(panelInfo);
              frame.setVisible(true);
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		  	if (f.isAnnotationPresent(RadioButtonAnnotation.class)){
//		    	  RadioButtonAnnotation radio = f.getAnnotation(RadioButtonAnnotation.class);
//		  		  JRadioButton radioButton = new JRadioButton(radio.nombre());
//				  f.setAccessible(true);
//				  frame.getContentPane().add(radioButton);
//		      }
//		  	if (f.isAnnotationPresent(BotonAnnotation.class)){
//				BotonAnnotation botonazo = f.getAnnotation(BotonAnnotation.class);
//				JButton boton = new JButton(botonazo.nombre());
//				boton.setVisible(true);
//				float posicionX = botonazo.posHorizontal();
//				float posicionY= botonazo.posVertical();
//				int ancho = botonazo.ancho();
//				int largo = botonazo.largo();
//				Dimension tamaño= new Dimension(ancho,largo);
//				boton.setAlignmentX(posicionX);
//				boton.setAlignmentY(posicionY);
//				boton.setSize(tamaño);
//				boton.addActionListener(new ActionListener()
//				{
//					@Override
//					public void actionPerformed(ActionEvent e)
//					{
//						System.out.println("show");
//						
//					}
//				});
//				frame.getContentPane().add(boton);
//			}
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

	
	@AnteriorAnnotation(nombre="ant")
	private String nombr;
	
	@RadioButton(nombre = "es alumno")
	private boolean ban;
	
	public void mostrarRadio(){
		
	}
	
}
