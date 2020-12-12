package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Monopoly.Calle;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class MostrarPropiedades extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MostrarPropiedades(List<Calle> propiedades) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 420);
		this.setTitle("Propiedades");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.control);
		textPane.setEditable(false);
		textPane.setBounds(66, 87, 498, 248);
		
		for(Calle  c: propiedades) {
			textPane.setText(textPane.getText()+"\r\n"+ c.getNombre()+" "+ Math.round(c.getAlquiler())+"$");
		}
		contentPane.add(textPane);
		
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		this.setVisible(true);
	
	}
}
