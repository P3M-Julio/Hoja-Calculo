package Proyecto.T03.UI.UIComponents.component;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JTextField;

import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.Util.operations;

public class block {
	private int x;
	private int y;
	private float value;
	private panelBase panel;
	private fieldNum fields[] = new fieldNum[2];
	private ArrayList<JComponent> comps = new ArrayList<>();
	private box box = new box();
	
	public block(panelBase panel) {
		this.panel = panel;
	}
	
	public void initBlock(int x, int y, column column) {
		this.x = x;
		this.y = y;
		fields[0] = new fieldNum(column);
		fields[1] = new fieldNum(column);
		
		fields[0].setBounds(x, y, 64, 16);
		box.setBounds(fields[0].getX() + fields[0].getWidth(), y, 32, 16);
		fields[1].setBounds(box.getX() + box.getWidth(), y, 64, 16);
		
		this.comps.add(fields[0]);
		this.comps.add(fields[1]);
		this.comps.add(box);
	}
	
	public void addComps() {
		panel.add(fields[0]);
		panel.add(box);
		panel.add(fields[1]);
	}
	
	public void updatePosition(int y) {
		fields[0].setBounds(x, y, 64, 16);
		box.setBounds(fields[0].getX() + fields[0].getWidth(), y, 32, 16);
		fields[1].setBounds(box.getX() + box.getWidth(), y, 64, 16);
	}
	
	public int getWidth() {
		return this.fields[1].getX() + this.fields[1].getWidth();
	}
	
	public void clear() {
		for (JTextField f : fields) {
			panel.remove(f);
		}
		
		panel.remove(box);
	}
	
	public void update() {
		box.update();
		
		float n1 = getFieldValue(0);
		float n2 = getFieldValue(1);
			
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
		
		fields[1].setEnabled((box.getMode() == operations.RAIZ) ? false : true);
		
		fields[0].update();
		fields[1].update();
	}
	
	public float getValue() {
		return this.value;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public ArrayList<JComponent> getCompList() {
		return this.comps;
	}
	
	public float getFieldValue(int i) {
		if (this.fields[i].getText().length() > 0) {
			return Float.valueOf(this.fields[i].getText());
		} else {
			return 0;
		}
	}
	
	public fieldNum getField(int i) {
		return fields[i];
	}
}
