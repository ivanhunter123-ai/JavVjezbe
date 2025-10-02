package yPrviBlok;

import java.util.Scanner;

public class cetvrtiZadatak {

// pravouganoik sa kordinatima
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        float a = sc.nextFloat();

	        float b = sc.nextFloat();

	        float x = sc.nextFloat();

	        float y = sc.nextFloat();

	        float sirina = a - x;
	        float visina = b - y;

	        if (sirina <= 0 || visina <= 0) {
	            System.out.println("Greška: Neispravne koordinate za pravougaonik.");
	        } else {
	            float povrsina = sirina * visina;
	            float obim = 2 * (sirina + visina);

	            System.out.println("Površina pravougaonika je: " + povrsina);
	            System.out.println("Obim pravougaonika je: " + obim);
	        }

	        sc.close();
	    }
	}