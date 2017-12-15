/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import utils.ExtensionFilter;

/**
 *
 * @author gerry
 */
public class GUIFunctions {

    //inputbox
    public static String sInputBox(String sTitle, String sPrompt) {
        String s="";
        s=JOptionPane.showInputDialog(null, sTitle, sPrompt, JOptionPane.QUESTION_MESSAGE);
        return s;
    }

    public static void showMsgBox(String sMsg)
    {
        JOptionPane.showMessageDialog(null,sMsg);
    }


    //load the file open dialog
      public static String openFileDialog(boolean imgFilter)//flag for saying we want to have the filter for album files or just images
      {
          JFileChooser fc;
          fc = new JFileChooser();

          FileFilter filterImgFiles = new ExtensionFilter("Image files",new String[] { ".jpg", ".gif", "jpeg" });
          FileFilter filterXmlFiles = new ExtensionFilter("Album files",new String[] { ".xml" });

          if(imgFilter==true)
            fc.addChoosableFileFilter(filterImgFiles);
          else
            fc.addChoosableFileFilter(filterXmlFiles);

           int returnVal = fc.showOpenDialog(null);
           if (returnVal == JFileChooser.APPROVE_OPTION)
           {
                File file = fc.getSelectedFile();
                System.out.println("File " + file.toString());
                return file.toString();
           }
           else
           {
               return "";
           }

       }//end open dialog
}
