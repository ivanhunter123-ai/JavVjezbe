package yPrviBlok;

import java.util.Scanner;

public class PrviBlokMravi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		    public static void main1(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        // Unos koordinata pravougaonika (stola)
		        System.out.println("Unesite koordinate lijeve donje tacke stola (x1 y1):");
		        int x1 = sc.nextInt();
		        int y1 = sc.nextInt();

		        System.out.println("Unesite koordinate desne gornje tacke stola (x2 y2):");
		        int x2 = sc.nextInt();
		        int y2 = sc.nextInt();

		        // Unos broja mrava
		        System.out.println("Unesite broj mrava:");
		        int brojMrava = sc.nextInt();

		        int brojNaIvici = 0;

		        // Unos koordinata svakog mrava i provjera da li je na ivici
		        for (int i = 1; i <= brojMrava; i++) {
		            System.out.println("Unesite koordinate mrava " + i + " (x y):");
		            int mx = sc.nextInt();
		            int my = sc.nextInt();

		            // Provjera da li je mrav na ivici pravougaonika
		            boolean naDonjojIvici = (my == y1) && (mx >= x1 && mx <= x2);
		            boolean naGornjojIvici = (my == y2) && (mx >= x1 && mx <= x2);
		            boolean naLijevojIvici = (mx == x1) && (my >= y1 && my <= y2);
		            boolean naDesnojIvici = (mx == x2) && (my >= y1 && my <= y2);

		            if (naDonjojIvici || naGornjojIvici || naLijevojIvici || naDesnojIvici) {
		                brojNaIvici++;
		            }
		        }

		        // Ispis rezultata
		        System.out.println("Broj mrava koji se nalaze na ivici stola je: " + brojNaIvici);
		    
		

	
}
}
