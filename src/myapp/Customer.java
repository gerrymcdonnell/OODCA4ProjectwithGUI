/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp;

/**
 *
 * @author student
 */
public abstract class Customer {
    private int ID;
    private String sName;
    private String sAddress;    
    private double balance;

    //abstract method
    public abstract double getDiscount(double orderTotal);

    //getters and setters
    //******************************************************************
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
    //******************************************************************


    public Customer(int ID,String sName, String sAddress,  double balance) {
        this.ID = ID;
        this.sName = sName;
        this.sAddress = sAddress;        
        this.balance = balance;
    }

    public Customer() {
        this.ID = -1;
        this.sName = "A Customer";
        this.sAddress = "Address";
        this.balance = 0;
    }


    public void display()
    {
        System.out.println("ID=" + ID +
                "\nsName=" + sName +
                "\nsAddress=" + sAddress +
                "\nbalance=" + balance);
    }






}
