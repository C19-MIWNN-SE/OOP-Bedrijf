package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.ZZPer;

import javax.swing.text.AbstractDocument;

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

        Werknemer baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000);
        Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000);
        ZZPer assistent = new ZZPer("Klaas", "Diemen", afdelingen[3], 50);

        assistent.huurIn(160);

        System.out.printf("Het aantal personen in het bedrijf is %d\n", Persoon.getAantalPersonen());
        System.out.println(baas);
        System.out.println(medewerker);
        System.out.println(assistent);

        System.out.printf("%s verdient %.2f per jaar\n", baas.getNaam(), baas.berekenJaarinkomen());
        System.out.printf("%s verdient %.2f per jaar\n", medewerker.getNaam(), medewerker.berekenJaarinkomen());
        System.out.printf("%s verdient %.2f per jaar\n", assistent.getNaam(), assistent.berekenJaarinkomen());
    }

}
