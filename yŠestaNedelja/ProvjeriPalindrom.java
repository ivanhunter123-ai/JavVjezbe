package yŠestaNedelja;

import java.util.Scanner;

public class ProvjeriPalindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Unesite rijec: ");
        String rijec = sc.nextLine();
        sc.close();

        rijec = rijec.toLowerCase().replaceAll("\\s+", "");

        StringBuilder sb = new StringBuilder(rijec);
        String obrnuto = sb.reverse().toString();

        if (rijec.equals(obrnuto)) {
            System.out.println("Rijec JE palindrom ");
        } else {
            System.out.println("Rijec NIJE palindrom ");
        }
    }
}
