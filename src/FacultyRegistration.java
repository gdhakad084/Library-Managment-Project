import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class FacultyRegistration extends JFrame {

	static String element;
	String newSubject;
	private JComboBox jdf;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblSubjects;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
    private JTextField textJTextField; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyRegistration frame = new FacultyRegistration();
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
	public FacultyRegistration() {
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 660);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add New");
		menuBar.add(mnAdd);
		
		JMenuItem mntmSubject = new JMenuItem("Subject");
		mntmSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    String newSubject= (String) JOptionPane.showInputDialog(textJTextField, "enter new Subject");
		    Connection con=DBInfo.con; 
		    String query= "insert into subject values (?)";
		    try{
		    	PreparedStatement spr= con.prepareStatement(query);
		    	spr.setString(1, newSubject.toUpperCase());
		    	int i= spr.executeUpdate();
		    	System.out.println(i);
		    	
		    }
		    catch(Exception ert)
		    {
		    	
		    }
			dispose();
			FacultyRegistration fr= new FacultyRegistration();
			fr.setVisible(true);
			}
		
		
		
		
});
		
		mnAdd.add(mntmSubject);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFaculty = new JLabel("New Faculty Registration");
		
		JLabel lblNewLabel = new JLabel("Name");
		
		textField = new JTextField();
		textField.setColumns(14);
		
		JLabel lblId = new JLabel("Id");
		
		textField_1 = new JTextField();
		textField_1.setColumns(14);
		
		JLabel lblMobile = new JLabel("Mobile");
		
		textField_3 = new JTextField();
		textField_3.setColumns(14);
		
		JLabel lblEmailId = new JLabel("Email Id");
		
		textField_4 = new JTextField();
		textField_4.setColumns(14);
		
		lblSubjects = new JLabel("Subjects");
		
		
	    Vector<String> vrd= new Vector<String>();
	    Connection cnv= DBInfo.con;
	    String queryvalue= "select * from subject";
	    try{
	    	PreparedStatement prs= cnv.prepareStatement(queryvalue);
	    	ResultSet res= (ResultSet)prs.executeQuery();
	    	while (res.next())
	    	{
	    		vrd.add(res.getString(1));
	    	}
	    }
	    catch(Exception ewe)
	    {
	    	
	    }
	    Collections.sort(vrd);;
	    vrd.add(0, "---select--");
		
		//vr.add("-----Select------");
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
	    Collections.sort(vrcategory);
	    vrcategory.add(0, "-----Select------");

		JLabel lblCaegory = new JLabel("Caegory");
		
		JComboBox comboBox_4 = new JComboBox(vrcategory);
		
		JLabel lblAddress = new JLabel("Address");
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		JLabel lblUsername = new JLabel("Username");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		Vector<String> vr2 = new Vector<String>();
		vr2.add("---Select---");
		vr2.add("I");
		vr2.add("II");
		vr2.add("III");
		vr2.add("VI");
		
		JLabel lblTotalSubject = new JLabel("Total Subject");
		
		JComboBox comboBox_5 = new JComboBox(vr2);
		
		JLabel lblRePassword = new JLabel("Re Password");
		
		passwordField_1 = new JPasswordField();

	    JComboBox comboBox = new JComboBox(vrd);
	    
		
		JComboBox comboBox_1 = new JComboBox(vrd);
		
		
		JComboBox comboBox_2 = new JComboBox(vrd);
		
		
		JComboBox comboBox_3 = new JComboBox(vrd);
		
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String fname= textField.getText();
				String fid= textField_1.getText();
				String fmobile= textField_3.getText();
				String femail= textField_4.getText();
				String fusername= textField_5.getText();
				String fpassword= new String(passwordField.getPassword());
				String frepass= new String(passwordField_1.getPassword());
				String faddres= textArea.getText();
				String fcategory= comboBox_4.getSelectedItem().toString();
				String fsubject = comboBox_5.getSelectedItem().toString();
				String fsubject1=comboBox.getSelectedItem().toString();
				String fsubject2= comboBox_1.getSelectedItem().toString();
				String fsubject3= comboBox_2.getSelectedItem().toString();
				String fsubject4= comboBox_3.getSelectedItem().toString();
				String catselect= "-----Select------";
				String tsubjectselect="---Select---";
				String scatSubject="---select--";
				String one="I";
				String two="II";
				String three="III";
				String four="VI";
				String check="---select--";
				int p=0;
				boolean sc= false;
				Vector<String> vrd1= new Vector<String>();
							    Connection cnv1= DBInfo.con;
							    String queryvalue1= "select username from login";
							    try{
							    	PreparedStatement prs1= cnv1.prepareStatement(queryvalue1);
							    	ResultSet res1= (ResultSet)prs1.executeQuery();
							    	while (res1.next())
							    	{
							    		vrd1.add(res1.getString(1));
							    	}
							    }
							    catch(Exception ewe)
							    {
							    	
							    }
							    int size=vrd1.size();
							    for(int i=0;i<size;i++)
							    {
							    	if(fusername.equals(vrd1.get(i)))
							    	{
							    	      sc=true;  	
							    	} 
							    }
							    boolean spt= false;
							    if(fsubject.equals(one))
								{   
									if(!(fsubject1.equals(check)))
									{
										p++;
									}
									if(!(fsubject2.equals(check)))
									{
										p++;
									}
									if(!(fsubject3.equals(check)))
									{
										p++;
									}
									if(!(fsubject4.equals(check)))
									{
										p++;
									}
									
									if(p!=1){
									spt=true;	
									}
									else{
										
									}
								}
							  if(fsubject.equals(two))
								{
									if(!(fsubject1.equals(check)))
									{
										p++;
									}
									if(!(fsubject2.equals(check)))
									{
										p++;
									}
									if(!(fsubject3.equals(check)))
									{
										p++;
									}
									if(!(fsubject4.equals(check)))
									{
										p++;
									}
									
									if(p!=2){
										spt=true;	
									}
								}
							   if(fsubject.equals(three))
								{
									if(!(fsubject1.equals(check)))
									{
										p++;
									}
									if(!(fsubject2.equals(check)))
									{
										p++;
									}
									if(!(fsubject3.equals(check)))
									{
										p++;
									}
									if(!(fsubject4.equals(check)))
									{
										p++;
									}
									
									if(p!=3){
										spt=true;	
									}
								}
							  if(fsubject.equals(four))
								{
									if(!(fsubject1.equals(check)))
									{
										p++;
									}
									if(!(fsubject2.equals(check)))
									{
										p++;
									}
									if(!(fsubject3.equals(check)))
									{
										p++;
									}
									if(!(fsubject4.equals(check)))
									{
										p++;
									}
									
									if(p!=4){
										spt=true;	
									   	
									}
								}
							  boolean pm1=fsubject1.equals(fsubject2)&&(!(fsubject1.equals(check)));
								boolean pm2=fsubject2.equals(fsubject3)&&(!(fsubject2.equals(check)));
								boolean pm3=fsubject3.equals(fsubject4)&&(!(fsubject3.equals(check)));
								boolean pm4=fsubject4.equals(fsubject1)&&(!(fsubject1.equals(check)));
								boolean pm5=fsubject2.equals(fsubject4)&&(!(fsubject2.equals(check)));
								boolean pm6=fsubject1.equals(fsubject3)&&(!(fsubject1.equals(check)));
							   			  
				if(fname.length()==0||fid.length()==0||fmobile.length()==0||femail.length()==0||fusername.length()==0||fpassword.length()==0
			    		||frepass.length()==0||faddres.length()==0||fcategory.equals(catselect)||fsubject.equals(tsubjectselect) )
			    {
			    	JOptionPane.showMessageDialog(null, "fill all the information", "error in filling", JOptionPane.ERROR_MESSAGE);
			    }
				else if(sc)
				{
					JOptionPane.showMessageDialog(null, "please enter another username", "error in filling", JOptionPane.ERROR_MESSAGE);
				}
				else if(spt)
				{
					JOptionPane.showMessageDialog(null, "please enter right subject option", "error in filling", JOptionPane.ERROR_MESSAGE);
				}
				else if(pm1||pm2||pm3||pm4||pm5||pm6)
				   {
					JOptionPane.showMessageDialog(null, "please choose different different subjects", "error in filling", JOptionPane.ERROR_MESSAGE);
				   }
				else if(!(fpassword.equals(frepass)))
				{
				   JOptionPane.showMessageDialog(null, "please enter right password");
				     
				}
			   else
			   {
				   Connection cons= DBInfo.con;
                   String squery= "insert into fregistration values (?,?,?,?,?,?,?,?,?,?,?) ";
                   try
                   {
                   java.sql.PreparedStatement spr=	cons.prepareStatement(squery);
                   spr.setString(1, fname);
                   spr.setString(2, fid);
                   spr.setString(3, fmobile);
                   spr.setString(4, femail);
                   spr.setString(5, fcategory);
                   spr.setString(6, faddres);
                   spr.setString(7, fsubject);
                   spr.setString(8, fsubject1);
                   spr.setString(9, fsubject2);
                   spr.setString(10, fsubject3);
                   spr.setString(11, fsubject4);
                   int i  = spr.executeUpdate();
                   System.out.println(i);
                   }
                   catch(Exception e234){ }
                   String squery1 = "insert into login values (?,?,?,?)";
                   try{
                	   java.sql.PreparedStatement spra= cons.prepareStatement(squery1);
                       spra.setString(1,fusername );
                       spra.setString(2,fpassword );
                       spra.setString(3,"faculty");
                       spra.setString(4,fid);
                       int i= spra.executeUpdate();
                       System.out.println(i);
                   } 	
                   catch(Exception e2345){} 
				
                   textField.setText(null);
   				textField_1.setText(null);
   				textField_3.setText(null);
   				textField_4.setText(null);
   				textField_5.setText(null);
   		        passwordField.setText(null);
   		        passwordField_1.setText(null);
   		        textArea.setText(null);
   		        comboBox.setSelectedIndex(0);
   		        comboBox_1.setSelectedIndex(0);
   		        comboBox_2.setSelectedIndex(0);
   		        comboBox_3.setSelectedIndex(0);
   		        comboBox_4.setSelectedIndex(0);
   		        comboBox_5.setSelectedIndex(0);
   		        
                   
			   }
				
			
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
		        passwordField.setText(null);
		        passwordField_1.setText(null);
		        textArea.setText(null);
		        comboBox.setSelectedIndex(0);
		        comboBox_1.setSelectedIndex(0);
		        comboBox_2.setSelectedIndex(0);
		        comboBox_3.setSelectedIndex(0);
		        comboBox_4.setSelectedIndex(0);
		        comboBox_5.setSelectedIndex(0);
		        
			}
		});
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login ldg= new login();
				ldg.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblId)
									.addComponent(lblMobile)
									.addComponent(lblEmailId)
									.addComponent(lblCaegory)
									.addComponent(lblAddress)
									.addComponent(lblNewLabel_1)
									.addComponent(lblTotalSubject, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblSubjects)
									.addComponent(lblUsername)
									.addComponent(lblRePassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblNewLabel)
								.addComponent(btnSave))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 166, Short.MAX_VALUE)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(comboBox_4, 0, 166, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(comboBox_5, Alignment.TRAILING, 0, 166, Short.MAX_VALUE)
								.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 166, Short.MAX_VALUE)
								.addComponent(comboBox_2, 0, 166, Short.MAX_VALUE)
								.addComponent(comboBox_3, 0, 166, Short.MAX_VALUE)
								.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(lblFaculty)))
					.addGap(122))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblFaculty)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMobile)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmailId)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCaegory)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAddress)
							.addGap(64)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalSubject)
								.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSubjects))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRePassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(btnLogin))
					.addGap(54)
					.addComponent(lblNewLabel_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setTitle("New Faculty Registration");
		setResizable(false);
		setLocationRelativeTo(this);
	}
}
