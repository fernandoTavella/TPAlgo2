package Elementos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JButton;
import anotaciones.BotonAnnotation;
import anotaciones.TTextArea;
import master.PantallaGeneral;


public class BotonSubmit extends PantallaGeneral{
	
	
	public static JButton inicializar(Field[] campos){
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
					boton.addActionListener(new ActionListener()		{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							System.out.println("show");
							
						}
					});
	}


