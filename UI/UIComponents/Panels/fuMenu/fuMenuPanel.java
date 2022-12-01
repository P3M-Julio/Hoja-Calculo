package Proyecto.T03.UI.UIComponents.Panels.fuMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Proyecto.T03.UI.UIComponents.component.column;
import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class fuMenuPanel extends panelBase {
	private JTextField fields[] = {new JTextField(), new JTextField()};
	private JComboBox<String> cBox = new JComboBox<>();
	private JComboBox<String> vBox = new JComboBox<>();
	private JComboBox<String> vmBox = new JComboBox<>();
	private column column;
	private String selectedVar;
	
	public fuMenuPanel(Dimension size) {
		super(size);
		this.cBox.setBounds(20, 30, 128, 16);
		this.cBox.addItem("Ninguna");
		this.cBox.addItem("Minimo");
		this.cBox.addItem("Maximo");
		this.cBox.addItem("Promedio");
		this.cBox.addItem("Variable");
		
		this.vBox.setBounds(20, 70, 128, 16);
		this.vBox.setVisible(false);
		
		this.vmBox.addItem("Ninguna");
		this.vmBox.addItem("Asignacion");
		this.vmBox.setBounds(20, 150, 128, 16);
		this.vmBox.setVisible(false);
		
		this.fields[0].setBounds(20, 110, 128, 16);
		this.fields[0].setEditable(false);
		this.fields[0].setVisible(false);
		
		this.add(fields[0]);
		this.add(cBox);
		this.add(vBox);
		this.add(vmBox);
		this.initComponents();
	}

	public void updateVarList() {
		vBox.removeAllItems();
		
		for (String n : programPanel.varsName) {
			vBox.addItem(n);
		}
	}
	
	@Override
	protected void draw() {
		Graphics g = createGraphics();
		g.setFont(new Font(this.getFont().getName(), 0, 20));
		g.setColor(new Color(0, 0, 0, 150));
		g.drawString("Operacion Final : ", 20, 20);
		
		if (cBox.getSelectedIndex() == 4) {
			g.drawString("Variable : ", 20, 65);
			g.drawString("Valor : ", 20, 105);
			g.drawString("Operacion : ", 20, 145);
		}
	}
	
	public void initComponents() {
		super.initComponents();
	}

	public void setColumn(column c) {
		this.column = c;
	}
	
	public void update() {
		vBox.setVisible((cBox.getSelectedIndex() == 4)? true : false);
		vmBox.setVisible((cBox.getSelectedIndex() == 4)? true : false);
		fields[0].setVisible((cBox.getSelectedIndex() == 4)? true : false);
		
		if (programPanel.vars.size() > 0) {
			fields[0].setText("" + programPanel.vars.get(vBox.getItemAt(vBox.getSelectedIndex())));
			this.selectedVar = vBox.getItemAt(vBox.getSelectedIndex());
		}
		
		if (column != null) {
			if (cBox.getSelectedIndex() == 0) {
				column.getFult().setMode(operations.NINGUNA);
			} else if (cBox.getSelectedIndex() == 1) {
				column.getFult().setMode(operations.MINIMO);
			} else if (cBox.getSelectedIndex() == 2) {
				column.getFult().setMode(operations.MAXIMO);
			} else if (cBox.getSelectedIndex() == 3) {
				column.getFult().setMode(operations.PROMEDIO);
			} else if (cBox.getSelectedIndex() == 4) {
				column.getFult().setMode(operations.VARIABLE);
			}
			
			if (vmBox.getSelectedIndex() == 1) {
				column.getFult().setVarMode(operations.ASSIGNACION);
			} else {
				column.getFult().setVarMode(operations.NINGUNA);
			}
		}
	}
	
	public String getVar() {
		return this.selectedVar;
	}
	
	public int getVarIndex() {
		return this.vBox.getSelectedIndex();
	}
	
	@Override
	protected void action(ActionEvent e) {
	}
}
