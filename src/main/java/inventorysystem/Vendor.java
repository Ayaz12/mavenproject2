/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ayaz
 */
public class Vendor {
    
    private static String name;
    private static String number;
    private static String address;
    private static int vendorId;
    private static int id;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/inventorysystem";

    static final String USER = "root";
    static final String PASS = "123456";
   
    static List inventory = new ArrayList();
    
    static Connection conn = null;
    static Statement stmt = null;
    
    
    public Vendor(String name, String number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public Vendor() {
    }

    
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getVendorId() {
        return vendorId;
    }

    public int getId() {
        return id;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public void setId(int id) {
        this.id = id;
    }
    static Scanner input = new Scanner(System.in);
    
    public static int displayMenu()
   {
       System.out.println("1.Add New Vendor");
       System.out.println("2.Find Vendor");
       System.out.println("3.Delete Vendor");
       System.out.println("5.Exit");
       System.out.println("Please Enter your Choice : ");
       
       int i = input.nextInt();
       return i;
   }
    public static void run() throws SQLException, ClassNotFoundException
   {
       while(true)
       {
           int i = displayMenu();
           switch(i)
                   {
                    case 1: addVendor();
                    break;
                    
                    case 2: findVendor();
                    break;
                        
                    case 3: deleteVendor();
                    break;
                        
                    case 4: System.exit(0);
                    default:System.out.println("Invalid Entry !!");
                   
                       }
       }
   }
    
    public static void addVendor() throws SQLException 
   {
       System.out.println("Add new Items : ");
       int count = input.nextInt();
       String sql;
      
       for(int i=0 ; i<count; i++)
       {
         System.out.println("Enter ID : ");
         int id = input.nextInt();
         System.out.println("Enter Vendor name : ");
         String name = input.next();
         System.out.println("Enter Number : ");
         String number = input.next();
         System.out.println("Enter VendorID : ");
         int vendorID = input.nextInt();
         
         System.out.println("ID: "+id +" " + " Name: "+name +" "+ "VendorID: "+vendorID+ " " + "Number: "+number+" "+"Address: "+address);
         
         stmt = conn.createStatement();
            
            sql = "INSERT INTO product(id,name,vendorname,barcode,price,quantity)"
                 + " VALUES ('"+id+"','"+name+"','"+number+"','"+address+"','"+vendorID+"')";
                         
        stmt.executeUpdate(sql);  
         
          
       }
       
       
    
      
   }
    public static void findVendor() throws SQLException
   {
       System.out.println("Enter ID of the Vendor : ");
       int id = input.nextInt();
       
       String sql;
       stmt = conn.createStatement();
       sql = "SELECT FROM product WHERE id = '"+id+"'"; 
       
       System.out.println("Successfully Find Record");
      
      }
    
     public static void deleteVendor() throws SQLException
   {
       
       System.out.println("Enter the ID of Vendor: ");
       int id = input.nextInt();
       String sql;
       sql = "DELETE FROM product WHERE id = '"+id+"'"; 
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);  
       System.out.println("Successfully Record Deleted");
   }
   
    public static void main(String[] arg) throws SQLException
    {
        
        Connection con = null;
        Statement stat = null;
        
        Vendor vendor = new Vendor();
   try{
       Class.forName("com.mysql.jdbc.Driver");
       
       System.out.println("Connecting to database..");
       con = DriverManager.getConnection(DB_URL, USER, PASS);
       
       System.out.println("Creating statement..");
       stat = con.createStatement();
       
       vendor.addVendor();
       String sql;
       sql = ("SELECT id ,name, address, number,vendorID FROM vendor");
       ResultSet rs = stat.executeQuery(sql);
   
       while(rs.next())
       {
           int id = rs.getInt("id");
           String name = rs.getString("name");
           String number = rs.getString("number");
           String address = rs.getString("address");
           int vendorID = rs.getInt("vendorID");
         
                   
           
           System.out.print(" ID: " + id);
           System.out.print(" name: " + name);
           System.out.print(" address: " + address);
           System.out.println(" number: " + number);
           System.out.println(" vendorID: " + vendorID);
           
       }
       rs.close();
       con.close();
       stat.close();
   } catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
     
      try{
         if(stat!=null)
            stat.close();
      }catch(SQLException se){
      }
      try{
         if(con!=null)
            con.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
   }
                  
       }
   
   
    

