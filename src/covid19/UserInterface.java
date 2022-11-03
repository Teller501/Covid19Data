package covid19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    static FileHandler fileHandler = new FileHandler();

    public void start(){
        Scanner scanner = new Scanner(System.in);

        int input = 0;
        boolean inputError;

        while(input!= 9){
            // Welcome and menu
            System.out.println("Covid 19 dataset");
            System.out.println("1. load data");
            System.out.println("2. sorter data efter region");
            System.out.println("3. sorter data efter aldersgruppe");
            System.out.println("4. sorter data primært efter region og sekundært aldersgruppe");
            System.out.println("5. sorter data efter tilfælde");
            System.out.println("9. exit");
            // DO-while loop that keeps looping if input error is true
            do {
                // Try Catch that takes input from user in the menu, and handling if the input is not an int
                try {
                    input = scanner.nextInt();
                    scanner.nextLine();
                    handleMenuInput(input);
                    inputError = false;
                } catch (InputMismatchException | IOException e) {
                    System.out.println("Ugyldig input prøv venligst igen!");
                    inputError = true;
                    scanner.nextLine();
                }
            } while (inputError);
        }
    }



    public void handleMenuInput(int input) throws IOException {
        // Switch-statement handling userinput and calling methods
        switch (input) {
            case 1 -> fileHandler.loadData();
            case 2 -> {
                ArrayList<Covid19Data> regionDataList = fileHandler.sortRegion();

                System.out.println("Printer liste sorteret efter regionen:");
                for (Covid19Data covid19Data : regionDataList){
                    System.out.println("Region: " + covid19Data.getRegion() + " Aldersgruppe: " + covid19Data.getAldersgruppe()
                            + " Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIalt() + " Døde: " + covid19Data.getDøde()
                            + " Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + " Indlage: " + covid19Data.getIndlagte()
                            + " Dato: " + covid19Data.getDato());
                }
            }
            case 3 -> {
                ArrayList<Covid19Data> aldersGruppeList = fileHandler.sortAldersgruppe();

                System.out.println("Printer liste sorteret efter aldersgruppen:");
                for (Covid19Data covid19Data : aldersGruppeList){
                    System.out.println("Region: " + covid19Data.getRegion() + " Aldersgruppe: " + covid19Data.getAldersgruppe()
                            + " Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIalt() + " Døde: " + covid19Data.getDøde()
                            + " Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + " Indlage: " + covid19Data.getIndlagte()
                            + " Dato: " + covid19Data.getDato());
                }
            }
            case 4 -> {
                ArrayList<Covid19Data> regionOgAldersgruppeList = fileHandler.sortRegionAndAldersgruppe();

                for (Covid19Data covid19Data : regionOgAldersgruppeList){
                    System.out.println("Region: " + covid19Data.getRegion() + " Aldersgruppe: " + covid19Data.getAldersgruppe()
                            + " Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIalt() + " Døde: " + covid19Data.getDøde()
                            + " Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + " Indlage: " + covid19Data.getIndlagte()
                            + " Dato: " + covid19Data.getDato());
                }
            }
            case 5 -> {
                ArrayList<Covid19Data> tilfældeList = fileHandler.sortTilfælde();

                for (Covid19Data covid19Data : tilfældeList){
                    System.out.println("Region: " + covid19Data.getRegion() + " Aldersgruppe: " + covid19Data.getAldersgruppe()
                            + " Bekræftede tilfælde i alt: " + covid19Data.getBekræftedeTilfældeIalt() + " Døde: " + covid19Data.getDøde()
                            + " Indlagte på intensiv afdeling: " + covid19Data.getIndlagtePåIntensivAfdeling() + " Indlage: " + covid19Data.getIndlagte()
                            + " Dato: " + covid19Data.getDato());
                }
            }
            case 9 -> {
                System.out.println("Afslutter programmet...");
                System.exit(1); // Terminating program
            }
            default -> System.out.println("Ugyldigt Input\n"); // by default if none of the above is input, print error


        }
    }


}
