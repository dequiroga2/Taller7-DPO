package uniandes.dpoo.taller7.interfaz1;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	public VentanaPrincipal() {
		setTitle("Juego de LightsOut");
		setSize(new Dimension(700,500));
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
