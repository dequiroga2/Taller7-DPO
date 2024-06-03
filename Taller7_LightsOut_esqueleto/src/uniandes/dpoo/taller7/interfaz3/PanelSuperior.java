package uniandes.dpoo.taller7.interfaz3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private TableroJuego tablero;
	private int size;
	
	public void setSizeTablero(int size1) {
		this.size = size1;
	}
	public int getSizeTablero() {
		return size;
	}
	
	public PanelSuperior(TableroJuego tablero) {
		this.tablero = tablero;
		
		setLayout(new GridLayout(1,6));
		
		tam = new JLabel("Tamaño");
		tam.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		
		String[] opciones = {"5x5","6x6","7x7","8x8","9x9"};
		dim = new JComboBox<String>(opciones);
		dim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) dim.getSelectedItem();
				if (seleccion != null) {
					int size = seleccion.equals("5x5") ? 5: seleccion.equals("6x6")? 6:
					seleccion.equals("7x7")? 7: seleccion.equals("8x8")? 8: seleccion.equals("9x9")? 9:10;
					setSizeTablero(size);
					tablero.setDimension(size);
				}
			}
		});
		
		dif = new JLabel("Dificultad");
		
		facil = new JRadioButton("Fácil");
		
		medio = new JRadioButton("Medio");
		
		dificil = new JRadioButton("Difícil");
		
		add(tam);
		add(dim);
		add(dif);
		add(facil);
		add(medio);
		add(dificil);
		
	}
	
}
