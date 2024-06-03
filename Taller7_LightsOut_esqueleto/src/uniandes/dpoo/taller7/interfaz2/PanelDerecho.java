package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDerecho extends JPanel{
	
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top;
	private JButton cambiar;
	
	public PanelDerecho() {
		setLayout(new GridLayout(4,1,10,10));
		
		nuevo = new JButton("NUEVO");
		
		reiniciar = new JButton("REINICIAR");
		
		top = new JButton("TOP-10");
		
		cambiar = new JButton("CAMBIAR JUGADOR");
		
		add(nuevo);
		add(reiniciar);
		add(top);
		add(cambiar);
	}

}
