package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauL4 extends JPanel{
	
	static String alors = "est en mode froid";
	
	public void paintComponent(Graphics g){              
		
	    Font font = new Font("Courier", Font.BOLD, 25);
	    g.setFont(font);
	    g.setColor(Color.BLACK);          
	    g.drawString("Actuelement le frigo "+ alors, 10, 20);
	    //System.out.println("ValuesL2: ");
	}
	
	static void setAlors(String newAlors){
		alors = newAlors;
	}


}
