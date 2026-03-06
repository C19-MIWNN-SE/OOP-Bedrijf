package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersoonTest {
    private Persoon baas;
    private Persoon medewerker;
    private Persoon assistent;

    @BeforeEach
    void setup() {
        baas = new Persoon("Mark","Den Haag",10000, new Afdeling());
        medewerker = new Persoon("Caroline", "Delft", 4000, new Afdeling());
        assistent = new Persoon("Klaas");
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

    @Test
    @DisplayName("getAfdelinggetAfdelingsPlaatsGeeftDeOpgegevenWaardeTerug")
    void getAfdelingGetAfdelingPlaatsGeeftDeOpgegevenWaardeTerug() {
        String naam = "Test";

        Persoon persoon = new Persoon("Mark", "Den Haag", 10000,
                new Afdeling(naam, "Testeradeel"));

        assertEquals(naam, persoon.getAfdeling().getAfdelingNaam());
    }
}
