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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPartida extends JFrame {

	private JPanel contentPane;
	private Partida partida;
	private Image v;
	private List<Canvas> p;
	private JTextField dinero;
	private Jugador jugador;
	
	
	public PanelPartida(Partida c,Jugador j) {
		setTitle("Partida");
		this.p= new ArrayList<>();
		this.partida =c ;
		this.jugador=j;
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1347, 959);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (int i =0;i<this.partida.numero_jugadores();i++) {
			//Posicion inicial de los jugadores
			
			int suma=0;
			Canvas canvas = new Canvas();
			
			canvas.setName(this.partida.getJugadores().get(i).getNombre());
			this.p.add(canvas);
			canvas.setBounds(817+suma, 785, 30, 28);
			
			contentPane.add(canvas);
			canvas.setBackground(this.partida.getJugadores().get(i).getColor());
			suma=suma+4;
			
		
			
	}
		System.out.println(partida.getTablero().getCasilla(0).getJugadores());
		
		
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
		
		JButton Comprar = new JButton("Comprar");
		Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Jugador> c = partida.getJugadores();
				
				if(partida.getTurno()==c.indexOf(jugador)) {
					
					System.out.println("Puedo comprar");
					
				}
			}
		});
		Comprar.setBounds(1080, 83, 89, 23);
		contentPane.add(Comprar);
		
		JButton pasarTurno = new JButton("Pasar turno");
		pasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Jugador> c = partida.getJugadores();
				
				if(partida.getTurno()==c.indexOf(jugador)) {
					partida.pasarTurno();
					System.out.println(partida.getTurno());
					System.out.println("He passado de turno");
					
					
				}
				
			}
		});
		pasarTurno.setBounds(1191, 83, 119, 23);
		contentPane.add(pasarTurno);
		
		
		
		
		
		
		
		this.setVisible(true);
		
		
		
	}
	
	
	public void DibujarFichaAvanza(int posicion) {
		
		
	
	}
}
