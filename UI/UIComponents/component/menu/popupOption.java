package Proyecto.T03.UI.UIComponents.component.menu;

import java.util.ArrayList;

import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class popupOption extends JPopupMenu {
	private ArrayList<menuItem> items = new ArrayList<>();
	
	public popupOption() {
	}
	
	public popupOption addItem(String text) {
		menuItem item = new menuItem(text);
		this.items.add(item);
		this.add(item);
		return this;
	}
	
	public menuItem getItem(int index) {
		return this.items.get(index);
	}
}
