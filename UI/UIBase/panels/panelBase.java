package Proyecto.T03.UI.UIBase.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Proyecto.T03.UI.UIBase.button.buttonBase;
import Proyecto.T03.UI.UIComponents.component.column;
import Proyecto.T03.UI.UIComponents.component.menu.menuItem;
import Proyecto.T03.UI.UIComponents.component.menu.menuOption;
import Proyecto.T03.UI.UIComponents.component.menu.popupOption;

@SuppressWarnings("serial")
public abstract class panelBase extends JPanel implements ActionListener {
	private static Graphics graphics;
	private static JMenuBar bar = new JMenuBar();
	private static popupOption popup = new popupOption();
	private ArrayList<buttonBase> buttons = new ArrayList<>();
	private ArrayList<menuOption> menuOptions = new ArrayList<>();
	private ArrayList<menuItem> popupOptions = new ArrayList<>();
	private ArrayList<column> columns = new ArrayList<>();
	protected abstract void draw();
	protected abstract void action(ActionEvent e);
	
	public panelBase(Dimension size) {
		this.setSize(size);
		this.setVisible(true);
		this.setLayout(null);
	}
	
	public void update() {
		for (column c : columns) {
			c.update();
		}
	}
	
	public static Graphics createGraphics() {
		return graphics.create();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		graphics = g;
		for (column c : columns) {
			c.draw();
		}
		
		this.draw();
	}
	
	public buttonBase addButton(int x, int y, int sx, int sy) {
		buttonBase base = new buttonBase();
		base.setBounds(x, y, sx, sy);
		base.addActionListener(this);
		buttons.add(base);
		return base;
	}

	public menuOption addMenuOption(String text) {
		menuOption menu = new menuOption();
		menu.setText(text);
		bar.add(menu);
		menuOptions.add(menu);
		return menu;
	}
	
	public column addColumn(String name, int div) {
		column c = new column(name, div, this);
		c.setPosition(0 + (columns.size() * 16));
		columns.add(c);
		c.setID(columns.indexOf(c));
		
		return c;
	}
	
	public buttonBase getButton(int index) {
		return buttons.get(index);
	}
	
	public menuOption getMenuOption(int index) {
		return menuOptions.get(index);
	}
	
	public JMenuBar getMenuBar() {
		return bar;
	}
	
	public popupOption getPopupMenu() {
		return popup;
	}
	
	public ArrayList<column> getColumnList() {
		return this.columns;
	}
	
	public void updatePositions() {
		for (int i = 0; i < columns.size(); i++) {
			columns.get(i).updatePosition(0 + (i * 16));
			columns.get(i).setID(columns.indexOf(columns.get(i)));
		}
	}
	
	public int showMessageWarning(String message) {
		return JOptionPane.showConfirmDialog(this, message, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	public void showMessageError(String message) {
		JOptionPane.showMessageDialog(this, message, "Error de comprobacion", JOptionPane.ERROR_MESSAGE);
	}
	
	public void clear() {
		for (column c : columns) {
			c.clear();
		}
		this.columns.clear();
	}
	
	public void initComponents() {
		for (buttonBase b : buttons) {
			this.add(b);
		}
		
		for (JMenuItem i : popupOptions) {
			popup.add(i);
		}
	}

	public ArrayList<buttonBase> getButtonList() {
		return this.buttons;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.action(e);
	}
}
