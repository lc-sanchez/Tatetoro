package view;

import javax.swing.JButton;

public class Boton {
	private JButton jBoton;
	private int fila;
	private int columna;
	
	public Boton(JButton jBoton, int fila, int columna) {
		this.jBoton=jBoton;
		this.fila=fila;
		this.columna=columna;
	}
	
	/*Getters y Setters*/
	public JButton getJBoton() {
		return this.jBoton;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
	}
}
