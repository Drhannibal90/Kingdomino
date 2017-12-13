import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlateauGraphic extends JPanel {

    private Image imgBg;
    private JButton button;
    private Image imgHeader;
    private ArrayList<Object> listDeSpriteTemporaire; //* listes des sprites à afficher
    private ArrayList<Object> listDeSprite; //* listes des sprites temporaire à afficher



    public PlateauGraphic(){
     // imgBg = img;
       ImageIcon imgTmp = new ImageIcon("img/parchemin.jpg");
       // imgHeader = resizePicture(imgTmp, 400,200).getImage();
        imgBg = resizePicture(imgTmp, 990,750).getImage();
        listDeSprite = new ArrayList<Object>();
        listDeSpriteTemporaire = new ArrayList<Object>();


    }


    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

       g2.drawImage(imgBg, 0,0,null);




    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    public void addSpritToDisplay(Object s){
        listDeSprite.add(s);
    }
    public void clearAllSprite(){
        listDeSprite.clear();
    }

    public void addTemporaireSpritToDisplay(Object s){
        listDeSpriteTemporaire.add(s);
    }
    public void clearAllSpriteTemporaire(){
        listDeSpriteTemporaire.clear();
    }

}
