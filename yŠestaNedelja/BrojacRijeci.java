package yŠestaNedelja;

import java.util.Scanner;

public class BrojacRijeci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite recenicu:");
        String linija = sc.nextLine();   
        sc.close();

        linija = linija.trim();

        int brojRijeci;
        if (linija.isEmpty()) {
            brojRijeci = 0; 
        } else {
            
            String[] dijelovi = linija.split("\s+");
            brojRijeci = dijelovi.length;
        }

        System.out.println("Broj rijeci: " + brojRijeci);
    }
}
