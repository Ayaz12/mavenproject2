/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;
import java.util.Scanner;
/**
 *
 * @author Ayaz
 */
public class InventorySystem {

    private String name;
    private String address;
    private String number;

    public InventorySystem(String name, String sddress, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public InventorySystem() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
    
    public static void main(String[] args) {
        
        
    }
}
