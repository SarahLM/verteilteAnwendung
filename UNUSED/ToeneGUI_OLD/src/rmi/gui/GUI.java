package rmi.gui;

import javax.sound.sampled.*;
import javax.swing.*;

import rmi.vermittler.ServerRemote;

import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Random;

public class GUI extends JFrame implements ActionListener {
	  JButton b1, b2, b3;

	  private static final long serialVersionUID = 1L;
	  
	  ServerRemote serverRemote;

	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        GUI app = new GUI();
	        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        app.startApp();
	      }
	    });
	  }


	  public GUI()
	  {
	    initGUI();
	  }
	  
	  private void startApp() {
		  try {
				serverRemote = (ServerRemote) Naming.lookup("rmi://localhost/ToeneService");
	    setVisible(true);
			} catch (Exception e) {
				System.out.println("RMI-interaces-client exception: " + e); }
		  }

	  private void initGUI() {
	    setLayout(new FlowLayout());
	    setSize(300, 200);
	    b1 = new JButton("Meeting");
	    b2 = new JButton("Mittagessen");
	    b3 = new JButton("Feierabend");
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    add(b1);
	    add(b2);
	    add(b3);
	  }

	  public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == b1) {
	    	try {
				serverRemote.play(1);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		//Sound.laser();
	    }
	    if (e.getSource() == b2) {
	    	try {
				serverRemote.play(2);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		//Sound.bang();

	    }
	    if (e.getSource() == b3) {
	    	try {
				serverRemote.play(3);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		//Sound.warp();
	    }
	  }
	}