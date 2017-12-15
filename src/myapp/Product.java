/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp;

/**
 *
 * @author student
 */
public class Product {
    private int ID;
    private String sName;
    private String sDecription;
    private String sImage;
    private String m_Category;
    private double price;
    private int m_StockQuantity;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getsDecription() {
        return sDecription;
    }

    public void setsDecription(String sDecription) {
        this.sDecription = sDecription;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getsImage() {
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

        public String getM_Category() {
        return m_Category;
    }

    public void setM_Category(String m_Category) {
        this.m_Category = m_Category;
    }

    public int getM_StockQuantity() {
        return m_StockQuantity;
    }

    public void setM_StockQuantity(int m_StockQuantity) {
        this.m_StockQuantity = m_StockQuantity;
    }



    public Product(int ID,String sName, String sDecription ,double price,String sCat) {
        this.ID = ID;
        this.sName = sName;
        this.sDecription = sDecription;
        this.price=price;
        this.sImage="N/A";
        this.m_Category=sCat;
        this.m_StockQuantity=1;
    }

    //create product with an image
    public Product(int ID,String sName, String sDecription ,double price,String sProductImage,String sCat) {
        this.ID = ID;
        this.sName = sName;
        this.sDecription = sDecription;
        this.price=price;
        this.sImage=sProductImage;
        this.m_Category=sCat;
        this.m_StockQuantity=1;
    }

    public Product() {
        this.ID = -1;
        this.sName = "default product";
        this.sDecription = "default description";
        this.price=0;
        this.sImage="N/A";
        this.m_Category="default category";
        this.m_StockQuantity=1;
    }

    public void display()
    {
        System.out.println(toString());
    }



    @Override
    public String toString() {
        return "\nID=" + ID +
                "\nsName= " + sName +
                "\nsDecription= " + sDecription +
                "\nprice= " + price +
                "\nCategory= " + m_Category +
                "\nImage= " + sImage +
                "\nStockQuantity= " + m_StockQuantity;
    }









}
