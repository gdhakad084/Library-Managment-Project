import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class StudentRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblCategory;
	private JTextArea textArea;
	private JLabel lblAddress;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField textField_4;
	private JLabel lblConfirmPassword;
	private JLabel lblMobileNo;
	private JTextField textField_7;
	private JLabel lblEmailId;
	private JTextField textField_8;
	private JLabel lblBranch;
	private JComboBox comboBox_1;
	private JLabel lblYear;
	private JComboBox comboBox_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
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
	public StudentRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 660);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		JLabel lblNewLabel = new JLabel("New Student Registration");
		
		JLabel lblName = new JLabel("Name");
		
		textField = new JTextField();
		textField.setColumns(14);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		
		textField_1 = new JTextField();
		textField_1.setColumns(14);
		
		JLabel lblNewLabel_2 = new JLabel("Roll No.");
		
		textField_2 = new JTextField();
		textField_2.setColumns(14);
		
		lblNewLabel_3 = new JLabel("Father Name");
		
		textField_3 = new JTextField();
		textField_3.setColumns(14);
		
		lblCategory = new JLabel("Category");
		
		Connection cnv= DBInfo.con;
	    Vector<String> vrcategory= new Vector<String>();
	    String queryvalue2= "select * from category";
	    try{
	    	java.sql.PreparedStatement prs= cnv.prepareStatement(queryvalue2);
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

	
		JComboBox comboBox = new JComboBox(vrcategory);
		
		JLabel label = new JLabel("");
		
		JScrollPane scrollPane = new JScrollPane();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(4);
		
		lblAddress = new JLabel("Address");
		
		lblUsername = new JLabel("Username");
		
		lblPassword = new JLabel("Password");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		
		lblMobileNo = new JLabel("Mobile No.");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		lblEmailId = new JLabel("Email Id");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);

		lblBranch = new JLabel("Branch");
		
		
		Vector<String> vrbranch= new Vector<String>();
	    String queryvalue5= "select * from cbranch";
	    try{
	    	java.sql.PreparedStatement prs= cnv.prepareStatement(queryvalue5);
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
	    vrbranch.add(0, "---Select---");
		
		comboBox_1 = new JComboBox(vrbranch);
		
		
		lblYear = new JLabel("Year");
		Vector<String> vr2 = new Vector<String>();
		vr2.add("---Select---");
		vr2.add("I");
		vr2.add("II");
		vr2.add("III");
		vr2.add("VI");
		vr2.add("V");
		vr2.add("VI");
		comboBox_2 = new JComboBox(vr2);
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String name= textField.getText();
				String id= textField_1.getText();
				String rollno= textField_2.getText();
				String fathername= textField_3.getText();
				String category= comboBox.getSelectedItem().toString();
				String Address= textArea.getText();
				String Username1= textField_4.getText();
				String password1= new String(passwordField.getPassword());
				String confirmPassword= new String(passwordField_1.getPassword());
				String mobile= textField_7.getText();
				String email= textField_8.getText();
				String branch= comboBox_1.getSelectedItem().toString();
				String year= comboBox_2.getSelectedItem().toString();
				String asdfg="-----Select------";
				String asdf="---Select---";
				String asd= "---Select---";
				boolean sc= false;
				Vector<String> vrd1= new Vector<String>();
							    Connection cnv1= DBInfo.con;
							    String queryvalue1= "select username from login";
							    try{
							    	java.sql.PreparedStatement prs1= cnv1.prepareStatement(queryvalue1);
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
							    	if(Username1.equals(vrd1.get(i)))
							    	{
							    	      sc=true;  	
							    	} 
							    }
				
				
				if(name.length()==0||id.length()==0||rollno.length()==0||fathername.length()==0||asdfg.equals(category)||
						Address.length()==0||Username1.length()==0||password1.length()==0||confirmPassword.length()==0||mobile.length()==0||email.length()==0||asdf.equals(branch)||asd.equals(year))
				{
					JOptionPane.showMessageDialog(null, "enter your all information", "error", JOptionPane.ERROR_MESSAGE);
					 	
				}
				else if(sc)
				{
					JOptionPane.showMessageDialog(null, "please enter another username", "error", JOptionPane.ERROR_MESSAGE);
				}
				else if(!password1.equals(confirmPassword))
				{
					JOptionPane.showMessageDialog(null, "please enter right password ", "error", JOptionPane.ERROR_MESSAGE);
				}
				
				else{
                            
					
					
					Connection cons= DBInfo.con;
                        String squery= "insert into sregistration values (?,?,?,?,?,?,?,?,?,?) ";
                        try
                        {
                        java.sql.PreparedStatement spr=	cons.prepareStatement(squery);
                        spr.setString(1, name);
                        spr.setString(2, id);
                        spr.setString(3, rollno);
                        spr.setString(4, fathername);
                        spr.setString(5, category);
                        spr.setString(6, Address);
                        spr.setString(7, mobile);
                        spr.setString(8, email);
                        spr.setString(9, branch);
                        spr.setString(10, year);
                        int i  = spr.executeUpdate();
                        System.out.println(i);
                        }
                        catch(Exception e234){ }
                        String squery1 = "insert into login values (?,?,?,?)";
                       try{
                    	   java.sql.PreparedStatement spra= cons.prepareStatement(squery1);
                           spra.setString(1,Username1 );
                           spra.setString(2,password1 );
                           spra.setString(3,"student");
                           spra.setString(4,id);
                           int i= spra.executeUpdate();
                           System.out.println(i);
                       } 	
                       catch(Exception e2345){} 

					textField.setText(null);
					textField_1.setText(null);
		             textField_2.setText(null);
		             textField_3.setText(null);
		             textField_4.setText(null);
		             passwordField.setText(null);
		             passwordField_1.setText(null);
		             textField_7.setText(null);
		             textField_8.setText(null);
					  textArea.setText(null);
					  comboBox.setSelectedIndex(0);
					  comboBox_1.setSelectedIndex(0); 
					  comboBox_2.setSelectedIndex(0);
					
				}
						
				
				
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText(null);
			textField_1.setText(null);
             textField_2.setText(null);
             textField_3.setText(null);
             textField_4.setText(null);
             passwordField.setText(null);
             passwordField_1.setText(null);
             textField_7.setText(null);
             textField_8.setText(null);
			  textArea.setText(null);
			  comboBox.setSelectedIndex(0);
			  comboBox_1.setSelectedIndex(0); 
			  comboBox_2.setSelectedIndex(0);
			}
		});
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login obj= new login();
				obj.setVisible(true);
				dispose();
			}
		});
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(143)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(lblAddress)
										.addComponent(lblUsername)
										.addComponent(lblConfirmPassword)
										.addComponent(lblCategory)
										.addComponent(lblEmailId)
										.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblBranch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMobileNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(comboBox_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, Alignment.LEADING, 159, 159, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(textField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, 0, 151, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(comboBox_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))))
					.addGap(109))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategory))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAddress)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobileNo)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailId))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnReset)
						.addComponent(btnLogin))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setTitle("New Student Registration");
		
		setLocationRelativeTo(this);
	}
}
