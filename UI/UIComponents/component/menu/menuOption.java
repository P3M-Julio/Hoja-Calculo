package Proyecto.T03.UI.UIComponents.component.menu;

import java.util.ArrayList;

import javax.swing.JMenu;

@SuppressWarnings("serial")
public class menuOption extends JMenu {
	private ArrayList<menuItem> items = new ArrayList<>();
	
	public menuOption() {
	}
	
	public menuOption addItem() {
		menuItem item = new menuItem("Item");
		items.add(item);
		this.add(item);
		return this;
	}
	
	public menuOption addItem(String text) {
		menuItem item = new menuItem(text);
		items.add(item);
		this.add(item);
		return this;
	}
	
	public menuItem getItem(int index) {
		return items.get(index);
	}
}
