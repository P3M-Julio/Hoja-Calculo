package Proyecto.T03.UI.UIBase.button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Proyecto.T03.Util.actionClicked;

@SuppressWarnings("serial")
public class buttonBase extends JButton {
	private actionClicked action;
	
	public buttonBase() {
		buttonBase base = this;
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base.getActionClicked().start();
			}
		});
	}
	
	public void setActionClicked(actionClicked action) {
		this.action = action;
	}
	
	public actionClicked getActionClicked() {
		return this.action;
	}
	
	public buttonBase setButtonText(String text) {
		this.setText(text);
		return this;
	}
	
	public buttonBase setFontSize(int size) {
		this.setFont(new Font(this.getFont().getFontName(), 0, size));
		return this;
	}
}
