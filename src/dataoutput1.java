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

public class dataoutput1 extends JPanel{

    JTable jt;
    public dataoutput1(String input,int num,String geter){

        
      String s[]={"hi"};
        System.out.println(input);
        
        String data [][]= new String [num][11];
  
      Connection con= DBInfo.con;
     
      String query="select * from bookdata where "+geter+"=?";
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
				data[i][4]=res.getString(5);
				data[i][5]=res.getString(6);
			    
				data[i][6]=res.getString(7);
				data[i][7]=res.getString(8);
				data[i][8]=res.getString(9);
				data[i][9]=res.getString(10);
				data[i][10]=res.getString(11);
				
				
				}
			
		}
		catch(Exception wewr){}
              
              String clmname[]={"Book Id","Book Name","Author","Subject","Category","Publication","Price","Edition","IMI NO","Total Book","Branch"};
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

