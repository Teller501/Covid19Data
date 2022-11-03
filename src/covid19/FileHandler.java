package covid19;

import comparator.AldersGruppeComparator;
import comparator.RegionComparator;
import comparator.TilfældeComparator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<Covid19Data> covid19DataList = new ArrayList<>();

    public void loadData() throws IOException {
        Scanner reader = new Scanner(new File("data/11_noegletal_pr_region_pr_aldersgruppe.csv"), StandardCharsets.ISO_8859_1);
        reader.nextLine();

        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            Covid19Data dataObjekt = parseCSVLine(line);

            covid19DataList.add(dataObjekt);
            System.out.println(line);
        }
    }

    private Covid19Data parseCSVLine(String line) {
        String[] parts = line.split(";");

        Covid19Data dataObjekt = new Covid19Data();
        dataObjekt.setRegion(parts[0]);
        dataObjekt.setAldersgruppe(parts[1]);
        int tilfælde = Integer.parseInt(parts[2]);
        dataObjekt.setBekræftedeTilfælde(tilfælde);
        dataObjekt.setDøde(Integer.parseInt(parts[3]));
        dataObjekt.setIndlagtePåIntensiv(Integer.parseInt(parts[4]));
        dataObjekt.setIndlagte(Integer.parseInt(parts[5]));
        dataObjekt.setDato(parts[6]);


        return dataObjekt;
    }

    public ArrayList<Covid19Data> getCovid19DataList() {
        return covid19DataList;
    }

    public ArrayList<Covid19Data> sortRegion(){
        Collections.sort(getCovid19DataList(), new RegionComparator());

        return getCovid19DataList();
    }

    public ArrayList<Covid19Data> sortAldersgruppe(){
        Collections.sort(getCovid19DataList(), new AldersGruppeComparator());

        return getCovid19DataList();
    }

    public ArrayList<Covid19Data> sortTilfælde(){
        Collections.sort(getCovid19DataList(), new TilfældeComparator());

        return getCovid19DataList();
    }
    public ArrayList<Covid19Data> sortRegionAndAldersgruppe(){
        Collections.sort(getCovid19DataList(), new RegionComparator().thenComparing(new AldersGruppeComparator()));

        return getCovid19DataList();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
