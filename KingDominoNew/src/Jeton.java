import javax.swing.*;
import java.awt.*;

public class Jeton {

    ImageIcon image;
    int valeur;
    int etoile;
    private int x;
    private int y;

    public Jeton(int valeur,int etoile,ImageIcon image){
        this.valeur=valeur;
        this.etoile=etoile;
        this.image=image;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }

    public Image getImage() {
        return image.getImage();
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Jeton{" +
                "image=" + image +
                ", valeur=" + valeur +
                ", etoile=" + etoile +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
