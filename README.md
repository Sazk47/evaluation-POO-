# Machine à Café

## Description
Simulation d'une machine à café autonome installée à la Gare de Montpellier.
La machine gère son stock, encaisse l'argent et nécessite une maintenance régulière.

## Fonctionnalités

### Produits disponibles
- Café Court (Espresso) : 1.50 euros
- Café Long (Allongé) : 2.00 euros

### Gestion des stocks
La machine surveille en permanence :
- Eau : 100 cl maximum
- Grains de café : 50 g maximum
- Gobelets : 10 unités maximum
- Usure : La machine doit être détartrée après 5 cafés

### Système monétaire
- Monnayeur : Argent inséré par le client
- Caisse : Total des gains de la machine

### Menu Technicien
Permet la maintenance de la machine :
- Recharger les stocks
- Détartrer la machine
- Récupérer l'argent de la caisse

## Utilisation

### Compilation
```bash
javac Machine.java Main.java
```

### Lancement
```bash
java Main
```

## Architecture
- `Machine.java` : Classe principale contenant la logique métier
- `Main.java` : Interface utilisateur avec menu interactif

## Règles de fonctionnement
1. Vérification de l'entartrage (prioritaire)
2. Vérification du crédit suffisant
3. Vérification des stocks disponibles
4. Si tout est OK, le café est servi
