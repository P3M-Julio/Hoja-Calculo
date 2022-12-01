package Proyecto.T03.UI.UIComponents.Panels.options;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.UI.UIComponents.Panels.varMenu.varMod.vmmMenuFrame;
import Proyecto.T03.Util.actionClicked;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class opMPVars extends panelBase {
	private JComboBox<String> options = new JComboBox<>();
	private JTextField[] fields = {new JTextField()};
	
	public opMPVars(Dimension size) {
		super(size);
		fields[0].setBounds(10, 80, 300, 32);
		
		this.addButton(120, 420, 100, 32).setButtonText("Modificar").setFontSize(12);
		this.addButton(240, 420, 100, 32).setButtonText("Eliminar").setFontSize(12);
		
		options.setBounds(10, 40, 128, 16);
		
		for (int i = 0; i < programPanel.varsName.size(); i++) {
			options.addItem(programPanel.varsName.get(i));
		}
		
		for (JTextField f : fields) {
			f.setEditable(false);
			this.add(f);
		}
		
		this.add(options);
		this.setBackground(new Color(100, 100, 100, 50));
		this.initComponents();
	}

	public void update() {
		if (this.isVisible()) {
			try {
				if (programPanel.vars.size() > 0) {
					this.fields[0].setText("" + programPanel.vars.get(options.getSelectedItem()));
					this.getButton(0).setEnabled(true);
					this.getButton(1).setEnabled(true);
				} else {
					this.getButton(0).setEnabled(false);
					this.getButton(1).setEnabled(false);
				}
			} catch(Exception e) {}
		}
	}
	
	@Override
	protected void draw() {
		Graphics g = createGraphics();
		g.setColor(Color.WHITE);
		g.setFont(new Font(this.getFont().getName(), 0, 20));
		g.setColor(new Color(0, 0, 0, 150));
		g.drawString("Variable : ", 10, 35);
		g.drawString("Valor : ", 10, 75);
	}

	public String getItem() {
		return options.getItemAt(options.getSelectedIndex());
	}
	
	@Override
	protected void action(ActionEvent e) {
	}
	
	public String getItem(int n) {
		return this.options.getItemAt(options.getSelectedIndex());
	}
	
	public void initComponents() {
		super.initComponents();
		opMPVars d = this;
		
		this.getButton(0).setActionClicked(new actionClicked() {
			public void start() {
				new vmmMenuFrame(d);
			}
		});
		
		this.getButton(1).setActionClicked(new actionClicked() {
			public void start() {
				String n = d.getItem(0);
				int i = d.showMessageWarning("Esta seguro de eliminar esta variable?");
				
				if (i == 0) {
					programPanel.vars.remove(n);
					programPanel.varsName.remove(n);
				}
			}
		});
	}
	
}
