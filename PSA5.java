/* Filename: PSA5.java
 * * //Adam Straus-002396166-astraus and Mike Forbes-002386818-mforbes
 * astraus@skidmore.edu and Mforbes@skidmore.edu
 * Date:10/18/11
 * Description: This class is designed to choose three pictures to put in a collage.  THe first two will be blended and the third will appear in the bottom left of the screen
 * 
 * Please be sure to selet the pictures in the order that they are numbered in the filenaames

*/
public class PSA5 {
public static void main (String[] args)
  {
    String background = FileChooser.pickAFile();  //choosing your three pictures
    String smiley = FileChooser.pickAFile();
    String rover = FileChooser.pickAFile();
    Picture pic1 = new Picture(background);
    Picture pic2 = new Picture(smiley);
    Picture pic3 = new Picture(rover);
    pic1.sepiaTint();
    pic1.blend(pic1,pic2); //This actually gets rid of the need for pic2 because a new picture with both of them has been returned
    pic3.greyScale();
    pic3.show();
    Picture callingObject = new Picture(); 
    Picture collage = callingObject.collage(pic1, pic3); //As you can see our collage method only needs two parameters
    collage.write("Straus_Forbes_PSA5.jpg");
    collage.show();
    

}
}