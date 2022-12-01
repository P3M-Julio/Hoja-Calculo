package Proyecto.T03.main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.Util.operations;

@SuppressWarnings("serial")
public class program extends JFrame {
	private static programPanel panel;
	
	public program() {
		this.setSize(800, 500);
		this.setTitle("Hoja de calculo");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		this.setVisible(true);
		
		panel = new programPanel(this.getSize());
		this.setJMenuBar(panel.getMenuBar());
		this.add(panel);
		panel.repaint();
		this.update();
	}
	
	public static programPanel getMainPanel() {
		return panel;
	}
	
	public void update() {
		while(true) {
			try {
				Thread.sleep(50);
				panel.update();
				panel.repaint();
				System.out.checkError();
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new program();
	}
}
