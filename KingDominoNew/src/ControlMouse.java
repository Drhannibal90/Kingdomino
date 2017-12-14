import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlMouse implements MouseListener, MouseMotionListener {

    private Model plateau;
    private Fenetre fenetre;
    private int caseClicked;
    private int X;
    private int Y;
    private final int TAILLECHATEAU = 100;
    private int taillechateau;
    private PlateauGraphic plateauGraphique;


    public ControlMouse(Model p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlClick(this);
        fenetre.setControlMove(this);
        X = 0;
        Y = 0;
        taillechateau = plateau.getTAILLECHATEAU();
        plateauGraphique = (PlateauGraphic) fenetre.getImagePlateau();

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
       // int tourJoueur = plateau.getTourJoueur();

        if ((x <= plateau.getPOSXCHATEAU()+600 && x >= plateau.getPOSXCHATEAU()-500) && (y <= plateau.getPOSYCHATEAU()+500 && y >= plateau.getPOSYCHATEAU()-500)){
            X = (mouseEvent.getX()-12 )/taillechateau;
            System.out.println("X = " +X);
            Y = (mouseEvent.getY()-12 )/taillechateau;
            System.out.println("Y = " + Y);

            Jeton[][] test =new Jeton[11][11];
            for (int i = 0;i<11;i++){
                for (int j =0;j<11;j++){
                    if ((j!=5||i!=5)){

                        test[i][j] = new Jeton(5,5,resizePicture(new ImageIcon("img/mines.png"),73,73));
                    }else {
                        System.out.println("i : " + i + " j : " + j);
                    }
                }
            }
            plateauGraphique.updateDominos(test);
            plateauGraphique.repaint();
            //* test follow mouse
            Domino d = new Domino(5,new Jeton(5,5,resizePicture(new ImageIcon("img/prairie.png"),73,73)),new Jeton(5,5,resizePicture(new ImageIcon("img/prairie.png"),73,73)));
            plateauGraphique.setJetonForMouse(d);
            plateauGraphique.setFollowMouse(true);


        }

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


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (plateauGraphique.isFollowMouse()){
            plateauGraphique.setCurrentMouseX(mouseEvent.getX());
            plateauGraphique.setCurrentMouseY(mouseEvent.getY());
            plateauGraphique.repaint();
        }
    }
}
