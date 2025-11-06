package yOsmaNedelja;

public class Menadzer extends Zaposleni {
    private double bonus;

    public Menadzer(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.bonus = bonus;
    }

    @Override
    public double mesecnaPlata() {
        return 1300 + 4 * ukupanBrojSati * plataPoSatu + bonus;
    }

    @Override
    public String tipZaposlenog() {
        return "Menadzer";
    }

    public double getBonus() {
        return bonus;
    }
}
