import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlateauGraphic extends JPanel {

    private Image imgBg, imgChateau;
    private JButton button;
    private Image imgHeader;
    private ArrayList<Object> listDeSpriteTemporaire; //* listes des sprites à afficher
    private ArrayList<Jeton> listeJeton; //* listes des sprites temporaire à afficher
    private JButton nextP, prevP;
    private JLabel pseudoP, pseudoC;
    private boolean followMouse;
    private int CurrentMouseX;
    private int CurrentMouseY;
    private int positionMouse;
    private Domino dominoTmp;
    /*

    0 = haut
    1 = droite
    2 = bas
    3 = gauche
     */


    public PlateauGraphic(){
        ImageIcon imgTmp = new ImageIcon("img/chateau.jpg");
        imgChateau = resizePicture(imgTmp, 73,73).getImage();
        imgTmp = new ImageIcon("img/parchemin.jpg");
       // imgHeader = resizePicture(imgTmp, 400,200).getImage();
        imgBg = resizePicture(imgTmp, 830,830).getImage();
        listeJeton = new ArrayList<Jeton>();
        listDeSpriteTemporaire = new ArrayList<Object>();
        nextP = new JButton("next");
        prevP = new JButton("prev");
        pseudoP = new JLabel("Tour de : pseudo");
        pseudoC = new JLabel("Chateau de : pseudo");

        setLayout(null);
        nextP.setSize(new Dimension(100,30));
        prevP.setSize(new Dimension(100,30));
        pseudoP.setSize(new Dimension(300,30));
        pseudoC.setSize(new Dimension(300,30));
        pseudoP.setLocation(1000,50);
        pseudoC.setLocation(1000,100);
        nextP.setLocation(1090,150);
        prevP.setLocation(990,150);
        add(prevP);
        add(nextP);
        add(pseudoP);
        add(pseudoC);
        followMouse =false;
        CurrentMouseX = 0;
        CurrentMouseY =0;
        positionMouse = 0;
    }


    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

       g2.drawImage(imgBg, 0,0,null);
        /*
        for (int i = 0; i <= 900; i += 100){
            for (int j = 0; j<850; j+=100){

                g2.drawImage(imgChateau, i,j,null);
            }
        }*/
        g2.drawImage(imgChateau, 5*73+12,5*73+12,null);

        for (Jeton j:listeJeton){
            g2.drawImage(j.getImage(), j.getX()*73+12,j.getY()*73+12,null);
        }
        if (followMouse && dominoTmp != null){
            Image imageJeton1 = dominoTmp.getJetons()[0].getImage();
            Image imageJeton2 = dominoTmp.getJetons()[1].getImage();
            positionMouse = positionMouse%4;
            //System.out.println("pos : "+ positionMouse);
            switch (positionMouse){
                case 0:
                    g2.drawImage(imageJeton1, CurrentMouseX,CurrentMouseY,null);
                    g2.drawImage(imageJeton2, CurrentMouseX,CurrentMouseY-73,null);break;
                case 1:
                    g2.drawImage(imageJeton1, CurrentMouseX,CurrentMouseY,null);
                    g2.drawImage(imageJeton2, CurrentMouseX+73,CurrentMouseY,null);break;
                case 2:
                    g2.drawImage(imageJeton1, CurrentMouseX,CurrentMouseY,null);
                    g2.drawImage(imageJeton2, CurrentMouseX,CurrentMouseY+73,null);break;
                case 3:
                    g2.drawImage(imageJeton1, CurrentMouseX-53,CurrentMouseY,null);
                    g2.drawImage(imageJeton2, CurrentMouseX-126,CurrentMouseY,null);break;
            }

        }




    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }
    public void updateDominos(Jeton[][] tab){
        listeJeton.clear();
        for (int i =0; i < tab.length; i++){
            for (int j =0; j < tab[i].length;j++){
                if (tab[i][j] != null){
                    Jeton tmp = tab[i][j];
                    tmp.setX(i);
                    tmp.setY(j);
                    listeJeton.add(tmp);
                }
            }
        }
        System.out.println(listeJeton.size());
    }
    public void setJetonForMouse(Domino j){
        dominoTmp = j;
    }

    public void addSpritToDisplay(Jeton s){
        listeJeton.add(s);
    }
    public void clearAllSprite(){
        listeJeton.clear();
    }

    public boolean isFollowMouse() {
        return followMouse;
    }

    public void setPositionMouse(int positionMouse) {
        this.positionMouse = positionMouse;
    }

    public int getPositionMouse() {
        return positionMouse;
    }

    public void setFollowMouse(boolean followMouse) {
        this.followMouse = followMouse;
    }

    public void addTemporaireSpritToDisplay(Object s){
        listDeSpriteTemporaire.add(s);
    }
    public void clearAllSpriteTemporaire(){
        listDeSpriteTemporaire.clear();
    }

    public int getCurrentMouseX() {
        return CurrentMouseX;
    }

    public void setCurrentMouseX(int currentMouseX) {
        CurrentMouseX = currentMouseX;
    }

    public int getCurrentMouseY() {
        return CurrentMouseY;
    }

    public void setCurrentMouseY(int currentMouseY) {
        CurrentMouseY = currentMouseY;
    }
}
