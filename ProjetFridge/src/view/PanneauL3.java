package view;

import controller.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanneauL3 extends JPanel{
	
	public void paintComponent(Graphics g){                
	    Font font = new Font("Courier", Font.BOLD, 25);
	    g.setFont(font);
	    g.setColor(Color.BLACK);          
	    g.drawString("Fridge : "+ main.inputLine, 20, 25);
	    //System.out.println("ValuesL2: ");
	}

}
