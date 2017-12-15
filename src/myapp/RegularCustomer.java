/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp;

/**
 *
 * @author gerry
 */
public class RegularCustomer extends Customer{

    private final double DISCOUNT_RATE=0.05;
    private final double DISCOUNT_AMOUNT_REQUIRED=400;

    public double getDiscount(double orderTotal)
    {
        //give a discount to customers only if they have met
        //the DISCOUNT_AMOUNT_REQUIRED
        if(orderTotal>=DISCOUNT_AMOUNT_REQUIRED)
            return orderTotal*DISCOUNT_RATE;
        else
            return 0;
    }

    public RegularCustomer() {
        super();
    }

    public RegularCustomer(int ID, String sName, String sAddress, double balance)
    {
        super(ID, sName, sAddress, balance);
    }





}
