import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by hannibal on 11/26/17.
 */
public class Clavier implements KeyListener {
    private Fenetre fenetre;
    private Model plateau;

    public Clavier(Fenetre fenetre, Model plateau) {
        this.fenetre = fenetre;
        this.plateau = plateau;
        fenetre.setClavier(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyChar());

        System.out.println("Le domino à changé de position ! ");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
