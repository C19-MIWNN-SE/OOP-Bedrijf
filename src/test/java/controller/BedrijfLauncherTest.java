package controller;

import model.Persoon;
import model.Werknemer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vincent Velthuizen
 */
class BedrijfLauncherTest {

    @Test
    @DisplayName("sizeArraylistMet7personenis7")
    void sizeArraylistMet7Personenis7() {
        ArrayList<Persoon> personen = new ArrayList<>();

        personen.add(new Werknemer());
        personen.add(new Werknemer());
        personen.add(new Werknemer());
        personen.add(new Werknemer());
        personen.add(new Werknemer());
        personen.add(new Werknemer());
        personen.add(new Werknemer());

        assertEquals(7, personen.size());
    }

}