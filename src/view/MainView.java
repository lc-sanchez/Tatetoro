package view;

import java.awt.GridLayout;
import javax.swing.JFrame;

import controller.MainController;

public class MainView {

	public TableroDeBotones botones;
	private JFrame frame;

	public MainView(JFrame frame) {
		this.frame = frame;
	}

	public void inicializar() {
		/*Se inicializa la pantalla de juego*/
		this.frame.setBounds(300, 300, 650, 500);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		this.frame.setVisible(true);
		this.frame.setTitle("Turno de jugador: " + MainController.getTurno() + ", Turno numero: " + MainController.getContTurno());
		
		//Se llena el tablero de juego
		botones = new TableroDeBotones(frame,3);
		botones.llenarTablero();
	}

}
