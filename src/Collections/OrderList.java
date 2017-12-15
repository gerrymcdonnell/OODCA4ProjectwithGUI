/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Collections;

/**
 *
 * @author gerry
 */
import XStream.Reader;
import XStream.Writer;
import java.util.Vector;
import myapp.Customer;
import myapp.Order;
import myapp.Product;

public class OrderList {
    Vector<Order> orderList = new Vector<Order>();
    //file name to save and load the vector
    private final String ORDERLIST_FILE="OrderListData.xml";


    //size of vector
    public int size() {
        return orderList.size();
    }

    //lets add a method to add Question objects to the vector
    public void add(Order obj) {
        orderList.addElement(obj);
    }

    public void delete(int index) {
        orderList.remove(index);
    }

    //print all
    public void print() {
        for (int i = 0; i < orderList.size(); i++) {
            //get the address of each Question in the vector
            Order temp = orderList.elementAt(i);
            System.out.println(i + ".) " + temp.toString());
        }
    }

    public Order getOrderByNumber(int i) {
        Order temp = orderList.elementAt(i);
        return temp;
    }

    public Customer getCustomer(int i) {
        Customer temp = orderList.elementAt(i).getCustomer();
        return temp;
    }

    public Vector <Product>getProductsOrdered(int i)
    {
        return orderList.elementAt(i).getProductsOrdered();
    }

    public double getOrderTotal(int i)
    {
        return orderList.elementAt(i).getM_orderTotal();
    }

    //Xstream methods
    public void SaveOrderList()
    {
       //save Order list to file with xstream
        Writer.WriteOrderListtoXMLFile(ORDERLIST_FILE, this);
    }

    public void LoadOrderList(OrderList myList)
    {
        Reader.ReadOrderXMLFile(ORDERLIST_FILE, myList);
    }
}
