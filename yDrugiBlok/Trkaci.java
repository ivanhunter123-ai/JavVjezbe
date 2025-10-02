package yDrugiBlok;

import java.util.*; // import mora biti ovde, van klase

public class Trkaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double cx = sc.nextDouble(), cy = sc.nextDouble();
        double R1 = sc.nextDouble(), R2 = sc.nextDouble();
        if (R1 > R2) { double t = R1; R1 = R2; R2 = t; } // zamena ako je R1 > R2

        int N = sc.nextInt(); // broj trkaca

        int cnt = 0; // brojac trkaca u prstenu i gornjoj poluravni
        double R1s = R1*R1, R2s = R2*R2; // kvadrati poluprecnika da se izbegne sqrt

        // promenljive za najudaljenijeg trkaca
        double maxD = -1, mx=0, my=0; 
        int idx=0;

        for (int i=1; i<=N; i++) {
            double x=sc.nextDouble(), y=sc.nextDouble(); // ucitavanje trkaca
            double dx=x-cx, dy=y-cy, d=dx*dx+dy*dy; // kvadrat udaljenosti od centra

            // provera da li je u prstenu i gornjoj poluravni
            if (d>=R1s && d<=R2s && y>=cy) cnt++;

            // azuriranje najudaljenijeg trkaca
            if (d>maxD) { maxD=d; idx=i; mx=x; my=y; }
        }

        System.out.println(cnt); // broj trkaca u prstenu i gornjoj poluravni
        // ispis najudaljenijeg trkaca: indeks, koordinate i rastojanje
        System.out.printf("%d %.4f %.4f %.4f%n", idx, mx, my, Math.sqrt(maxD));
    }
}
