import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class CViewStudents extends Frame implements ActionListener 
{
	TextArea t;
	Label l;
	Button bback;

	public CViewStudents() {
		super("View Students");
		l=new Label("Student Details ",Label.CENTER);
		bback= new Button("BACK TO HOME PAGE");
		t=new TextArea();
		t.setBounds(30,30,100,500);
		setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
		add(l);
		add(t);
		add(bback);
		bback.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		t.append("\n\tID\t Name\t DOB\t\t\t DOJ\n");
		 try
  			{
  			 Class.forName("oracle.jdbc.driver.OracleDriver");
 			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nanna533");
 			 PreparedStatement st=con.prepareStatement("select * from STUDENT");
 			 ResultSet rs=st.executeQuery();
  			 ResultSetMetaData rd=rs.getMetaData();
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
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bback) 
                  {
			SHome obj= new SHome();
			setVisible(false);
		}
	
	}
}

class MView
       {
	public static void main(String args[])
         {
		CViewStudents obj=new CViewStudents();
	}
}