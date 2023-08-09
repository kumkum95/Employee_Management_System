package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tfusername,tfpassword;
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username=new JLabel("username");
        username.setBounds(40,20,100,30);
        add(username);
        
        tfusername=new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        JLabel password=new JLabel("password");
        password.setBounds(40,70,100,30);
        add(password);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/gu9.jpg"));
        Image i2=i1.getImage().getScaledInstance(128,128,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(10,10,850,200);
        add(image);
        
        
        JButton click=new JButton("Login");
        click.setBounds(150,140,150,30);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        add(click);
        click.addActionListener(this);
        
        setVisible(true);
        setSize(600,300);
        setLocation(450,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            String username=tfusername.getText();
            String password=tfpassword.getText();
            conn c=new conn();
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new home();
            }else{
            JOptionPane.showMessageDialog(null,"Invalid username or password");
            setVisible(false);
            new Login();
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
