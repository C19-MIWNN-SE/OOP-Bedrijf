package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Spelen met de elementen in een bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        String naam = toetsenbord.nextLine();

        System.out.print("Geef de woonplaats: ");
        String woonplaats = toetsenbord.nextLine();

        System.out.print("Geef de naam van de afdeling: ");
        String afdelingsnaam = toetsenbord.nextLine();

        System.out.print("Geef de plaats van de afdeling: ");
        String afdelingsplaats = toetsenbord.nextLine();

        Afdeling afdeling = new Afdeling(afdelingsnaam, afdelingsplaats);

        Werknemer werknemer = null;
        while (werknemer == null) {
            System.out.print("Geef de maandsalaris: ");
            double maandsalaris = toetsenbord.nextDouble();

            try {
                werknemer = new Werknemer(naam, woonplaats, afdeling, maandsalaris);
                System.out.println(werknemer);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
            }
        }
    }

}
