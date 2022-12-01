package Proyecto.T03.UI.UIComponents.Panels.options;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.Util.operations;

@SuppressWarnings("serial")
public class opMPMembers extends panelBase {
	
	public opMPMembers(Dimension size) {
		super(size);
		this.setBackground(new Color(100, 100, 100, 50));
	}

	public void update() {
	}
	
	@Override
	protected void draw() {
		Graphics g = createGraphics();
		g.setFont(new Font(this.getFont().getName(), 0, 20));
		g.setColor(new Color(0, 0, 0, 150));
		g.drawString("Paradigma 3M - Integrantes :", 20, 20);
		
		g.setFont(new Font(this.getFont().getName(), 0, 16));
		g.setColor(new Color(10, 10, 10, 150));
		g.drawString("Julio Cesar Ramos Chandomi", 40, 40);
		g.drawString("Denisse Adamaris Muñoz Rodriguez", 40, 60);
		g.drawString("Brigit Fernanda Ortega Huizar", 40, 80);
		g.drawString("Angel Miguel Urieta Cruz", 40, 100);
		g.drawString("Manuel Adrian Romero Cuellar", 40, 120);
		g.drawString("Melissa Lorena olguin Torres", 40, 140);
		g.drawString("Erick Eduardo Flores Hernandez", 40, 160);
		
		g.drawImage(new ImageIcon(operations.class.getResource("imgs/icono.png")).getImage(),
				50, 180, 256, 256, null);
	}
	
	@Override
	protected void action(ActionEvent e) {
	}
	
	public void initComponents() {
		super.initComponents();
	}
	
}
