package comparator;

import covid19.Covid19Data;

import java.util.Comparator;

public class TilfældeComparator implements Comparator<Covid19Data> {
    public int compare(Covid19Data c1, Covid19Data c2){
        return Integer.compare(c1.getBekræftedeTilfældeIalt(),c2.getBekræftedeTilfældeIalt());
    }
}
