package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "maandsalaris {0} geeft jaarsalaris {1}")
    @DisplayName("berekenJaarinkomen")
    @CsvSource({
            "    0,      0",
            " 4000,  48000", // zonder bonus krijg ik 12 keer het maandsalaris
            " 4500,  58500", // dit is precies de bonus
            " 5000,  65000", // dus vanaf hier is het 13 keer het maandsalaris
            "10000, 130000",
            "20000, 260000"
    })
    void berekenJaarinkomen(double maandsalaris, double verwachtJaarinkomen) {
        // arrange
        baas.setMaandsalaris(maandsalaris);

        // act
        double daadwerkelijkJaarinkomen = baas.berekenJaarinkomen();

        // assert
        assertEquals(verwachtJaarinkomen, daadwerkelijkJaarinkomen, .1);
    }


    @Test
    void personeelsnummerVanNieuwPersoonIsAantalPersonenPlus1() {
        // arrange
        int verwachtPersoneelsNummer = Persoon.getAantalPersonen() + 1;

        // act
        Persoon nieuwPersoon = new Werknemer("Klaas");

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
