package yŠestaNedelja;

import java.util.Scanner;

public class BrojacSlova {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Unesite rijec: ");
        String rijec = sc.nextLine();
        sc.close();

        rijec = rijec.toLowerCase();

        int samoglasnici = 0;
        int suglasnici = 0;

        for (int i = 0; i < rijec.length(); i++) {
            char c = rijec.charAt(i);

            if (c >= 'a' && c <= 'z') {

            	if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    samoglasnici++;
                } else { 
                    suglasnici++;
                }
            }
        }

        System.out.println("Broj samoglasnika: " + samoglasnici);
        System.out.println("Broj suglasnika: " + suglasnici);
    }
}
