package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;


public class VentanaPrincipal extends JFrame{
	
	private PanelSuperior panelup;
	private PanelDerecho panelright;
	private PanelInferior panelbot;
	private TableroJuego tablero;
	private Top10 top10;
	
	public VentanaPrincipal() {
		setTitle("Juego de LightsOut");
		setSize(new Dimension(700,500));
		
		panelup = new PanelSuperior();
		add(panelup, BorderLayout.NORTH);
		
		top10 = new Top10();
        try {
            top10.cargarRecords(new File("top10.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		panelright = new PanelDerecho(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "NUEVO":
                        actualizar();
                        break;
                    case "REINICIAR":
                    	//panelbot.reiniciar();
                        tablero.reiniciar();
                        break;
                    case "TOP":
                        top10();
                        break;
                    case "CAMBIAR":
                    	cambiar();
                    	break;
                }
            }
			
		});
		
		JPanel margen = new JPanel(new BorderLayout());
		margen.add(panelright, BorderLayout.CENTER);
		margen.setBorder(BorderFactory.createEmptyBorder(160,0,160,10));
		add(margen, BorderLayout.EAST);
		
		int dificultad = panelup.dificultad();
		int dimensiones = panelup.getDimensiones();
		
		panelbot = new PanelInferior();
		add(panelbot, BorderLayout.SOUTH);
		
		Tablero tableroModelo = new Tablero(dimensiones);
		tablero = new TableroJuego(tableroModelo, dificultad, dimensiones);
		VentanaPrincipal ventana = this;
		
		tablero.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                int size = getWidth() / dimensiones;
                int i = e.getX() / size;
                int j = e.getY() / size;
                if (i < dimensiones && j < dimensiones) {
                    tablero.mecanismo(i, j);
                    repaint();
                }
                panelbot.jugadas();
                if(tableroModelo.tableroIluminado()) {
                	JDialog dialog = new JDialog(ventana, "Ganador", true);
                    dialog.setSize(200, 150);
                    dialog.setLocationRelativeTo(ventana);

                    JLabel ganador = new JLabel("Has ganado");
                    ganador.setHorizontalAlignment(SwingConstants.CENTER);
                    dialog.add(ganador, BorderLayout.CENTER);
                	dialog.setVisible(true);
                	File file= new File("data/top10.csv");
                	try {
                		top10.salvarRecords(file);
                	}catch(Exception exception) {
                		System.err.println("No se pudo guardar");
                	}
                }
            }
		});
		
		add(tablero, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                guardar();
            }
        });
		
		setVisible(true);
	}
	
	public void guardar() {
		try {
            top10.salvarRecords(new File("top10.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void actualizar() {
		int dificultad = panelup.dificultad();
		int dimensiones = panelup.getDimensiones();
		Tablero tableroModelo = new Tablero(dimensiones);
		tablero.actualizar(tableroModelo, dificultad, dimensiones);
		repaint();
	}
	
	private void cambiar() {
    	JDialog jugador = new JDialog(this, "Cambiar Jugador", true);
    	jugador.setSize(250, 150);
    	jugador.setLayout(new FlowLayout());
    	jugador.setLocationRelativeTo(this);

    	JLabel lbl= new JLabel("Ingrese el nombre del jugador");
    	jugador.add(lbl);
    	
    	JTextField txt= new JTextField(20);
    	jugador.add(txt);
    	
    	JButton close = new JButton("Cerrar");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jugador.dispose();
				panelbot.jugador(txt.getText());
			}
            });
		jugador.add(close);
		
		jugador.setVisible(true);
    }
	
	public void top10() {
		
	}
	
	
	public static void main(String[] args) {
		new VentanaPrincipal();
	}
	
}
