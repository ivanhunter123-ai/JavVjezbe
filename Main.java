public class Main {

    public static void main(String[] args) {

        Automobil auto = new Automobil("Audi", 2008, 2200, "Crna", 5, "dizel");
        Kamion kamion = new Kamion("MAN", 2015, 5000, "Bijela", 10.5, true);
        Kombi kombi = new Kombi("Ford", 2012, 1800, "Siva", 9);

        System.out.println(" Automobil ===");
        auto.prikaziInformacije();
        System.out.println("Cijena registracije: " + auto.izracunajRegistraciju() + " EUR\n");

        System.out.println("=== Kamion ===");
        kamion.prikaziInformacije();
        System.out.println("Cijena registracije: " + kamion.izracunajRegistraciju() + " EUR\n");

        System.out.println("=== Kombi ===");
        kombi.prikaziInformacije();
        System.out.println("Cijena registracije: " + kombi.izracunajRegistraciju() + " EUR");
    }
}