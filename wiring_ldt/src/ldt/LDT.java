/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ldt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Elcot
 */
public class LDT {

    /**
     * @param args the command line arguments
     */
    String description[]=new String[5000];
    double quantity[]=new double[5000];
    String group[]=new String[5000];
    String uom[]=new String[5000];
    double dummy_quantity=0,cot_quantity=0,pvc_quantity=0,heat_shrink_quantity=0,wire_quantity=0,house_quantity=0;
    double terminal_quantity=0,seal_quantity=0,fcov_quantity=0,caps_quantity=0,comp_quantity=0,cove_quantity=0;
    double grom_quantity=0,hard_quantity=0,label_quantity=0,stopper_quantity=0,tape_quantity=0,fuse_quantity=0;
    double etro_quantity=0,clam_quantity=0;
    
    double cot_cycle_time=0,dummy_cycle_time=0,pvc_cycle_time=0,heat_shrink_cycle_time=0,house_cycle_time=0,terminal_cycle_time=0,fcov_cycle_time=0;
    double caps_cycle_time=0,comp_cycle_time=0,grom_cycle_time=0,hard_cycle_time=0,label_cycle_time=0,stopper_cycle_time=0;
    double tape_cycle_time=0,fuse_cycle_time=0,etro_cycle_time=0,clam_cycle_time=0,wire_cycle_time=0,cove_cycle_time=0,_cycle_time=0;
    int bom_length=0;
    LDT()
    {
        deleteCycleTime();
        categorize();
        //System.out.println("fetchCycleTime() = " + fetchCycleTime("Route wires"));
        categorizeBom();
        print();
        //insertCycleTime();
    }
    void categorizeBom()
    {
        int i;
        for(i=0;i<bom_length;i++)
        {
            if(group[i].toLowerCase().contains("seal"))
            {
                
                if(description[i].toLowerCase().contains("cavity") || description[i].toLowerCase().contains("dummy") )
                {
                    if(uom[i].toLowerCase().contains("mm"))
                    {
                        dummy_quantity+=quantity[i]/1000;
                        
                    }
                    else
                    {
                       dummy_quantity+=quantity[i];
                    }
                }
                else
                {
                    if(uom[i].toLowerCase().contains("mm"))
                    {
                        seal_quantity+=quantity[i]/1000;
                        
                    }
                    else
                    {
                       seal_quantity+=quantity[i];
                    }
                }
            }
            else if(group[i].toLowerCase().contains("tube"))
            {
                if(description[i].toLowerCase().contains("cot") )
                {
                    if(uom[i].toLowerCase().contains("mm"))
                    {
                        cot_quantity+=quantity[i]/1000;
                        
                    }
                    else
                    {
                    cot_quantity+=quantity[i];
                    }
                }
                else if(description[i].toLowerCase().contains("vo") )
                {
                    if(uom[i].toLowerCase().contains("mm"))
                    {
                        pvc_quantity+=quantity[i]/1000;
                        
                    }
                    else
                    {
                    pvc_quantity+=quantity[i];
                    }
                }
                else if(description[i].toLowerCase().contains("shrink") )
                {
                    if(uom[i].toLowerCase().contains("mm"))
                    {
                        heat_shrink_quantity+=quantity[i]/1000;
                        
                    }
                    else
                    {
                    heat_shrink_quantity+=quantity[i];
                    }
                }
            }
            else if(group[i].toLowerCase().contains("wire"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        wire_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                wire_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("hous"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        house_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                house_quantity+=quantity[i];
                }
            }
            
            else if(group[i].toLowerCase().contains("trml"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        terminal_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                terminal_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("fcov"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        fcov_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                fcov_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("caps"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        caps_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                caps_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("comp"))
            {
                System.out.println("description[i] = " + description[i]);
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        comp_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                comp_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("cove"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        cove_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                cove_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("grom"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        grom_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                grom_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("hard"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        hard_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                hard_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("labl"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        label_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                label_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("stpr"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        stopper_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                stopper_quantity+=quantity[i];
                }
            }
            
            else if(group[i].toLowerCase().contains("tape"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        tape_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                tape_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("fuse"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        fuse_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                fuse_quantity+=quantity[i];
                }
            }
            
            else if(group[i].toLowerCase().contains("etro"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        etro_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                etro_quantity+=quantity[i];
                }
            }
            else if(group[i].toLowerCase().contains("clam"))
            {
                if(uom[i].toLowerCase().contains("mm"))
                    {
                        clam_quantity+=quantity[i]/1000;
                        
                    }
                else
                {
                clam_quantity+=quantity[i];
                }
            }
        }
       /* System.out.println("cot_quantity = " + cot_quantity);
        System.out.println("pvc_quantity = " + pvc_quantity);
        System.out.println("heat_shrink_quantity = " + heat_shrink_quantity);
        System.out.println("dummy_quantity = " + dummy_quantity);*/
    }
    double fetchCycleTime(String type)
    {
        try
        {
            Connection conn;
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection("jdbc:odbc:wiring");
           Statement st=conn.createStatement();
           ResultSet res=st.executeQuery("select * from ldt_cycle_data where operation='"+type+"'");
           while(res.next())
           {
               return Double.parseDouble(res.getString("cycle_time"));
           }
            
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Fetch Cycle Time = " + e);
        }
        return 0;
    }
    void print()
    {
        System.out.println("RESULT =\n " );
        System.out.println("cot_quantity = " + cot_quantity);
        double cot_time=fetchCycleTime("Cot tube");
        cot_cycle_time=cot_time*cot_quantity;
        System.out.println("cot_cycle_time = " + cot_cycle_time);
        insertCycleTime("cot tube",cot_time,cot_quantity,cot_cycle_time);
        System.out.println("\n");
        
        
        System.out.println("dummy_quantity = " + dummy_quantity);
        double dummy_time=fetchCycleTime("Dummy seal");
        dummy_cycle_time=dummy_time*dummy_quantity;
        System.out.println("dummy_cycle_time = " + dummy_cycle_time);
        insertCycleTime("Dummy seal",dummy_time,dummy_quantity,dummy_cycle_time);
        System.out.println("\n");
        
        System.out.println("pvc_quantity = " + pvc_quantity);
        double pvc_time=fetchCycleTime("PVC tube");
        pvc_cycle_time=pvc_time*pvc_quantity;
        System.out.println("pvc_cycle_time = " + pvc_cycle_time);
        insertCycleTime("PVC tube",pvc_time,pvc_quantity,pvc_cycle_time);

        System.out.println("\n");
        
        System.out.println("heat_shrink_quantity = " + heat_shrink_quantity);
        double heat_time=fetchCycleTime("Heat shrink tube");
        heat_shrink_cycle_time=heat_time*heat_shrink_quantity;
        System.out.println("heat_shrink_cycle_time = " + heat_shrink_cycle_time);
                insertCycleTime("Heat shrink tube",heat_time,heat_shrink_quantity,heat_shrink_cycle_time);

        System.out.println("\n");
        
        
        System.out.println("house_quantity = " + house_quantity);
        double house_time=fetchCycleTime("Connectors");
        house_cycle_time=house_time*house_quantity;
        System.out.println("house_cycle_time = " + house_cycle_time);
                insertCycleTime("Connectors",house_time,house_quantity,house_cycle_time);

        System.out.println("\n");
        
        System.out.println("terminal_quantity="+terminal_quantity);
        double terminal_time=fetchCycleTime("Total terminal fitting");
        terminal_cycle_time=terminal_time*terminal_quantity;
        System.out.println("terminal_cycle_time = " + terminal_cycle_time);
                insertCycleTime("Total terminal fitting",terminal_time,terminal_quantity,terminal_cycle_time);

        System.out.println("\n");
        
        
        System.out.println("fcov_quantity="+fcov_quantity);
        double fcov_time=fetchCycleTime("Fuse box cover");
        fcov_cycle_time=fcov_time*fcov_quantity;
        System.out.println("fcov_cycle_time = " + fcov_cycle_time);
                insertCycleTime("Fuse box cover",fcov_time,fcov_quantity,fcov_cycle_time);

        System.out.println("\n");
        
        System.out.println("caps_quantity="+caps_quantity);
        double cap_time=fetchCycleTime("Cap");
        caps_cycle_time=cap_time*caps_quantity;
        System.out.println("caps_cycle_time = " + caps_cycle_time);
                insertCycleTime("Cap",cap_time,caps_quantity,caps_cycle_time);

        System.out.println("\n");
        
        System.out.println("comp_quantity="+comp_quantity);
        double comp_time=fetchCycleTime("FuseHolder");
        comp_cycle_time=comp_time*comp_quantity;
        System.out.println("comp_cycle_time = " + comp_cycle_time);
                insertCycleTime("FuseHolder",comp_time,comp_quantity,comp_cycle_time);

        System.out.println("\n");
        
        System.out.println("cove_quantity="+cove_quantity);
        double cove_time=fetchCycleTime("Cover");
        cove_cycle_time=cove_time*cove_quantity;
        System.out.println("comp_cycle_time = " + cove_cycle_time);
                insertCycleTime("Cover",cove_time,cove_quantity,cove_cycle_time);

        System.out.println("\n");
        
        System.out.println("grom_quantity="+grom_quantity);
        double grom_time=fetchCycleTime("Junction Box");
        grom_cycle_time=grom_time*grom_quantity;
        System.out.println("grom_cycle_time = " + grom_cycle_time);
                insertCycleTime("Junction Box",grom_time,grom_quantity,grom_cycle_time);

        System.out.println("\n");
        
         System.out.println("hard_quantity="+hard_quantity);
         double hard_time=fetchCycleTime("Fasteners");
        hard_cycle_time=hard_time*hard_quantity;
        System.out.println("hard_cycle_time = " + hard_cycle_time);
                insertCycleTime("Fasteners",hard_time,hard_quantity,hard_cycle_time);

        System.out.println("\n");
        
        System.out.println("label_quantity="+label_quantity);
        double label_time=fetchCycleTime("Label");
       label_cycle_time=label_time*label_quantity;
        System.out.println("label_cycle_time = " + label_cycle_time);
                insertCycleTime("Label",label_time,label_quantity,label_cycle_time);

        System.out.println("\n");
        
        System.out.println("stopper_quantity="+stopper_quantity);
        double stop_time=fetchCycleTime("Stopper");
       stopper_cycle_time=stop_time*stopper_quantity;
        System.out.println("stopper_cycle_time = " + stopper_cycle_time);
                insertCycleTime("Stopper",stop_time,stopper_quantity,stopper_cycle_time);

        System.out.println("\n");
        
        
        System.out.println("tape_quantity="+tape_quantity);
        double tape_time=fetchCycleTime("rough tape");
        tape_cycle_time=tape_time*tape_quantity;
        System.out.println("tape_cycle_time = " + tape_cycle_time);
                insertCycleTime("rough tape",tape_time,tape_quantity,tape_cycle_time);

        System.out.println("\n");
        
        System.out.println("fuse_quantity="+fuse_quantity);
        double fuse_time=fetchCycleTime("Fuse");
        fuse_cycle_time=fuse_time*fuse_quantity;
        System.out.println("fuse_cycle_time = " + fuse_cycle_time);
                insertCycleTime("Fuse",fuse_time,fuse_quantity,fuse_cycle_time);

        System.out.println("\n");
        
        System.out.println(" etro_quantity="+ etro_quantity);
        double etro_time=fetchCycleTime("Diode fixing");
         etro_cycle_time=etro_time* etro_quantity;
        System.out.println(" etro_cycle_time = " +  etro_cycle_time);
                insertCycleTime("Diode fixing",etro_time,etro_quantity,etro_cycle_time);

        System.out.println("\n");
        
        
         System.out.println(" clam_quantity="+ clam_quantity);
         double clam_time=fetchCycleTime("Cable strap fixing");
         clam_cycle_time=clam_time* clam_quantity;
        System.out.println(" clam_cycle_time = " +  clam_cycle_time);
                insertCycleTime("Cable strap fixing",clam_time,clam_quantity,clam_cycle_time);

        
        System.out.println("\n");
        
        
        System.out.println(" wire_quantity="+ wire_quantity);
        double wire_time=fetchCycleTime("Route wires");
         wire_cycle_time=wire_time* wire_quantity;
        System.out.println(" wire_cycle_time = " +  wire_cycle_time);
                insertCycleTime("Route wires",wire_time,wire_quantity,wire_cycle_time);

        
        
        
        
        
        
        
        
        
        
    }
    void insertCycleTime(String cat,double cycle,double qty,double total)
    {
        try
         {
             Connection conn;
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             conn=DriverManager.getConnection("jdbc:odbc:wiring");
            
            //Query Statement
            Statement st = conn.createStatement();
            st.execute("insert into total_ldt_cycle_time(operation,cycle_time,quantity,total_cycle_time) values('"+cat+"',"+cycle+","+qty+","+total+")");
            conn.close(); 
         }
         catch(Exception e)
         {
             System.out.println(e);
         }   
        
    }
    void categorize()
    {
        try
        {
            Connection conn;
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection("jdbc:odbc:wiring");
           Statement st=conn.createStatement();
           ResultSet res=st.executeQuery("select * from ldt_bom");
           while(res.next())
           {
               System.out.println("bom_length = " + bom_length);
               String descript=res.getString("Description");
               if(descript==null)
               {
                   break;
               }
               description[bom_length]=descript;
               group[bom_length]=res.getString("Tech Group");
               uom[bom_length]=res.getString("UOM");
               try
               {
               quantity[bom_length]=Double.parseDouble(res.getString("Qty"));
               }
               catch(Exception doub)
               {
                   System.out.println("double Exception = " + doub);
               }
               bom_length++;
               
           }
            
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("categorize Exception = " + e);
        }
    }
    void deleteCycleTime()
    {
         try
        {
            Connection conn;
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection("jdbc:odbc:wiring");
           Statement st=conn.createStatement();
          st.executeQuery("delete from total_ldt_cycle_time");
           
            
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("categorize Exception = " + e);
        }

        
    }
    public static void main(String[] args) {
        // TODO code application logic here
      
    }
}

