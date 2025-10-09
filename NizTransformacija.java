package yTreciBlok;

import java.util.Scanner;
import java.util.Random;

public class NizTransformacija {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Unesite duzinu niza: ");
        int duzina = input.nextInt();

        int[] niz = new int[duzina];

        for (int i = 0; i < duzina; i++) {
            niz[i] = rand.nextInt(21) - 10; 
        }

        System.out.println("\nOriginalni niz:");
        for (int broj : niz) {
            System.out.print(broj + " ");
        }

        double[] noviNiz = new double[duzina];

        for (int i = 0; i < duzina; i++) {
            int broj = niz[i];
            if (broj % 2 == 0) {
                noviNiz[i] = -1 * broj;
            } else {
                noviNiz[i] = 1.0 / broj;
            }
        }

        System.out.println("\n\nNovi niz:");
        for (double broj : noviNiz) {
            System.out.print(broj + " ");
        }

        input.close();
    }
}
