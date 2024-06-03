package uniandes.dpoo.taller7.interfaz2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel{

	private JLabel tam;
	private JComboBox dim;
	private JLabel dif;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	
	public PanelSuperior() {
		setLayout(new GridLayout(1,6));
		Font labels = new Font("Dialog", Font.BOLD, 14);
		
		tam = new JLabel("Tamaño");
		//tam.setFont(labels);
		tam.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		String[] opciones = {"5x5","6x6","7x7","8x8","9x9"};
		dim = new JComboBox<String>(opciones);
		//dim.setFont(labels);
		
		dif = new JLabel("Dificultad");
		//dif.setFont(labels);
		
		facil = new JRadioButton("Fácil");
		//facil.setFont(labels);
		
		medio = new JRadioButton("Medio");
		//medio.setFont(labels);
		
		dificil = new JRadioButton("Difícil");
		//dificil.setFont(labels);
		
		add(tam);
		add(dim);
		add(dif);
		add(facil);
		add(medio);
		add(dificil);
		
	}
	
}
