package model;

/**
 * @author Vincent Velthuizen
 * Een afdeling binnen ons bedrijf
 */
public class Afdeling {
    private static final String DEFAULT_AFDELING_NAAM = "Onbekend";
    private static final String DEFAULT_AFDELING_PLAATS = "Onbekend";
    private String afdelingNaam;
    private String afdelingPlaats;

    public Afdeling(String afdelingNaam, String afdelingPlaats) {
        this.afdelingNaam = afdelingNaam;
        this.afdelingPlaats = afdelingPlaats;
    }

    public Afdeling() {
        this(DEFAULT_AFDELING_NAAM, DEFAULT_AFDELING_PLAATS);
    }

    public String getAfdelingNaam() {
        return afdelingNaam;
    }

    public String getAfdelingPlaats() {
        return afdelingPlaats;
    }
}
