package yOsmaNedelja;

public class Mainn {
    public static void main(String[] args) {
        Restoran restoran = new Restoran("MojRestoran", "Ulica 1, Grad", "123456789");

        restoran.dodajZaposlenog(new Konobar(1, "Marko", "Markovic", 10, 40, 5));
        restoran.dodajZaposlenog(new Kuvar(2, "Ana", "Anic", 12, 35));
        restoran.dodajZaposlenog(new Menadzer(3, "Jovan", "Jovic", 15, 40, 500));
        restoran.dodajZaposlenog(new Konobar(4, "Petar", "Petrovic", 11, 38, 2));
        restoran.dodajZaposlenog(new Kuvar(5, "Maja", "Majic", 13, 37));

        restoran.obracunPlata();
    }
}
