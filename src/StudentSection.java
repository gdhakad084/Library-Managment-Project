import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class StudentSection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSection frame = new StudentSection();
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
	public StudentSection() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome ! ");
		lblWelcomeToThe.setFont(new Font("Verdana", Font.PLAIN, 23));
		
		JButton btnNewButton = new JButton("Issued Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			stuid scn= new stuid();
				scn.setVisible(true);
		    		
		}
			
		});
		
		JButton btnSearchBookBy = new JButton("Search Book By id");
		btnSearchBookBy.addActionListener(new ActionListener() {
			private JTextField jtf;	
			public void actionPerformed(ActionEvent e) {
				String getbookid= (String)JOptionPane.showInputDialog(jtf,"enter book id");
		        String bookid="";
		        String bname="";
		        String bauthor="";
		        String bsubject="";
		        String bcategory="";
		        String bpublication="";
		        String bprice="";
		        String bedition="";
		        String bimi="";
		        String btotal="";
		        String bbranch="";
				Connection con= DBInfo.con;
				String query="select * from bookdata where bid=?";
				try{
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, getbookid);
					ResultSet res=(ResultSet) ps.executeQuery();
					
					while(res.next())
						{
						bookid=res.getString(1);
					    bname=res.getString(2);
					    bauthor=res.getString(3);
					    bsubject=res.getString(4);
					    bcategory=res.getString(5);
					    bpublication=res.getString(6);
					    System.out.println(bpublication);
					    bprice=res.getString(7);
					    bedition=res.getString(8);
					    bimi=res.getString(9);
					    btotal=res.getString(10);
					    bbranch=res.getString(11);
						}
					
				}
				catch(Exception wewr){}
				if(getbookid.equals(bookid)){
				sbid obj= new sbid(bookid,bname,bauthor,bsubject,bcategory,bpublication,bprice,bedition,bimi,btotal,bbranch);
			obj.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "please check your id no");
				}
		
			
			}
		});
		
		JButton btnSearchBookBy_1 = new JButton("Search Book By other");
		btnSearchBookBy_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
				
				searchbookby obj = new searchbookby();
				obj.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login obj= new login();
			    obj.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(145)
					.addComponent(lblWelcomeToThe)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(btnSearchBookBy_1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addGap(78))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(btnSearchBookBy, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblWelcomeToThe))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addComponent(btnSearchBookBy_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchBookBy, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setTitle("Student Section");
		setResizable(false);
		setLocationRelativeTo(this); 
	}

}
