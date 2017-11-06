package master;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Excepciones.FFormNotFoundException;
import algoii.tp.db.Alumno;
import anotaciones.CCheckBox;
import anotaciones.CCombo;
import anotaciones.FForm;
import anotaciones.HHashMap;
import anotaciones.IInput;
import anotaciones.LList;
import anotaciones.PPassword;
import anotaciones.RadioButton;
import anotaciones.Siguiente;
import anotaciones.TTextArea;
import anotaciones.TextBoxAnnotation;


// Constante comunicacion entre pantalla general y dibujar -> cuando esté creando una pantalla siguiente," dibujar " va a comunicarse con pantalla general para gestionar los atributos de esa nueva clase, que a su vez luego se volvera a comunicar con dibujar para que dibuje la pantalla

public class PantallaCreator extends Component{
	
	static JFrame frame = new JFrame();
	private HashMap<String,Field[]> mapaClases = new HashMap<>();

	public void crearPantalla(String nombreClase) throws Exception {
		Class<?> cls = Class.forName(nombreClase);
		if(!cls.isAnnotationPresent(FForm.class)){
			throw new FFormNotFoundException(nombreClase);
		}else{
			FForm form = cls.getAnnotation(FForm.class);
			frame.setTitle(form.title());
			//creamos los botones siguiente atras si es q hay
			mapaClases.put(nombreClase,cls.getDeclaredFields());
			JPanel mainPanel = new JPanel(new GridLayout(2,1));
			JPanel bottomPanel = new JPanel();
			if(cls.isAnnotationPresent(Siguiente.class)){
				Siguiente next = cls.getAnnotation(Siguiente.class);
				JButton nextButton = new JButton(next.next());
				nextButton.setText(next.label());
				nextButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						//Buscar validar mediante metodo
						try
						{
							frame.getContentPane().removeAll();
							crearPantalla(next.next());
						}
						catch(Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				bottomPanel.add(nextButton);
			}
			JPanel interPanel = new JPanel();
			for(Field campo : cls.getDeclaredFields()){
			      if (campo.isAnnotationPresent(IInput.class)){
			    	  IInput input = campo.getAnnotation(IInput.class);
			    	  JLabel lbl = new JLabel(input.label());		
			    	  JTextField text = new JTextField("");
			    	  text.setEditable(input.editable());
			    	  text.setVisible(true);
			    	  text.setPreferredSize(new Dimension(120,20));
					  interPanel.add(lbl);
					  interPanel.add(text);
			      }
			      if (campo.isAnnotationPresent(PPassword.class)){
			    	  PPassword password = campo.getAnnotation(PPassword.class);
			    	  JLabel lbl = new JLabel(password.label());		
			    	  JPasswordField pass = new JPasswordField(3);
					  pass.setVisible(true);
					  pass.setPreferredSize(new Dimension(120,20));
					  interPanel.add(lbl);
					  interPanel.add(pass);
			      }
			      if (campo.isAnnotationPresent(RadioButton.class)){
			    	  RadioButton radio = campo.getAnnotation(RadioButton.class);
			    	  JRadioButton radioButton = new JRadioButton(radio.nombre());
			    	  radioButton.setVisible(true);
					  interPanel.add(radioButton);
			      }
				if (campo.isAnnotationPresent(TTextArea.class)){
			    	  TTextArea ta = campo.getAnnotation(TTextArea.class);
			    	  JLabel lbl = new JLabel(ta.label());		
					  JTextArea text = new JTextArea();
					  text.setVisible(true);
					  interPanel.add(lbl);
					  JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					  scroll.setPreferredSize(new Dimension(240,60));
					  
					  interPanel.add(scroll);
			      }
				if(campo.isAnnotationPresent(HHashMap.class)){
					HHashMap ha = campo.getAnnotation(HHashMap.class);
					JLabel lbl = new JLabel(ha.label());
					campo.getType();
					campo.get(this);
					interPanel.add(lbl);
					JTable table=new JTable(4,2);
					table.setPreferredSize(new Dimension(240,320));
					interPanel.add(table);
				}
				if(campo.isAnnotationPresent(LList.class))
				{
					LList lista = campo.getAnnotation(LList.class);
					JLabel lbl= new JLabel(lista.label());
					String[] arrayDatos = casteoDatos(lista.datos());
					JList list = new JList(arrayDatos);
					list.setVisible(true);
					interPanel.add(lbl);
					interPanel.add(list);
					list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
					JScrollPane panelDesplazamiento = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					interPanel.add(panelDesplazamiento);
				}
				if(campo.isAnnotationPresent(TextBoxAnnotation.class)){
					TextBoxAnnotation text = campo.getAnnotation(TextBoxAnnotation.class);
					JLabel lbl = new JLabel(text.label());
					JTextField textBox = new JTextField();
					Dimension tamaño= new Dimension(text.ancho(),text.largo());
					textBox.setPreferredSize(tamaño);
					textBox.setVisible(true);
					JScrollPane panelDesplazamiento = new JScrollPane(textBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					interPanel.add(lbl);
					interPanel.add(textBox);
					interPanel.add(panelDesplazamiento);
					
				}if(campo.isAnnotationPresent(CCombo.class)){
					CCombo comboBox = campo.getAnnotation(CCombo.class);
					JComboBox comb = new JComboBox();
					JLabel lbl = new JLabel(comboBox.label());
					Class<?>[] elementos = comboBox.elementos();
					for (Class<?> elemento : elementos){
						comb.addItem(elemento);
					}
				    comb.setVisible(true);
					interPanel.add(lbl);
					interPanel.add(comb);
				}
				if(campo.isAnnotationPresent(CCheckBox.class)){
					CCheckBox check = campo.getAnnotation(CCheckBox.class);
					JCheckBox checkBox = new JCheckBox();
					JLabel lbl = new JLabel (check.label());
					interPanel.add(lbl);
					interPanel.add(checkBox);

			}
			mainPanel.add(interPanel);
			mainPanel.add(bottomPanel);
			frame.add(mainPanel);
			frame.setVisible(true);
			frame.setSize(580,150);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		}
	}
	
	public void agregarElemento(PantallaCreator nuevoElemento){
		Field[] campos = Formulario.class.getDeclaredFields();
		nuevoElemento.inicializar(campos);
		frame.getContentPane().add(nuevoElemento);
		
	}
	
	public void inicializar(Field[] campos){}
	
	
String[] casteoDatos(Class<?>[] datos){
	
	String[] arrayDatos = {};
	int i = 0;
	for(Class<?> dato : datos){
		arrayDatos[i] = dato.toString();
		i++;
		
	}
	return arrayDatos;
}
}
			
	
//	public void agregarElemento(PantallaGeneral nuevoElemento){
//		Field[] campos = ShowAnotacion.class.getDeclaredFields();
//		nuevoElemento.inicializar(campos);
//		frame.getContentPane().add(nuevoElemento);
//	}
//	
//	public static void inicializar(Field[] campos){
//		Field[] fields = TestGral.class.getDeclaredFields();
//		for(Field f : fields){
//			if (f.isAnnotationPresent(BotonAnnotation.class)){
//				JButton boton = BotonSubmit.inicializar();
//						
//			}
//		}
//	}
	

