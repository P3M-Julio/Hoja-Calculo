package Proyecto.T03.UI.UIComponents.Panels.fuMenu;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Proyecto.T03.Util.operations;
import Proyecto.T03.main.program;

@SuppressWarnings("serial")
public class fuMenuFrame extends JFrame {
	private fuMenuPanel panel;
	
	public fuMenuFrame() {
		this.setTitle("Modificar Componente");
		this.setSize(325, 250);
		this.setLocationRelativeTo(program.getMainPanel());
		this.setIconImage(new ImageIcon(operations.class.getResource("imgs/icono_32.png")).getImage());
		panel = new fuMenuPanel(this.getSize());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				panel.updateVarList();
			}
 		});
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.setResizable(false);
		this.add(panel);
	}
	
	public void update() {
		panel.update();
	}
	
	public fuMenuPanel getPanel() {
		return panel;
	}
}
