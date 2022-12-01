package Proyecto.T03.UI.UIComponents.Panels.varMenu.varMod;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.UI.UIComponents.Panels.options.opMPVars;
import Proyecto.T03.Util.actionClicked;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.program;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class vmmMenuFrame extends JFrame {
	private vmmMenuPanel panel;
	private opMPVars panel2;
	
	public vmmMenuFrame(opMPVars p) {
		this.setTitle("Modificar Componente");
		this.setSize(400, 210);
		this.setLocationRelativeTo(program.getMainPanel());
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		panel = new vmmMenuPanel(this.getSize());
		panel2 = p;
		vmmMenuFrame f = this;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		panel.getButton(0).setActionClicked(new actionClicked() {
			public void start() {
				String n = panel2.getItem();
				
				if (panel.getField(0).getText().length() > 0 &&
						panel.getField(1).getText().length() > 0) {
					try {
						programPanel.vars.put(panel.getField(0).getText(), Float.valueOf(panel.getField(1).getText()));
						programPanel.vars.remove(n);
						programPanel.varsName.set(programPanel.varsName.indexOf(n), panel.getField(0).getText());
						f.dispose();
					} catch(Exception e) {
						panel.showMessageError("El segundo campo solo puede contener numeros");
					}
				} else {
					panel.showMessageError("Complete los campos antes de guardar");
				}
			}
		});
		
		this.add(panel);
	}
	
	public vmmMenuPanel getPanel() {
		return panel;
	}
}
