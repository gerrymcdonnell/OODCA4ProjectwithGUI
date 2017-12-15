/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp;
import java.util.Vector;
import utils.Methods;
/**
 *
 * @author student
 */
public class Order {
    private int id;
    private String dDate; //will need to be a date field
    private Customer mCustomer;
    private Vector <Product> m_OrderedProducts=new Vector(); //collection of ordered products
    private double m_discountAmount=0;
    private double m_orderTotal=0;

    private final double VAT_RATE=0.21;



    //Getters and setters
    public String getdDate() {
        return dDate;
    }

    public void setdDate(String dDate) {
        this.dDate = dDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getM_orderTotal() {
        return m_orderTotal;
    }

    public void setM_orderTotal(double m_orderTotal) {
        this.m_orderTotal = m_orderTotal;
    }




    @Override
    public String toString() {
        return "id= " + id + "\ndDate=" + dDate;
    }

    public void addProduct(Product p)
    {
        m_OrderedProducts.add(p);
    }



    public Order()
    {
        this.id = -1;
        this.dDate = "a date";
        this.mCustomer = null;
    }

    public Order(int id, String dDate, Customer mCustomer) {
        this.id = id;
        this.dDate = dDate;
        this.mCustomer = mCustomer;
    }

    //create an order and add one product
    public Order(int id, String dDate, Customer mCustomer,Product p) {
        this.id = id;
        this.dDate = dDate;
        this.mCustomer = mCustomer;
        addProduct(p); //add product to order vector
    }

    //create an order and an vector of products
    public Order(int id, String dDate, Customer mCustomer,Vector <Product> vP) {
        this.id = id;
        this.dDate = dDate;
        this.mCustomer = mCustomer;
        m_OrderedProducts=vP; //shud copy them in?
    }

    //get the customer object
    public Customer getCustomer()
    {
        return this.mCustomer;
    }

    //get the ordered products vector
    public Vector <Product>getProductsOrdered()
    {
        return m_OrderedProducts;
    }
    //add up all product totals and return value
    public double getTotal()
    {
        double tempTotal=0;
        double tempVAT=0;
        double tempRoundNum=0;

        for(int i=0;i<m_OrderedProducts.size();i++)
        {
            tempTotal+=m_OrderedProducts.elementAt(i).getPrice();
        }
        //apply VAT RATE
        tempVAT=calculateVAT(tempTotal);

        //round number
        tempTotal=Methods.RoundNumber(tempTotal);

        return tempTotal+tempVAT;
    }

    private double calculateVAT(double dAmount)
    {
        return  Methods.RoundNumber(dAmount*VAT_RATE);
    }

    public void display()
    {
        System.out.println(toString());
        mCustomer.display();
        for(int i=0;i<m_OrderedProducts.size();i++)
        {
            m_OrderedProducts.elementAt(i).display();
        }

        m_orderTotal=getTotal();        

        m_discountAmount=mCustomer.getDiscount(getTotal());

        if(m_discountAmount!=0)
        {
            //apply discount
            m_orderTotal=m_orderTotal-m_discountAmount;
            System.out.println("With Discount of ( € " + m_discountAmount + ") Order Total: € " + m_orderTotal );
        }
        else
        {
            //no discount
            System.out.println("No Discount: Order Total: € " + m_orderTotal );
        }


        //System.out.println("VAT Added: "+ calculateVAT);
        

    }




}
