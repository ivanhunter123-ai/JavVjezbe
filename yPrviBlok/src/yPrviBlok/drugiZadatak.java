package yPrviBlok;

import java.util.Scanner;

public class drugiZadatak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

        System.out.print("Unesite duzinu pravougaonika: ");
        float duzina = sc.nextFloat();

        System.out.print("Unesite sirinu pravougaonika: ");
        float sirina = sc.nextFloat();

        float povrsina = duzina * sirina;
        float obim = 2 * (duzina + sirina);

        System.out.println("Povrsina pravougaonika je: " + povrsina);
        System.out.println("Obim pravougaonika je: " + obim);

        sc.close();
    }


	}


