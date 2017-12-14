import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by hannibal on 11/26/17.
 */
public class Clavier implements KeyListener {
    private Fenetre fenetre;
    private Model plateau;
    private int position;
    private PlateauGraphic pltG;

    public Clavier(Fenetre fenetre, Model plateau) {
        this.fenetre = fenetre;
        this.plateau = plateau;
        fenetre.setClavier(this);
        position = 0;
        pltG = (PlateauGraphic) fenetre.getImagePlateau();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyChar());
        if (keyEvent.getKeyChar() == 'd'){
            pltG.setPositionMouse(pltG.getPositionMouse()+1);


        }
        System.out.println("Le domino à changé de position ! ");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
