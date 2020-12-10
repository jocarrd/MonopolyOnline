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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class TableroCliente extends JFrame {

	private JPanel contentPane;
	private Partida partida;
	private Image v;
	private List<Canvas> p;
	private JTextField dinero;
	private Jugador jugador;
	private Socket servidor;

	public void escuchandoServidor() {

		Thread nuevosJugadores = new Thread(new Runnable() {

			@Override
			public void run() {
				try (Socket servidor = new Socket("localhost", 5555);) {
					while (true) {
						DataOutputStream sal = new DataOutputStream(servidor.getOutputStream());
						ObjectInputStream ent = new ObjectInputStream(servidor.getInputStream());

						sal.writeBytes("inicio" + "\r\n");
						try {
							List<Partida> partidas = (List<Partida>) ent.readObject();
							int i = 0;
							int indice = 0;
							for (Partida p : partidas) {
								if (p.getId().equals(partida.getId())) {
									indice = i;
								}
								i++;
							}

							if (partidas.get(indice).numero_jugadores() > partida.numero_jugadores()) {

								partida.resetJugadores(partidas.get(indice).getJugadores());
								//Resetea los jugadores para añadir el nuevo 

							}

						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

					}

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		nuevosJugadores.start();
		

	}

	public TableroCliente(Partida c, Jugador j) {
		setTitle("Partida");
		this.p = new ArrayList<>();
		this.partida = c;
		this.jugador = j;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1347, 959);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 180, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int suma = 0;
		for (int i = 0; i < this.partida.numero_jugadores(); i++) {
			// Posicion inicial de los jugadores

			
			Canvas canvas = new Canvas();
				System.out.println(i);
			canvas.setName(this.partida.getJugadores().get(i).getNombre());
			this.p.add(canvas);
			canvas.setBounds(640 + suma, 567, 30, 28);

			contentPane.add(canvas);
			canvas.setBackground(this.partida.getJugadores().get(i).getColor());
			suma = suma + 40;

		}

		System.out.println(partida.getTablero().getCasilla(0).getJugadores());

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TableroCliente.class.getResource("/InterfazGrafica/monopoly.jpg")));
		lblNewLabel.setBounds(77, -107, 969, 887);
		contentPane.add(lblNewLabel);

		Label label = new Label("Dinero ");
		label.setBounds(1136, 42, 39, 35);
		contentPane.add(label);

		dinero = new JTextField();
		dinero.setBackground(new Color(0, 255, 51));
		dinero.setEditable(false);
		dinero.setBounds(1181, 47, 86, 20);
		contentPane.add(dinero);
		dinero.setColumns(10);
		this.dinero.setText(0 + "");

		JTextPane informacion = new JTextPane();
		informacion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		informacion.setBounds(1123, 127, 187, 20);
		contentPane.add(informacion);

		JButton Comprar = new JButton("Comprar");
		Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Jugador> c = partida.getJugadores();

				if (partida.getTurno() == c.indexOf(jugador)) {

					System.out.println("Puedo comprar");
					informacion.setText("Compra realizada");

				}
			}
		});
		Comprar.setBounds(1080, 83, 89, 23);
		contentPane.add(Comprar);

		JButton pasarTurno = new JButton("Pasar turno");
		pasarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Jugador> c = partida.getJugadores();

				if (partida.getTurno() == c.indexOf(jugador)) {
					partida.pasarTurno();
					System.out.println(partida.getTurno());
					informacion.setText(jugador.getNombre() + " ,has pasado de turno");
					System.out.println("He passado de turno");

				}

			}
		});
		pasarTurno.setBounds(1191, 83, 119, 23);
		contentPane.add(pasarTurno);

		JButton btnNewButton = new JButton("Ver propiedades");
		btnNewButton.setBounds(1181, 158, 129, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(647, 578, 10, 10);
		contentPane.add(panel);
		this.escuchandoServidor();
		this.setResizable(false);

		this.setVisible(true);

	}

	public void DibujarFichaAvanza(int posicion) {

	}
}
