public class Controleur {

    public Controleur(Model p) {
        Fenetre f = new Fenetre(p);
        new ControlMouse(p,f);
        new ControlMenu(p,f);
        new ControlButton(p,f);
        new Clavier(f,p);
        f.setVisible(true);
    }
}
