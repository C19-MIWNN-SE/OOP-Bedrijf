package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Velthuizen
 */
class ZZPerTest {

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            " 50, 100,  5000",
            "150, 100, 15000",
            "100,  50,  5000"
    })
    @DisplayName("bereken jaarinkomen geeft correcte waarde op basis van uurtarief en uren gewerkt")
    void berekenJaarinkomenGeeftCorrecteWaardeOpBasisVanUurtariefEnUrenGewerkt(double uurtarief,
                                                                               int urenGewerkt,
                                                                               double verwachtJaarinkomen) {
        ZZPer zzper = new ZZPer("Mark", "Den Haag", new Afdeling(), uurtarief);
        zzper.huurIn(urenGewerkt);
        assertEquals(verwachtJaarinkomen, zzper.berekenJaarinkomen());
    }

}