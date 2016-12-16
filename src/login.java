import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(this);
		setTitle("login form");
		contentPane.setBackground(Color.LIGHT_GRAY);
		JLabel lblNewLabel = new JLabel("Username");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String username= textField.getText();
			char c[] = passwordField.getPassword();
			String pass= new String(c);
			if(username.length()==0&&pass.length()==0)
			{
				JOptionPane.showMessageDialog(null,"enter both username and password");     
			}
			else{
			  try{
				Connection con= DBInfo.con;
				String query="select * from login where username=? and password=?";
				int flag=0;
				String usertype="";
				
				PreparedStatement stmt=(PreparedStatement) con.prepareStatement(query);
				stmt.setString(1,username);
				stmt.setString(2,pass);
				ResultSet res=(ResultSet) stmt.executeQuery();
				while(res.next())
					{
					String name=res.getString(1);
					String pass1=res.getString(2);
					if((username.equals(name)) && (pass.equals(pass1)))
					{
						usertype = res.getString(3);
						System.out.println(res.getString(3));
						flag =1;
						
						    
					}
				}
		      if(flag==0)
		      {
		    	  JOptionPane.showMessageDialog(null,"Invalid User Name or Password", "invalid",JOptionPane.ERROR_MESSAGE);	  
		      }
		      else{
		    	  if(usertype.equalsIgnoreCase("faculty"))
		    	  {
		              FacultySection obj= new FacultySection();
		              obj.setVisible(true);
		    		  dispose(); 		  
		    	  }
		    	  else if(usertype.equalsIgnoreCase("student"))
		    	  {
		    		  StudentSection obj= new StudentSection();
		    		  obj.setVisible(true);
		    		 dispose();
		    	  }
		    	  else if(usertype.equalsIgnoreCase("admin"))
		    	  {
		    		  AdminSection obj= new AdminSection();
		    		  obj.setVisible(true);
		    	
		    		  dispose();
		    	  }
		      }
			
			
			}
			catch(Exception e1)
			{
			System.out.println("error");	
			}
			  
			  textField.setText(null);
				passwordField.setText(null);
			
			}}
		});
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText(null);
			passwordField.setText(null);
			}
		});
		
		JButton btnNewButton_2 = new JButton("New Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			StudentRegistration scn= new StudentRegistration();
			scn.setVisible(true);
			dispose();
				
			}
		});
		
		JButton btnNewFaculty = new JButton("New Faculty");
		btnNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyRegistration fcn = new FacultyRegistration();
				fcn.setVisible(true);
				dispose();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addComponent(btnNewButton_2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(15)
									.addComponent(btnNewFaculty, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton_1)
											.addGap(29))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))))
					.addGap(89))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewFaculty, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
