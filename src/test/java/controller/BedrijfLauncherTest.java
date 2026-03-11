package controller;

import model.Persoon;
import model.Werknemer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Velthuizen
 */
class BedrijfLauncherTest {

    private ArrayList<Persoon> personen;

    @BeforeEach
    void setup() {
        personen = new ArrayList<>();

        personen.add(new Werknemer("Anne"));
        personen.add(new Werknemer("Naledi"));
        personen.add(new Werknemer("Ambi"));
        personen.add(new Werknemer("Ronald"));
        personen.add(new Werknemer("Mark"));
        personen.add(new Werknemer("Klaas"));
        personen.add(new Werknemer("Jannie"));
    }

    @Test
    @DisplayName("sizeArraylistMet7personenis7")
    void sizeArraylistMet7Personenis7() {
        assertEquals(7, personen.size());
    }

    @Test
    @DisplayName("Een gesorteerde lijst is gesorteerd")
    void eenGesorteerdeLijstIsGesorteerd() {
        Collections.sort(personen);

        assertAll(
                () -> assertInstanceOf(Comparable.class, personen.get(0)),
                () -> assertEquals(new Werknemer("Ambi"), personen.get(0)),
                () -> assertEquals(new Werknemer("Ronald"), personen.get(6))
        );
    }

}