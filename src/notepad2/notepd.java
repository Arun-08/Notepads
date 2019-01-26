package notepad2;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
public class notepd extends Frame implements ActionListener 
{
	MenuBar mb;
	Menu file;
	MenuItem n,o,s,c,exit;
	TextArea ta;
	FileDialog fd;
	
	notepd()
	{
		ta=new TextArea();
		mb=new MenuBar();
		setMenuBar(mb);
		file=new Menu("FILE");
		mb.add(file);
		n=new MenuItem("New");
		o=new MenuItem("Open");
		s=new MenuItem("Save");
		c=new MenuItem("Close");
		exit=new MenuItem("Exit");
		file.add(n);
		file.add(o);
		file.add(s);
		file.add(c);
		file.add(exit);
		add(ta);
		n.addActionListener(this);
		o.addActionListener(this);
		s.addActionListener(this);
		c.addActionListener(this);
		exit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==n)
	ta.setText(" ");
		if(ae.getSource()==c)
			ta.setVisible(false);;
			if(ae.getSource()==exit)
				
				System.exit(0);
			if(ae.getSource()==o)
			{
				try
				{
					fd=new FileDialog(this,"Open my window",FileDialog.LOAD);
							fd.show();
				FileReader fr=new FileReader(fd.getDirectory()+fd.getFile());
					BufferedReader br=new BufferedReader(fr);
					while(br.readLine()!=null)
					{
						String s=br.readLine();
						ta.append(s+"/n");
					}
				}
				catch(Exception e)
				{
					System.out.println("Reading eror");
				}
			}
			if(ae.getSource()==s)
			{
				try
				{
					fd=new FileDialog(this,"Open my window",FileDialog.SAVE);
					fd.show();
					String s=ta.getText();
					FileWriter fr=new FileWriter(fd.getDirectory()+fd.getFile());
					fr.write(s);;
					fr.close();
				}
				catch(Exception e)
				{
					System.out.println("Reading error");
				}
			}
	}
			
		public static void main(String[] args)throws Exception
		{
		// TODO Auto-generated method stub
         notepd t=new notepd();
         t.setVisible(true);
         t.setSize(600,600);
	}

}
