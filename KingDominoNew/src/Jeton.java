import javax.swing.*;

public class Jeton {

    ImageIcon image;
    int valeur;
    int etoile;

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

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
