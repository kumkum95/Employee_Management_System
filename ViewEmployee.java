package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice empid;
    JButton search,print,update,back;
    
    ViewEmployee(){
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table=new JTable();
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        JLabel sbn=new JLabel("Search by EmpID");
        sbn.setBounds(20,20,150,20);
        add(sbn);
        
        empid=new Choice();
        empid.setBounds(180,20,150,20);
        add(empid);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            while(rs.next()){
                empid.add(rs.getString("EmpID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        search=new JButton("search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        update=new JButton("upadte");
        update.setBounds(120,70,80,20);
        update.addActionListener(this);
        add(update);
        
        print=new JButton("print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        add(print);
        
        back=new JButton("back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employee where EmpID='"+empid.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(empid.getSelectedItem());
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new home();
        }
    }
    public static void main(String args[]){
        new ViewEmployee();
    }
}
