package yOsmaNedelja;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<EProizvodi> proizvodi = new ArrayList<>();
        int izbor;

        do {
            System.out.println("\n--- MENI ---");
            System.out.println("1. Unos uređaja");
            System.out.println("2. Pregled svih uređaja");
            System.out.println("3. Pregled uređaja po tipu");
            System.out.println("0. Izlaz");
            System.out.print("Vaš izbor: ");
            izbor = sc.nextInt();
            sc.nextLine(); 

            switch (izbor) {
                case 1: 
                    System.out.print("Unesite šifru (RA, TE, TV + broj): ");
                    String sifra = sc.nextLine().toUpperCase();

                    System.out.print("Unesite opis uređaja: ");
                    String opis = sc.nextLine();

                    System.out.print("Unesite uvoznu cijenu: ");
                    double cijena = sc.nextDouble();
                    sc.nextLine();

                    if (sifra.startsWith("RA")) {
                        System.out.print("Procesor: ");
                        String proc = sc.nextLine();
                        System.out.print("Memorija (GB): ");
                        int mem = sc.nextInt();
                        proizvodi.add(new Racunari(opis, sifra, cijena, proc, mem));
                    } else if (sifra.startsWith("TE")) {
                        System.out.print("Operativni sistem: ");
                        String os = sc.nextLine();
                        System.out.print("Veličina ekrana: ");
                        double ekran = sc.nextDouble();
                        proizvodi.add(new Telefoni(opis, sifra, cijena, os, ekran));
                    } else if (sifra.startsWith("TV")) {
                        System.out.print("Veličina ekrana: ");
                        double ekran = sc.nextDouble();
                        proizvodi.add(new TV(opis, sifra, cijena, ekran));
                    } else {
                        System.out.println("❌ Neispravna šifra! Mora početi sa RA, TE ili TV.");
                    }
                    break;

                case 2: // Pregled svih uređaja
                    if (proizvodi.isEmpty()) {
                        System.out.println("Nema unesenih uređaja!");
                    } else {
                        System.out.println("\n--- SVI UREĐAJI ---");
                        for (EProizvodi p : proizvodi) {
                            System.out.println(p);
                            System.out.printf("Maloprodajna cijena: %.2f\n", p.maloprodajnaCijena());
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 3: // Pregled po tipu
                    System.out.print("Unesite tip uređaja (RA, TE, TV): ");
                    String tip = sc.nextLine().toUpperCase();
                    boolean ima = false;
                    for (EProizvodi p : proizvodi) {
                        if (p.sifra.startsWith(tip)) {
                            if (!ima) {
                                System.out.println("\n--- Uređaji tipa " + tip + " ---");
                                ima = true;
                            }
                            System.out.println(p);
                            System.out.printf("Maloprodajna cijena: %.2f\n", p.maloprodajnaCijena());
                            System.out.println("----------------------------");
                        }
                    }
                    if (!ima) {
                        System.out.println("⚠️ Nema uređaja tog tipa.");
                    }
                    break;

                case 0:
                    System.out.println("Program završava rad. Hvala!");
                    break;

                default:
                    System.out.println("Pogrešan izbor! Pokušajte ponovo.");
                    break;
            }

        } while (izbor != 0);

        sc.close();
    }
}
