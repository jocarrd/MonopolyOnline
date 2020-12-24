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
import javax.swing.JTextField;
import javax.swing.JScrollPane;

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
		textPane.setBounds(10, 11, 650, 369);
		contentPane.add(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(595, 34, 23, 48);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(663, 55, 2, 2);
		contentPane.add(scrollPane_1);
		
		for(Calle  c: propiedades) {
			textPane.setText(textPane.getText()+"\r\n"+ c.getNombre()+" "+ Math.round(c.getAlquiler())+"$");
		}
		
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		this.setVisible(true);
	
	}
}
