package yDrugiBlok;


	import java.util.Scanner;

	public class OdbranaDvorca {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	     
	   
	        // D - maksimalno Menhetn (Manhattan) rastojanje do dvorca da bi katapult bio pretnja
	        // KA - šteta (damage) po jednom pogotku od jednog katapulta
	        // HD - zdravlje (health) dvorca
	        System.out.println("Unesite N (broj katapulta), D (domet), KA (steta po katapultu), HD (zdravlje dvorca):");
	        int N = sc.nextInt();
	        int D = sc.nextInt();
	        int KA = sc.nextInt();
	        int HD = sc.nextInt();

	        int brojPretnji = 0;

	        System.out.println("Unesite koordinate " + N + " katapulta (x y u svakoj liniji):");
	        for (int i = 0; i < N; i++) {
	            int x = sc.nextInt();
	            int y = sc.nextInt();

	            // Menhetn rastojanje
	            int manhattan = Math.abs(x) + Math.abs(y);

	            if (manhattan <= D) {
	                brojPretnji++;
	            }
	        }

	        int ukupnaSteta = brojPretnji * KA;
	        boolean srusen = ukupnaSteta >= HD;

	        // Rezultat
	        System.out.println();
	        System.out.println("Broj katapulta koji predstavljaju pretnju: " + brojPretnji);
	        System.out.println("Ukupna steta ako svi ispale po jedan hit: " + ukupnaSteta);
	        if (srusen) {
	            System.out.println("Dvorac CE biti srusen!");
	        } else {
	            System.out.println("Dvorac NECE biti srusen!");
	        }

	        sc.close();
	    }
	}

