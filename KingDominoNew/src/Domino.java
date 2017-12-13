public class Domino {

    int valeur;
    Jeton[] jetons;
    int[] position;

    /* valeur  position
        -------------

        0;0 => G D

        -------------

                G
        0;1 =>
                D

        -------------

        1;0 => D G

        -------------

                D
        1;1 =>
                G

        -------------
     */



    public Domino(int valeur, Jeton jeton1, Jeton jeton2){

        this.valeur=valeur;

        jetons=new Jeton[]{jeton1,jeton2};

        position=new int[]{0,0};
    }

    public int getValeur() {
        return valeur;
    }

    public int[] getPosition() {

        return position;
    }

    public void setPosition(int x,int y) {
        position=new int[]{x,y};
    }

    public Jeton[] getJetons() {

        return jetons;
    }
}
