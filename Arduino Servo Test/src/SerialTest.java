import java.io.BufferedReader;                    
import java.io.InputStreamReader;         
import java.io.OutputStream;        
import gnu.io.CommPortIdentifier;           
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;   
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;
import gnu.io.PortInUseException;     
import java.io.IOException;
import gnu.io.UnsupportedCommOperationException;
import processing.core.PApplet;

import java.util.TooManyListenersException;
import java.util.Scanner;                   

public class SerialTest extends PApplet implements SerialPortEventListener {        
   
    private static SerialPort serialPort ;         
    private CommPortIdentifier portId  = null;       
    private static final int TIME_OUT = 2000;    
    private static final int BAUD_RATE = 9600; 
    private BufferedReader input;               
    private OutputStream output;                
    private String name;        
    Scanner inputName;
 

    private void initialize(){
        CommPortIdentifier ports = null;     
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers(); 
        while(portEnum.hasMoreElements()){  //browse through available ports
                ports = (CommPortIdentifier)portEnum.nextElement();
               if(ports.getPortType() == CommPortIdentifier.PORT_SERIAL&&ports.getName().equals("COM4")){ 

                System.out.println("COM port found:COM4");
                portId = ports;                  //initialize
                break;                                                                                     }
           
            }
        if(portId==null){
            System.out.println("COM port not found");
            System.exit(1);
        }
    }
    private void portConnect(){
        //connect to port
        try{
         serialPort = (SerialPort)portId.open(this.getClass().getName(),TIME_OUT);  
                                                                                  
                                                                               
        System.out.println("Port open succesful: COM6"); 
        
    
        serialPort.setSerialPortParams(BAUD_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
        
        

        }
        catch(PortInUseException e){
            System.out.println("Port already in use");
            System.exit(1);
        }
        catch(NullPointerException e2){
            System.out.println("COM port maybe disconnected");
        }
        catch(UnsupportedCommOperationException e3){
            System.out.println(e3.toString());
            
        }
       

        try{

       input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output =  serialPort.getOutputStream();

        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
        serialPort.notifyOnOutputEmpty(true);
        }
        catch(Exception e){
            System.out.println(e.toString());
                            }
        
    }

   
    public void serialEvent(SerialPortEvent evt) { 
   
       if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) { 
   try {
    String inputLine=input.readLine();
    System.out.println(inputLine);
                                //inputName = new Scanner(System.in); 
                                //name = inputName.nextLine();
                               // name = name + '\n';
                               // System.out.printf("%s",name);
                               // output.write(name.getBytes());     
   } catch (Exception e) {
    System.err.println(e.toString());
   }
  }
       
    }

    private void close(){
        if(serialPort!=null){
            serialPort.close(); 
        }
        input = null;       
        output = null;
    }
    public static void main(String[] args) {
        SerialTest myTest = new SerialTest();  
        myTest.initialize();
        myTest.portConnect();

		try {
			if(serialPort.getOutputStream().equals("Hi")) {
				System.out.println("wow it worked");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
       System.out.println("Started");
       while(1>0);
        
       
      }
    
}