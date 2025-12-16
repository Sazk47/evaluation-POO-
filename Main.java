public class Main {
public static void main(String[] args) {
    Machine machine = new Machine();
    
    System.out.println("=== TEST 1 : Cafe normal ===");
    machine.insererArgent(2.0);
    machine.servirCafeCourt();
    System.out.println("Cafes servis: " + machine.getBacMarc());
    
    System.out.println("\n=== TEST 2 : Credit insuffisant ===");
    machine.servirCafeLong();
    
    System.out.println("\n=== TEST 3 : Servir jusqu'a entartrage ===");
    for (int i = 0; i < 4; i++) {
        machine.insererArgent(2.0);
        machine.servirCafeCourt();
        System.out.println("Cafes servis: " + machine.getBacMarc());
    }
    
    System.out.println("\n=== TEST 4 : Machine entartree ===");
    machine.insererArgent(5.0);
    machine.servirCafeCourt();
    
    System.out.println("\n=== TEST 5 : Verification des stocks ===");
    Machine machine2 = new Machine();
    machine2.insererArgent(20.0);
    for (int i = 0; i < 6; i++) {
        boolean ok = machine2.servirCafeLong();
        if (!ok) {
            break;
        }
    }
    }
}
