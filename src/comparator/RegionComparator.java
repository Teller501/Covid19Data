package comparator;

import covid19.Covid19Data;

import java.util.Comparator;

public class RegionComparator implements Comparator<Covid19Data> {
    public int compare(Covid19Data c1, Covid19Data c2){
        return c1.getRegion().compareTo(c2.getRegion());
    }
}
