package Proyecto.T03.UI.UIComponents.Panels.varMenu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.Util.actionClicked;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.program;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class vmMenuFrame extends JFrame {
	private vmMenuPanel panel;
	
	public vmMenuFrame() {
		this.setTitle("Agregar Componente");
		this.setSize(400, 210);
		this.setLocationRelativeTo(program.getMainPanel());
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		panel = new vmMenuPanel(this.getSize());
		vmMenuFrame f = this;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		panel.getButton(0).setActionClicked(new actionClicked() {
			public void start() {
				if (panel.getField(0).getText().length() > 0 &&
						panel.getField(1).getText().length() > 0) {
					try {
						programPanel.vars.put(panel.getField(0).getText(), Float.valueOf(panel.getField(1).getText()));
						programPanel.varsName.add(panel.getField(0).getText());
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
	
	public vmMenuPanel getPanel() {
		return panel;
	}
}
