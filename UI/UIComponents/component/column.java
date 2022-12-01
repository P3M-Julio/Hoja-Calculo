package Proyecto.T03.UI.UIComponents.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.UI.UIComponents.Panels.columnMod.agrMenuFrame;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.programPanel;

public class column {
	private panelBase panel;
	private fieldUlt fult = new fieldUlt();
	private JPopupMenu popup = new JPopupMenu();
	private JMenuItem[] popupItems = new JMenuItem[2];
	private ArrayList<JComponent> comps = new ArrayList<>();
	private ArrayList<block> blocks = new ArrayList<>();
	private ArrayList<boxMult> boxs = new ArrayList<>();
	private String name;
	private float totalValue;
	private int divisions;
	private int id = 0;
	private int y;
	
	public column(String name, int div, panelBase panel) {
		column c = this;
		this.name = name;
		this.divisions = div;
		this.panel = panel;
		
		popupItems[0] = new JMenuItem("Modificar");
		popupItems[1] = new JMenuItem("Eliminar");
		
		popupItems[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agrMenuFrame f = new agrMenuFrame(1);
				f.getPanel().setRenameState(true);
				f.getPanel().getField(0).setText(c.getName());
				f.getPanel().getField(1).setEnabled(false);
				f.getPanel().getField(1).setText("" + c.divisions); 
				programPanel.currentColumn = c;
			}
		});
		
		popupItems[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.remove();
			}
		});
		
		popup.add(popupItems[0]);
		popup.add(popupItems[1]);
	}
	
	public JPopupMenu getPopupMenu() {
		return this.popup;
	}
	
	public void addBlock() {
		blocks.add(new block(panel));
	}
	
	public void addBox(block block1, block block2) {
		boxMult b = new boxMult();
		b.setPanel(panel);
		b.setBlocks(block1, block2);
		b.initBox(y);
		boxs.add(b);
	}

	public void update() {
		for (block b : blocks) {
			b.update();
		}
		
		for (boxMult b : boxs) {
			b.calculateValue();
		}
		
		for (int i = 1; i < boxs.size(); i++) {
			boxs.get(i).setOperativeValue(boxs.get(i-1).getValue());
		}
		
		if (boxs.size() > 0) {
			totalValue = boxs.get(boxs.size() - 1).getValue();
		} else {
			totalValue =  blocks.get(0).getValue();
		}
		
		if (fult.getMode() == operations.NINGUNA) {
			fult.setValue(totalValue);
		}
		
		fult.update();
	}
	
	public void initColumn() {
		for (int i = 0; i < divisions / 2; i++) {
			this.addBlock();
		}
		
		for (int i = 0; i < blocks.size(); i++) {
			this.blocks.get(i).initBlock(32 , y, this);
		}
		
		for (int i = 1; i < blocks.size(); i++) {
			this.blocks.get(i).initBlock(32 + (i * blocks.get(i).getWidth()), y, this);
		}
		
		for (int i = 1; i < blocks.size(); i++) {
			this.addBox(blocks.get(i - 1), blocks.get(i));
		}
		
		for (int i = 1; i < boxs.size(); i++) {
			boxs.get(i).setOpertative(true);
		}
		
		for (block b: blocks) {
			b.addComps();
		}
		
		for (boxMult b : boxs) {
			b.addComps();
		}
		
		for (int i = 0; i < blocks.size(); i++) {
			for (int j = 0; j < 2; j++) {
				this.blocks.get(i).getField(j).initField(i, j);
			}
		}
		
		this.fult.initComp(blocks.get(blocks.size() - 1));
		this.fult.setColumn(this);
		panel.add(fult);
	}
	
	public void initComps() {
		for (int i = 0; i < blocks.size(); i++) {
			comps.addAll(blocks.get(i).getCompList());
		}
		
		for (int i = 0; i < boxs.size(); i++) {
			comps.add(boxs.get(i).getComponents());
		}
		
		for (JComponent x : comps) {
			x.setToolTipText(name);
			x.add(popup);
			x.setComponentPopupMenu(popup);
		}
	}
	
	public void updatePosition(int y) {
		this.y = y;
		
		for (block b : blocks) {
			b.updatePosition(y);
		}
		
		for (boxMult b : boxs) {
			b.updatePosition(y);
		}
		
		this.fult.setBounds(fult.getX(), y, fult.getWidth(), fult.getHeight());
	}
	
	public void setName(String text) {
		this.name = text;
		for (JComponent x : comps) {
			x.setToolTipText(name);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setID(int i) {
		this.id = i;
	}
	
	public int getID() {
		return this.id;
	}
	
	public fieldUlt getFult() {
		return this.fult;
	}
	
	public int getDivisions() {
		return this.divisions;
	}
	
	public float getTotalValue() {
		return this.totalValue;
	}
	
	private void remove() {
		panel.getColumnList().remove(this);
		
		for (JComponent f : comps) {
			panel.remove(f);
		}
		
		panel.remove(fult);
		panel.updatePositions();
	}
	
	public void clear() {
		for (block b : blocks) {
			b.clear();
		}
		
		for (boxMult b : boxs) {
			b.clear();
		}
		
		panel.remove(fult);
	}
	
	public column setPosition(int y) {
		this.y = y;
		this.initColumn();
		this.initComps();
		return this;
	}
	
	public block getBlock(int i) {
		return this.blocks.get(i);
	}
	
	public void draw() {
		Graphics g = panelBase.createGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(blocks.get(0).getX() - 32, y + 0, 32, 16);
		
		g.setColor(Color.WHITE);
		g.fillRect(blocks.get(0).getX() - 30, y + 2, 28, 12);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(panel.getFont().getName(), 0, 15));
		g.drawString("" + this.id, blocks.get(0).getX() - 30, y + 14);
		
	}
}
