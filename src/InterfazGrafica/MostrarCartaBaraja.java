package InterfazGrafica;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Monopoly.Casilla;
import Monopoly.TipoCasilla;

import java.awt.BorderLayout;
import java.util.List;

public class MostrarCartaBaraja extends JFrame {
	public MostrarCartaBaraja(String s, int n) {

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setText(s + " " + n + "$" + "\r\n");
	}

}