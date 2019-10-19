package kakaoTalk;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Kakao5 extends JFrame {

Kakao5(){
      setTitle("카카오톡");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container container = getContentPane();
      container.setBackground(Color.YELLOW);
      container.setLayout(null);
      JTextArea textarea = new JTextArea(100,100);
      textarea.setBackground(Color.YELLOW);
      JScrollPane scroll = new JScrollPane(textarea);
      JTextField textfield = new JTextField(100);
      JButton button = new JButton("전송");
      button.setBackground(Color.YELLOW);
      button.setBackground(Color.YELLOW);
      container.add(textfield);
      container.add(button);
      textfield.setBounds(5,450,245,80);
      button.setBounds(250,450,70,80);
      scroll.setBounds(10,30,310,400);
      container.add(scroll);
      
      FileReader in = null;
      
      try
      {
    	  in = new FileReader("c:\\Temp\\test.txt");
    	  int c;
    	  while ((c = in.read()) != -1){
    		  textarea.append((char)c + "");
    	  }
    	  in.close();
      }
      catch(IOException e){
    	  
      }
      
      textfield.addActionListener(new ActionListener(){
          FileWriter fout = null;
         public void actionPerformed(ActionEvent e){
        	 
             String t = textfield.getText();
             textarea.append("\n"+t);
             textfield.setText(""); 

  
            try{
            	fout = new FileWriter("c:\\Temp\\test.txt",true);
            	fout.write("\r\n"+t); 
            	fout.close();
            }
            catch(IOException e1){
          	  
            }
            
         }
      });
      
      button.addActionListener(new ActionListener(){
    	  FileWriter fout = null;
    	  public void actionPerformed(ActionEvent e){
      
              String t = textfield.getText();
              textarea.append("\n"+t);
              textfield.setText(""); 

    		  
      
              try{
              	fout = new FileWriter("c:\\Temp\\test.txt",true);
              	fout.write("\r\n"+t); 
              	fout.close();
              }
              catch(IOException e1){
            	  
              }
    	
      }
      });
      

    		       
      setSize(350,600);
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new Kakao5();
   }
}
