package model;

/**
 * @author Vincent Velthuizen
 * iemand die werk doet voor ons bedrijf
 */
public class Persoon {
    public static int aantalPersonen = 0;

    public int personeelsnummer;
    public String naam;
    public String woonplaats;
    public double maandsalaris;

    public Persoon(String naam, String woonplaats, double maandsalaris) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.maandsalaris = maandsalaris;
    }

    public Persoon(String naam) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = "Onbekend";
        this.maandsalaris = 0.0;
    }

    public Persoon() {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = "Onbekend";
        this.woonplaats = "Onbekend";
        this.maandsalaris = 0.0;
    }

    public double berekenJaarinkomen() {
        return 12 * maandsalaris;
    }
}
