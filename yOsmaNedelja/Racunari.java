package yOsmaNedelja;

public class Racunari extends EProizvodi {
    private String procesor;
    private int memorija;

    public Racunari(String opis, String sifra, double uvoznaCijena, String procesor, int memorija) {
        super(opis, sifra, uvoznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }

    @Override
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        cijena *= 1.05; 
        return cijena;
    }

    @Override
    public String toString() {
        return "RAČUNAR -> " + super.toString() +
               ", Procesor: " + procesor + ", Memorija: " + memorija + "GB";
    }
}
