package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WerknemerTest {
    private Werknemer baas;
    private Werknemer medewerker;
    private Werknemer assistent;

    @BeforeEach
    void setup() {
        baas = new Werknemer("Mark","Den Haag", new Afdeling(),10000);
        medewerker = new Werknemer("Caroline", "Delft", new Afdeling(), 4000);
        assistent = new Werknemer("Klaas");
    }

    @Test
    void berekenJaarinkomenMaandsalaris10000Uitkomst120000() {
        // arrange
        baas.setMaandsalaris(10000);
        double verwachtJaarinkomen = 120000;

        // act
        double daadwerkelijkJaarinkomen = baas.berekenJaarinkomen();

        // assert
        assertEquals(verwachtJaarinkomen, daadwerkelijkJaarinkomen, .1);
    }

    @Test
    void berekenJaarinkomenMaandsalaris5000Uitkomst60000() {
        // arrange
        baas.setMaandsalaris(5000);
        double verwachtJaarinkomen = 60000;

        // act
        double daadwerkelijkJaarinkomen = baas.berekenJaarinkomen();

        // assert
        assertEquals(verwachtJaarinkomen, daadwerkelijkJaarinkomen, .1);
    }

    @Test
    void berekenJaarinkomenMaandsalaris0Uitkomst0() {
        // arrange
        assistent.setMaandsalaris(0);
        double verwachtJaarinkomen = 0;

        // act
        double daadwerkelijkJaarinkomen = assistent.berekenJaarinkomen();

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
        medewerker.setMaandsalaris(4500);
        assertTrue(medewerker.heeftRechtOpBonus());
    }

    @Test
    @DisplayName("heeftRechtOpBonusBijMaandsalarisGRENSWAARDE_BONUSgeeftTrue")
    void heeftRechtOpBonusBijMaandsalaris5000geeftTrue() {
        medewerker.setMaandsalaris(5000);
        assertTrue(medewerker.heeftRechtOpBonus());
    }

    @Test
    @DisplayName("heeftRechtOpBonusBijMaandsalarisGRENSWAARDE_BONUSgeeftFalse")
    void heeftRechtOpBonusBijMaandsalaris4000geeftTrue() {
        medewerker.setMaandsalaris(4000);
        assertFalse(medewerker.heeftRechtOpBonus());
    }

    @Test
    @DisplayName("getMaandsalarisNaSetMaandsalarisNegatiefGeeft0")
    void getMaandsalarisNaSetMaandsalarisNegatiefGeeft0() {
        medewerker.setMaandsalaris(-100);
        assertEquals(0, medewerker.getMaandsalaris());
    }
}
