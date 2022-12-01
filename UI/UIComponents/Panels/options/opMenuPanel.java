package Proyecto.T03.UI.UIComponents.Panels.options;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import Proyecto.T03.UI.UIBase.panels.panelBase;
import Proyecto.T03.Util.actionClicked;

@SuppressWarnings("serial")
public class opMenuPanel extends panelBase {
	private opMPVars sbVars;
	private opMPMembers sbMembers;
	
	public opMenuPanel(Dimension size) {
		super(size);
		sbVars = new opMPVars(size);
		sbVars.setBounds(130, 0, sbVars.getWidth(), sbVars.getHeight());
		
		sbMembers = new opMPMembers(this.getSize());
		sbMembers.setBounds(130, 0, sbVars.getWidth(), sbVars.getHeight());
		sbMembers.setVisible(false);
		
		this.add(sbVars);
		this.add(sbMembers);
		this.addButton(15, 20, 85, 25).setButtonText("Variables").setFontSize(10);
		this.addButton(15, 40 + this.getButton(0).getHeight(), 85, 25).setButtonText("Integrantes").setFontSize(9);
		this.addButton(15, 420, 85, 25).setButtonText("Cerrar").setFontSize(10);
		this.initComponents();
	}
	
	@Override
	protected void draw() {
		Graphics g = createGraphics();
		g.setColor(new Color(100, 100, 100, 100));
		g.fillRect(110, 10, 10, 440);
	}
	
	public void update() {
		this.sbVars.update();
	}
	
	@Override
	protected void action(ActionEvent e) {
	}
	
	public void initComponents() {
		super.initComponents();
		
		this.getButton(0).setActionClicked(new actionClicked() {
			public void start() {
				sbVars.setVisible((sbVars.isVisible()) ? false : true);
				sbMembers.setVisible(false);
			}
		});
		
		this.getButton(1).setActionClicked(new actionClicked() {
			public void start() {
				sbVars.setVisible(false);
				sbMembers.setVisible((sbMembers.isVisible()) ? false : true);
			}
		});
	}
}
