package Proyecto.T03.UI.UIComponents.Panels.columnMod;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.Util.actionClicked;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.program;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class agrMenuFrame extends JFrame {
	private argMenuPanel panel;
	
	public agrMenuFrame(int mof) {
		this.setSize(400, 210);
		this.setLocationRelativeTo(program.getMainPanel());
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		panel = new argMenuPanel(this.getSize());
		
		agrMenuFrame f = this;
		argMenuPanel p = panel;
		if (mof == 0) {
			panel.getButton(0).setActionClicked(new actionClicked() {
				public void start() {
					if (panel.getField(0).getText().length() > 0 &&
							panel.getField(1).getText().length() > 0) {
						int n = 0;
						
						try {
							n = Integer.valueOf(panel.getField(1).getText());
						} catch(Exception er) {
							p.showMessageError("El segundo campo solo puede contener numeros");
						}
						
						if (n != 1) {
							try {
								program.getMainPanel().addColumn(p.getField(0).getText(), n);
								f.dispose();
							} catch(Exception er) {}
						} else {
							p.showMessageError("No se puede asignar una sola variable");
						}
					} else {
						p.showMessageError("Complete los campos antes de guardar");
					}
				}
			});
			this.setTitle("Agregar Componente");
		} else if (mof == 1) {
			panel.getButton(0).setActionClicked(new actionClicked() {
				public void start() {
					if (panel.getField(0).getText().length() > 0 &&
							panel.getField(1).getText().length() > 0) {
						
						try {
							int n = program.getMainPanel().getColumnList().indexOf(programPanel.currentColumn);
							program.getMainPanel().getColumnList().get(n).setName(p.getField(0).getText());
							p.setRenameState(false);
							
							f.dispose();
						} catch(Exception er) {}
					} else {
						p.showMessageError("Complete los campos antes de guardar");
					}
				}
			});
			this.setTitle("Modificar Componente");
		}
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		this.add(panel);
	}
	
	public argMenuPanel getPanel() {
		return panel;
	}
}
