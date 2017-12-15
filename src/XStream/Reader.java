package XStream;

import Collections.CustomerList;
import Collections.OrderList;
import Collections.ProductList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.util.Vector;
import myapp.Product;

public class Reader {

   
    public static void ReadProductXMLFile(String sFile,ProductList myList)
    {
    	XStream xs = new XStream(new DomDriver());
    	
    	try {
            FileInputStream fis = new FileInputStream(sFile);
            xs.fromXML(fis, myList);
            System.out.println("\n\nLoaded " + myList.size() + " Products.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }



    public static void ReadCustomerXMLFile(String sFile,CustomerList myList)
    {
    	XStream xs = new XStream(new DomDriver());
    	try {
            FileInputStream fis = new FileInputStream(sFile);
            xs.fromXML(fis, myList);
            System.out.println("\n\nLoaded " + myList.size() + " Customers.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void ReadOrderXMLFile(String sFile,OrderList myList)
    {
    	XStream xs = new XStream(new DomDriver());
    	try {
            FileInputStream fis = new FileInputStream(sFile);
            xs.fromXML(fis, myList);
            System.out.println("\n\nLoaded " + myList.size() + " Orders.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }



    
}

