package InterfazGrafica;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Monopoly.Jugador;
import Monopoly.Partida;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class SelecionPartida extends JFrame {

	private JPanel contentPane;
	private Partida selecionada;
	
	
	public Partida getPartida() {
		return selecionada;
	}
	
	
	
	

	public SelecionPartida(List<Partida> partidas) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.contentPane.setBackground(Color.BLACK);

		JLabel bienvenida = new JLabel("");
		bienvenida.setForeground(Color.RED);
		bienvenida.setFont(new Font("Power Green", Font.PLAIN, 21));
		bienvenida.setText("Selecione una partida");
		bienvenida.setBounds(302, 11, 233, 32);
		contentPane.add(bienvenida);

		JLabel selecion = new JLabel("");
		selecion.setFont(new Font("Power Green Small", Font.PLAIN, 22));
		selecion.setForeground(Color.GREEN);
		selecion.setBounds(352, 349, 104, 32);
		contentPane.add(selecion);
		this.setResizable(false);
		int c = 30;
		for (Partida i : partidas) {
			JButton btnNewButton = new JButton(i.getId());
			btnNewButton.setBackground(Color.GREEN);
			btnNewButton.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					selecion.setText(btnNewButton.getText());
				}

				public void mouseExited(MouseEvent e) {
					selecion.setText("");
				}
				
				public void mouseClicked(MouseEvent e) {
					JButton c = (JButton)e.getComponent();
					for(Partida d : partidas) {
						if(d.getId().equals(c.getText())) {
							selecionada=d;
						}
					}

					SelecionPartida.this.dispose();
					
				
				}

			});

			btnNewButton.setBounds(47 + c, 88, 112, 113);
			contentPane.add(btnNewButton);
			c = c + 150;
		}

		this.setVisible(true);
		Thread parpadeo = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {

					try {

						bienvenida.setVisible(true);
						Thread.sleep(1000);
						bienvenida.setVisible(false);
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		});
		parpadeo.start();
		
		
		
		
	}
}
