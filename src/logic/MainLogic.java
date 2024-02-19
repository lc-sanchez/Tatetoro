package logic;

import controller.MainController;

public class MainLogic {

	private static String ganador = " ";
	private static Casillero[][] matrizDeJuego;

	private static int contTurnos=1;
	
	
	public static void inicializarMatrizDeJuego(int nivel) {
		/*Inicializa la matriz de juego con los casilleros vacios*/
		matrizDeJuego=new Casillero[nivel][nivel];
		for(int i=0;i<nivel;i++) {
			for(int j=0;j<nivel;j++) {
				Casillero casillero=new Casillero("",i,j);
				matrizDeJuego[i][j]=casillero;
			}
		}
	}
	

	public static void actualizarCasillero(String valor,int fila, int columna) {
		/*Actualiza los valores de los casilleros de la matriz cuando se ejecuta una jugada*/
		matrizDeJuego[fila][columna].setValorCasillero(valor);
	}
	
	
	private static void changeTurno() {
		/* Intercambia los turnos de los jugadores, se decidió setear el primer turno como X */
		if(MainController.getTurno() == "X") { 
			MainController.setTurno("O");
		}
		else {
			MainController.setTurno("X");
		}
	}
	
	private static boolean validarPorFilas() {
		/* Valida por filas */
		int cont;
		for (cont = 0; cont < 3; ++cont) {
			if (validar(matrizDeJuego[cont][0],matrizDeJuego[cont][1],matrizDeJuego[cont][2])) {
				return true;
			}
		}
		return false;
	}
			

	private static boolean validarPorColumnas() {
		/* Valida por columnas */
		int cont;
		for (cont = 0; cont < 3; ++cont) {
			if (validar(matrizDeJuego[0][cont],matrizDeJuego[1][cont],matrizDeJuego[2][cont])) {
				return true;
			}
		}

		return false;
	}

	private static boolean validarPorDiagonal() {
		/*Valida por diagonales */
		// validar por diagonal 0,0 hasta 2,2
		if(validar(matrizDeJuego[0][0],matrizDeJuego[1][1],matrizDeJuego[2][2])) {
			return true;
		}
		// validar por diagonal 0,2, hasta 2,0
		else if(validar(matrizDeJuego[0][2],matrizDeJuego[1][1],matrizDeJuego[2][0])) {
			return true;
		}
		return false;
	}
	
	private static boolean validarPorTatetoro() {
		/* Valida los casos correctos de diagonales por tatetoro */
		if(validar(matrizDeJuego[0][1],matrizDeJuego[1][2],matrizDeJuego[2][0])) {
			return true;
		}
		else if(validar(matrizDeJuego[1][0],matrizDeJuego[0][1],matrizDeJuego[2][2])) {
			return true;
		}
		else if(validar(matrizDeJuego[1][0],matrizDeJuego[2][1],matrizDeJuego[0][2])) {
			return true;
		}
		else if(validar(matrizDeJuego[0][0],matrizDeJuego[2][1],matrizDeJuego[1][2])) {
			return true;
		}
		return false;
	}
	
	
	private static boolean validar(Casillero primero, Casillero segundo, Casillero tercero) {
		/* Recorre y verifica los valores de los casilleros pasados por parametros son iguales, para asi determinar un ganador*/
		if (primero.getValorCasillero() == segundo.getValorCasillero() && segundo.getValorCasillero()==tercero.getValorCasillero() &&
				tercero.getValorCasillero() != "") {
			setGanador(primero.getValorCasillero());
			return true;
		}
		return false;
	}
	


	public static boolean validarPartida() {
		/* Se encarga de recorrer todos los casos posibles para verificar si hay un ganador en la partida */

		if (validarPorFilas()) {
			return true;
		}

		if (validarPorColumnas()) {
			return true;
		}

		if (validarPorDiagonal()) {
			return true;
		}
		
		if (validarPorTatetoro()) {
			return true;
		}
		
		if (contTurnos==9) {
			setGanador("Nadie");
			return true;
		}
		
		contTurnos++;
		changeTurno();
		return false;
	}

	/* Getters y setters */
	public static int getContTurnos() {return contTurnos;}
	public static void setContTurnos(int contTurnos) {MainLogic.contTurnos = contTurnos;}
	
	public static void setGanador(String ganador) {MainLogic.ganador = ganador;}
	public static String getGanador() {return ganador;}
}
