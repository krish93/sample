/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhr;

/**
 *
 * @author Elcot

*/
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class TableIcon extends JFrame

{
    
    
        String[] columnNames = {"ID",
                        "MACHINE NAME",
                        "TYPE",
                        "SPECIFICATION",
                        "MAKE","MACHINE COST/YEAR","MACHINE UPTIME/YEAR","MAINTANANCE COST","CONSUMABLES COST","POWER CHARGES/YEAR","SPACE COST/YEAR",
                         "FIX","VAR","MHR","MMR"};
    
        Object[][] data_new =new Object[50][50];
    
    
    public TableIcon(Object data[][],int count)
    {
       /* ImageIcon backIcon = getImage("/images/bac.png");
        ImageIcon exitIcon = getImage("/images/exit.png");
        ImageIcon forwardIcon = getImage("/images/forward.png");*/
            System.out.println("data = " + data[0][0]);
             for(int i=0;i<=count;i++)
             {
                 for(int j=0;j<16;j++)
                 {
                     data_new[i][j]=data[i][j];
                     System.out.println("data_new[count]][j] = " + data_new[i][j]);
                                          System.out.println("data[count]][j] = " + data[i][j]);

                 }
                 
             }

       

        DefaultTableModel model = new DefaultTableModel(data_new, columnNames){
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
            
        };
        
        JTable table = new JTable( model )
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment( JLabel.CENTER );
     table.setDefaultRenderer(String.class, centerRenderer);
        
        
       
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
      
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    
    }

  

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

   

}