package cisc275.group3.controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import cisc275.group3.scene.Scene;
import cisc275.group3.sceneobject.ToolCage;
import cisc275.group3.sceneobject.ToolCamera;
import cisc275.group3.sceneobject.ToolNet;
import cisc275.group3.sceneobject.ToolTrimmer;
import cisc275.group3.utility.EnumLayerCode;
import cisc275.group3.utility.EnumLayerCodeTutorial;
import cisc275.group3.utility.EnumSceneType;
import cisc275.group3.view.GameWindow;

/**
 * The Tools controller is responsible for both the "model" and control of the
 * toolbox.
 * <p>
 * The toolbox augments the mouse and sets a "click type" that can be checked
 * against the object type to determine compatibility. Because there is no
 * underlying model, the controller implements the corresponding logic.
 * <p>
 * ControllerTool.java
 * <p>
 * 
 * @author Scott
 * @author Jolyne
 */
public class ControllerTools extends ControllerScene {

	//JPanel and Buttons variables
	private JPanel toolPanel;
	private JButton netButton;
	private JButton cameraButton;
	private JButton cageButton;
	private JButton trimmerButton;
	private ImageIcon toolBg;

	/**
	 * Constructor
	 * 
	 * @param w
	 *            int-scene width
	 * @param h
	 *            int-scene height
	 * @param f
	 *            GameWindow-JFrame container
	 * @param cl
	 *            HashMap-associations of scene controllers and layers
	 * @param sceneType
	 *            EnumSceneType-type of scene to be constructed
	 */
	public ControllerTools(int w, int h, GameWindow f, HashMap<String, Component> cl, EnumSceneType sceneType) {
		super(w, h, f, cl, sceneType);
		toolBg = new ImageIcon("img/toolbox_open_menu_3.png");
	}

	@Override
	@SuppressWarnings("serial")
	protected void createScene() {
		Dimension toolSize = new Dimension(300, 300);
		toolPanel = new JPanel(true) {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(toolBg.getImage(), 0, 0, toolSize.width, toolSize.height, this);
			}
		};

		toolPanel.setLayout(null);
		toolPanel.setPreferredSize(toolSize);
		toolPanel.setBounds(SCREEN_WIDTH - toolSize.width - 120, -5, toolSize.width, toolSize.height);

		addToolButtons();

		if (sceneType == EnumSceneType.TUTORIAL) {
      mainPane.setLayer(toolPanel, EnumLayerCodeTutorial.ToolsPanelHidden.getCode());
      mainPane.add(toolPanel, EnumLayerCodeTutorial.ToolsPanelHidden.getCode());
		} else {
  		mainPane.setLayer(toolPanel, EnumLayerCode.Tools.getCode());
  		mainPane.add(toolPanel, EnumLayerCode.Tools.getCode());
		}

		// Set Tool Overlay Graphics
		toolOverlay();
		
