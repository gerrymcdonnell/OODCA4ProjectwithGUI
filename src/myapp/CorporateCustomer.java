/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp;

/**
 *
 * @author gerry
 */
//special type of customer that buys large amounts of stock
public class CorporateCustomer extends Customer{
    private final double STANDARD_DISCOUNT=0.10;
    private final double EXTRA_DISCOUNT_RATE=0.15;

    private final double DISCOUNT_AMOUNT_REQUIRED=800;

    private String sWebSite;
    private String sEmail;
    private String sContactName;

    public double getDiscount(double orderTotal)
    {
        //give a discount to corporate customers who are special customers
        //eg 10% off an order
        if(orderTotal>=DISCOUNT_AMOUNT_REQUIRED)
            return orderTotal*EXTRA_DISCOUNT_RATE;
        else
            return orderTotal*STANDARD_DISCOUNT;
    }

    public CorporateCustomer() {
        super();
        this.sWebSite = "";
        this.sEmail = "";
        this.sContactName = "";
    }



    public CorporateCustomer(int ID, String sName, String sAddress, double balance, String sWebSite, String sEmail, String sContactName) {
        super (ID,sName, sAddress,balance);
        this.sWebSite = sWebSite;
        this.sEmail = sEmail;
        this.sContactName = sContactName;
    }


    //getters and setters
    //****************************************************************************
    public String getsContactName() {
        return sContactName;
    }

    public void setsContactName(String sContactName) {
        this.sContactName = sContactName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsWebSite() {
        return sWebSite;
    }

    public void setsWebSite(String sWebSite) {
        this.sWebSite = sWebSite;
    }

    @Override
    public String toString() {
        return "sWebSite=" + sWebSite + "\nsEmail=" + sEmail + "\nsContactName=" + sContactName;
    }
    //****************************************************************************


    public void display()
    {
        super.display();
        System.out.println(toString());
    }


}
