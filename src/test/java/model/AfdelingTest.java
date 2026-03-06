package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Velthuizen
 */
class AfdelingTest {

    @Test
    @DisplayName("gettersNaAllArgsConstructorGevenOpgegevenWaardenTerug")
    void gettersNaAllArgsConstructorGevenOpgegevenWaardenTerug() {
        String naam = "IT";
        String plaats = "Groningen";
        Afdeling afdeling = new Afdeling(naam, plaats);

        assertAll(
                () -> assertEquals(naam, afdeling.getAfdelingNaam()),
                () -> assertEquals(plaats, afdeling.getAfdelingPlaats())
        );
    }
}