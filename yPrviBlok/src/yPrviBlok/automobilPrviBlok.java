package yPrviBlok;

import java.util.Scanner;

public class automobilPrviBlok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
	    System.out.println ("Unesite broj automobila : ");
	    int N = sc.nextInt();
		int ukupnaZarada = 0;
		for (int i = 1; i <=N; i++) {
			System.out.println("Unesite broj sati na parkingu za auto " + i + ":") ; 
			int sati = sc.nextInt();
			int cijena;
			if (sati <= 5) {
				cijena = sati * 2;
			} else {
				cijena = 10 + (sati - 5);
			}
              ukupnaZarada += cijena;
		
	}
        System.out.println("Ukupna zarada parkinga je " + ukupnaZarada + " EUR ");
} 
}
