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

public class CustomerList {
    Vector<Customer> customerList = new Vector<Customer>();
    //file name to save and load the vector
    private final String CUSTOMERLIST_FILE="CustomerListData.xml";

    public CustomerList() {
    }

    //size of vector
    public int size() {
        return customerList.size();
    }

    //lets add a method to add Question objects to the vector
    public void add(Customer obj) {
        customerList.addElement(obj);
    }

    public void delete(int index) {
        customerList.remove(index);
    }

    //print all
    public void print() {
        for (int i = 0; i < customerList.size(); i++) {
            //get the address of each Question in the vector
            Customer temp = customerList.elementAt(i);
            System.out.println(i + ".) " + temp.toString());
        }
    }

    //returns a  object
     public Customer getCustomerByNumber(int i) {
        Customer temp = customerList.elementAt(i);
        return temp;
    }

    public void printCustomerByNumber(int i) {
        Customer temp = customerList.elementAt(i);
        temp.display();
    }

    public void printCustomerByID(int i) {
        Customer temp = customerList.elementAt(i);
        temp.display();
    }

    public void updateCustomer(int i,Customer updatedCustomer)
    {
        customerList.elementAt(i).setID(updatedCustomer.getID());
        customerList.elementAt(i).setsName(updatedCustomer.getsName());
        customerList.elementAt(i).setsAddress(updatedCustomer.getsAddress());
        customerList.elementAt(i).setBalance(updatedCustomer.getBalance());
    }


     //search collection for a product with an id of
    public Customer searchCustomerName(String sName) {
        for (int x = 0; x < customerList.size(); x++) {
            if (customerList.elementAt(x).getsName().equals(sName)) {
                //found customer
                Customer c=customerList.elementAt(x);
                return c;
            }
        }
        return null;
    }

    //method to clear the vector
    public void clear() {
        customerList.clear();
    }


     //Xstream methods
    public void SaveCustomerList()
    {
       //save product list to file with xstream
        Writer.WriteCustomerListtoXMLFile(CUSTOMERLIST_FILE, this);
    }

    public void LoadCustomerList(CustomerList myList)
    {
        Reader.ReadCustomerXMLFile(CUSTOMERLIST_FILE, myList);
    }
}
