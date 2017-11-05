import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class TestCard{
	
    
	
    public static void main(String [] inforux){
    	JFrame frame = new JFrame("Main");
    	
        JPanel panelLogin = new JPanel(new GridLayout(2,1));
        JPanel panelData = new JPanel();
        //Panel de captura de datos
        panelData.add(new JLabel("Usuario"));
        JTextField textField = new JTextField("");
        textField.setPreferredSize(new Dimension(120,20));
        panelData.add(textField);
        panelData.add(new JLabel("Password"));
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(120,20));
        panelData.add(password);
        panelData.setBorder(new EmptyBorder(10,10,10,10));
        //Panel para los botones 
        JPanel panelBtns = new JPanel(); 
        panelBtns.add(new JButton("OK"));
        panelBtns.add(new JButton("OUCH"));
        

        //Panel de logeo 
        panelLogin.add(panelData);
        panelLogin.add(panelBtns);
        frame.setSize(250,360);
        frame.add(panelLogin);
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


}
