package logic;

public class Casillero {
	private String valor;
	private int fila;
	private int columna;
	
	public Casillero(String valor,int fila, int columna) {
		this.valor=valor;
		this.fila=fila;
		this.columna=columna;
	}
	
	/*Setters y Getters */
	public void setValorCasillero(String nuevoValor) {
		this.valor=nuevoValor;
	}
	
	public String getValorCasillero() {
		return this.valor;
	}
	
	public int getFilaCasillero() {
		return this.fila;
	}
	
	public int getColumnaCasillero() {
		return this.columna;
	}

}
