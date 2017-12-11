package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanneauL3 extends JPanel{
	
	public void paintComponent(Graphics g){                
	    Font font = new Font("Courier", Font.BOLD, 25);
	    g.setFont(font);
	    g.setColor(Color.BLACK);
	    //System.out.println("Tu commences a me les briser"+ controller.main.all);
	    g.drawString("Fridge : "+ controller.main.all, 50, 50);
	    //System.out.println("ValuesL2: ");
	}

}
