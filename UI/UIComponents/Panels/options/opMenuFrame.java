package Proyecto.T03.UI.UIComponents.Panels.options;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.Util.actionClicked;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.program;

@SuppressWarnings("serial")
public class opMenuFrame extends JFrame {
	private opMenuPanel panel;
	
	public opMenuFrame() {
		this.setTitle("Opciones");
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		this.setSize(500, 500);
		opMenuFrame f = this;
		
		this.setLocationRelativeTo(program.getMainPanel());
		panel = new opMenuPanel(this.getSize());
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		panel.getButton(2).setActionClicked(new actionClicked() {
			public void start() {
				f.dispose();
			}
		});
		
		this.add(panel);
	}
	
	public void update() {
		panel.update();
	}
	
	public opMenuPanel getPanel() {
		return panel;
	}
}
