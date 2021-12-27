import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class SDelete extends Frame implements ActionListener 
{
	List students;
	Button bsel,bdel,bview;
	TextField t;

	public SDelete() {
		super("Delete Students");
		students=new List(10);		
		t=new TextField(30);
		bsel=new Button("Select the row to be Deleted");
		bdel= new Button("Delete");
		bview= new Button("View Students");
		setLayout(new FlowLayout());
		add(students);
		add(bsel);
		add(t);
		add(bdel);
		add(bview);
		bsel.addActionListener(this);
		bdel.addActionListener(this);
		bview.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nanna533");
			PreparedStatement stmt=con.prepareStatement("select * from STUDENT"); 			
			students.add("\n \t ID \t Name \t \t DOB \t DOJ \n");;	
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				String id=Integer.toString(rs.getInt("STUDENT_NO"));
				String name=rs.getString("STUDENT_NAME");
				String dob=rs.getString("STUDENT_DOB");
				String doj=rs.getString("STUDENT_DOJ");
				students.add("      "+id+"         -        "+name+"      -      "+dob+"      -      "+doj);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bsel) {
			t.setText(students.getSelectedItem());	
		}
		else if(ae.getSource()==bdel) {
			String str=t.getText();
			str = str.replaceAll("\\s", "");
			String s[]= str.split("-");
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","nanna533");
				PreparedStatement stmt=con.prepareStatement("delete from STUDENT where STUDENT_NO=?"); 
				System.out.println("Id: "+Integer.parseInt(s[0])+" Deleted");
				stmt.setInt(1,Integer.parseInt(s[0]));
				stmt.execute();
				SDelete obj=new SDelete();
				setVisible(false);
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()==bview) {

			CViewStudents obj = new CViewStudents();
			setVisible(false);
		}	
	}
}

class Delete
{
	public static void main(String args[]) {

		SDelete obj=new SDelete();
	}
}