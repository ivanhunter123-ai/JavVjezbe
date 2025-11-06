package yOsmaNedelja;

public class EProizvodi {
    protected String opis;
    protected String sifra;
    protected double uvoznaCijena;

    public EProizvodi(String opis, String sifra, double uvoznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.uvoznaCijena = uvoznaCijena;
    }

    public double maloprodajnaCijena() {
        return uvoznaCijena * 1.05;
    }

    @Override
    public String toString() {
        return "Opis: " + opis + ", Šifra: " + sifra + ", Uvozna cijena: " + uvoznaCijena;
    }
}
