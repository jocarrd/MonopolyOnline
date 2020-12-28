package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Monopoly.*;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class MostrarPropiedades extends JFrame {
	
	Partida p;
	Jugador j;
	String s = "";

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MostrarPropiedades(List<Calle> propiedades, Jugador j, Partida p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 420);
		this.setTitle("Propiedades");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 644, 369);
		textPane.setText(s);
		contentPane.add(textPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(652, 11, 23, 369);
		contentPane.add(scrollPane);
		
//		for(Calle  c: propiedades) {
//			textPane.setText(textPane.getText()+"\r\n"+ c.getNombre()+" "+ Math.round(c.getAlquiler())+"$");
//		}
		
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 this.setResizable(false);
		this.setVisible(true);
	
	}
	
	
	public void anyadirPropiedades(Partida p, Jugador j, String nombrePropiedad, double d) {
		this.j = j;
		this.p = p;
		this.s = s + nombrePropiedad + d + "\r\n";
	}
	
	
	
}
