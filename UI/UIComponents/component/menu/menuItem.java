package Proyecto.T03.UI.UIComponents.component.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import Proyecto.T03.Util.actionClicked;

@SuppressWarnings("serial")
public class menuItem extends JMenuItem {
	private actionClicked action;
	
	public menuItem(String text) {
		this.setText(text);
		menuItem item = this;
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.getActionClicked().start();
			}
		});
	}
	
	public void setActionClicked(actionClicked action) {
		this.action = action;
	}
	
	public actionClicked getActionClicked() {
		return this.action;
	}
}
