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
		setBounds(100, 100, 450, 300);
		this.setTitle("Propiedades");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(42, 81, 315, 146);
		
		for(Calle  c: propiedades) {
			textPane.setText(textPane.getText()+"\r\n"+ c.getNombre()+" "+ Math.round(c.getAlquiler()));
		}
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(56, 41, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alquiler");
		lblNewLabel_1.setBounds(124, 41, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
