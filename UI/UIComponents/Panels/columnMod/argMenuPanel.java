package Proyecto.T03.UI.UIComponents.Panels.columnMod;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import Proyecto.T03.UI.UIBase.panels.panelBase;

@SuppressWarnings("serial")
public class argMenuPanel extends panelBase {
	private JTextField[] fields = new JTextField[3];
	private boolean rename;
	
	public argMenuPanel(Dimension size) {
		super(size);
		fields[0] = new JTextField();
		fields[0].setBounds(20, 30, 340, 32);
		
		fields[1] = new JTextField();
		fields[1].setBounds(20, 100, 340, 32);
		
		this.addButton(270, 140, 90, 24).setButtonText("Aceptar");

		this.add(fields[0]);
		this.add(fields[1]);
		this.initComponents();
	}
	
	public void setRenameState(boolean flag) {
		this.rename = flag;
	}

	@Override
	protected void draw() {
		Graphics g = createGraphics();
		g.setFont(new Font(this.getFont().getName(), 0, 20));
		g.setColor(new Color(0, 0, 0, 150));
		g.drawString("Nombre : ", 20, 20);
		if (rename) {
			g.setColor(new Color(0 , 0, 0, 50));
		}
		g.drawString("Cantidad de variables : ", 20, 90);
	}

	public JTextField getField(int i) {
		return this.fields[i];
	}
	
	@Override
	protected void action(ActionEvent e) {
	}
	
	public void initComponents() {
		super.initComponents();
	}
}
