package Proyecto.T03.UI.UIComponents.Panels.columnMod.addVar;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.Util.actionClicked;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.program;

@SuppressWarnings("serial")
public class avMenuFrame extends JFrame {
	private avMenuPanel panel;
	public boolean usingVar = false;
	
	public avMenuFrame() {
		this.setSize(400, 190);
		this.setLocationRelativeTo(program.getMainPanel());
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		panel = new avMenuPanel(this.getSize());
		
		avMenuFrame f = this;

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.setResizable(false);
		this.setTitle("Asignar variable");
		
		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				panel.updateVarList();
			}
 		});
		
		panel.getButton(0).setActionClicked(new actionClicked() {
			@Override
			public void start() {
				f.dispose();
				usingVar = true;
			}
		});
		
		panel.getButton(1).setActionClicked(new actionClicked() {
			@Override
			public void start() {
				f.dispose();
				usingVar = false;
			}
		});
		
		this.add(panel);
	}
	
	public void update() {
		panel.update();
	}
	
	public avMenuPanel getPanel() {
		return panel;
	}
}