		componentList.put("Tools", toolPanel);
	}

	/**
	 * Adds tool buttons for each individual tool to scene.
	 */
	private void addToolButtons() {
	  // Net Button and Tool
		netButton = new JButton();
		netButton.setBorderPainted(false);
		netButton.setBorder(null);
		netButton.setMargin(new Insets(0, 0, 0, 0));
		netButton.setContentAreaFilled(false);
		netButton.setIcon(new ImageIcon("img/toolPics/toolbar_net2.png"));
		netButton.setSize(50, 50);
		netButton.setBounds(60, 50, 50, 50);
		
		netButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		netButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component toolComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
				
				if (sceneType == EnumSceneType.TUTORIAL) {
          mainPane.setLayer(toolComponent, EnumLayerCodeTutorial.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolNet) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          } else {
            Scene.setCurrentTool(new ToolNet());
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_net2.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
          }
				} else {
  				mainPane.setLayer(toolComponent, EnumLayerCode.Tools.getCode());
  				if (Scene.getCurrentTool() instanceof ToolNet) {
  					Scene.setCurrentTool(null);
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
  				} else {
  					Scene.setCurrentTool(new ToolNet());
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_net2.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  				}
				}
			}
		});
		toolPanel.add(netButton);

		// Camera Button and Tool
		cameraButton = new JButton();
		cameraButton.setBorderPainted(false);
		cameraButton.setBorder(null);
		cameraButton.setMargin(new Insets(0, 0, 0, 0));
		cameraButton.setContentAreaFilled(false);
		cameraButton.setIcon(new ImageIcon("img/toolPics/toolbar_cam.png"));
		cameraButton.setSize(50, 50);
		cameraButton.setBounds(190, 50, 50, 50);
		;
		cameraButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		cameraButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component toolComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
				
				if (sceneType == EnumSceneType.TUTORIAL) {
          mainPane.setLayer(toolComponent, EnumLayerCodeTutorial.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolCamera) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          } else {
            Scene.setCurrentTool(new ToolCamera());
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_cam.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
          }
				} else {
  				mainPane.setLayer(toolComponent, EnumLayerCode.Tools.getCode());
  				if (Scene.getCurrentTool() instanceof ToolCamera) {
  					Scene.setCurrentTool(null);
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
  				} else {
  					Scene.setCurrentTool(new ToolCamera());
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_cam.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  				}
				}
			}
		});
		toolPanel.add(cameraButton);

		// Cage Button and Tool
		cageButton = new JButton();
		cageButton.setBorderPainted(false);
		cageButton.setBorder(null);
		cageButton.setMargin(new Insets(0, 0, 0, 0));
		cageButton.setContentAreaFilled(false);
		cageButton.setIcon(new ImageIcon("img/toolPics/toolbar_cage.png"));
		cageButton.setSize(50, 50);
		cageButton.setBounds(60, 170, 50, 50);
		;
		cageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		cageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component toolComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
				
				if (sceneType == EnumSceneType.TUTORIAL) {
          mainPane.setLayer(toolComponent, EnumLayerCodeTutorial.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolCage) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          } else {
            Scene.setCurrentTool(new ToolCage());
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_cage.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
          }
				} else {
  				mainPane.setLayer(toolComponent, EnumLayerCode.Tools.getCode());
  				if (Scene.getCurrentTool() instanceof ToolCage) {
  					Scene.setCurrentTool(null);
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
  				} else {
  					Scene.setCurrentTool(new ToolCage());
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_cage.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  				}
				}
			}
		});
		toolPanel.add(cageButton);

		// Trimmer Button and Tool
		trimmerButton = new JButton();
		trimmerButton.setBorderPainted(false);
		trimmerButton.setBorder(null);
		trimmerButton.setMargin(new Insets(0, 0, 0, 0));
		trimmerButton.setContentAreaFilled(false);
		trimmerButton.setIcon(new ImageIcon("img/toolPics/toolbar_trim.png"));
		trimmerButton.setSize(50, 50);
		trimmerButton.setBounds(190, 170, 50, 50);
		;
		trimmerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		trimmerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component toolComponent = mainPane
						.getComponentsInLayer(mainPane.getLayer(componentList.get("Tools")))[0];
				
				if (sceneType == EnumSceneType.TUTORIAL) {
			    mainPane.setLayer(toolComponent, EnumLayerCodeTutorial.Tools.getCode());
          if (Scene.getCurrentTool() instanceof ToolTrimmer) {
            Scene.setCurrentTool(null);
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
            mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
          } else {
            Scene.setCurrentTool(new ToolTrimmer());
            mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_trim.png"));
            mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
          }
				} else {
  				mainPane.setLayer(toolComponent, EnumLayerCode.Tools.getCode());
  				if (Scene.getCurrentTool() instanceof ToolTrimmer) {
  					Scene.setCurrentTool(null);
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_empty.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
  				} else {
  					Scene.setCurrentTool(new ToolTrimmer());
  					mouseLabel.setIcon(new ImageIcon("img/toolPics/mouse_trim.png"));
  					mouseLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
  				}
				}
			}
		});
		toolPanel.add(trimmerButton);
	}

	/**
	 * sets tool overlay
	 */
	private void toolOverlay() {
		mouseLabel = new JLabel(new ImageIcon("img/mouse_empty.png"));
		mouseLabel.setBounds(0, 0, 100, 100);
		mouseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		mainPane.setLayer(mouseLabel, JLayeredPane.MODAL_LAYER);
		mainPane.add(mouseLabel, JLayeredPane.MODAL_LAYER);

		componentList.put("MouseLabel", mouseLabel);

		if (sceneType == EnumSceneType.TUTORIAL) {
		  // Only add overlay to tutorial
		  componentList.get("Tutorial").addMouseMotionListener(new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
          mouseLabel.setLocation(e.getX() - 50, e.getY() - 50);
        }
      });
		} else {
		  // Add overlay to all game scenes
      componentList.get("Bay").addMouseMotionListener(new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
          mouseLabel.setLocation(e.getX() - 50, e.getY() - 50);
        }
      });
		
  		componentList.get("Beach").addMouseMotionListener(new MouseAdapter() {
  			@Override
  			public void mouseMoved(MouseEvent e) {
  				mouseLabel.setLocation(e.getX() - 50, e.getY() - 50);
  			}
  		});
  
  		componentList.get("Wetland").addMouseMotionListener(new MouseAdapter() {
  			@Override
  			public void mouseMoved(MouseEvent e) {
  				mouseLabel.setLocation(e.getX() - 50, e.getY() - 50);
  			}
  		});
		}
	}
}