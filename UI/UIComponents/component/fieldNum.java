package Proyecto.T03.UI.UIComponents.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JTextField;

import Proyecto.T03.UI.UIComponents.Panels.columnMod.addVar.avMenuFrame;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class fieldNum extends JTextField {
	private avMenuFrame frame = new avMenuFrame();
	private JMenuItem option = new JMenuItem();
	private String var;
	private column c;
	
	public fieldNum(column c) {
		this.c = c;
	}
	
	public void update() {
		frame.update();
		if (programPanel.varsName.size() > 0) {
			if (frame.usingVar) {
				var = frame.getPanel().getVar();
				this.setText("" + programPanel.vars.get(var));
			}
		}
		
		if (!(frame.usingVar)) {
			var = "";
		}
	}
	
	public void initField(int i, int j) {
		option.setText("Asignar variable - Campo " + i + "-" + j);
		this.setComponentPopupMenu(c.getPopupMenu());
		this.getComponentPopupMenu().add(option);
		
		option.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
			}
		});
	}
	
	public void setVar(String n) {
		this.var = n;
	}
}
