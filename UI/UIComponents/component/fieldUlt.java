package Proyecto.T03.UI.UIComponents.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import Proyecto.T03.UI.UIComponents.Panels.fuMenu.fuMenuFrame;
import Proyecto.T03.Util.operations;
import Proyecto.T03.main.programPanel;

@SuppressWarnings("serial")
public class fieldUlt extends JTextField {
	private JPopupMenu PMO = new JPopupMenu();
	private JMenuItem items[] =  {new JMenuItem("Modificar")};
	private fuMenuFrame frame = new fuMenuFrame();
	private column column;
	private float value;
	private int div;
	private operations mode = operations.NINGUNA;
	private operations varMode = operations.NINGUNA;
	
	public fieldUlt() {
		PMO.add(items[0]);
		items[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				programPanel.currentColumn = column;
			}
		});
		
		this.setComponentPopupMenu(PMO);
		this.setEditable(false);
	}
	
	public void update() {
		this.frame.update();
		
		if (column != null) {
			div = column.getDivisions();
			
			try {
				switch (mode) {
					case NINGUNA :
						this.value = column.getTotalValue();
						break;
					case MINIMO :
						float min = column.getBlock(0).getFieldValue(0);
						
						for (int i = 0; i < div; i++) {
							for (int j = 0; j < 2; j++) {
								if (column.getBlock(i/2).getFieldValue(j) < min) {
									min = column.getBlock(i/2).getFieldValue(j);
								}
							}
						}
						
						this.value = min;
						break;
					case MAXIMO :
						float max = 0;
						
						for (int i = 0; i < div; i++) {
							for (int j = 0; j < 2; j++) {
								if (column.getBlock(i/2).getFieldValue(j) > max) {
									max = column.getBlock(i/2).getFieldValue(j);
								}
							}
						}
						
						this.value = max;
						break;
					case PROMEDIO :
						float f = column.getTotalValue();
						this.value = (float) (f / div);
						break;
					case VARIABLE :
						if (varMode == operations.ASSIGNACION) {
							programPanel.vars.replace(frame.getPanel().getVar(), column.getTotalValue());
						}
						
						this.value = column.getTotalValue();
						break;
					default :
						
						break;
				}
			} catch(Exception e) {}
			
			if (mode != operations.NINGUNA || varMode != operations.ASSIGNACION) {
				this.setText("" + value);
			}
			
			if (varMode == operations.ASSIGNACION) {
				this.setText(programPanel.varsName.get(frame.getPanel().getVarIndex()) + " : "+ value);
			}
		}
	}
	
	public void setColumn(column c) {
		this.column = c;
		this.frame.getPanel().setColumn(column);
	}
	
	public void setDivisions(int div) {
		this.div = div;
	}
	
	public void setMode(operations mode) {
		this.mode = mode;
	}
	
	public void setVarMode(operations mode) {
		this.varMode = mode;
	}
	
	public operations getMode() {
		return this.mode;
	}
	
	public float getValue() {
		return this.value;
	}
	
	public void initComp(block block) {
		this.setBounds(block.getWidth(), block.getY(), 128, 16);
	}
	
	public void setValue(float f) {
		this.setText("" + f);
	}
}
