package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void berekenJaarinkomenMaandsalaris5000Uitkomst60000() {
        // arrange
        Persoon persoon = new Persoon("Mark", "Den Haag", 5000);
        double verwachtJaarinkomen = 60000;

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
    void personeelsnummerVanNieuwPersoonIsAantalPersonenPlus1() {
        // arrange
        int verwachtPersoneelsNummer = Persoon.getAantalPersonen() + 1;

        // act
        Persoon nieuwPersoon = new Persoon();

        // assert
        assertEquals(verwachtPersoneelsNummer, nieuwPersoon.getPersoneelsnummer());
    }

    @Test
    @DisplayName("heeftRechtOpBonusBijMaandsalarisGRENSWAARDE_BONUSgeeftTrue")
    void heeftRechtOpBonusBijMaandsalarisGrenswaardeBonuSgeeftTrue() {
        Persoon persoon = new Persoon("Caroline", "Assen", 4500);
        assertTrue(persoon.heeftRechtOpBonus());
    }

    @Test
    @DisplayName("heeftRechtOpBonusBijMaandsalarisGRENSWAARDE_BONUSgeeftTrue")
    void heeftRechtOpBonusBijMaandsalaris5000geeftTrue() {
        Persoon persoon = new Persoon("Caroline", "Assen", 5000);
        assertTrue(persoon.heeftRechtOpBonus());
    }

    @Test
    @DisplayName("heeftRechtOpBonusBijMaandsalarisGRENSWAARDE_BONUSgeeftFalse")
    void heeftRechtOpBonusBijMaandsalaris4000geeftTrue() {
        Persoon persoon = new Persoon("Caroline", "Assen", 4000);
        assertFalse(persoon.heeftRechtOpBonus());
    }

    @Test
    @DisplayName("getMaandsalarisNaSetMaandsalarisNegatiefGeeft0")
    void getMaandsalarisNaSetMaandsalarisNegatiefGeeft0() {
        Persoon persoon = new Persoon("Caroline", "Assen", 4000);
        persoon.setMaandsalaris(-100);
        assertEquals(0, persoon.getMaandsalaris());
    }
}
