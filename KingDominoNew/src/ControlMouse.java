import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlMouse implements MouseListener {

    private Model plateau;
    private Fenetre fenetre;
    private int caseClicked;
    private int X;
    private int Y;
    private final int TAILLECHATEAU = 100;


    public ControlMouse(Model p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlClick(this);
        X = 0;
        Y = 0;

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
       // int tourJoueur = plateau.getTourJoueur();
        /*
        if ((x <= plateau.getChateau(tourJoueur).getX()+600 && x >= plateau.getChateau(tourJoueur).getX()-500) && (y <= plateau.getChateau(tourJoueur).getY()+500 && y >= plateau.getChateau(tourJoueur).getY()-500)){
            if (mouseEvent.getX() >= plateau.getChateau(tourJoueur).getX() )
                X = (mouseEvent.getX() - plateau.getChateau(tourJoueur).getX())/100;
            else
                X = -1*(6-((( mouseEvent.getX() + plateau.getChateau(tourJoueur).getX())/100)+10)%13);
            System.out.println("X = " +X);
            if (mouseEvent.getY() >= plateau.getChateau(tourJoueur).getY())
                Y = ( plateau.getChateau(tourJoueur).getY() - mouseEvent.getY() )/100;
            else
                Y = 6-((plateau.getChateau(tourJoueur).getY() + mouseEvent.getY() )/100);
            System.out.println("Y = " + Y);


        }*/

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void initCasesPetitPlateau(){

    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }


}
