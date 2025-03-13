/**
 * @(#)MountImagePanel.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
/**This class is a <code>JPanel</code> where an image is mounted from a file
 **/
public class MountImagePanel extends JPanel{
        
             
    /**image This field represents the image that is goin to be loaded into the <code>MountImagePanel</code> */
     private Image imagen;
     /**imagePath This field is the current path of the <code>image</code> file*/
     private File imagePath;
     /**imageHeight represents the <code>image</code> height*/
     private int imageHeight;
     /**imageWidth represents the <code>image</code> width*/
     private int imageWidth;
     /**cliente is the name that is going to be drawn infront of the <code>image</code>*/
     private String cliente;
    
    /**
     * Creates a new instance of <code>MountImagePanel</code> with the following details 
     *@param imageName It is the name of the imagethat is going to be drawn into the panel
     *@param imageWidth It is the Width of the image
     *@param imageHeigth It is the Heigth of the image
     */ 
    public MountImagePanel(String imageName,int imageWidth,int imageHeight)  {
    	imagePath=new File(imageName);
    	this.imageHeight=imageHeight;
    	this.imageWidth=imageWidth;
    	cliente="";
    	 try{
        
        loadImage();
        
        }
        catch(IOException ex){
        	this.add(new JTextArea(""+ex.getMessage()));
        }
    	
    	
    }
    
    /**This method is used to load a <code>String</code> that is going to be shown in the panel.
     * @nombre Is the name of the customer that is going to be drawn in the panel
     */
   
    public void cargaNombre(String nombre){
    	cliente=nombre;
    	repaint(); //Call to the paint()method so it can redraw an then show the name in the panel
    }
    /**This method loads the image file 
     *@throws IOException If the image file is not found*/
    public void loadImage() throws IOException{
    	if(imagePath.isFile()){
    		imagen=Toolkit.getDefaultToolkit().getImage(imagePath.toString());
    	}
    	else throw new IOException("Problems loading image");
    	
    }
    
    /**This methods overrides the <code>paint()</code> method of the <code>Componet</code> class
     **/
      public void paint(Graphics g){
    	
    	g.drawImage(imagen,0,0,imageWidth,imageHeight,this);
    	g.drawString(cliente,10,10);
        }
}
