package model;

/**
 * @author Vincent Velthuizen
 * Beschrijft iemand die in dienst is bij ons bedrijf
 */
public class Werknemer extends Persoon {
    public static final double GRENSWAARDE_BONUS = 4500.0;

    private static final double DEFAULT_MAANDSALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;

    private double maandsalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandsalaris) {
        super(naam, woonplaats, afdeling);
        setMaandsalaris(maandsalaris);
    }

    public Werknemer(String naam) {
        super(naam);
        setMaandsalaris(DEFAULT_MAANDSALARIS);
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
    }

    public double berekenJaarinkomen() {
        double jaarinkomen = maandsalaris * MAANDEN_PER_JAAR;

        if (heeftRechtOpBonus()) {
            jaarinkomen += maandsalaris;
        }

        return jaarinkomen;
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus",
                super.toString(),
                heeftRechtOpBonus() ? "met" : "zonder");
    }

    public String korteDisplayVariant() {
        return super.toString();
    }

    public double getMaandsalaris() {
        return maandsalaris;
    }

    public void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            throw new IllegalArgumentException(
                    String.format("Maandsalaris: %s is niet toegestaan. Het maandsalaris mag niet negatief zijn.",
                            maandsalaris));
        }
        this.maandsalaris = maandsalaris;
    }
}
