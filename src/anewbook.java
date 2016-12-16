import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class anewbook extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anewbook frame = new anewbook();
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
	public anewbook() {
	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		setResizable(false);
		AdminSection  obj= new AdminSection();
		setLocationRelativeTo(obj);
		setTitle("Add a new book");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New Subject");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			private JTextField textJTextField;	
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
				anewbook fr= new anewbook();
				fr.setVisible(true);
				}
			
			
			
		});
		mnAdd.add(mntmNewMenuItem);
		
		JMenuItem mntmNewSubject = new JMenuItem("New Author");
		mntmNewSubject.addActionListener(new ActionListener() {
			private JTextField textJTextField;
			public void actionPerformed(ActionEvent e) {
				String newAuthor= (String) JOptionPane.showInputDialog(textJTextField, "enter new Author");
			    Connection con=DBInfo.con;
			    
			    String query= "insert into author values (?)";
			    try{
			    	PreparedStatement spr= con.prepareStatement(query);
			    	spr.setString(1, newAuthor.toUpperCase());
			    	int i= spr.executeUpdate();
			    	System.out.println(i);
			    	
			    }
			    catch(Exception ert)
			    {
			    	
			    }
				dispose();
				anewbook fr= new anewbook();
				fr.setVisible(true);

			
			}
		});
		mnAdd.add(mntmNewSubject);
		
		JMenuItem mntmNewPublication = new JMenuItem("New Publication");
		mntmNewPublication.addActionListener(new ActionListener() {
			private JTextField textJTextField;
			public void actionPerformed(ActionEvent e) {
				String newPublisher= (String) JOptionPane.showInputDialog(textJTextField, "enter new Publisher");
			    Connection con=DBInfo.con;
			    newPublisher.toLowerCase();
			    String query= "insert into publisher values (?)";
			    try{
			    	PreparedStatement spr= con.prepareStatement(query);
			    	spr.setString(1, newPublisher.toUpperCase());
			    	int i= spr.executeUpdate();
			    	System.out.println(i);
			    	
			    }
			    catch(Exception ert)
			    {
			    	
			    }
				dispose();
				anewbook fr= new anewbook();
				fr.setVisible(true);

			
			}

		});
		mnAdd.add(mntmNewPublication);
		
		JMenuItem mntmNewCategory = new JMenuItem("New Category");
		mntmNewCategory.addActionListener(new ActionListener() {
			private JTextField textJTextField;
			public void actionPerformed(ActionEvent e) {
				String newCat= (String) JOptionPane.showInputDialog(textJTextField, "enter new Category");
			    Connection con=DBInfo.con; 
			    newCat.toLowerCase();
			    String query= "insert into category values (?)";
			    try{
			    	PreparedStatement spr= con.prepareStatement(query);
			    	spr.setString(1, newCat.toUpperCase());
			    	int i= spr.executeUpdate();
			    	System.out.println(i);
			    	
			    }
			    catch(Exception ert)
			    {
			    	
			    }
				dispose();
				anewbook fr= new anewbook();
				fr.setVisible(true);

			
			}

		});
		mnAdd.add(mntmNewCategory);
		
		JMenuItem mntmNewBranch = new JMenuItem("New Branch");
		mntmNewBranch.addActionListener(new ActionListener() {
			private JTextField textJTextField;
			public void actionPerformed(ActionEvent e) {
				String newBranch= (String) JOptionPane.showInputDialog(textJTextField, "enter new Branch");
			    Connection con=DBInfo.con;
			    newBranch.toLowerCase();
			    String query= "insert into cbranch values (?)";
			    try{
			    	PreparedStatement spr= con.prepareStatement(query);
			    	spr.setString(1, newBranch.toUpperCase());
			    	int i= spr.executeUpdate();
			    	System.out.println(i);
			    	
			    }
			    catch(Exception ert)
			    {
			    	
			    }
				dispose();
				anewbook fr= new anewbook();
				fr.setVisible(true);

			
			}

		});
		mnAdd.add(mntmNewBranch);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNewLabel = new JLabel("Book Id");
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblBookName = new JLabel("Book Name");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		
		JLabel lblNewLabel_1 = new JLabel("Subject");
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
	    vrauthor.add(0, "---select--");
		JComboBox comboBox = new JComboBox(vrauthor);
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
	    vrsubject.add(0, "---select--");
		JComboBox comboBox_1 = new JComboBox(vrsubject);
		
		JLabel lblCategory = new JLabel("Category");
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
	    vrcategory.add(0, "---select--");
		JComboBox comboBox_2 = new JComboBox(vrcategory);
		
		JLabel lblPublication = new JLabel("Publication");
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
	    vrpublisher.add(0, "---select--");
		JComboBox comboBox_3 = new JComboBox(vrpublisher);
		
		JLabel lblPrice = new JLabel("Price");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition");
		Vector<String> edtion1= new Vector<>();
		edtion1.add("---select--");
		edtion1.add("1st");
		edtion1.add("2nd");
		edtion1.add("3rd");
		edtion1.add("4th");
		edtion1.add("5th");
		edtion1.add("6th");
		edtion1.add("7th");
		edtion1.add("8th");
		edtion1.add("9th");
		edtion1.add("10th");
		
		JComboBox comboBox_4 = new JComboBox(edtion1);
		
		JLabel lblImiNo = new JLabel("Imi No.");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblTotalBooks = new JLabel("Total Books");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblBranch = new JLabel("Branch");
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
	    vrbranch.add(0, "---select--");
		JComboBox comboBox_5 = new JComboBox(vrbranch);
		
		JLabel lblAddBookHere = new JLabel("Add Book Here");
		lblAddBookHere.setFont(new Font("Verdana", Font.PLAIN, 23));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookid= textField.getText();
				String bookname= textField_1.getText();
				String bookprice= textField_2.getText();
				String bookimi= textField_3.getText();
				String totalbook= textField_4.getText();
				String author=comboBox.getSelectedItem().toString();
				String subject=comboBox_1.getSelectedItem().toString();
				String category=comboBox_2.getSelectedItem().toString();
				String publication=comboBox_3.getSelectedItem().toString();
				String edition=comboBox_4.getSelectedItem().toString();
				String branch=comboBox_5.getSelectedItem().toString();
				String compare= "---select--";	
				if(bookid.length()==0||bookname.length()==0||bookprice.length()==0||bookimi.length()==0||totalbook.length()==0||
					author.equalsIgnoreCase(compare)||subject.equalsIgnoreCase(compare)||category.equalsIgnoreCase(compare)||
					publication.equalsIgnoreCase(compare)||edition.equalsIgnoreCase(compare)||branch.equalsIgnoreCase(compare)	)
				{
				     
					JOptionPane.showMessageDialog(null, "fill all the information");
				}
				else
				{
					Connection cons= DBInfo.con;
                    String squery= "insert into bookdata values (?,?,?,?,?,?,?,?,?,?,?) ";
                    try
                    {
                    java.sql.PreparedStatement spr=	cons.prepareStatement(squery);
                    spr.setString(1, bookid);
                    spr.setString(2, bookname);
                    spr.setString(3, author);
                    spr.setString(4, subject);
                    spr.setString(5, category);
                    spr.setString(6, publication);
                    spr.setString(7,bookprice);
                    spr.setString(8, edition);
                    spr.setString(9, bookimi);
                    spr.setString(10, totalbook);
                    spr.setString(11, branch);
                    int i  = spr.executeUpdate();
                    System.out.println(i);
                    }
                    catch(Exception e234){ }
                    textField.setText(null);
        			textField_1.setText(null);
        			textField_2.setText(null);
        			textField_3.setText(null);
        			textField_4.setText(null);
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
			textField_2.setText(null);
			textField_3.setText(null);
			textField_4.setText(null);
			comboBox.setSelectedIndex(0);
			comboBox_1.setSelectedIndex(0);
			comboBox_2.setSelectedIndex(0);
			comboBox_3.setSelectedIndex(0);
			comboBox_4.setSelectedIndex(0);
			comboBox_5.setSelectedIndex(0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addComponent(lblAddBookHere))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnSave)
								.addGap(30)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addGap(48))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(118)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblCategory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel)
											.addComponent(lblBookName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblAuthor)
											.addComponent(lblNewLabel_1)
											.addComponent(lblPublication, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
											.addComponent(lblPrice)
											.addComponent(lblEdition)
											.addComponent(lblImiNo))
										.addGap(26)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
													.addComponent(textField, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
													.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblBranch, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblTotalBooks, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
										.addGap(34)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(comboBox_5, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))))))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddBookHere)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublication)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdition)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImiNo)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalBooks)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
