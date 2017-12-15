package XStream;


import Collections.CustomerList;
import Collections.OrderList;
import Collections.ProductList;
import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;
import myapp.Product;

public class Writer {

          

    public static void WriteProductListtoXMLFile(String sFile,ProductList myList)
    {
    	 //Serialize the object
        XStream xs = new XStream();
        //Write to a file in the file system
        try {
            FileOutputStream fs = new FileOutputStream(sFile);
            xs.toXML(myList, fs);
            System.out.println("Saved File: " + sFile);

        } catch (FileNotFoundException E) {
            E.printStackTrace();
        }       
    }


    public static void WriteCustomerListtoXMLFile(String sFile,CustomerList myList)
    {
    	 //Serialize the object
        XStream xs = new XStream();
        //Write to a file in the file system
        try {
            FileOutputStream fs = new FileOutputStream(sFile);
            xs.toXML(myList, fs);
            System.out.println("Saved File: " + sFile);

        } catch (FileNotFoundException E) {
            E.printStackTrace();
        }
    }

    public static void WriteOrderListtoXMLFile(String sFile,OrderList myList)
    {
    	 //Serialize the object
        XStream xs = new XStream();
        //Write to a file in the file system
        try {
            FileOutputStream fs = new FileOutputStream(sFile);
            xs.toXML(myList, fs);
            System.out.println("Saved File: " + sFile);

        } catch (FileNotFoundException E) {
            E.printStackTrace();
        }
    }



}
