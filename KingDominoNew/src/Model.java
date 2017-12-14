import javax.swing.*;
import java.awt.*;

public class Model {
    Jeton[][] plateauJoueur1;
    Jeton[][] plateauJoueur2;

    int[] placeXJoueur1;
    int[] placeYJoueur1;
    int[] placeXJoueur2;
    int[] placeYJoueur2;
    private final int POSXCHATEAU = 450;
    private final int POSYCHATEAU = 300;
    private final int TAILLECHATEAU = 73;

    int joueur;

    public int getTAILLECHATEAU() {
        return TAILLECHATEAU;
    }

    public int getPOSXCHATEAU() {
        return POSXCHATEAU;
    }

    public int getPOSYCHATEAU() {
        return POSYCHATEAU;
    }
    /*  valeur plateau
        0= rien
        1= chateau
        2=foret
        3=eau
        4=desert
        5=prairie
        6=mine
        7=champs
     */


    public boolean determineNewXY(Jeton[][] plateauEphemere){
        int[] placeXEphemere =new int[2];
        int[] placeYEphemere =new int[2];

        placeXEphemere[0]=10;
        placeXEphemere[1]=0;
        placeYEphemere[0]=0;
        placeYEphemere[1]=10;

        for(int y=0;y<9;y++){
            for(int x=0;x<9;x++){
                if (plateauEphemere[x][y].getValeur()!=0){
                    if(x<placeXEphemere[0])
                        placeXEphemere[0]=x;
                }
            }
        }
        for(int y=9;y>0;y--){
            for(int x=0;x<9;x++){
                if (plateauEphemere[x][y].getEtoile()!=0){
                    if(y>placeXEphemere[1])
                        placeXEphemere[1]=y;
                }
            }
        }
        for(int y=0;y<9;y++){
            for(int x=9;x>0;x--){
                if (plateauEphemere[x][y].getValeur()!=0){
                    if(x>placeYEphemere[0])
                        placeYEphemere[0]=x;
                }
            }
        }
        for(int y=0;y<9;y++){
            for(int x=0;x<9;x++){
                if (plateauEphemere[x][y].getValeur()!=0){
                    if(y<placeYEphemere[1])
                        placeYEphemere[1]=y;
                }
            }
        }

        if(placeYEphemere[0]-placeXEphemere[0]<=5 && placeXEphemere[1]-placeYEphemere[1]<=5){
            if (joueur==0){
                placeXJoueur1[0]=placeXEphemere[0];
                placeXJoueur1[1]=placeXEphemere[1];
                placeYJoueur1[0]=placeYEphemere[0];
                placeYJoueur1[1]=placeYEphemere[1];

                for(int x=0;x<9;x++){
                    for(int y=0;y<9;y++){
                        plateauJoueur1[x][y].setValeur(plateauEphemere[x][y].getValeur());
                        plateauJoueur1[x][y].setEtoile(plateauEphemere[x][y].getEtoile());
                    }
                }
            }
            else{
                placeXJoueur2[0]=placeXEphemere[0];
                placeXJoueur2[1]=placeXEphemere[1];
                placeYJoueur2[0]=placeYEphemere[0];
                placeYJoueur2[1]=placeYEphemere[1];

                for(int x=0;x<9;x++){
                    for(int y=0;y<9;y++){
                        plateauJoueur2[x][y].setValeur(plateauEphemere[x][y].getValeur());
                        plateauJoueur2[x][y].setEtoile(plateauEphemere[x][y].getEtoile());
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Domino[] generateNewDomino(){
        Domino[] dominos=new Domino[2];
        dominos[0]=generateDomino();
        dominos[1]=generateDomino();

        return dominos;
    }

    public Domino generateDomino(){
        Jeton jeton1 = generateJeton();
        Jeton jeton2 = generateJeton();
        int valeur=(int)Math.round(Math.random()*49+1);

        return new Domino(valeur,jeton1,jeton2);
    }

    public Jeton generateJeton(){
        int valeur=(int)Math.round(Math.random()*5+2);
        int etoile=0;
        ImageIcon image=null;
        double proba = Math.random();

        if (proba<0.5)
            etoile=1;
        if (proba<0.25)
            etoile=2;
        if (proba<0.1)
            etoile=3;

        if (valeur==2)
            image=new ImageIcon("img/foret.png");
        if (valeur==3)
            image=new ImageIcon("img/eau.png");
        if (valeur==4)
            image=new ImageIcon("img/desert.png");
        if (valeur==5)
            image=new ImageIcon("img/prairie.png");
        if (valeur==6)
            image=new ImageIcon("img/mines.png");
        if (valeur==7)
            image=new ImageIcon("img/champs.png");

        return new Jeton(valeur,etoile,image);
    }
}
