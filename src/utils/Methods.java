/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

/**
 *
 * @author gerry
 */
public class Methods {

    public static void PrintString(String s)
    {
        System.out.println(s);
    }

    //problem seems to round to 3 decimal places
    public static double RoundNumber(double dNum)
    {
        double result = dNum * 100;
        result = Math.round(result);
        result = result / 100;
        return result;
    }

    public static int StringToInt(String s)
    {
        try{
            int itemp;
            itemp= Integer.parseInt(s);
            return itemp;
        }
        catch(Exception NumberFormatException)
        {
            return -1;
        }
    }

    public static double StringToDouble(String s)
    {
        return Double.parseDouble(s);
    }

    public static String IntToString(int i)
    {
        return Integer.toString(i);
    }

    public static String DoubleToString(double d)
    {
        return Double.toString(d);
    }
}
