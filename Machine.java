
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
            return "ERREUR : Machine entartrée - Appelez le technicien";
        }
        
        if (monnayeur < prixCafe) {
            return "Crédit insuffisant, ajoutez de la monnaie";
        }
        
        if (eau < eauNecessaire) {
            return "Plus d'eau !";
        }
        if (grainsCafe < grainsNecessaires) {
            return "Plus de grains de café !";
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
        
        System.out.println("Votre café est prêt !");
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
        
        System.out.println("Votre café est prêt !");
        return true;
    }
    
    public double rendreMonnaie() {
        double aRendre = monnayeur;
        monnayeur = 0.0;
        return aRendre;
    }
    
    public void recharger() {
        eau = 100;
        grainsCafe = 50;
        gobelets = 10;
        System.out.println("Machine rechargee !");
    }
    
    public void detartrer() {
        bacMarc = 0;
        System.out.println("Machine detartree !");
    }
    
    public double recupererCaisse() {
        double montant = caisse;
        caisse = 0.0;
        System.out.println("Caisse recuperee : " + montant + " euros");
        return montant;
    }
    
    public void afficherEtat() {
        System.out.println("\n--- ETAT DE LA MACHINE ---");
        System.out.println("Eau : " + eau + "/100 cl");
        System.out.println("Grains : " + grainsCafe + "/50 g");
        System.out.println("Gobelets : " + gobelets + "/10");
        System.out.println("Cafes servis : " + bacMarc + "/" + DUREE_VIE);
        System.out.println("Credit : " + monnayeur + " euros");
        System.out.println("Caisse : " + caisse + " euros");
        if (estEntartree()) {
            System.out.println("STATUT : HORS SERVICE (entartree)");
        } else {
            System.out.println("STATUT : En service");
        }
        System.out.println("--------------------------\n");
    }
}
