package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDerecho extends JPanel{
	
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top;
	private JButton cambiar;
	
	public PanelDerecho(ActionListener cond) {
		setLayout(new GridLayout(4,1,10,10));
		
		nuevo = new JButton("NUEVO");
		nuevo.setActionCommand("NUEVO");
		nuevo.addActionListener(cond);
		
		reiniciar = new JButton("REINICIAR");
		reiniciar.setActionCommand("REINICIAR");
		reiniciar.addActionListener(cond);
		
		top = new JButton("TOP-10");
		top.setActionCommand("TOP");
		top.addActionListener(cond);
		
		cambiar = new JButton("CAMBIAR JUGADOR");
		cambiar.setActionCommand("CAMBIAR");
		cambiar.addActionListener(cond);
		
		add(nuevo);
		add(reiniciar);
		add(top);
		add(cambiar);
	}

}
