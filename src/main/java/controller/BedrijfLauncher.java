package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Spelen met de elementen in een bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        ArrayList<Afdeling> afdelingen = leesAfdelingenIn("src/main/resources/Afdelingen.txt");
        ArrayList<Persoon> personen = leesPersonenIn("src/main/resources/Personen.csv", afdelingen);

        Collections.sort(personen);

        try (PrintWriter writer = new PrintWriter("src/main/resources/PersonenPerAfdeling.txt")) {
            for (Afdeling afdeling : afdelingen) {
                writer.printf("Afdeling: %s\n", afdeling.getAfdelingNaam());

                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        writer.printf("-- %s\n", persoon);
                    }
                }

                writer.println();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Kon Personen per Afdeling bestand niet openen om te schrijven.");
        }
    }

    private static ArrayList<Persoon> leesPersonenIn(String bestandMetPersonen, ArrayList<Afdeling> afdelingen) {
        ArrayList<Persoon> personen = new ArrayList<>();

        try (Scanner personenScanner = new Scanner(new File(bestandMetPersonen))) {
            while (personenScanner.hasNextLine()) {
                String[] persoonEigenschappen = personenScanner.nextLine().split(",");

                String type = persoonEigenschappen[0];
                String naam = persoonEigenschappen[1];
                String woonplaats = persoonEigenschappen[2];
                int afdelingsindex = Integer.parseInt(persoonEigenschappen[3]);
                double ietsMetGeld = Double.parseDouble(persoonEigenschappen[4]);

                switch (type) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(afdelingsindex), ietsMetGeld));
                        break;
                    case "Zzper":
                        personen.add(new ZZPer(naam, woonplaats, afdelingen.get(afdelingsindex), ietsMetGeld));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(afdelingsindex)));
                        break;
                    default:
                        System.err.printf("Personen gevonden met type: %s, deze wordt genegeerd.\n", type);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Kon personen bestand niet laden.");
            throw new RuntimeException(fileNotFoundException.getMessage());
        }

        return personen;
    }

    private static ArrayList<Afdeling> leesAfdelingenIn(String bestandMetAfdelingen) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        try (Scanner afdelingenScanner = new Scanner(new File(bestandMetAfdelingen))) {
            while (afdelingenScanner.hasNextLine()) {
                String afdelingsnaam = afdelingenScanner.nextLine();
                String afdelingsplaats = afdelingenScanner.nextLine();

                afdelingen.add(new Afdeling(afdelingsnaam, afdelingsplaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Kon afdelingen bestand niet laden.");
            throw new RuntimeException(fileNotFoundException.getMessage());
        }

        return afdelingen;
    }

}
