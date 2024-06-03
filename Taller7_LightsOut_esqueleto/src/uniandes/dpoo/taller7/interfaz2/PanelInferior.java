package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel{
	
	private JLabel jugadas;
	private JTextField txt1;
	private JLabel jugador;
	private JTextField txt2;
	
	public PanelInferior() {
		
		setLayout(new GridLayout(1,4));
		
		jugadas = new JLabel("Jugadas:");
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		
		jugador = new JLabel("Jugador:");
		
		add(jugadas);
		add(txt1);
		add(jugador);
		add(txt2);
	}
	
	
}
