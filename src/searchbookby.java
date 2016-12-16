import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchbookby extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbookby frame = new searchbookby();
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
	public searchbookby() {
		
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSearchBook = new JLabel("Search Book");
		lblSearchBook.setFont(new Font("Verdana", Font.PLAIN, 23));
		
		JLabel lblSubject = new JLabel("By Subject");
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
	    vrauthor.add(0, "------select------");
	    JLabel lblByAuthor = new JLabel("By Author");
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
	    vrsubject.add(0, "------select------");
	    JComboBox comboBox = new JComboBox(vrsubject);
		JComboBox comboBox_1 = new JComboBox(vrauthor);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String sender="bsubject";
				String sbox= comboBox.getSelectedItem().toString();	
				String chek="------select------";
				if(sbox.equals(chek))
				{
                      JOptionPane.showMessageDialog(null, "please select any choice"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bsubject=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found for current subject");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search SUbject Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					comboBox.setSelectedIndex(0);
					  
				}
			}
		});
		
		
		
		
		
		
		
		
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender="bauthor";
				String sbox= comboBox_1.getSelectedItem().toString();	
				String chek="------select------";
				if(sbox.equals(chek))
				{
                      JOptionPane.showMessageDialog(null, "please select any choice"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bauthor=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found for current author");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search Author Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					comboBox_1.setSelectedIndex(0);
					  
				}
		
			
			}
		});
		
		JLabel lblByCategory = new JLabel("By Category");
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
	    vrcategory.add(0, "------select------");
		JComboBox comboBox_2 = new JComboBox(vrcategory);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender="bcategory";
				String sbox= comboBox_2.getSelectedItem().toString();	
				String chek="------select------";
				if(sbox.equals(chek))
				{
                      JOptionPane.showMessageDialog(null, "please select any choice"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bcategory=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found for current category");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search Category Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					comboBox_2.setSelectedIndex(0);
					  
				}
		
			
			
			}
		});
		
		JLabel lblByPublisher = new JLabel("By Publisher");
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
	    vrpublisher.add(0, "------select------");
		JComboBox comboBox_3 = new JComboBox(vrpublisher);
		
		JButton button_2 = new JButton("Search");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sender="bpubliction";
				String sbox= comboBox_3.getSelectedItem().toString();	
				String chek="------select------";
				if(sbox.equals(chek))
				{
                      JOptionPane.showMessageDialog(null, "please select any choice"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bpubliction=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found for current publication");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search Publication Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					comboBox_3.setSelectedIndex(0);
					  
				}
		
			
			}
		});
		
		JLabel lblByBranch = new JLabel("By Branch");
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
	    vrbranch.add(0, "------select------");
		JComboBox comboBox_4 = new JComboBox(vrbranch);
		
		JButton button_3 = new JButton("Search");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String sender="bbranch";
				String sbox= comboBox_4.getSelectedItem().toString();	
				String chek="------select------";
				if(sbox.equals(chek))
				{
                      JOptionPane.showMessageDialog(null, "please select any choice"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bbranch=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found for current branch");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search Branch Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					comboBox_4.setSelectedIndex(0);
					  
				}
		
			
			}
		});
		
		JLabel lblByName = new JLabel("By Name");
		
		JButton button_4 = new JButton("Search");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender="bname";
				String sbox= textField.getText();	
				
				if(sbox.length()==0)
				{
                      JOptionPane.showMessageDialog(null, "please enter any book name"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bname=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search Book Name Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					textField.setText(null);
					  
				}
			
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblByImi = new JLabel("By IMI");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button_5 = new JButton("Search");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender="bimi";
				String sbox= textField_1.getText();	
				
				if(sbox.length()==0)
				{
                      JOptionPane.showMessageDialog(null, "please enter any book IMI NO"); 					
				}
				else
				{
					Connection con= DBInfo.con;
					
				      String query="select * from bookdata where bimi=?";
				      int ju=0;
				      
				      try{
							
				             
							PreparedStatement ps= con.prepareStatement(query);
							ps.setString(1, sbox);
							ResultSet res=(ResultSet) ps.executeQuery();
							ResultSetMetaData remd= res.getMetaData();
				             
				             while(res.next())
								{
				                 ju++;         	 
								}
		                   if(ju==0)
		                   {
		                	JOptionPane.showMessageDialog(null, "no book found");   
		                   }	
		                   else{
				             JFrame jf=new JFrame();
						       
						        dataoutput1 tab= new dataoutput1(sbox,ju,sender);
						        jf.setTitle("Search IMI Result");
						        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						        jf.setSize(screenSize.width, 500);
						        jf.setVisible(true);
						        
						        jf.getContentPane().add(tab);
						        jf.setResizable(false);
		                   }
				             
				         
				      }
				      catch(Exception erty)
				      {
				    	  
				      }
					
					textField_1.setText(null);
					  
				}
		
			
			
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(lblSearchBook))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSubject)
								.addComponent(lblByCategory, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblByPublisher, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblByBranch, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblByName, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblByImi, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
								.addComponent(lblByAuthor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox, 0, 190, Short.MAX_VALUE)
										.addComponent(comboBox_1, 0, 190, Short.MAX_VALUE)
										.addComponent(comboBox_2, 0, 190, Short.MAX_VALUE)
										.addComponent(comboBox_3, 0, 190, Short.MAX_VALUE)
										.addComponent(comboBox_4, 0, 190, Short.MAX_VALUE)
										.addComponent(textField))
									.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnSearch)
										.addComponent(button, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
										.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearchBook)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblByAuthor)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblByCategory)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblByPublisher)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_2)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblByBranch)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblByName)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_4)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblByImi)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_5))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	    setTitle("Search Book By");
	    setResizable(false);
	    AdminSection obj= new AdminSection();
	    setLocationRelativeTo(obj);
	    
	}
}
