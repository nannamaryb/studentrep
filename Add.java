import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class SAdd extends Frame implements ActionListener
{
	Label no,name,dob,doj;
	TextField tname,tno,tdoj,tdob;
	Button badd,back;
	public SAdd()
	{
		super("Add");
		no = new Label("No:");
		name= new Label("Name");
		dob = new Label("DOB");
		doj = new Label("DOJ");
		tno = new TextField(20);
		tname = new TextField(10);
		tdob = new TextField(10);
		tdoj = new TextField(10);
		badd = new Button("Add");
		back = new Button("Back");
		badd.addActionListener(this);
		back.addActionListener(this);
		setLayout(new FlowLayout());
		add(no);
		add(tno);
		add(name);
		add(tname);
		add(dob);
		add(tdob);
		add(doj);
		add(tdoj);
		add(badd);
		add(back);
		setSize(500,500);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{

		  
		if(ae.getSource() == back)
		{
			SHome obj = new SHome();
			setVisible(false);
		}

		else if(ae.getSource() == badd)
		{  
                        SAdd obj = new SAdd();
			setVisible(false);

		    try
		    {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nanna533");
   			PreparedStatement stmt1 = con.prepareStatement("insert into STUDENT values(?,?,?,?)");
			stmt1.setString(1,tno.getText());
			stmt1.setString(2,tname.getText());
			stmt1.setString(3,tdob.getText());
			stmt1.setString(4,tdoj.getText());
			stmt1.execute();
			System.out.println("Added Successfully");
   
		     }

			catch(Exception e)
			{
				System.out.println(e);
			}

		}
		else 
		{
			System.exit(0);
		}
        }		  
  }

class Add
{
	public static void main(String args[])
	{
		SAdd obj;
		obj = new SAdd();
	}
}

