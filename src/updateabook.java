import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class updateabook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateabook frame = new updateabook(null,null,null,null,null,null,null,null,null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public updateabook(String a,String b,String c,String d,String ec,String f,String g,String h,String i,String j,String k) {
		
		setBounds(100, 100, 520, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUpdateYourBook = new JLabel("Update Your Book");
		lblUpdateYourBook.setFont(new Font("Verdana", Font.PLAIN, 23));
		
		JLabel lblBookId = new JLabel("Book id");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Book name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		JLabel lblPublication = new JLabel("Publication");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		JLabel lblImiNo = new JLabel("Imi no.");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblTotalBooks = new JLabel("Total Books");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblBranch = new JLabel("Branch");
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		
		
		Vector<String> vrauthor= new Vector<String>();
	    Connection cnv= DBInfo.con;
	    String queryvalue= "select * from author";
	    try{
	    	PreparedStatement prs= cnv.prepareStatement(queryvalue);
	    	ResultSet res= (ResultSet)prs.executeQuery();
	    	while (res.next())
	    	{
	    		vrauthor.add(res.getString(1));
	    	}
	    }
	    catch(Exception ewe)
	    {
	    	
	    }
	    Collections.sort(vrauthor);;
	    vrauthor.add(0, "--select new---");
		
		JComboBox comboBox = new JComboBox(vrauthor);
         Vector<String> vrsubject= new Vector<String>();
		
	    String queryvalue1= "select * from subject";
	    try{
	    	PreparedStatement prs= cnv.prepareStatement(queryvalue1);
	    	ResultSet res= (ResultSet)prs.executeQuery();
	    	while (res.next())
	    	{
	    		vrsubject.add(res.getString(1));
	    	}
	    }
	    catch(Exception ewe)
	    {
	    	
	    }
	    Collections.sort(vrsubject);;
	    vrsubject.add(0, "--select new---");
		
		JComboBox comboBox_1 = new JComboBox(vrsubject);
		Vector<String> vrcategory= new Vector<String>();
	    String queryvalue2= "select * from category";
	    try{
	    	PreparedStatement prs= cnv.prepareStatement(queryvalue2);
	    	ResultSet res= (ResultSet)prs.executeQuery();
	    	while (res.next())
	    	{
	    		vrcategory.add(res.getString(1));
	    	}
	    }
	    catch(Exception ewe)
	    {
	    	
	    }
	    Collections.sort(vrcategory);;
	    vrcategory.add(0, "--select new---");
		JComboBox comboBox_2 = new JComboBox(vrcategory);
		Vector<String> vrpublisher= new Vector<String>();
	    String queryvalue4= "select * from publisher";
	    try{
	    	PreparedStatement prs= cnv.prepareStatement(queryvalue4);
	    	ResultSet res= (ResultSet)prs.executeQuery();
	    	while (res.next())
	    	{
	    		vrpublisher.add(res.getString(1));
	    	}
	    }
	    catch(Exception ewe)
	    {
	    	
	    }
	    Collections.sort(vrpublisher);;
	    vrpublisher.add(0, "--select new---");
		JComboBox comboBox_3 = new JComboBox(vrpublisher);
		Vector<String> edtion1= new Vector<>();
		edtion1.add("--select new---");
		edtion1.add("1st");
		edtion1.add("2nd");
		edtion1.add("3rd");
		edtion1.add("4th");
		edtion1.add("5th");
		edtion1.add("6th");
		edtion1.add("7th");
		edtion1.add("8th");
		edtion1.add("9th");
		edtion1.add("10th");
		
		
		Vector<String> vrbranch= new Vector<String>();
	    String queryvalue5= "select * from cbranch";
	    try{
	    	PreparedStatement prs= cnv.prepareStatement(queryvalue5);
	    	ResultSet res= (ResultSet)prs.executeQuery();
	    	while (res.next())
	    	{
	    		vrbranch.add(res.getString(1));
	    	}
	    }
	    catch(Exception ewe)
	    {
	    	
	    }
	    Collections.sort(vrbranch);
	    vrbranch.add(0, "--select new---");
	    JComboBox comboBox_4 = new JComboBox(vrbranch);
	    JComboBox comboBox_5 = new JComboBox(edtion1);
		textField.setText(a);
		textField_1.setText(b);
		textField_2.setText(c);
		textField_3.setText(d);
		textField_4.setText(ec);
		textField_5.setText(f);
		textField_6.setText(g);
		textField_7.setText(h);
		textField_8.setText(i);
		textField_9.setText(j);
		textField_10.setText(k);
		
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String gname= textField_1.getText();
				String gauthor= comboBox.getSelectedItem().toString();
				String gsubject=comboBox_1.getSelectedItem().toString();
				String gcategory=comboBox_2.getSelectedItem().toString();
				String gpublication=comboBox_3.getSelectedItem().toString();
				String gbranch=comboBox_4.getSelectedItem().toString();
				String gedition=comboBox_5.getSelectedItem().toString();
				String gprice=textField_6.getText();
				String gimi=textField_8.getText();
				String gtotal=textField_9.getText();
				String select="--select new---";
				String pauthor=c; 
				String psubject=d;
				String pcategory=ec;
				String ppublication=f;
				System.out.println(ppublication);
				String pbranch=k;
				String pedition=h;
				
				
				if(gname.length()==0||gprice.length()==0||gimi.length()==0||gtotal.length()==0)
			  {
				  JOptionPane.showMessageDialog(null, "please fill all inforamtion");
			  }
			  else
			  {   
				  if(!(gauthor.equalsIgnoreCase(select)))
				  {
					  pauthor= gauthor;
					  
				  }
				  if(!(gsubject.equalsIgnoreCase(select)))
				  {
					  psubject=gsubject;
				  }
				  if(!(gcategory.equalsIgnoreCase(select)))
				  {
					  pcategory=gcategory;
				  }
				  if(!(gpublication.equalsIgnoreCase(select)))
				  {
					  ppublication=gpublication;
				  }
				  if(!(gbranch.equalsIgnoreCase(select)))
				  {
					  pbranch= gbranch;
				  }
				  if(!(gedition.equalsIgnoreCase(select)))
				  {
					  pedition= gedition;
				  }
				  Connection cona= DBInfo.con;
				 
				  String querys= "UPDATE bookdata " +
		                   "SET bname="+"\""+gname+"\""+",bauthor="+"\""+pauthor+"\""+",bsubject="+"\""+psubject+"\""+",bcategory="+"\""+pcategory+"\""+",bpubliction="+"\""+ppublication+"\""+
		                   ",bprice="+"\""+gprice+"\""+",bedition="+"\""+pedition+"\""+",bimi="+"\""+gimi+"\""+",btotal="+"\""+gtotal+"\""+",bbranch="+"\""+pbranch+"\""+"where bid="+"\""+a+"\"";
	            
				  // System.out.println(a+"::"+gname+"::"+pauthor+psubject+pcategory+pcategory+ppublication+gprice+pedition+gimi+gtotal+pbranch);
                  
				  try
                  {
                	/*  Statement psa= cona.createStatement();
                	psa.executeUpdate(querys);
                	  
                	 System.out.println("hello");*/
					  PreparedStatement psa= cona.prepareStatement(querys);
					  int i= psa.executeUpdate();
					  System.out.println(i);
					  if(i>0)
					  {
						  dispose();
						  JOptionPane.showMessageDialog(null, "successfull updated");
					  }
                  }
                  catch(Exception tre)
                  {
                	  
                  }
			  }
			
			
			
			}
		});
		JButton btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(a);
				textField_1.setText(b);
				textField_2.setText(c);
				textField_3.setText(d);
				textField_4.setText(ec);
				textField_5.setText(f);
				textField_6.setText(g);
				textField_7.setText(h);
				textField_8.setText(i);
				textField_9.setText(j);
				textField_10.setText(k);
				
			
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(161)
							.addComponent(lblUpdateYourBook))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookId)
								.addComponent(lblNewLabel)
								.addComponent(lblAuthor)
								.addComponent(lblSubject)
								.addComponent(lblCategory)
								.addComponent(lblPublication)
								.addComponent(lblPrice)
								.addComponent(lblEdition)
								.addComponent(lblImiNo)
								.addComponent(lblTotalBooks)
								.addComponent(lblBranch))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(131)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUpdateYourBook)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBookId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSubject)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCategory)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPublication)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrice)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEdition)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImiNo)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTotalBooks)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setResizable(false);
		AdminSection obj= new AdminSection();
		setLocationRelativeTo(obj);
		setTitle("Update Book ");
	
	}
}
