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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class submitabook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnReset;
	private JButton btnIssueABook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					submitabook frame = new submitabook();
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
	public submitabook() {
		setTitle("submit a book");
		setResizable(false);
		setBounds(100, 100, 450, 320);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReferenceNo = new JLabel("Reference No");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book Id");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Person Id");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnSubmitABook = new JButton("Submit A Book");
		btnSubmitABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			String refnoe= textField.getText();
			String bno= textField_1.getText();
			String sno= textField_2.getText();
			if(refnoe.length()==0&&bno.length()==0&&sno.length()==0)
			{
				JOptionPane.showMessageDialog(null,"enter all required field");     
			}
			else{
			  try{
				Connection con= DBInfo.con;
				String query="select * from issuedbooks where refno=? and book_id=? and student_id=?";
				int flag=0;
				
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(query);
				stmt.setString(1,refnoe);
				stmt.setString(2,bno);
				stmt.setString(3,sno);
				ResultSet res=(ResultSet) stmt.executeQuery();
				while(res.next())
					{
					String reference=res.getString(1);
					String book=res.getString(2);
					String student=res.getString(3);
					if((refnoe.equals(reference)) && (bno.equals(book)) &&  (sno.equals(student)))
					{
						
						System.out.println(res.getString(4));
						flag =1;
						
						    
					}
				}
				if(flag==0)
			      {
			    	  JOptionPane.showMessageDialog(null,"Invalid book name, reference no and student id", "invalid",JOptionPane.ERROR_MESSAGE);	  
			      }
				else
				{
					
					String query1= "DELETE from issuedbooks WHERE book_id=?";
					
					try{
						PreparedStatement ps= (PreparedStatement)con.prepareStatement(query1);
						ps.setString(1, bno);
						int i= ps.executeUpdate();
						
						if(i>0)
						{
							JOptionPane.showMessageDialog(null,"suceessfull submited");
						       
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
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			  }
			  catch(Exception edfdf)
			  {
				  }
			  }
		      

			
			  
		}});
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
			}
		});
		
		btnIssueABook = new JButton("Issue A Book");
		btnIssueABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				issuebook obj= new issuebook();
				obj.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSubmitABook)
							.addGap(18)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnIssueABook, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblStudentId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblReferenceNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblBookId, Alignment.LEADING))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenceNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmitABook)
						.addComponent(btnReset)
						.addComponent(btnIssueABook))
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
		AdminSection obj= new AdminSection();
	     setLocationRelativeTo(obj);
		
	}
}
