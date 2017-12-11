package view;

import java.awt.Image;

import javax.swing.JButton;


public class Button extends JButton{
	
	private String name;
	private Image img;
	
	public Button(String buttonname){
		super(buttonname);
		this.name = buttonname;
}	
}


