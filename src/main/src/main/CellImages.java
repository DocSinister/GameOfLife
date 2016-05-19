package src.main;



import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class CellImages extends JComponent {
	private int x, y, width, height;
	
	public CellImages(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fill3DRect(x, y, width, height, true);
	}
}