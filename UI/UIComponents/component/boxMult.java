package Proyecto.T03.UI.UIComponents.component;

import javax.swing.JComponent;

import Proyecto.T03.UI.UIBase.panels.panelBase;

public class boxMult {
	private int x;
	private float value;
	public float opValue;
	public boolean operative;
	
	private block block[] = new block[2];
	private box box = new box();
	private panelBase panel;
	
	public boxMult() {
	}
	
	public void setPanel(panelBase panel) {
		this.panel = panel;
	}
	
	public void initBox(int y) {
		x = block[0].getWidth();
		this.box.setBounds(x, y, 32, 16);
	}
	
	public void addComps() {
		panel.add(box);
	}
	
	public int getX() {
		return this.x;
	}
	
	public JComponent getComponents() {
		return this.box;
	}
	
	public void clear() {
		panel.remove(box);
	}
	
	public void setOpertative(boolean flag) {
		operative = flag;
	}
	
	public void updatePosition(int y) {
		this.box.setBounds(x, y, 32, 16);
	}
	
	public void calculateValue() {
		box.update();
		float n1 = block[0].getValue();
		float n2 = block[1].getValue();
		
		if (operative) { 
			n1 = opValue;
			n2 = block[1].getValue();
		}
		
		switch (box.getMode()) {
			case SUMA :
				value = n1 + n2;
				break;
			case RESTA :
				value = n1 - n2;
				break;
			case MULTIPLICACION :
				value = n1 * n2;
				break;
			case DIVISION :
				value = n1 / n2;
				break;
			case ELEVACION :
				value = (float) Math.pow((double) n1, (double) n2);
				break;
			case RAIZ :
				value = (float) Math.sqrt((double) n1);
				break;
		default:
			break;
		}
	}
	
	public float getOperativeValue() {
		return opValue;
	}
	
	public float getValue() {
		return value;
	}
	
	public block getBlock(int i) {
		return block[i];
	}
	
	public void setOperativeValue(float f) {
		this.opValue = f;
	}
	
	public void setBlocks(block b, block b2) {
		this.block[0] = b;
		this.block[1] = b2;
	}
}
