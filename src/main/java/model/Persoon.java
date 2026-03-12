package model;

/**
 * @author Vincent Velthuizen
 * iemand die werk doet voor ons bedrijf
 */
public abstract class Persoon implements Comparable<Persoon> {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";

    private static int aantalPersonen = 0;

    private int personeelsnummer;
    private String naam;
    private String woonplaats;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public abstract double berekenJaarinkomen();

    public String toonJaarinkomen() {
        return String.format("%s verdient %.2f per jaar", naam, berekenJaarinkomen());
    }

    @Override
    public int compareTo(Persoon anderePersoon) {
        return this.naam.compareTo(anderePersoon.naam);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Persoon persoon)) return false;

        return naam.equals(persoon.naam);
    }

    @Override
    public int hashCode() {
        return naam.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", this.naam, this.woonplaats, this.afdeling);
    }

    public static int getAantalPersonen() {
        return aantalPersonen;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }
}
