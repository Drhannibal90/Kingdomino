
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButton implements ActionListener {

    private Model p;
    private Fenetre f;

    public ControlButton(Model p, Fenetre f) {
        this.p = p;
        this.f = f;
        this.f.setControlButton(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Début de la partie");
        f.switchFrame();
        String j1 = ((MenuG)f.getImageMenu()).getJ1().getText();
        if (j1.length() == 0)
            j1 = "Joueur 1";
        String j2 = ((MenuG)f.getImageMenu()).getJ2().getText();
        if (j2.length() == 0)
            j2 = "Joueur 2";
        System.out.println("Le joueur 1 s'appele : " + j1 );
        System.out.println("Le joueur 2 s'appele : " + j2 );

    }

    public void placeImageDomino(Domino dm){

    }
}
