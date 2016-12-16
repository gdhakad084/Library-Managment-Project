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

public class FacultySection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultySection frame = new FacultySection();
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
	public FacultySection() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcome = new JLabel("Welcome !");
		lblWelcome.setFont(new Font("Verdana", Font.PLAIN, 23));
		
		JButton btnSearchBookBy = new JButton("Search Book By Id");
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
		
		JButton btnSearchBookBy_1 = new JButton("Search Book By ");
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
		
		JButton btnNewButtontton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login obj= new login();
			    obj.setVisible(true);
			}
		});
		
		JButton btnIssuedBook = new JButton("issued Book");
		btnIssuedBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stuid scn= new stuid();
					scn.setVisible(true);
			    		
			}			
		 
		
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(lblWelcome)
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addComponent(btnSearchBookBy, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSearchBookBy_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addComponent(btnIssuedBook, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblWelcome))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchBookBy, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearchBookBy_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(btnIssuedBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setTitle("Faculty Section");
		setResizable(false);
		setLocationRelativeTo(this);
	}

}
