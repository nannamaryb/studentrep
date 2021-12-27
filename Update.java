import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class SUpdate extends Frame implements ActionListener
{
	Label no,name,doj;
	TextField tname,tno,tdoj,tdob;
	Button bupdate,back,view;
	public SUpdate()
	{
		super("Update");
		no = new Label("No:");
		name= new Label("Name");
		doj = new Label("DOJ");
		tno = new TextField(20);
		tname = new TextField(10);
		tdob = new TextField(10);
		tdoj = new TextField(10);
		bupdate = new Button("Update");
		back = new Button("Back");
		view = new Button("View");
		bupdate.addActionListener(this);
		back.addActionListener(this);
		view.addActionListener(this);
		setLayout(new FlowLayout());
		add(no);
		add(tno);
		add(name);
		add(tname);
		add(doj);
		add(tdoj);
		add(bupdate);
		add(back);
		add(view);
		setSize(500,500);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) 
	{
	   if(ae.getSource() == bupdate)
	   {
  	         try
		    {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nanna533");
			PreparedStatement stmt= con.prepareStatement("update STUDENT set STUDENT_NAME=(?),STUDENT_DOJ=(?) where STUDENT_NO=(?)");
	                stmt.setString(1,tname.getText());
			stmt.setString(2,tdoj.getText());
			stmt.setString(3,tno.getText());
			stmt.executeUpdate();
			SUpdate obj = new SUpdate();
			setVisible(false);
		     }
			catch(Exception e)
			{
				System.out.println(e);
			}
	     }
	     else if(ae.getSource() == back)
		{
			SHome obj = new SHome();
			setVisible(false);
		}
	
 	    else if(ae.getSource() == view)
		  {
		    CViewStudents obj=new CViewStudents();
		    setVisible(false);
		  }
	 }
}

class Update
{

	public static void main(String args[ ])
	{
	    SUpdate obj= new SUpdate();
        }
}
