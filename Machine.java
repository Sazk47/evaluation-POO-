import java.util.HashMap;
import java.util.Scanner;

public class Machine {

    private static final double PRIX_COURT = 1.50;
    private static final double PRIX_LONG = 2.00;
    
    private static final int EAU_COURT = 10;
    private static final int EAU_LONG = 20;
    
    private static final int GRAINS_CAFE = 10;
    private static final int GOBELET = 1;
    
    private static final int DUREE_VIE = 5;

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
    
    public void insererArgent(double montant) {
        monnayeur = monnayeur + montant;
    }
    
    private boolean estEntartree() {
        return bacMarc >= DUREE_VIE;
    }
    
    private String verifierDisponibilite(int eauNecessaire, int grainsNecessaires, double prixCafe) {
        if (estEntartree()) {
            return "ERREUR : Machine entartree - Appelez le technicien";
        }
        
        if (monnayeur < prixCafe) {
            return "Credit insuffisant, ajoutez de la monnaie";
        }
        
        if (eau < eauNecessaire) {
            return "Plus d'eau !";
        }
        if (grainsCafe < grainsNecessaires) {
            return "Plus de grains de cafe !";
        }
        if (gobelets < 1) {
            return "Plus de gobelets !";
        }
        
        return "OK";
    }
    
    public boolean servirCafeCourt() {
        String verif = verifierDisponibilite(EAU_COURT, GRAINS_CAFE, PRIX_COURT);
        
        if (!verif.equals("OK")) {
            System.out.println(verif);
            return false;
        }
        
        eau = eau - EAU_COURT;
        grainsCafe = grainsCafe - GRAINS_CAFE;
        gobelets = gobelets - GOBELET;
        
        caisse = caisse + PRIX_COURT;
        monnayeur = monnayeur - PRIX_COURT;
        
        bacMarc = bacMarc + 1;
        
        System.out.println("Votre cafe est pret !");
        return true;
    }
    
    public boolean servirCafeLong() {
        String verif = verifierDisponibilite(EAU_LONG, GRAINS_CAFE, PRIX_LONG);
        
        if (!verif.equals("OK")) {
            System.out.println(verif);
            return false;
        }
        
        eau = eau - EAU_LONG;
        grainsCafe = grainsCafe - GRAINS_CAFE;
        gobelets = gobelets - GOBELET;
        
        caisse = caisse + PRIX_LONG;
        monnayeur = monnayeur - PRIX_LONG;
        
        bacMarc = bacMarc + 1;
        
        System.out.println("Votre cafe est pret !");
        return true;
    }
    
    public double rendreMonnaie() {
        double aRendre = monnayeur;
        monnayeur = 0.0;
        return aRendre;
    }
}
