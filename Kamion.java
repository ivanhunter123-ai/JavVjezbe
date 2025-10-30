public class Kamion extends Vozilo {
	
    private double kapacitetTereta;
    private boolean prikolica;

    public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
                  double kapacitetTereta, boolean prikolica) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.kapacitetTereta = kapacitetTereta;
        this.prikolica = prikolica;
    }

    @Override
    public void prikaziInformacije() {
        super.prikaziInformacije();
        System.out.println("Kapacitet tereta: " + kapacitetTereta + " t");
        System.out.println("Prikolica: " + (prikolica ? "da" : "ne"));
    }

    @Override
    public double izracunajRegistraciju() {
        double cijena = super.izracunajRegistraciju();
        if (prikolica) {
            cijena += 50;
        }
        return cijena;
    }
}
