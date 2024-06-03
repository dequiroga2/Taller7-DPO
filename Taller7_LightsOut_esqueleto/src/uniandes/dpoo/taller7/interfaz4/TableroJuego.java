package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class TableroJuego extends JPanel{
	
	private Tablero tablero;
	private JLabel score;
	private int dimension;
	private boolean[][] celdas;
	private Top10 top10;
	
	public TableroJuego(Tablero tablero, int dificultad,int dimension) {
		iniciar();
		this.tablero = tablero;
		tablero.desordenar(dificultad);
		this.celdas = tablero.darTablero();
		this.dimension = dimension;
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		int panelAncho = getWidth();
		int panelAlto = getHeight();
		int celdaAncho = panelAncho / dimension;
		int celdaAlto = panelAlto / dimension;
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				int x = i*celdaAncho;
				int y = j*celdaAlto;
				if (celdas[i][j] == true) {
					g2d.setColor(Color.YELLOW);
				} else {
					g2d.setColor(Color.GRAY);
				}
				g2d.fillRect(x, y, celdaAncho, celdaAlto);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(x, y, celdaAncho, celdaAlto);
			}
		}
	}
	
	public void iniciar() {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				celdas[i][j] = false;
			}
		}
	}
	
	public void mecanismo(int i, int j) {
		for (int cordx = -1; cordx <= 1; cordx++) {
            for (int cordy = -1; cordy <= 1; cordy++) {
                int x = i + cordx;
                int y = j + cordy;
                if (limites(x, y)) {
                    celdas[x][y] = !celdas[x][y];
                }
            }
        }
	}
		
	public boolean limites(int i, int j) {
		return i >= 0 && i < dimension && j >= 0 && j < dimension;
	}
	
	public void reiniciar() {
		this.tablero.reiniciar();
	}
	
	public void actualizar(Tablero tableroNuevo, int dificultad, int dimension) {
        this.dimension = dimension;
        this.tablero.desordenar(dificultad);
        TableroJuego tablero = new TableroJuego(tableroNuevo,dificultad,dimension);
    }
}
