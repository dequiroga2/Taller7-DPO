package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.interfaz2.PanelDerecho;
import uniandes.dpoo.taller7.interfaz2.PanelInferior;
import uniandes.dpoo.taller7.interfaz2.PanelSuperior;

public class VentanaPrincipal extends JFrame{
	
	private PanelSuperior panelup;
	private PanelDerecho panelright;
	private PanelInferior panelbot;
	
	public VentanaPrincipal() {
		setTitle("Juego de LightsOut");
		setSize(new Dimension(600,500));
		
		panelup = new PanelSuperior();
		add(panelup, BorderLayout.NORTH);
		
		panelright = new PanelDerecho();
		
		JPanel margen = new JPanel(new BorderLayout());
		margen.add(panelright, BorderLayout.CENTER);
		margen.setBorder(BorderFactory.createEmptyBorder(160,0,160,10));
		add(margen, BorderLayout.EAST);
		
		panelbot = new PanelInferior();
		add(panelbot, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
