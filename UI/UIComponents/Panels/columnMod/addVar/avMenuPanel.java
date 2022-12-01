package Proyecto.T03.UI.UIComponents.Panels.columnMod.addVar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class avMenuPanel extends panelBase {
	private JTextField fields = new JTextField();
	private JComboBox<String> vBox = new JComboBox<>();
	
	public avMenuPanel(Dimension size) {
		super(size);
		
		vBox.setBounds(20, 30, 340, 16);
		fields.setBounds(20, 80, 340, 32);
		fields.setEditable(false);
		
		this.addButton(170, 120, 90, 24).setButtonText("Aplicar");
		this.addButton(270, 120, 90, 24).setButtonText("Quitar");
		
		this.add(vBox);
		this.add(fields);
		this.initComponents();
	}
	
	public void update() {
		try {
			 fields.setText("" + 
					 programPanel.vars.get(vBox.getItemAt((vBox.getSelectedIndex()))));
		} catch (Exception e) {}
	}
	
	public void updateVarList() {
		vBox.removeAllItems();
		
		for (String n : programPanel.varsName) {
			vBox.addItem(n);
		}
	}

	public String getVar() {
		try {
			return programPanel.varsName.get(vBox.getSelectedIndex());
		} catch (Exception e) {
			return "null";
		}
	}
	
	@Override
	protected void draw() {
		Graphics g = createGraphics();
		g.setFont(new Font(this.getFont().getName(), 0, 20));
		g.setColor(new Color(0, 0, 0, 150));
		g.drawString("Variable : ", 20, 20);
		g.drawString("Valor : ", 20, 70);
	}
	
	@Override
	protected void action(ActionEvent e) {
	}
}
