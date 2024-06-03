package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaPrincipal extends JFrame{
	
	private PanelSuperior panelup;
	private PanelDerecho panelright;
	private PanelInferior panelbot;
	private TableroJuego tablero;
	
	public VentanaPrincipal() {
		setTitle("Juego de LightsOut");
		setSize(new Dimension(700,500));
		
		
		tablero = new TableroJuego(5);
		
		panelup = new PanelSuperior(tablero);
		add(panelup, BorderLayout.NORTH);
		
		
		
		panelright = new PanelDerecho();
		JPanel margen = new JPanel(new BorderLayout());
		margen.add(panelright, BorderLayout.CENTER);
		margen.setBorder(BorderFactory.createEmptyBorder(160,0,160,10));
		add(margen, BorderLayout.EAST);
		
		panelbot = new PanelInferior();
		add(panelbot, BorderLayout.SOUTH);
		
		add(tablero, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
