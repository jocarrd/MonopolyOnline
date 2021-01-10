package InterfazGrafica;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Monopoly.Casilla;
import Monopoly.TipoCasilla;

import java.awt.BorderLayout;
import java.util.List;

//Interfaz grafica para mostrar el mensaje que contiene el texto de una carta
public class MostrarCartaBaraja extends JFrame {
	public MostrarCartaBaraja(String s, int n) {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTextArea textArea = new JTextArea();
		setBounds(200, 200, 500, 200);
		textArea.setEditable(false);
		getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setText(s + " " + n + "$" + "\r\n");
		this.show();
	} 

}
