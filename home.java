package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class home extends JFrame implements ActionListener{
    JButton add,add1,add2,add3;
    home(){
        setLayout(null);
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/gu4.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        
        add=new JButton("add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        add(add);
        
        add1=new JButton("view Employees");
        add1.setBounds(820,80,150,40);
        add1.addActionListener(this);
        add(add1);
        
        add2=new JButton("update Employee");
        add2.setBounds(650,140,150,40);
        add2.addActionListener(this);
        add(add2);
        
        add3=new JButton("remove Employee");
        add3.setBounds(820,140,150,40);
        add3.addActionListener(this);
        add(add3);
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible (true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()==add1){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()==add2){
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String args[]){
        new home();
    }
    
}
