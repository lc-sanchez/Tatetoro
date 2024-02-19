package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MainController;
import view.MainView;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			 //Create our view
			JFrame frame = new JFrame();
	        MainView view = new MainView(frame);

	        //Create our controller
	        MainController controller = new MainController();

			public void run() {
				try {
					view.inicializar();
					controller.inicializarMatrizLogica();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
