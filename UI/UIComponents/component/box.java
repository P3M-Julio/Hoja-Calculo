package Proyecto.T03.UI.UIComponents.component;

import javax.swing.JComboBox;

import Proyecto.T03.Util.operations;

@SuppressWarnings("serial")
public class box extends JComboBox<String> {
	private operations opMode = operations.SUMA;
	
	public box() {
		this.addItem("+");
		this.addItem("-");
		this.addItem("*");
		this.addItem("/");
		this.addItem("pow");
		this.addItem("sqrt");
	}
	
	public void update() {
		if (this.getSelectedItem() == this.getItemAt(0)) {
			this.opMode = operations.SUMA;
		} else if (this.getSelectedItem() == this.getItemAt(1)) {
			this.opMode = operations.RESTA;
		} else if (this.getSelectedItem() == this.getItemAt(2)) {
			this.opMode = operations.MULTIPLICACION;
		} else if (this.getSelectedItem() == this.getItemAt(3)) {
			this.opMode = operations.DIVISION;
		} else if (this.getSelectedItem() == this.getItemAt(4)) {
			this.opMode = operations.ELEVACION;
		} else if (this.getSelectedItem() == this.getItemAt(5)) {
			this.opMode = operations.RAIZ;
		}
	}
	
	public void setMode(operations opMode) {
		this.opMode = opMode;
	}
	
	public operations getMode() {
		return this.opMode;
	}
}
