/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

/**
 *
 * @author Ayaz
 */
public class Order {
    
    private static int id;
    private static int orderID;
    private static int customerID;
    private static String ordereDate;

    public Order() {
    }

    public Order(int id, int orderID, int customerID)
    {
        this.id = id;
        this.orderID = orderID;
        this.customerID = customerID;
        
    }

      
    public static int getId() {
        return id;
    }

    public static int getOrderID() {
        return orderID;
    }

    public static int getCustomerID() {
        return customerID;
    }

    public static String getOrdereDate() {
        return ordereDate;
    }

    public static void setId(int id) {
        Order.id = id;
    }

    public static void setOrderID(int orderID) {
        Order.orderID = orderID;
    }

    public static void setCustomerID(int customerID) {
        Order.customerID = customerID;
    }

    public static void setOrdereDate(String ordereDate) {
        Order.ordereDate = ordereDate;
    }

    
    
}

