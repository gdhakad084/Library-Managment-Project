import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.UpdatableResultSet;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminSection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection frame = new AdminSection();
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
	public AdminSection() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		setTitle("Admin Section");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(this);
	
		JLabel lblWelcomeToThe = new JLabel("Welcome In Admin Section !");
		lblWelcomeToThe.setFont(new Font("Traditional Arabic", Font.BOLD, 22));
		
		Icon normal= new ImageIcon("book.png");
		
		JButton btnAddNewBook = new JButton("Add A Book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     anewbook obj= new anewbook();
			     obj.setVisible(true);
			}
		});
		
		JButton btnUpdateABook = new JButton("Update A Book");
		btnUpdateABook.addActionListener(new ActionListener() {
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
				updateabook obj= new updateabook(bookid,bname,bauthor,bsubject,bcategory,bpublication,bprice,bedition,bimi,btotal,bbranch);
			obj.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "please check your id no");
				}
			
			}
		});
		
		JButton btnDeleteABook = new JButton("Delete Book");
		btnDeleteABook.addActionListener(new ActionListener() {
			private JTextField jtb;
			public void actionPerformed(ActionEvent e) {
				String getbookid= (String)JOptionPane.showInputDialog(jtb,"enter book id");
				
				Connection con= DBInfo.con;
				String query= "DELETE from bookdata WHERE bid=?";
				
				try{
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, getbookid);
					int i= ps.executeUpdate();
					
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"suceessfull deleted");
					       
					}
					else
					{
						JOptionPane.showMessageDialog(null,"try again book not found");
						
					}
				}
				catch(Exception e1234)
				{
					
				}
				
			}
		});
		
		JButton btnSearchBookBy = new JButton("Search Book Id");
	
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
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			private JTextField jtb;
			public void actionPerformed(ActionEvent e) {
                String getstudentid= (String)JOptionPane.showInputDialog(jtb,"enter student id");
				
				Connection con= DBInfo.con;
				String querys= "DELETE from login WHERE id=?";
				try{
					PreparedStatement ps= con.prepareStatement(querys);
					ps.setString(1, getstudentid);
					int i= ps.executeUpdate();
					
				
				}
				catch(Exception e1234)
				{
					
				}
				String query= "DELETE from sregistration WHERE sid=?";
				try{
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, getstudentid);
					int i= ps.executeUpdate();
					
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"suceessfull deleted");
					       
					}
					else
					{
						JOptionPane.showMessageDialog(null,"try again or not found");
						
					}
				}
				catch(Exception e1234)
				{
					
				}
				
			
			
			}
		});
		
		JButton btnSearchBookBy_2 = new JButton("Search Book By Other");
		btnSearchBookBy_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchbookby obj = new searchbookby();
				obj.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose();
				login obj= new login();
			    obj.setVisible(true);
			}
		});
		
		JButton btnIssueABook = new JButton("Issue A Book");
		btnIssueABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			issuebook obj= new issuebook();
			obj.setVisible(true);
			}
		});
		
		JButton btnSubmitBook = new JButton("Submit Book");
		btnSubmitBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			submitabook obj= new submitabook();
			obj.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(lblWelcomeToThe)
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(371, Short.MAX_VALUE)
					.addComponent(btnNewButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddNewBook, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnUpdateABook, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteABook, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(btnSearchBookBy_2)
									.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
									.addComponent(btnIssueABook, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSearchBookBy, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSubmitBook, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWelcomeToThe)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewBook, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateABook, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteABook, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchBookBy, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteStudent, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmitBook, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchBookBy_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIssueABook, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setResizable(false);
		setLocationRelativeTo(this);
	}
}
