package yPrviBlok;

import java.util.Scanner;

public class PrviBlok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
		float prviBroj = sc.nextFloat();
		float drugiBroj = sc.nextFloat();
		
		if (prviBroj > drugiBroj ) {
			System.out.println("Prvi broj je veci od drugog");
		} else if (prviBroj < drugiBroj ) {
			System.out.println("Drugi broj je veci od prvog");
		}	else {
				System.out.println("Jednaki su.");
			}
		}
	}


