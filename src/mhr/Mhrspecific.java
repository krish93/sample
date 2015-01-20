/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Elcot
 */
public class Mhrspecific extends javax.swing.JFrame {

    /**
     * Creates new form Mhrspecific
     */
    String selection;
    int row_count=0;
    String dir = System.getProperty("user.dir");
    Map<String,Integer> repeatedName=new HashMap<String,Integer>();
    
    /*String[] columnNames = {"ID",
                        "MACHINE NAME",
                        "TYPE",
                        "SPECIFICATION",
                        "MAKE","MACHINE COST/YEAR","MACHINE UPTIME/YEAR","MAINTANANCE COST","CONSUMABLES COST","POWER CHARGES/YEAR","SPACE COST/YEAR",
                         "FIX","VAR","MHR","MMR"};*/
    
    


    
  Object[][] data =new Object[50][50];


    

    public Mhrspecific() {
        System.out.println("callled = ");
       
        initComponents();
         hashmap();
        // table.setVisible(false);
        // table.isVisible();
         jButton2.setEnabled(false);
        System.out.println("hash");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        category = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryItemStateChanged(evt);
            }
        });
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel1.setText("Select a Category");

        jButton1.setText("Get Result in Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("MHR CALCULATOR");

        jButton2.setText("Get Result in Table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryItemStateChanged
        // TODO add your handling code here:
        selection=category.getSelectedItem().toString();
        selection=selection.toLowerCase();
        System.out.println("selection = " + selection); 
        
        
        
          
    }//GEN-LAST:event_categoryItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("in go");
        select_from_file();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       // new MhrspecificTable().setVisible(true);
        //System.out.println("data = " + data);
      
        TableIcon frame = new TableIcon(data,row_count);
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    




    }//GEN-LAST:event_jButton2ActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed
    void hashmap()
    {
        BufferedReader br=null;
          try
          {
              dir+="\\Files";
              br= new BufferedReader(new FileReader(dir+"\\consolidate_result.txt"));
              while( br.ready() )
              {
                  

                  String ar[]=br.readLine().split(",");
                 
                  
                   ar[0]=ar[0].toLowerCase();
                  if(repeatedName.containsKey(ar[0]))
                {
                    repeatedName.put(ar[0],repeatedName.get(ar[0])+1);
                }
                else
                {
                    repeatedName.put(ar[0],1);
                }
              }
          }
          catch(Exception e)
          {
              System.out.println("read = " +e);
          }
        
        //select_from_file();
          seeHashResult();
    }
    void seeHashResult()
     {
         Set set=repeatedName.entrySet();
         Iterator inc=set.iterator();
         
         while(inc.hasNext())
         {
             Map.Entry me=(Map.Entry)inc.next();
             
             System.out.print("data = " + me.getKey());
             String entries=me.getKey().toString();
             entries=entries.toUpperCase();
             category.addItem(entries);
             
         }
     }
     
    void select_from_file()
    {
          File f=new File("specific.xlsx");
          XSSFWorkbook workbook = new XSSFWorkbook(); 
          XSSFSheet spreadsheet = workbook.createSheet("Result");
          XSSFRow row=spreadsheet.createRow(1);
          XSSFCell cell;
          cell=row.createCell(1);
          cell.setCellValue("ID");
          cell=row.createCell(2);
          cell.setCellValue("MACHINE NAME");
          cell=row.createCell(3);
          cell.setCellValue("TYPE");
          cell=row.createCell(4);
          cell.setCellValue("SPECIFICATION");
          cell=row.createCell(5);
          cell.setCellValue("MAKE");
          cell=row.createCell(6);
          cell.setCellValue("MACHINE COST/YEAR");
          cell=row.createCell(7);
          cell.setCellValue("MACHINE UPTIME/YEAR");
          cell=row.createCell(8);
          cell.setCellValue("MAINTANANCE COST");
          cell=row.createCell(9);
          cell.setCellValue("CONSUMABLES COST");
          cell=row.createCell(10);
          cell.setCellValue("POWER CHARGES/YEAR");
          cell=row.createCell(11);
          cell.setCellValue("SPACE COST/YEAR");
          cell=row.createCell(12);
          cell.setCellValue("FIX");
          cell=row.createCell(13);
          cell.setCellValue("VAR");
          cell=row.createCell(14);
          cell.setCellValue("MHR");
          cell=row.createCell(15);
          cell.setCellValue("MMR");
          
          //read from file
          BufferedReader br=null;
          try
          {
              String sCurrentLine;
              br= new BufferedReader(new FileReader(dir+"\\consolidate_result.txt"));
              int j=2,row_len=2,id=1;


              while( br.ready() )
              {
                  
                  String ar[]=br.readLine().split(",");
                 //System.out.println("ar[0] = " + ar[0]);
                  //System.out.println("ar[1] = " + ar[1]);
                  //System.out.println("ar[2] = " + ar[2]);
                 // System.out.println("ar[3] = " + ar[3]);
                  ar[0]=ar[0].toLowerCase();
                  System.out.println("selection in priint = " + selection);
                 if(ar[0].equals(selection))
                 {
                     row=spreadsheet.createRow(row_len);
                  cell=row.createCell(1);
                  cell.setCellValue(id);
                  data[row_count][0]=id;
                     System.out.println(" data[row_count][0]= " +  data[row_count][0]);


                     System.out.println("inside specific print= " );
                     System.out.println("ar[0] = " + ar[0]);
                   for(int i=0;i<14;i++)
                   {
                     cell=row.createCell(j);
                     cell.setCellValue(ar[i]);
                     System.out.println("ar[i] = " + ar[i]);
                     
                     data[row_count][i+1]=ar[i];
                     
                    System.out.println(" data[row_count][i+1]= " +  data[row_count][i+1]);


                     j++;
                   }
                   row_len++;
                   row_count++;

                   j=2;
                   id++;
                 }
                  
                  
                 
              }
              FileOutputStream out = new FileOutputStream(f);
              workbook.write(out);
              JOptionPane.showMessageDialog(this,"Result generated in 'Specific.xlsx");
              jButton1.setEnabled(false);
                       jButton2.setEnabled(true);

              out.close();
           
          }
          catch(Exception e)
          {
              System.out.println("IO Exception = "+e);
          }
          finally
          {
              try
              {
                  if(br != null)
                       br.close();
                  
              }
              catch(Exception e)
              {
                  System.out.println("finally");
              }
          }
      
      
      
      
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mhrspecific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mhrspecific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mhrspecific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mhrspecific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // Mhrspecific specific=new Mhrspecific();
        //specific.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox category;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
