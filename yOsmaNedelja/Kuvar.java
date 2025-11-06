package yOsmaNedelja;

public class Kuvar extends Zaposleni {

    public Kuvar(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
    }

    @Override
    public double mesecnaPlata() {
        return 1500 + 4 * ukupanBrojSati * plataPoSatu;
    }

    @Override
    public String tipZaposlenog() {
        return "Kuvar";
    }
}
