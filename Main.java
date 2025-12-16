import java.util.Scanner;

public class Main {
    
    public static void afficherMenuPrincipal(Machine machine) {
        System.out.println("\n-------------------------------------------------------");
        System.out.print("ETAT : EAU: " + machine.getEau() + "cl");
        System.out.print(" | GRAINS: " + machine.getGrainsCafe() + "g");
        System.out.println(" | GOBELETS: " + machine.getGobelets());
        
        String statut = (machine.getBacMarc() >= 5) ? "ENTARTREE" : "OK";
        System.out.println("CREDIT : " + machine.getMonnayeur() + " euros | PANNES : " + statut);
        System.out.println("-------------------------------------------------------");
        
        System.out.println("1. Inserer une piece (Simuler +0.50 euros)");
        System.out.println("2. Commander un Espresso (1.50 euros)");
        System.out.println("3. Commander un Allonge (2.00 euros)");
        System.out.println("4. MENU TECHNICIEN (Maintenance)");
        System.out.println("5. Quitter");
        System.out.print("\nVotre choix : ");
    }
    
    public static void menuTechnicien(Machine machine, Scanner scanner) {
        boolean retour = false;
        
        while (!retour) {
            System.out.println("\n=== MENU TECHNICIEN ===");
            System.out.println("1. Recharger la machine");
            System.out.println("2. Detartrer la machine");
            System.out.println("3. Recuperer l'argent de la caisse");
            System.out.println("0. Retour au menu principal");
            System.out.print("Votre choix : ");
            
            int choix = scanner.nextInt();
            
            switch (choix) {
                case 1:
                    machine.recharger();
                    break;
                case 2:
                    machine.detartrer();
                    break;
                case 3:
                    machine.recupererCaisse();
                    break;
                case 0:
                    retour = true;
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        boolean continuer = true;
        
        while (continuer) {
            afficherMenuPrincipal(machine);
            int choix = scanner.nextInt();
            
            switch (choix) {
                case 1:
                    machine.insererArgent(0.50);
                    System.out.println("Piece de 0.50 euros inseree");
                    break;
                    
                case 2:
                    machine.servirCafeCourt();
                    break;
                    
                case 3:
                    machine.servirCafeLong();
                    break;
                    
                case 4:
                    menuTechnicien(machine, scanner);
                    break;
                    
                case 5:
                    double monnaie = machine.rendreMonnaie();
                    if (monnaie > 0) {
                        System.out.println("Monnaie rendue : " + monnaie + " euros");
                    }
                    continuer = false;
                    System.out.println("\nMerci et a bientot !");
                    break;
                    
                default:
                    System.out.println("Choix invalide. Veuillez reessayer.");
            }
        }
        
        scanner.close();
    }
}
