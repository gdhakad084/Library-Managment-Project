import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class issuebook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblStudentId;
	private JTextField textField_2;
	private JLabel lblBookName_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issuebook frame = new issuebook();
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
	public issuebook() {
		setTitle("issue a book");
		setResizable(false);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRefrenceNo = new JLabel("Refrence No.");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book Id");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		lblStudentId = new JLabel("Person Id");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);

		
		lblBookName_1 = new JLabel("Book name");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		 
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String ref= textField.getText();
				String bid= textField_1.getText();
				String stid= textField_2.getText();
				String bkname= textField_3.getText();
			
				if(ref.length()==0||bid.length()==0||stid.length()==0||bkname.length()==0)
					{
					     
						JOptionPane.showMessageDialog(null, "fill all the information");
					}
				else
				{
					Connection cons= DBInfo.con;
                    String squery= "insert into issuedbooks values (?,?,?,?) ";
                    try
                    {
                    java.sql.PreparedStatement spr=	cons.prepareStatement(squery);
                    spr.setString(1, ref);
                    spr.setString(2, bid);
                    spr.setString(3, stid);
                    spr.setString(4, bkname);
                    int i  = spr.executeUpdate();
                    System.out.println(i);
        
                         }
                    catch(Exception e234)
                    { 
                    	
                    }
                    textField.setText(null);
        			textField_1.setText(null);
        			textField_2.setText(null);
        			textField_3.setText(null);

                
			}
			}});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        textField.setText(null);
    			textField_1.setText(null);
    			textField_2.setText(null);
    			textField_3.setText(null);

			
			}
		});
		
		JButton btnSubmitBook = new JButton("Submit Book");
		btnSubmitBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitabook obj= new submitabook();
				obj.setVisible(true);	
				dispose();	
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblRefrenceNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblBookId, Alignment.LEADING)
									.addComponent(lblStudentId, Alignment.LEADING))
								.addComponent(lblBookName_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(btnIssueBook)
							.addGap(18)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSubmitBook)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRefrenceNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBookId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStudentId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBookName_1))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssueBook)
						.addComponent(btnReset)
						.addComponent(btnSubmitBook))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		AdminSection obj= new AdminSection();
		
	    setLocationRelativeTo(obj);
	}
}
