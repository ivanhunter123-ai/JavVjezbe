public class Kombi extends Vozilo {

    private int kapacitetPutnika;

    public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
                 int kapacitetPutnika) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.kapacitetPutnika = kapacitetPutnika;
    }

    @Override
    public void prikaziInformacije() {
        super.prikaziInformacije();
        System.out.println("Kapacitet putnika: " + kapacitetPutnika);
    }

    @Override
    public double izracunajRegistraciju() {
        double cijena = super.izracunajRegistraciju();
        if (kapacitetPutnika > 8) {
            cijena += 30;
        }
        return cijena;
    }
}