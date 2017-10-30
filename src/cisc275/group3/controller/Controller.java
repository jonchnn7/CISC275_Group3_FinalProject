package cisc275.group3.controller;

import cisc275.group3.model.scene.BayScene;
import cisc275.group3.view.AlphaView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.w3c.dom.events.MouseEvent;


public class Controller implements MouseListener {
  
  AlphaView testView;
  BayScene testBay;
  
  private boolean click;	
	
  public Controller() {
    testView = new AlphaView(1280, 720);
    testBay = new BayScene("Bay", 0, 0, 1280, 720, true, true);
    //System.out.println(testBay);
    
    testView.updateObjects(testBay.getSceneItems());
    
    click = false;
	    
    testView.addMouseListener(this);
  }
	
  public static void main (String[] args) {
	  Controller c = new Controller();
  }

@Override
public void mouseClicked(java.awt.event.MouseEvent e) {
  testBay.processClick(e.getX(), e.getY());
  testView.updateObjects(testBay.getSceneItems());
  
}

@Override
public void mousePressed(java.awt.event.MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(java.awt.event.MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(java.awt.event.MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(java.awt.event.MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}