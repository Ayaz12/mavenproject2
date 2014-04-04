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
public class Product {

   
    
   private static String name;
   private static String barcode;
   private static float price;
   private static int quantity;
   private static int id;
   private static String date;
   private static int vendorID;
   
   static List inventory = new ArrayList();
    
   static Connection conn = null;
   static Statement stmt = null;
   static final String JDBCDriver = "com.mysql.jdbc.Driver";  
   static final String DBURL = "jdbc:mysql://localhost/inventorysystem";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "123456";
   
   public Product(String name, String barcode, float price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public Product() {
    }

    public static String getDate() {
        return date;
    }

    public static int getVendorID() {
        return vendorID;
    }

    public static void setDate(String date) {
        Product.date = date;
    }

    public static void setVendorID(int vendorID) {
        Product.vendorID = vendorID;
    }
    
    
   public static void setId(int id) {
        Product.id = id;
    }

    public static int getId() {
        return id;
    }

    
    public String getCode() {
        return barcode;
    }

     
    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Product.quantity = quantity;
    }

         
    public float getPrice() {
        return price;
    }

    public void setCode(String barcode) {
        this.barcode = barcode;
    }

    public void setPrice(float price) {
       if(price < 0)
       
           System.out.println("Price cannot be negative");
       else
           
       this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "item_name=" + name + ", barcode=" + barcode + ", price=" + price + '}';
    }
 
   static Scanner input = new Scanner(System.in);
   
   public static int displayMenu()
   {
       System.out.println("1.Add Item");
       System.out.println("2.Find Item");
       System.out.println("3.Delete Item");
       System.out.println("4.Count Item");
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
                    case 1: addItem();
                    break;
                    
                    case 2: findItem();
                    break;
                        
                    case 3: deleteItem();
                    break;
                        
                    case 4: countItem();
                    break;
                        
                    case 5: System.exit(0);
                    default:System.out.println("Invalid Entry !!");
                   
                       }
       }
       
   }
      
   public static void addItem() throws SQLException 
   {
       System.out.println("Add new Items : ");
       int count = input.nextInt();
       String sql;
      
       for(int i=0 ; i<count; i++)
       {
         System.out.println("Enter ID : ");
         int id = input.nextInt();
         System.out.println("Enter Item name : ");
         String name = input.next();
         System.out.println("Enter Barcode : ");
         String barcode = input.next();
         System.out.println("Enter Price : ");
         float price = input.nextFloat();
         System.out.println("Enter quantity : ");
         int quantity = input.nextInt();
         System.out.println("Enter date : ");
         String date = input.next();
         System.out.println("Enter VendorID : ");
         int vendorID = input.nextInt();
         System.out.println("ID: "+id +" " + " Name: "+name +" "+ "Barcode: "+barcode +"VendorID: "+vendorID+ " " + "Date: "+date+" "+"Price: "+price+" "+" Quantity: "+quantity);
         
         stmt = conn.createStatement();
            
            sql = "INSERT INTO product(id,name,vendorname,barcode,price,quantity)"
                 + " VALUES ('"+id+"','"+name+"','"+barcode+"','"+price+"','"+quantity+"','"+date+"','"+vendorID+"')";
                         
        stmt.executeUpdate(sql);  
         
          
       }
       
       
    
      
   }
   
   public static void findItem() throws SQLException
   {
       System.out.println("Enter ID of the Item : ");
       int id = input.nextInt();
       
       String sql;
       stmt = conn.createStatement();
       sql = "SELECT FROM product WHERE id = '"+id+"'"; 
       
       System.out.println("Successfully Find Record");
      
      }
   
   public static void countItem()
   {
       System.out.println("Number of Items : "+quantity);
       
   }
   
   public static void deleteItem() throws SQLException
   {
       
       System.out.println("Enter the ID of Item: ");
       int id = input.nextInt();
       String sql;
       sql = "DELETE FROM product WHERE id = '"+id+"'"; 
       stmt = conn.createStatement();
       stmt.executeUpdate(sql);  
       System.out.println("Successfully Record Deleted");
   }
    
  /* public boolean askAgain()  
    {  
        System.out.println("Press 1 to display menu again, press any other key to exit");  
        int ch = input.nextInt();  
        if(ch == 1)  
            return true;  
        else   
            return false;  
    }
   */
    public static void main(String[] args) throws SQLException {
      
        Product product = new Product();
        //product.run();
         
      
   try{     
      
      Class.forName("com.mysql.jdbc.Driver");

      
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DBURL,USER,PASS);
 
   
      System.out.println("Creating statement...");
     
      stmt = conn.createStatement();
      String sql;
      
      //product.findItem();
     
      product.run(); 
      
      
      sql = "SELECT id,name,vendorname,quantity,barcode,price FROM product"; 
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
         
         int id  = rs.getInt("id");
         float price = rs.getFloat("price");
         String barcode = rs.getString("barcode");
         String name = rs.getString("name");
         int quantity = rs.getInt("quantity");
         int vendorID = rs.getInt("vendorID");
          String date = rs.getString("date");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(" name: " + name);
         System.out.print(" barcode: " + barcode);
         System.out.print(" price: " + price);
         System.out.println(" quantity: " + quantity);
         System.out.println(" vendorID: " + vendorID);
         System.out.println(" date: " + date);
  }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
     
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
   }
    }


          







 



