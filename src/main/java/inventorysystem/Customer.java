/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysystem;

/**
 *
 * @author Ayaz
 */
public class Customer {
    
    private String name;
    private String number;
    private String address;
    private int Id;

    public Customer(String name, String number, String address, int Id) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public Customer() {
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
    
    
    
}

