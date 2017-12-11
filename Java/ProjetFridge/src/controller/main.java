package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import view.Fenetre;


public class main extends javax.swing.JFrame implements SerialPortEventListener  {
	   SerialPort serialPort;
	   public static String inputLine;
	   public static String all;
	   
	   public String getInputLine(){
			return inputLine;
		}
	   
	    private static final String PORT_NAMES[] = { 
	        "COM3", // com Arduino
	    };
	    BufferedReader input;  
	    private OutputStream output;   // The output stream to the port 
	    private static final int TIME_OUT = 2000; // Milliseconds to block while waiting for port open
	    private static final int DATA_RATE = 9600;  // vitesse de défilement arduino
	    public void initialize() {
	        CommPortIdentifier portId = null;
	        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

	        while (portEnum.hasMoreElements()) {   //identifie le port auquel on est connècté
	            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
	            for (String portName : PORT_NAMES) {
	                if (currPortId.getName().equals(portName)) {
	                    portId = currPortId;
	                    break;
	                }
	            }
	        }
	        if (portId == null) {
	            System.out.println("Could not find COM port.");
	            return;
	        }
	        try {          // open serial port, and use class name for the appName.
	            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
	            serialPort.setSerialPortParams(DATA_RATE,  // set port parameters
	                    SerialPort.DATABITS_8,
	                    SerialPort.STOPBITS_1,
	                    SerialPort.PARITY_NONE);

	            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));   // open the streams
	            output = serialPort.getOutputStream();
	            serialPort.addEventListener(this);   // add event listeners
	            serialPort.notifyOnDataAvailable(true);
	        } catch (Exception e) {
	            System.err.println(e.toString());
	        }}

	    public synchronized void close() {                      
	        if (serialPort != null) {
	            serialPort.removeEventListener();
	            serialPort.close();
	        }}

	    //Handle an event on the serial port. Read the data and print it.
	     
	    public synchronized void serialEvent(SerialPortEvent oEvent) {
	        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
	            try {
	            	/*int compteur = 0;
	            	compteur = compteur + 1;*/
	            	all = inputLine;
	            	inputLine=input.readLine();
	                System.out.println(inputLine);
	                all = all + inputLine;
	                //System.out.println("all : "+all);
	                Fenetre.TempWanted = Integer.parseInt(Fenetre.textField.getText());
	    			//System.out.println(textField.getText());
	                System.out.println(Fenetre.textField.getText());
	                Fenetre.panneau.repaint();
	          
	                //System.out.println("new call");
	                
	            } catch (Exception e) {
	                System.err.println(e.toString());
	            }
	        }
	        // Ignore all the other eventTypes, but you should consider the other ones.
	    }
	    Fenetre fenetre = new Fenetre();

	    public static void main(String[] args) throws Exception {
	        main main = new main();
	        main.initialize();
	        Thread t = new Thread() {
	            public void run() { //garde le programme actif pour 1000 seconds
	                //récupère données console arduino et les affiches
	                try {Thread.sleep(100000);/*System.out.println("Passage");*/} catch (InterruptedException ie) {}
	            }
	        };
	        t.start();
	        System.out.println("Started");
	    }
	}
