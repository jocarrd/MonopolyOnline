package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Monopoly.Jugador;
import Monopoly.Partida;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

//Interfaz grafica para mostrar una ventana de registro de un jugador para la partida
public class RegistrarJugador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Jugador jugadorCreado;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RegistrarJugador() { 
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField(); 
		textField.setBounds(68, 82, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduzca su nombre");
		lblNewLabel.setBounds(31, 57, 149, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"RED", "BLACK", "ORANGE", "PINK", "MAGENTA", "YELLOW", "WHITE", "BLUE", "CYAN"}));
		comboBox.setBounds(251, 81, 86, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selecionado = (String)comboBox.getSelectedItem();
				
				Color c=null;
				
				if(selecionado.equals("RED")) {
					c = Color.RED;
				}
				else if(selecionado.equals("BLACK")) {
					c= Color.BLACK;
				}
				
				else if (selecionado.equals("ORANGE")) {
					c= Color.ORANGE;
				}
				
				else if (selecionado.equals("PINK")) {
					c = Color.PINK;
				}
				
				else if (selecionado.equals("MAGENTA")) {
					c = Color.MAGENTA;
				}
				else if (selecionado.equals("YELLOW")) {
					c = Color.YELLOW;
				}
				else if (selecionado.equals("WHITE")) {
					c = Color.WHITE;
				}
				else if (selecionado.equals("BLUE")) {
					c = Color.BLUE;
				}
				else if (selecionado.equals("BROWN")) {
					c = Color.CYAN;
				}
				

				
				Jugador nuevo = new Jugador(textField.getText(),c);
				jugadorCreado=nuevo;
				RegistrarJugador.this.dispose();
				
			}
		});
		btnNewButton.setBounds(251, 161, 89, 23);
		contentPane.add(btnNewButton);
		this.setVisible(true);
	}
	
	public Jugador getJugador() {
		return this.jugadorCreado;
	}
}
