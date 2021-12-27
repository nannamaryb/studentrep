import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class SFind extends Frame implements ActionListener
{
	Label no,l;
	TextArea t;
	TextField tno;
	Button bfind,back;
	public SFind()
	{
		super("Find");
		l=new Label("Student Details ",Label.CENTER);
		no = new Label("No:");
		tno = new TextField(10);
		bfind = new Button("Find");
		back = new Button("back");
		t=new TextArea();
		t.setBounds(30,30,100,500);
		setLayout(new FlowLayout());
		add(no);
		add(tno);
		add(bfind);
		add(l);
		add(t);
		add(back);
		bfind.addActionListener(this);
		back.addActionListener(this);
		setSize(500,500);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{

		  if(ae.getSource() == bfind)
		  {

		 	try
  			{
  			 Class.forName("oracle.jdbc.driver.OracleDriver");
 			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nanna533");
 			 PreparedStatement st=con.prepareStatement("select * from STUDENT where STUDENT_NO=(?)");
			 st.setString(1,tno.getText());
 			 ResultSet rs=st.executeQuery();
			  while(rs.next())
			  {
				String sno=rs.getString("STUDENT_NO");
				String sname=rs.getString("STUDENT_NAME");
				String sdob=rs.getString("STUDENT_DOB");
				String sdoj=rs.getString("STUDENT_DOJ");
				t.append("\t"+sno+"\t"+sname+"\t"+sdob+"\t"+sdoj+"\n");

 			  }
                	}
 			catch(Exception ex)
 			{
 			 System.out.println(ex);
 			} 
		 }
		else if(ae.getSource() == back)
		{
			SHome obj=new SHome();
			setVisible(false);
		}
        }		  
  }

class Find
{
	public static void main(String args[])
	{
		SFind obj;
		obj = new SFind();
	}
}

