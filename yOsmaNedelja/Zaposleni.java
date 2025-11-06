package yOsmaNedelja;

public class Zaposleni {
    protected int id;
    protected String ime;
    protected String prezime;
    protected double plataPoSatu;
    protected int ukupanBrojSati;

    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSati = ukupanBrojSati;
    }

    public double mesecnaPlata() {
        return 0; // redefinisati u podklasama
    }

    public String tipZaposlenog() {
        return "Zaposleni";
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getUkupanBrojSati() {
        return ukupanBrojSati;
    }
}
