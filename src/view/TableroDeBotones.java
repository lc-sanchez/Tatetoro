package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.MainController;

public class TableroDeBotones {

	private JFrame frame;
	public static Boton[][] listaBotones;

	public TableroDeBotones(JFrame frame, int nivel) {
		this.frame = frame;
		TableroDeBotones.listaBotones = new Boton[nivel][nivel];
	}

	public void llenarTablero() {
		/*Llena la ventana de juego, el tablero, con los Jbuttons correspondientes adhiriendoles un evento a cada uno*/
		for (int i = 0; i < listaBotones.length; i++) {
			for (int j = 0; j < listaBotones[0].length; j++) {
				JButton Jboton = new JButton();
				Boton boton= new Boton(Jboton,i,j);
				Jboton.setFont(new Font("Tahoma",Font.PLAIN,90));
				Jboton.setText("");
				agregarEventoBoton(boton);
				this.frame.getContentPane().add(Jboton);
				listaBotones[i][j] = new Boton(Jboton,i,j); 
			}
		}
	}
	
	public void escribirJugada(Boton boton, int fila, int columna) {
		/*Escribe una nueva jugada en la matriz logica, mediante el llamado del controlador*/
		MainController.actualizarJugadaMatriz(MainController.getTurno(),fila,columna);
		boton.getJBoton().setText(MainController.getTurno());
		boton.getJBoton().setEnabled(false);
		
	}
	
	
	private void agregarEventoBoton(Boton boton) {
		/* Agrega eventos a los botones y  llamando al MainController para que se encargue de llamar a la logica para
		 * verificar la partida en cada jugada */
		boton.getJBoton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribirJugada(boton,boton.getFila(),boton.getColumna());
				
				if(MainController.hayGanador()) {
					//Pantallita de ganador
					desactivarBotones();
					JOptionPane.showMessageDialog(frame, "Felicitaciones has ganado jugador: " + MainController.getGanador());
					return;
				}
				frame.setTitle("Turno de jugador: " + MainController.getTurno() + ", Turno numero: " + MainController.getContTurno());
			}
		});
	}
	
	
	private void desactivarBotones() {
		/* Desactiva los botones una vez que se determina una partida ganada */
		for (int i = 0; i < listaBotones.length; i++) {
			for (int j = 0; j < listaBotones.length; j++) {
				listaBotones[i][j].getJBoton().setEnabled(false);
			}
		}
	}
}
