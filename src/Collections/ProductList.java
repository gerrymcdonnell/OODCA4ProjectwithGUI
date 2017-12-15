/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import XStream.Reader;
import XStream.Writer;
import java.util.Vector;
import myapp.Product;

/**
 *
 * @author gerry
 */
public class ProductList {

    Vector<Product> productList = new Vector<Product>();
    //file name to save and load the vector
    private final String PRODUCTLIST_FILE="ProductListData.xml";

    public ProductList() {
    }

    //size of vector
    public int size() {
        return productList.size();
    }

    //lets add a method to add Question objects to the vector
    public void add(Product obj) {
        productList.addElement(obj);
    }

    public void delete(int index) {
        productList.remove(index);
    }

    //print all
    public void print() {
        for (int i = 0; i < productList.size(); i++) {
            //get the address of each Question in the vector
            Product temp = productList.elementAt(i);
            System.out.println(i + ".) " + temp.toString());
        }
    }

     //returns a product object
     public Product getProductByNumber(int i) {
        Product temp = productList.elementAt(i);
        return temp;
    }

    public void printProductByNumber(int i) {
        Product temp = productList.elementAt(i);
        temp.display();
    }

    public void printProductByID(int i) {
        Product temp = productList.elementAt(i);
        temp.display();
    }

    public void updateProduct(int i,Product updatedProduct)
    {
        productList.elementAt(i).setM_Category(updatedProduct.getM_Category());
        productList.elementAt(i).setsName(updatedProduct.getsName());
        productList.elementAt(i).setsImage(updatedProduct.getsImage());
        productList.elementAt(i).setsDecription(updatedProduct.getsDecription());
        productList.elementAt(i).setPrice(updatedProduct.getPrice());
    }


    //method to clear the vector
    public void clear() {
        productList.clear();
    }

    //search collection for a product with an id of
    public int searchProductByID(int iID) {
        for (int x = 0; x < productList.size(); x++) {
            if (productList.elementAt(x).getID() == iID) {
                //found product
                return x;
            }
        }
        return -1;
    }

    //search collection for a product with an id of
    public Product searchProductName(String sName) {
        for (int x = 0; x < productList.size(); x++) {
            if (productList.elementAt(x).getsName().equals(sName)) {
                //found
                Product p=productList.elementAt(x);
                return p;
            }
        }
        return null;
    }

    //update the stock level for a product
    public void updateStockQuantityByID(int iID, int iAmount) {
        for (int x = 0; x < productList.size(); x++) {
            if (productList.elementAt(x).getID() == iID) {
                //found product
                if (productList.elementAt(x).getM_StockQuantity() != 0) {
                    productList.elementAt(x).setM_StockQuantity(iAmount);
                }
            }
        }
    }

    //Xstream methods
    public void SaveProductList()
    {
       //save product list to file with xstream
        Writer.WriteProductListtoXMLFile(PRODUCTLIST_FILE, this);
    }

    public void LoadProductList(ProductList myList)
    {
        Reader.ReadProductXMLFile(PRODUCTLIST_FILE, myList);
    }

}
