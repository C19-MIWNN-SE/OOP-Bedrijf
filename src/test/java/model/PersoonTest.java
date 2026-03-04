package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersoonTest {

    @Test
    void berekenJaarinkomenMaandsalaris10000Uitkomst120000() {
        // arrange
        Persoon persoon = new Persoon("Mark", "Den Haag", 10000);
        double verwachtJaarinkomen = 120000;

        // act
        double daadwerkelijkJaarinkomen = persoon.berekenJaarinkomen();

        // assert
        assertEquals(verwachtJaarinkomen, daadwerkelijkJaarinkomen, .1);
    }

    @Test
    void berekenJaarinkomenMaandsalaris0Uitkomst0() {
        // arrange
        Persoon persoon = new Persoon("Mark", "Den Haag", 0);
        double verwachtJaarinkomen = 0;

        // act
        double daadwerkelijkJaarinkomen = persoon.berekenJaarinkomen();

        // assert
        assertEquals(verwachtJaarinkomen, daadwerkelijkJaarinkomen, .1);
    }

    @Test
    void personeelsnummerVanTweedePersoonIs2() {
        // arrange
        Persoon.aantalPersonen = 0;

        // act
        new Persoon();
        Persoon tweedePersoon = new Persoon();

        // assert
        assertEquals(2, tweedePersoon.personeelsnummer);
    }
}
