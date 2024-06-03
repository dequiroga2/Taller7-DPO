package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class TableroJuego extends JPanel{
	
	private int dimension;
	
	public TableroJuego(int dimension) {
		this.dimension = dimension;
	}
	
	public void setDimension(int dimension) {
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
				g2d.setColor(Color.YELLOW);
				g2d.fillRect(x, y, celdaAncho, celdaAlto);
				g2d.setColor(Color.BLACK);
				g2d.drawRect(x, y, celdaAncho, celdaAlto);
			}
		}
		
		
		//Rectangle2D rectangle = new Rectangle2D.Double(0,0,500,410);
		//g.drawRect(0, 0, 100, 82);
		
		//g2d.draw(rectangle);
		
	}
}
