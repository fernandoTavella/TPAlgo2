
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		for(Field f : fields){
		      if (f.isAnnotationPresent(TTextArea.class)){
		    	  TTextArea ta = f.getAnnotation(TTextArea.class);
		    	  JFrame frame = new JFrame("Test");
				  frame.setVisible(true);
				  frame.setSize(500,200);
				  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  
				  JPanel panel = new JPanel();
				  JTextArea text = new JTextArea();
				  text.setVisible(true);
				  text.setEditable(false);
				  text.setLocation(0,20);
				  text.setText(ta.label());
				  panel.add(text);
				  
				  frame.add(panel);
				  
				  System.out.println(ta.label());
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
