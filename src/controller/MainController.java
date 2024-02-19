package controller;



import logic.MainLogic;

public class MainController {

	private static String turno = "X";

	public MainController() {
	}
	
	public void inicializarMatrizLogica() {
		/*Inicializa la matriz logica de tamaño 3x3 */
		MainLogic.inicializarMatrizDeJuego(3);
	}
	
	public static void actualizarJugadaMatriz(String valor,int fila, int columna) {
		/*Actualiza la matriz de juego llamando al metodo logico  pasandole por parametros el valor a cambiar y la posicion*/
		MainLogic.actualizarCasillero(valor,fila,columna);
	}
	
	public static boolean hayGanador() {
		/*Determina si hay un ganador en la partida llamando al metodo logico de validad partida*/
		return MainLogic.validarPartida();
	}
	
	/* Getters y Setters*/
	public static String getTurno() {return turno;}
	public static void setTurno(String turnoR) {turno = turnoR;}
	
	public static String getGanador() {return MainLogic.getGanador();}
	
	public static int getContTurno() {return MainLogic.getContTurnos();}
	
}
