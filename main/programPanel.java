package Proyecto.T03.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

import Proyecto.T03.UI.UIComponents.Panels.columnMod.agrMenuFrame;
import Proyecto.T03.UI.UIComponents.Panels.options.opMenuFrame;
import Proyecto.T03.UI.UIComponents.Panels.varMenu.vmMenuFrame;
import Proyecto.T03.UI.UIComponents.component.column;
import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.Util.actionClicked;

@SuppressWarnings("serial")
public class programPanel extends panelBase {
	public static column currentColumn;
	public static HashMap<String, Float> vars = new HashMap<>();
	public static ArrayList<String> varsName = new ArrayList<>();
	private opMenuFrame opMF;
	
	public programPanel(Dimension size) {
		super(size);
		this.addMenuOption("Ventana").addItem("Opciones").addItem("Limpiar ventana");
		this.getPopupMenu().addItem("Agregar columna");
		this.getPopupMenu().addItem("Agregar variable");
		for (int i = 0; i < 1; i++) {
			this.addColumn("Slot-"+i, 6);
		}
		this.add(this.getMenuBar());
		this.add(this.getPopupMenu());
		this.setComponentPopupMenu(this.getPopupMenu());
		
		this.update();
		this.initComponents();
	}
	
	public void update() {
		super.update();
		try {
			opMF.update();
			
		} catch(Exception e) {}
	}
	
	public void draw() {
	}
	
	public void action(ActionEvent e) {
	}
	
	public void initComponents() {
		super.initComponents();
		panelBase b = this;
		this.getPopupMenu().getItem(0).setActionClicked(new actionClicked() {
			public void start() {
				new agrMenuFrame(0);
			}
		});
		
		this.getPopupMenu().getItem(1).setActionClicked(new actionClicked() {
			public void start() {
				new vmMenuFrame();
			}
		});
		
		this.getMenuOption(0).getItem(0).setActionClicked(new actionClicked() {
			public void start() {
				opMF = new opMenuFrame();
			}
		});
		
		this.getMenuOption(0).getItem(1).setActionClicked(new actionClicked() {
			public void start() {
				int i = b.showMessageWarning("Esta seguro de limpiar toda la pantalla?");
				
				if (i == 0) {
					b.clear();
				}
			}
		});
	}
}
