package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cempid;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
        setLayout(null);
        
        JLabel empid=new JLabel("Employee ID");
        empid.setBounds(50,50,100,30);
        add(empid);
        
        cempid=new Choice();
        cempid.setBounds(200,50,100,30);
        add(cempid);
        
        JLabel ename=new JLabel("Name");
        ename.setBounds(50,100,100,30);
        add(ename);
        
        JLabel lname=new JLabel();
        lname.setBounds(200,100,100,30);
        add(lname);
        
        JLabel ephone=new JLabel("Phone");
        ephone.setBounds(50,150,100,30);
        add(ephone);
        
        JLabel lphone=new JLabel();
        lphone.setBounds(200,150,100,30);
        add(lphone);
        
        JLabel eemail=new JLabel("Email");
        eemail.setBounds(50,200,100,30);
        add(eemail);
        
        JLabel lemail=new JLabel();
        lemail.setBounds(200,200,200,30);
        add(lemail);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee where EmpID='"+cempid.getSelectedItem()+"'");
            while(rs.next()){
                lname.setText(rs.getString("name"));
                lphone.setText(rs.getString("phone"));
                lemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from employee where EmpID='"+cempid.getSelectedItem()+"'");
                    while(rs.next()){
                        lname.setText(rs.getString("name"));
                        lphone.setText(rs.getString("phone"));
                        lemail.setText(rs.getString("email"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/guu.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,232,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                conn c=new conn();
                c.s.executeUpdate("delete from employee where EmpID='"+cempid.getSelectedItem()+"'");
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
                setVisible(false);
                new home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new home();
        }
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
}
