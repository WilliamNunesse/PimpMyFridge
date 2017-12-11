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
	private JLabel label = new JLabel("TempWanted :");
	static String TempWantedInter="18";
	public static JTextField textField = new JTextField(""+TempWantedInter);
	public static int TempWanted = 18;
	
	
	
	
	
	

	 
	public Fenetre(){
		/*System.out.println(values.getTempValueWanted());
		//values.setTempValueWanted(18);
		//System.out.println(values.getTempValueWanted());*/
		this.setTitle("FrigoUSB");
		this.setSize(900,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		boutonmoins.addActionListener(this);
		boutonplus.addActionListener(this);
		panneau.setLayout(new BoxLayout(panneau, BoxLayout.Y_AXIS));
		
		JPanel L1 = new JPanel();
		JPanel L1B = new JPanel();
		L1.setLayout(new BoxLayout(L1, BoxLayout.LINE_AXIS));
		L1.setBackground(Color.RED);

		textField.setPreferredSize(new Dimension(30, 30));
		textField.setForeground(Color.RED);
		
		L1.add(boutonmoins);
		L1.add(boutonplus);
		L1B.add(label);
		L1B.add(textField);
		panneau.add(L1);
		panneau.add(L1B);
		
		JPanel L2 = new JPanel();
		L2.setLayout(new BoxLayout(L2, BoxLayout.LINE_AXIS)); 
		Font font = new Font("Times", Font.BOLD, 20);
		L2.setFont(font);
		//L2.drawString(values.getTempValueWanted());
		panneau.add(L2);
		
		PanneauL2 L21 = new PanneauL2();
		panneau.add(L21);
		PanneauL3 L3 = new PanneauL3();
		panneau.add(L3);
		PanneauL4 L4 = new PanneauL4();
		panneau.add(L4);
		
		
		
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
		//TempWantedInter = textField.getText();
		//TempWantedInter = String.valueOf(TempWanted);
		if(TempWanted > 23){
			PanneauL4.setAlors("est en mode chaud");
		}
		else{
			PanneauL4.setAlors("est en mode froid");
		}
		panneau.repaint();
	}
	public void boutonMoinsM(){
		TempWanted = values.getTempValueWanted();
		//System.out.println(values.getTempValue());
		values.setTempValueWanted(TempWanted-1);
		TempWanted = values.getTempValueWanted();
		System.out.println("Nous sommes à "+values.getTempValueWanted());
		//System.out.println("Temp Nous sommes à "+TempWanted);
		//TempWantedInter = textField.getText();
		//TempWantedInter = String.valueOf(TempWanted);
		
		if(TempWanted > 23){
			PanneauL4.setAlors("est en mode chaud");
		}
		else{
			PanneauL4.setAlors("est en mode froid");
		}
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
		if(e.getSource() == textField){
			TempWanted = Integer.parseInt(textField.getText());
			System.out.println(textField.getText());
			panneau.repaint();
		}
		    
		
	}
}
