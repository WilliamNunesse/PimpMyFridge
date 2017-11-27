package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;




public class PanneauL2 extends JPanel{
	
	
	public void paintComponent(Graphics g){                
	    Font font = new Font("Courier", Font.BOLD, 25);
	    g.setFont(font);
	    g.setColor(Color.BLACK);          
	    g.drawString("La température que vous désirez actuelement est : "+ Fenetre.TempWanted, 10, 20);
	    //System.out.println("ValuesL2: ");
	}

}
