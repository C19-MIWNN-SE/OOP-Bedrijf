package model;

/**
 * @author Vincent Velthuizen
 *
 * Iemand die flexibel inzetbaar is voor ons bedrijf maar geen vergoeding ontvangt.
 */
public class Vrijwilliger extends Persoon implements Oproepbaar {
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        urenGewerkt = 0;
    }

    @Override
    public double berekenJaarinkomen() {
        return 0;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger (die dit jaar %d uren is ingezet).",
                super.toString(), urenGewerkt);
    }
}
