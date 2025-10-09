package yTreciBlok;

import java.util.Scanner;

public class EvidencijaTemperatura {
	
	private double[] temperature; 
	

	public EvidencijaTemperatura(double[] temperature) {
		this.temperature = temperature;
	}
	
	
	public double[] getTemperature() {
		return temperature;
	}
	
	
	public void setTemperature(double[] temperature) {
		this.temperature = temperature;
	}
	
	
	public double prosjecnaTemperatura(double[] niz) {
		double suma = 0;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		return suma / niz.length;
	}
	
	public double maksimalnaTemperatura(double[] niz) {
		double max = niz[0];
		for (int i = 1; i < niz.length; i++) {
			if (niz[i] > max) {
				max = niz[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		Scanner unos = new Scanner(System.in);
		
		double[] temp = new double[5];
		
		System.out.println("Unesite 5 temperatura: ");
		for (int i = 0; i < temp.length; i++) {
			System.out.print("Temperatura " + (i + 1) + ": ");
			temp[i] = unos.nextDouble();
		}
		
		EvidencijaTemperatura evidencija = new EvidencijaTemperatura(temp);
		
		System.out.println("\nDuzina niza: " + evidencija.getTemperature().length);
		System.out.print("Unesene temperature: ");
		for (double t : evidencija.getTemperature()) {
			System.out.print(t + " ");
		}
		System.out.println();
		
		System.out.print("\nUnesite temperaturu koju zelite provjeriti: ");
		double trazena = unos.nextDouble();
		
		boolean postoji = false;
		for (double t : evidencija.getTemperature()) {
			if (t == trazena) {
				postoji = true;
				break;
			}
		}
		
		if (postoji) {
			System.out.println("Temperatura " + trazena + " se nalazi u nizu.");
		} else {
			System.out.println("Temperatura " + trazena + " se NE nalazi u nizu.");
		}
		
		int novaDuzina = 0;
		double[] privremeni = new double[evidencija.getTemperature().length];
		
		for (int i = 0; i < evidencija.getTemperature().length; i++) {
			boolean duplikat = false;
			for (int j = 0; j < novaDuzina; j++) {
				if (evidencija.getTemperature()[i] == privremeni[j]) {
					duplikat = true;
					break;
				}
			}
			if (!duplikat) {
				privremeni[novaDuzina] = evidencija.getTemperature()[i];
				novaDuzina++;
			}
		}
		
		double[] bezDuplikata = new double[novaDuzina];
		for (int i = 0; i < novaDuzina; i++) {
			bezDuplikata[i] = privremeni[i];
		}
		
		evidencija.setTemperature(bezDuplikata);
		
		System.out.print("\nAzurirani niz temperatura (bez duplikata): ");
		for (double t : evidencija.getTemperature()) {
			System.out.print(t + " ");
		}
		System.out.println();
		
		System.out.println("\nProsjecna temperatura: " + evidencija.prosjecnaTemperatura(evidencija.getTemperature()));
		System.out.println("Maksimalna temperatura: " + evidencija.maksimalnaTemperatura(evidencija.getTemperature()));
		
		unos.close();
	}
}
