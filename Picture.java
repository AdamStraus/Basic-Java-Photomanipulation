/* Filename: Picture.java
 * * //Adam Straus-002396166-astraus and Mike Forbes-002386818-mforbes
 * astraus@skidmore.edu and Mforbes@skidmore.edu
 * Date:10/18/11
 * Description: This class contains all the methods called in PSA5, inclduing
 * greyScale, sepiaTint, and collage among others.
*/
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.awt.Color;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public void subtractColor(int subRed, int subGreen, int subBlue) {
    Pixel[] pA = this.getPixels();
    Pixel p = null;
    int r = 0;
    int g = 0;
      int b = 0;
    for (int i = 0; i < pA.length; i++) {
      p = pA[i];
      r = p.getRed();
      g = p.getGreen();
      b = p.getBlue();
      p.setRed(r-subRed);
      p.setGreen(g-subGreen);
      p.setBlue(b-subBlue);
    }
  }
    public void negative() {
    Pixel[] pANegative = this.getPixels();
    Pixel p = null;
    int i = 0;
      while (i < pANegative.length) {
       p = pANegative[i];
       int oldR = p.getRed();
       int oldG = p.getGreen();
       int oldB = p.getBlue();
       p.setRed(255-oldR);
       p.setGreen(255-oldR);
       p.setBlue(255-oldB);
       i++;
       
    }
      
    
  }
  public void greyScale () {  //This method will make all pixels in the picture grey based on their original brightness
    Pixel[] pAGrey = this.getPixels();
    Pixel p = null;
    int i = 0;
      while (i < pAGrey.length) {
      p = pAGrey[i];
      int r = p.getRed();
      int g = p.getGreen();
      int b = p.getBlue();
      int gScale = (int)((r+g+b)/3);
      p.setRed(gScale);
      p.setGreen(gScale);
      p.setBlue(gScale);
      i++;
    }
  }
  public void swapColor() {
    Pixel[] pA = getPixels();
    Pixel p = null;
      for (int i = 0; i < pA.length; i++) {
      p = pA[i];
      int oRed = p.getRed();
      int oGreen = p.getGreen();
      int oBlue = p.getBlue();
      p.setRed(oBlue);
      p.setGreen(oRed);
      p.setBlue(oGreen);
      }
  }
  public void stripes() {
    Pixel p = null;
    int height = getHeight();
    int width = getWidth();
    int stripe = (int)(getWidth()/20);
      for (int y = 0; y < height; y++) {
      for (int x = 0; x < width-3; x = x+stripe) {
        p = getPixel(x,y);
          p.setRed(255);
          p.setBlue(0);
          p.setGreen(0);
          p = getPixel(x+1,y);
          p.setRed(255);
          p.setBlue(0);
          p.setGreen(0);
          p = getPixel(x+2,y);
          p.setRed(255);
          p.setBlue(0);
          p.setGreen(0);
          
      
    
  }
      }
}
  public void sepiaTint()  //This method will put a sepia filter on the picture it is called on
  {
    Pixel pixel = null;
    double redValue = 0;
    double blueValue = 0;
    double greenValue = 0;
    
    this.greyScale(); //This makes the whole picture grey
    
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
          if (redValue < 60) //These are checks to see what the color value of the pixel is
          {
            redValue = redValue * 0.9;  //these are change to the color dependent on the original color of the pixel
            greenValue = greenValue * 0.9;
            blueValue = blueValue * 0.9;
          }
          
          else if (redValue < 190)
          {
            blueValue = blueValue * 0.8;
          }
          
             else 
              {
              blueValue = blueValue * 0.9;
              }
             
             pixel.setRed((int) redValue);
             pixel.setGreen((int) greenValue);
             pixel.setBlue((int) blueValue);
      }  
    }       
  }
  public void verticalMirror() {
    int width = getWidth();
    int mP = width / 2; //mP stands for mirror Point
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    for (int y = 0; y<getHeight(); y++)
    {
      for (int x = 0; x<mP; x++)
      {
        leftPixel = getPixel(x,y);
        rightPixel = getPixel(width - 1 - x, y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
    
  
  public Picture collage(Picture p1, Picture p2)  //This will put p1 and p2 on the same canvas.  The reason we use only two parameters is because we are
                                                  // already blending two of our original pictures in PSA5 into one picture.
  {

    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    Picture p = new Picture (p1.getWidth(), p1.getHeight());
        for(int sourceX = 0, targetX = 0; sourceX < p1.getWidth(); sourceX++, targetX++) 
        {
          for(int sourceY = 0, targetY = 0; sourceY < p1.getHeight(); sourceY++, targetY++) 
          {
        sourcePixel = p1.getPixel(sourceX, sourceY);
        targetPixel = p.getPixel(targetX, targetY);
        targetPixel.setColor(sourcePixel.getColor());
          }
        }

       for(int sourceX = 0, targetX = 0; sourceX < p2.getWidth(); sourceX++, targetX++) //These for loops put the second picture at the bottom left of the first one
       { 
         for(int sourceY = 0, targetY = (p1.getHeight() - p2.getHeight() - 1); sourceY < p2.getHeight(); sourceY++, targetY++) 
         {
           sourcePixel = p2.getPixel(sourceX, sourceY);
           targetPixel = p.getPixel(targetX, targetY);
           targetPixel.setColor(sourcePixel.getColor());
  }
  }
       return p;
}
  public Picture blend(Picture p1, Picture p2) //This picture will blend two pictures on the vertical axis so they both appear on the same place
  {
    Picture p = null;
    if (p1.getWidth() > p2.getWidth()) //This if statement checks which picture is bigger so you don't get an array out of bounds error
    {
    p = new Picture(p1.getWidth(), p1.getHeight());
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
      for(int sourceX = 0, targetX = 0; sourceX < p2.getWidth(); sourceX++, targetX++) 
        {
          for(int sourceY = 0, targetY = 0; sourceY < p2.getHeight(); sourceY++, targetY++) 
          {
            if (sourceX % 2 == 0) //This puts one  column of pixels from one picture, then the next from the other picture, and switches back and forth 
            {
             sourcePixel = p1.getPixel(sourceX, sourceY);
             targetPixel = this.getPixel(targetX, targetY);
             targetPixel.setColor(sourcePixel.getColor());
            }
            else 
            {
              sourcePixel = p2.getPixel(sourceX, sourceY);
             targetPixel = this.getPixel(targetX, targetY);
             targetPixel.setColor(sourcePixel.getColor());

            }
          }
      }
    } else { //This is the same loop but with p1 and p2 reversed to account for the size differences
    p = new Picture(p2.getWidth(), p2.getHeight());
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
      for(int sourceX = 0, targetX = 0; sourceX < p1.getWidth(); sourceX++, targetX++) 
        {
          for(int sourceY = 0, targetY = 0; sourceY < p1.getHeight(); sourceY++, targetY++) 
          {
            if (sourceX % 2 == 0) 
            {
             sourcePixel = p1.getPixel(sourceX, sourceY);
             targetPixel = this.getPixel(targetX, targetY);
             targetPixel.setColor(sourcePixel.getColor());
            }
            else 
            {
              sourcePixel = p2.getPixel(sourceX, sourceY);
             targetPixel = this.getPixel(targetX, targetY);
             targetPixel.setColor(sourcePixel.getColor());

            }
          }
      }
    }

              
          
return p;
  }
  
 
    
}




   

// end of class Picture, put all new methods before this
 

  
