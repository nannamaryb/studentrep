import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class SHome extends Frame implements ActionListener
{
	Button badd,bdelete,bexit,bupdate,bview,bfind;
	public SHome()
	{
		badd = new Button("Add");
		bdelete = new Button("Delete");
		bupdate = new Button("Update");
		bview = new Button("View");
		bfind = new Button("Find");
		bexit = new Button("exit");
		badd.addActionListener(this);
		bdelete.addActionListener(this);
		bview.addActionListener(this);
		bfind.addActionListener(this);
		bexit.addActionListener(this);
		bupdate.addActionListener(this);
		setLayout(new GridLayout(4,2));
		add(badd);
		add(bdelete);
		add(bupdate);
		add(bview);
		add(bfind);
		add(bexit);
		setSize(500,500);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == bexit) 
		{
			System.exit(0);
		}

		   
		  if(ae.getSource() == badd)
		  {
		   	SAdd obj = new SAdd();
			setVisible(false);
		  }
		  else if(ae.getSource() == bdelete)
		  {
		    SDelete obj=new SDelete();
		    setVisible(false);
		  }	
		else if(ae.getSource() == bview)
		  {
		    CViewStudents obj=new CViewStudents();
		    setVisible(false);
		  }

		  else if(ae.getSource() == bupdate)
		  {
		        SUpdate obj = new SUpdate();
			setVisible(false);
		  }	
		    else if(ae.getSource() == bfind)
		  {
		        SFind obj = new SFind();
			setVisible(false);
		  }
        }		  
  }

class MHome
{
	public static void main(String args[])
	{
		SHome obj;
		obj = new SHome();
	}
}

