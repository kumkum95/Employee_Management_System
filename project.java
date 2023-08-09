package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class project extends JFrame implements ActionListener{
    project(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serit",Font.PLAIN,60));
        heading.setForeground(Color.RED);
        setSize(1170,650);
        setLocation(250,50);
        setVisible(true);
        add(heading);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/gu5.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        JButton clickhere=new JButton("Click here to continue");
        clickhere.setBounds(400,400,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        image.add(clickhere);
        clickhere.addActionListener(this);
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }
    public static void main(String args[]){
         new project();
    }
}
