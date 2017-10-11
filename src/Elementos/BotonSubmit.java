package Elementos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.lang.reflect.Field;

import javax.swing.*;

import master.PantallaGeneral;
import anotaciones.BotonAnnotation;


@SuppressWarnings("serial")
public class BotonSubmit extends PantallaGeneral{
	@Override
	public void inicializar(Field[] campos){

			for(Field f : campos){
				if (f.isAnnotationPresent(BotonAnnotation.class)){
				
					BotonAnnotation botonazo = f.getAnnotation(BotonAnnotation.class);
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
					boton.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e){
							System.out.println("show");
						}
					});
	}
}
	}
}


