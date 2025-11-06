package yOsmaNedelja;

public class Konobar extends Zaposleni {
    private int prekovremeniSati;

    public Konobar(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati, int prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.prekovremeniSati = prekovremeniSati;
    }

    @Override
    public double mesecnaPlata() {
        double plataRedovno = ukupanBrojSati * plataPoSatu;
        double plataPrekovremeni = prekovremeniSati * plataPoSatu * 1.2;
        return 4 * (plataRedovno + plataPrekovremeni);
    }

    @Override
    public String tipZaposlenog() {
        return "Konobar";
    }

    public int getPrekovremeniSati() {
        return prekovremeniSati;
    }
}
