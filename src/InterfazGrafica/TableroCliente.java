package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Monopoly.Calle;
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
import java.awt.Font;

public class TableroCliente extends JFrame {

	private JPanel contentPane;
	private Partida partida;
	private Image v;
	private List<Canvas> p;
	private JTextField dinero;
	private Jugador jugador;
	private Socket servidor;
	private List<Canvas> jugadores_ficha = new ArrayList<>();
	private int click_dados;
	private int click_comprar;

	public void escuchandoServidor() {
		System.out.println("estamos aqui");
		
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
							int indice = 0;  //Obtenemos el indice de nuestra partida
							for (Partida p : partidas) {
								if (p.getId().equals(partida.getId())) {
									indice = i;
								}
								i++;
							}
								System.out.println("hola");
							if (partidas.get(indice).numero_jugadores() > partida.numero_jugadores()) {

								partida.resetJugadores(partidas.get(indice).getJugadores());
								// Resetea los jugadores para añadir el nuevo
								System.out.println("Alguien se unio");

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
		this.click_dados = 0;
		this.click_comprar=0;
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
			System.out.println(canvas.getName());
			this.p.add(canvas);
			canvas.setBounds(640 + suma, 567, 30, 28);

			contentPane.add(canvas);
			canvas.setBackground(this.partida.getJugadores().get(i).getColor());
			suma = suma + 40;
			this.jugadores_ficha.add(canvas);

		}

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TableroCliente.class.getResource("/InterfazGrafica/monopoly.jpg")));
		lblNewLabel.setBounds(77, -107, 774, 887);
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
		this.dinero.setText(String.valueOf(jugador.getDinero()));

		JTextPane informacion = new JTextPane();
		informacion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		informacion.setBounds(1123, 127, 187, 20);
		contentPane.add(informacion);

		JButton Comprar = new JButton("Comprar");
		Comprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Jugador> c = partida.getJugadores();

				if (partida.getTurno() == c.indexOf(jugador) && click_dados != 0 && click_comprar==0) {
					
				 	if (partida.getTablero().getCasilla(jugador.getPosicion_tablero()).esunaCalle() ) {
				 		Calle d = (Calle) partida.getTablero().getCasilla(jugador.getPosicion_tablero());
				 		jugador.anadir_propiedad(d);
						jugador.sacar_dinero(d.getPrecio_compra());
						d.setPropietario(jugador);
						informacion.setText("Compra realizada");
						dinero.setText(String.valueOf((Math.round(jugador.getDinero()))));
						click_comprar++;
						
					} else {
						informacion.setText(" No puede comprar");
					}

				}else {
					informacion.setText(" No puede comprar");
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
					click_dados--;

				}

			}
		});
		pasarTurno.setBounds(1191, 83, 119, 23);
		contentPane.add(pasarTurno);

		JButton btnNewButton = new JButton("Ver propiedades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Calle> propiedades = jugador.getPropiedades();
				MostrarPropiedades mostrarPropiedades = new MostrarPropiedades(propiedades);

			}
		});
		btnNewButton.setBounds(1181, 158, 129, 23);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBounds(647, 578, 10, 10);
		contentPane.add(panel);

		JButton dado1 = new JButton("");
		dado1.setBackground(Color.WHITE);
		dado1.setBounds(1112, 458, 89, 86);
		contentPane.add(dado1);

		JButton dado2 = new JButton("");
		dado2.setForeground(Color.BLACK);
		dado2.setBackground(Color.WHITE);
		dado2.setBounds(1231, 458, 89, 86);
		contentPane.add(dado2);

		JButton btnNewButton_1 = new JButton("Lanzar Dados");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Jugador> c = partida.getJugadores();

				if (partida.getTurno() == c.indexOf(jugador) && click_dados == 0) {

					List<Integer> dados = partida.getDados();
					dado1.setText(String.valueOf(dados.get(0)));
					dado2.setText(String.valueOf(dados.get(1)));

					jugador.movimiento_tablero(dados.get(0) + dados.get(1)); // Actualizamos la posicion del jugador en
																				// el tablero
					DibujarFichaAvanza(jugador.getPosicion_tablero(), jugador.getNombre()); // Actualizamos la posicion
																							// del jugador en la
																							// interfaz
					click_dados++;
				}

			}
		});
		btnNewButton_1.setToolTipText("Pulsa para lanzar los dados");
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(1156, 399, 113, 23);
		contentPane.add(btnNewButton_1);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(534, 591, 46, 14);
		contentPane.add(label_1);

		this.escuchandoServidor();
		this.setResizable(false);

		this.setVisible(true);

	}

	public void DibujarFichaAvanza(int posicion, String nombre) {

		for (Canvas c : this.jugadores_ficha) {
			System.out.println("hola");
			if (c.getName().equals(nombre)) {
				System.out.println("hola");
				if (posicion == 1) {
					c.setBounds(582, 567, 30, 28);
				}

				if (posicion == 2) {
					c.setBounds(534, 567, 30, 28);
				}

				if (posicion == 3) {
					c.setBounds(482, 567, 30, 28);
				}

				if (posicion == 4) {
					c.setBounds(431, 567, 30, 28);
				}
				if (posicion == 5) {
					c.setBounds(383, 567, 30, 28);
				}
				if (posicion == 6) {
					c.setBounds(330, 567, 30, 28);
				}

			}
		}
	}
}
