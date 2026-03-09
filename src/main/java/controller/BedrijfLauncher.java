package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.ZZPer;

import java.util.ArrayList;

/**
 * @author Vincent Velthuizen
 * Spelen met de elementen in een bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        Afdeling[] afdelingen = {
                new Afdeling("Uitvoering", "Hilversum"),
                new Afdeling("Support", "Amsterdam"),
                new Afdeling("Management", "Almere"),
                new Afdeling("Documentatie", "Gouda")
        };

        ArrayList<Persoon> personen = new ArrayList<>();

        personen.add(new Werknemer("Mark", "Den Haag", afdelingen[2], 10000));
        personen.add(new Werknemer("Angelique", "Rotterdam", afdelingen[2], 5000));
        personen.add(new Werknemer("Caroline", "Delft", afdelingen[1], 4000));
        personen.add(new ZZPer("Klaas", "Diemen", afdelingen[3], 50.00));
        personen.add(new ZZPer("Ronald", "Zaandam", afdelingen[0], 80.00));
        personen.add(new ZZPer("Jannie", "Utrecht", afdelingen[0], 60.00));
        personen.add(new ZZPer("Anne", "Zwolle", afdelingen[0], 40.00));

        for (Persoon persoon : personen) {
            if (persoon instanceof ZZPer) {
                ((ZZPer) persoon).huurIn(320);
            }
        }

        for (Persoon persoon : personen) {
            System.out.println(persoon.toonJaarinkomen());
        }
    }

}
