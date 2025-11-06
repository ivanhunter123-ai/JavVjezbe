package yOsmaNedelja;

import java.util.ArrayList;

public class Restoran {
    private String naziv;
    private String adresa;
    private String pib;
    private ArrayList<Zaposleni> zaposleni;

    public Restoran(String naziv, String adresa, String pib) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
        this.zaposleni = new ArrayList<>();
    }

    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }

    public void ukloniZaposlenog(int id) {
        zaposleni.removeIf(z -> z.getId() == id);
    }

    public Zaposleni nadjiZaposlenog(int id) {
        for (Zaposleni z : zaposleni) {
            if (z.getId() == id) return z;
        }
        return null;
    }

    public void obracunPlata() {
        // Ispis zaglavlja tabele
        System.out.println("ID  Ime        Prezime    Tip        Sati  Prek/BONUS  Plata");
        System.out.println("---------------------------------------------------------------");

        double ukupno = 0;

        // Prolazimo kroz sve zaposlene
        for (Zaposleni z : zaposleni) {
            String prekBonus = "";
            if (z instanceof Konobar) {
                prekBonus = ((Konobar) z).getPrekovremeniSati() + "h";
            } else if (z instanceof Menadzer) {
                prekBonus = ((Menadzer) z).getBonus() + " EUR";
            }

            double plata = z.mesecnaPlata();
            ukupno += plata;

            System.out.println(
                z.getId() + "  " +
                z.getIme() + "       " +
                z.getPrezime() + "      " +
                z.tipZaposlenog() + "        " +
                z.getUkupanBrojSati() + "    " +
                prekBonus + "       " +
                plata
            );
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Ukupan trosak plata: " + ukupno + " EUR");
    }}
