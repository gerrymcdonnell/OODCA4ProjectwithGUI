/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testing;

import Collections.ProductList;
import XStream.Writer;
import java.util.Vector;
import myapp.*;
import utils.Methods;


/**
 *
 * @author student
 */
public class testClasses {

    public static void main(String[] args)
    {

        testProduct();

        testCustomer();

        testOrders();

        testMethods();

    }

    public static void testProduct()
    {
        //create a product
        ProductList productlist=new ProductList();        

        Product p1=new Product(1,"Goodfellas","A Mob story",12.99,"DVD");
        Product p2=new Product(1,"Black Hawk Down","Military Drama",15.99,"DVD");
        Product p3=new Product(1,"The Godfather","A Mob story",13.99,"DVD");

        productlist.add(p1);
        productlist.add(p2);
        productlist.add(p3);

        for(int i=0;i<productlist.size();i++)
        {
            productlist.printProductByNumber(i);
        }

        //productlist.SaveProductList(); works

        //productlist.LoadProductList(productlist); works
    }

    public static void testCustomer()
    {
        Vector <Customer> CustomerList=new Vector();

        Customer c1=new RegularCustomer();
        Customer corp1=new CorporateCustomer(); //CorporateCustomer(int ID, String sName, String sAddress, float balance, String sWebSite, String sEmail, String sContactName) {
        Customer c2=new RegularCustomer(2,"timmy o tool","12 hill street,dundalk",0);   //int ID, String sName, String sAddress, float balance
        Customer corp2=new CorporateCustomer(2,"Bobs Auto Parts","12 hill street,dundalk",0,"email","www.www.com","jim Jones");

        CustomerList.add(c1);
        CustomerList.add(corp1);
        CustomerList.add(c2);
        CustomerList.add(corp2);

        System.out.println("Printing " + CustomerList.size() + " customers");
        for(int i=0;i<CustomerList.size();i++)
        {
            System.out.println("Customer [ " + i + " ]");
            CustomerList.elementAt(i).display();            
            System.out.println();
        }
    }


    public static void testOrders()
    {
        Vector <Order> OrderList=new Vector();

        //create customers
        Customer c1=new RegularCustomer();
        Customer corp1=new CorporateCustomer(); //CorporateCustomer(int ID, String sName, String sAddress, float balance, String sWebSite, String sEmail, String sContactName) {
        Customer c2=new RegularCustomer(2,"timmy o tool","12 hill street,dundalk",0);   //int ID, String sName, String sAddress, float balance
        Customer corp2=new CorporateCustomer(2,"Bobs Auto Parts","12 hill street,dundalk",0,"email","www.www.com","jim Jones");

        //create some products
        Vector <Product> StockList=new Vector();

        Product p1=new Product(1,"Goodfellas","A Mob story",12.99,"DVD");
        Product p2=new Product(1,"Black Hawk Down","Military Drama",15.99,"DVD");
        Product p3=new Product(1,"The Godfather","A Mob story",13.99,"DVD");

        StockList.add(p1);
        StockList.add(p2);
        StockList.add(p3);


        //create an order for each customer
        Order o1=new Order(1, "", c1,p1);
        Order o2=new Order(2, "", c2,p2);
        Order o3=new Order(3, "", corp1,StockList);
        Order o4=new Order(4, "", corp2,p3);


        //add orders to vector
        OrderList.add(o1);
        OrderList.add(o2);
        OrderList.add(o3);
        OrderList.add(o4);

        //print them out
        System.out.println("Printing " + OrderList.size() + " order");
        for(int i=0;i<OrderList.size();i++)
        {
            System.out.println("Order Num [" + i + "]");
            OrderList.elementAt(i).display();
            System.out.println();
        }
    }

    public static void testMethods()
    {
        System.out.println(Methods.StringToInt("56"));
        System.out.println(Methods.StringToInt("ttt"));
    }

}
