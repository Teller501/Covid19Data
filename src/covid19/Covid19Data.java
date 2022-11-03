package covid19;

public class Covid19Data {
    private String region;
    private String aldersgruppe;
    private int bekræftedeTilfældeIalt;
    private int døde;
    private int indlagtePåIntensiv;
    private int indlagte;
    private String dato;


    public Covid19Data() {
    }

    public String getRegion() {
        return region;
    }

    public String getAldersgruppe() {
        return aldersgruppe;
    }

    public int getBekræftedeTilfældeIalt() {
        return bekræftedeTilfældeIalt;
    }

    public int getDøde() {
        return døde;
    }

    public int getIndlagtePåIntensivAfdeling() {
        return indlagtePåIntensiv;
    }

    public int getIndlagte() {
        return indlagte;
    }

    public String getDato() {
        return dato;
    }


    public void setRegion(String part) {
        this.region = part;
    }

    public void setAldersgruppe(String part) {
        this.aldersgruppe = part;
    }

    public void setBekræftedeTilfælde(int bekræftedeTilfældeIalt) {
        this.bekræftedeTilfældeIalt = bekræftedeTilfældeIalt;
    }

    public void setDøde(int døde) {
        this.døde = døde;
    }

    public void setIndlagtePåIntensiv(int indlagtePåIntensiv) {
        this.indlagtePåIntensiv = indlagtePåIntensiv;
    }

    public void setIndlagte(int indlagte) {
        this.indlagte = indlagte;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Covid19Data{" +
                "region='" + region;
    }
}
