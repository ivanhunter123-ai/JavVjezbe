public class Automobil extends Vozilo {
	
    private int brojVrata;
    private String tipMotora; 

    public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
                     int brojVrata, String tipMotora) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.brojVrata = brojVrata;
        this.tipMotora = tipMotora;
    }

    @Override
    public void prikaziInformacije() {
        super.prikaziInformacije();
        System.out.println("Broj vrata: " + brojVrata);
        System.out.println("Tip motora: " + tipMotora);
    }

    @Override
    public double izracunajRegistraciju() {
        double cijena = super.izracunajRegistraciju();
        if (tipMotora.equalsIgnoreCase("dizel")) {
            cijena += 20;
        }
        return cijena;
    }
}
