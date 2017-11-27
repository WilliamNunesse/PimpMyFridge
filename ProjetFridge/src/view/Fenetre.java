package view;

import model.Values;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame implements ActionListener{
	
	
	public static Panneau panneau = new Panneau();
	private Button boutonplus = new Button("Bouton +");
	private Button boutonmoins = new Button("Bouton -");
	public Values values = new Values();
	
	static int TempWanted = 18;
	

	 
	public Fenetre(){
		/*System.out.println(values.getTempValueWanted());
		//values.setTempValueWanted(18);
		//System.out.println(values.getTempValueWanted());*/
		this.setTitle("FrigoUSB");
		this.setSize(900,1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		boutonmoins.addActionListener(this);
		boutonplus.addActionListener(this);
		panneau.setLayout(new BoxLayout(panneau, BoxLayout.Y_AXIS));
		
		JPanel L1 = new JPanel();
		L1.setLayout(new BoxLayout(L1, BoxLayout.LINE_AXIS));
		//L1.setBackground(Color.RED);
		L1.add(boutonmoins);
		L1.add(boutonplus);
		panneau.add(L1);
		
		/*JPanel L2 = new JPanel();
		L2.setLayout(new BoxLayout(L2, BoxLayout.LINE_AXIS)); 
		Font font = new Font("Times", Font.BOLD, 20);
		L2.setFont(font);
		L2.drawString(values.getTempValueWanted());
		panneau.add(L2);*/
		
		PanneauL2 L2 = new PanneauL2();
		panneau.add(L2);
		PanneauL3 L3 = new PanneauL3();
		panneau.add(L3);
		
		this.setContentPane(panneau);
		this.setVisible(true);
	}
	public void boutonPlusP(){
		TempWanted = values.getTempValueWanted();
		//System.out.println(values.getTempValue());
		values.setTempValueWanted(TempWanted+1);
		TempWanted = values.getTempValueWanted();
		System.out.println("Nous sommes à "+values.getTempValueWanted());
		//System.out.println("Temp Nous sommes à "+TempWanted);
		panneau.repaint();
	}
	public void boutonMoinsM(){
		TempWanted = values.getTempValueWanted();
		//System.out.println(values.getTempValue());
		values.setTempValueWanted(TempWanted-1);
		TempWanted = values.getTempValueWanted();
		System.out.println("Nous sommes à "+values.getTempValueWanted());
		//System.out.println("Temp Nous sommes à "+TempWanted);
		panneau.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == boutonplus){
			boutonPlusP();
		}
		if(e.getSource() == boutonmoins){
			boutonMoinsM();
		}
		    
		
	}
}
