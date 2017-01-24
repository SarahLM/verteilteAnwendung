package rmi.mitarbeiter;

import javax.sound.sampled.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.rmi.Remote;
import java.util.Random;
import java.rmi.server.UnicastRemoteObject;

public class Sound implements Remote {
	private static final long serialVersionUID = 1L;
	
	 public void run(int ID) {
		 
		  
		  switch(ID)
		  {
		  case 1:
			  InputStream is = getClass().getResourceAsStream("imperial_march.wav");
				try {
					javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);

					javax.sound.sampled.Clip clip = AudioSystem.getClip();;
					clip.open(audioInputStream);
					clip.start();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			  break;
	    
	    
		  case 2:
			  InputStream is2 = getClass().getResourceAsStream("Sarafina.wav");
				try {
					javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is2);

					javax.sound.sampled.Clip clip = AudioSystem.getClip();;
					clip.open(audioInputStream);
					clip.start();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			  break;
		  case 3:
			  InputStream is3 = getClass().getResourceAsStream("push_it.wav");
				try {
					javax.sound.sampled.AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is3);

					javax.sound.sampled.Clip clip = AudioSystem.getClip();;
					clip.open(audioInputStream);
					clip.start();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			  break;
	   
		  }
	  }
}

