package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class AddEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JLabel heading,name,fname,dobname,salary,address,phone,email,higheste,desig,adn,eid,tfeid;
    JTextField tffname,tfname,tfsalary,tfaddress,tfphone,tfemail,tfdesig,tfadn;
    JComboBox tfhe;
    JDateChooser dcdob;
    JButton add,add1;
    AddEmployee(){
        setSize(900,700);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading=new JLabel("Add employee deatils");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("serif",Font.PLAIN,20));
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        dobname=new JLabel("DOB");
        dobname.setBounds(50,200,150,30);
        dobname.setFont(new Font("serif",Font.PLAIN,20));
        add(dobname);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,20));
        add(salary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        address=new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("serif",Font.PLAIN,20));
        add(address);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        phone=new JLabel("Phone no.");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("serif",Font.PLAIN,20));
        add(phone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        email=new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("serif",Font.PLAIN,20));
        add(email);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        higheste=new JLabel("Highest Education");
        higheste.setBounds(400,300,150,30);
        higheste.setFont(new Font("serif",Font.PLAIN,20));
        add(higheste);
        
        String courses[]={"BBA","BCA","BSC","BTECH","B.COM","MBA","MCA","MTECH","MSC","M.COM","PHD"};
        tfhe=new JComboBox(courses);
        tfhe.setBackground(Color.WHITE);
        tfhe.setBounds(600,300,150,30);
        add(tfhe);
        
        desig=new JLabel("Designation");
        desig.setBounds(50,350,150,30);
        desig.setFont(new Font("serif",Font.PLAIN,20));
        add(desig);
        
        tfdesig=new JTextField();
        tfdesig.setBounds(200,350,150,30);
        add(tfdesig);
        
        adn=new JLabel("Aadhar Number");
        adn.setBounds(400,350,150,30);
        adn.setFont(new Font("serif",Font.PLAIN,20));
        add(adn);
        
        tfadn=new JTextField();
        tfadn.setBounds(600,350,150,30);
        add(tfadn);
        
        eid=new JLabel("Employee ID");
        eid.setBounds(50,400,150,30);
        eid.setFont(new Font("serif",Font.PLAIN,20));
        add(eid);
        
        tfeid=new JLabel(""+number);
        tfeid.setBounds(200,400,150,30);
        add(tfeid);
        
        add=new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        add1=new JButton("back");
        add1.setBounds(450,550,150,40);
        add1.setBackground(Color.BLACK);
        add1.setForeground(Color.WHITE);
        add1.addActionListener(this);
        add(add1);
        
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String)tfhe.getSelectedItem();
            String designation=tfdesig.getText();
            String aadhar=adn.getText();
            String empId=tfeid.getText();
            
            try{
                conn con=new conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
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
        new AddEmployee();
    }
}
