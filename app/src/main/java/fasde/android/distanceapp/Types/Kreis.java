package fasde.android.distanceapp.Types;

public enum Kreis {

    EL_NORD("EL-Nord"),
    EL_MITTE("EL-Mitte"),
    EL_SUED("EL-Süd"),
    GRAFSCHAFT("Grafschaft"),
    OSTFRIESLAND("Ostfriesland"),
    CLP("Cloppenburg"),
    OSNA("Osnabrück");

    String name;

    Kreis(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Kreis getForName(String kreisName){
        for(Kreis kreis : Kreis.values()){
            if(kreis.getName().equals(kreisName)){
                return kreis;
            }
        }
        return null;
    }
}
