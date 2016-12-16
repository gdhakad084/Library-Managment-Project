import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSet;

public class dataoutput2 extends JPanel{

    JTable jt;
    public dataoutput2(String input,int num,String geter){

        
      String s[]={"hi"};
        System.out.println(input);
        
        String data [][]= new String [num][4];
  
      Connection con= DBInfo.con;
     
      String query="select * from issuedbooks where "+geter+"=?";
      int u,i; 
      try{
			
             
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1, input);
			ResultSet res=(ResultSet) ps.executeQuery();
			ResultSetMetaData remd= res.getMetaData();
             System.out.println(remd.getColumnCount());	
             System.out.println(ps.getMaxRows());
             
			while(res.next())
				{
				    u	=res.getRow();
				i=u-1;
				data[i][0]=res.getString(1);
				data[i][1]=res.getString(2);
				data[i][2]=res.getString(3);
				data[i][3]=res.getString(4);
				
				
				}
			
		}
		catch(Exception wewr){}
              
              String clmname[]={"Reference No","Book Number","Student Id","Book Name"};
              DefaultTableModel model = new DefaultTableModel(data,clmname);
           
              
              
              
              
        JTable table = new JTable(model);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        table.setPreferredScrollableViewportSize(new Dimension((screenSize.width-40),400));
        table.setFillsViewportHeight(true);

        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        add(js);

    }

}

