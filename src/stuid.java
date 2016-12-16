import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class stuid extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stuid frame = new stuid();
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
	public stuid() {
		
		setTitle(" Enter Your id");
		setResizable(false);
		setBounds(100, 100, 450, 120);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblStudentId = new JLabel("Enter Your Id");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sid= textField.getText();
			if(sid.length()==0)
			{

                JOptionPane.showMessageDialog(null, "please select Your Id"); 
			}
			else
			{    
				String sender="student_id";
				Connection con= DBInfo.con;
				
			      String query="select * from issuedbooks where student_id=?";
			      int ju=0;
			      
			      try{
						
			             
						PreparedStatement ps= con.prepareStatement(query);
						ps.setString(1, sid);
						ResultSet res=(ResultSet) ps.executeQuery();
						ResultSetMetaData remd= res.getMetaData();
			             
			             while(res.next())
							{
			                 ju++;         	 
							}
	                   if(ju==0)
	                   {
	                	JOptionPane.showMessageDialog(null, "no data found");   
	                   }	
	                   else{
			             JFrame jf=new JFrame();
					       
					        dataoutput2 tab= new dataoutput2(sid,ju,sender);
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
		 dispose();
			}
					
			
			
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText(null);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lblStudentId)
							.addGap(29)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(122)
							.addComponent(btnEnter)
							.addGap(18)
							.addComponent(btnReset)))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnter)
						.addComponent(btnReset))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
