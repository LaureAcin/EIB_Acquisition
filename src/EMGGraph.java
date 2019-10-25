import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class EMGGraph extends JPanel {
	public EMGGraph() {

		this.setLayout(new GridLayout(1, 2));
		setBackground(Color.red);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawLine(0, 0, 100, -100);
		super.paintComponent(g);
	}
}
