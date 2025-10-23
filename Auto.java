package yŠestaNedelja;

import java.util.ArrayList;

public class Auto {
    
    private String marka;
    private int godiste;
    private int snaga;
    private boolean prodato;
    private int kubikaza;
    private boolean registrovan;
    private boolean mozeSeRegistrovati;

    private static int brojProdatih = 0;


    public Auto(String marka, int godiste, int snaga, boolean prodato, int kubikaza, boolean registrovan) {
        this.marka = marka;
        this.godiste = godiste;
        this.snaga = snaga;
        this.prodato = prodato;
        this.kubikaza = kubikaza;

        if (prodato) brojProdatih++;

        if (godiste < 1985) {
            this.mozeSeRegistrovati = false;
            this.registrovan = false;
        } else {
            this.mozeSeRegistrovati = true;
            this.registrovan = registrovan;
        }

        listaAuta.add(this);

        if (this.mozeSeRegistrovati && !this.registrovan) {
            listaZaRegistraciju.add(this);
        }
    }


    public String getMarka() { return marka; }
    public void setMarka(String marka) { this.marka = marka; }

    public int getGodiste() { return godiste; }
    public void setGodiste(int godiste) { 
        this.godiste = godiste; 
        if (godiste < 1985) this.mozeSeRegistrovati = false;
    }

    public int getSnaga() { return snaga; }
    public void setSnaga(int snaga) { this.snaga = snaga; }

    public boolean isProdato() { return prodato; }
    public void setProdato(boolean prodato) { 
        this.prodato = prodato; 
        if (prodato) brojProdatih++;
    }

    public int getKubikaza() { return kubikaza; }
    public void setKubikaza(int kubikaza) { this.kubikaza = kubikaza; }

    public boolean isRegistrovan() { return registrovan; }
    public void setRegistrovan(boolean registrovan) { 
        if (godiste >= 1985) this.registrovan = registrovan; 
        else this.registrovan = false;
    }

    public boolean isMozeSeRegistrovati() { return mozeSeRegistrovati; }
    public void setMozeSeRegistrovati(boolean mozeSeRegistrovati) { this.mozeSeRegistrovati = mozeSeRegistrovati; }

    public static int getBrojProdatih() { return brojProdatih; }

    // ================== LOGIKA ==================

    public double getKoeficijentGodista() {
        double koef = 0.0;
        if (godiste >= 1985 && godiste <= 2000) koef = 1.0;
        else if (godiste >= 2001 && godiste <= 2010) koef = 2.0;
        else if (godiste >= 2011) koef = 3.0;
        return koef;
    }

    public double izracunajRegistraciju() {
        if (!mozeSeRegistrovati) return 0.0;
        return getKoeficijentGodista() * kubikaza * snaga;
            }

    public static ArrayList<Auto> listaAuta = new ArrayList<>();
    public static ArrayList<Auto> listaZaRegistraciju = new ArrayList<>();
    
    @Override
    public String toString() {
        return "Auto: " + marka +
               " | Godište: " + godiste +
               " | Snaga: " + snaga + " KS" +
               " | Kubikaža: " + kubikaza +
               " | Prodato: " + (prodato ? "da" : "ne") +
               " | Registrovan: " + (registrovan ? "da" : "ne") +
               " | Može se registrovati: " + (mozeSeRegistrovati ? "da" : "ne");
    }
    

    public static void main(String[] args) {

        new Auto("Golf 2", 1984, 55, true, 1600, true);
        new Auto("Opel Astra", 2005, 90, false, 1600, false);
        new Auto("Audi A4", 2018, 140, true, 2000, true);
        new Auto("Fiat Punto", 2003, 60, false, 1200, false);
        new Auto("BMW 320d", 2015, 135, true, 2000, true);

        System.out.println(" Svi automobili ");
        for (Auto a : listaAuta) {
            System.out.println(a);
        }

        System.out.println("\nAuta koja se mogu registrovati, a nisu registrovana ");
        for (Auto a : listaZaRegistraciju) {
            System.out.println(a.getMarka() + " (" + a.getGodiste() + ")");
        }

        System.out.println("\n Iznosi registracija ");
        double ukupno = 0.0;
        for (Auto a : listaAuta) {
            double iznos = a.izracunajRegistraciju();
            if (iznos > 0) System.out.println(a.getMarka() + ": " + iznos);
            ukupno += iznos;
        }

        System.out.println("\nUkupan iznos registracija: " + ukupno);
        System.out.println("Broj prodatih auta: " + Auto.getBrojProdatih());
    }
}
