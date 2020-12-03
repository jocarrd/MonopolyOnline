package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Monopoly.Jugador;
import Monopoly.Partida;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JTextField;

public class PanelPartida extends JFrame {

	private JPanel contentPane;
	private Partida c;
	private Image v;
	private List<Canvas> p;
	private JTextField dinero;
	private Jugador j;
	
	
	public PanelPartida(Partida c,Jugador j) {
		setTitle("Partida");
		this.p= new ArrayList<>();
		this.c =c ;
		this.j=j;
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1347, 959);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (int i =0;i<this.c.numero_jugadores();i++) {
			//Posicion inicial de los jugadores
			
			Canvas canvas = new Canvas();
			canvas.setName(this.c.getJugadores().get(i).getNombre());
			this.p.add(canvas);
			canvas.setBounds(817, 785, 30, 28);
			contentPane.add(canvas);
			canvas.setBackground(this.c.getJugadores().get(i).getColor());

	}
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelPartida.class.getResource("/InterfazGrafica/monopoly.jpg")));
		lblNewLabel.setBounds(10, 0, 991, 916);
		contentPane.add(lblNewLabel);
		
		Label label = new Label("Dinero ");
		label.setBounds(1136, 42, 39, 35);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(309, 823, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		dinero = new JTextField();
		dinero.setBackground(new Color(0, 255, 51));
		dinero.setEditable(false);
		dinero.setBounds(1181, 47, 86, 20);
		contentPane.add(dinero);
		dinero.setColumns(10);
		this.dinero.setText(0+"");
		
		
		
		
		
		this.setVisible(true);
		
		
		
	}
	
	
	public void DibujarFichaAvanza(int posicion) {
		
		
	
	}
}
