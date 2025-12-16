import java.util.HashMap;
import java.util.Scanner;

public class Machine {

    private int eau;
    private int grainsCafe;
    private int gobelets;
    private int bacMarc;

    private double monnayeur;
    private double caisse;

   public Machine() {
    eau = 100;
    grainsCafe = 50;
    gobelets = 10;
    bacMarc = 0;
    monnayeur = 0.0;
    caisse = 0.0;
   }
   public int getEau() {
    return eau;
}

public int getGrainsCafe() {
    return grainsCafe;
}

public int getGobelets() {
    return gobelets;
}

public int getBacMarc() {
    return bacMarc;
}

public double getMonnayeur() {
    return monnayeur;
}

public double getCaisse() {
    return caisse;
    }
}
