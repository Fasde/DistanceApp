package fasde.android.distanceapp;

public enum Kreis {

    EL_NORD("Emsland-Nord"),
    EL_MITTE("Emsland-Mitte"),
    EL_SUED("Emsland-Süd"),
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
}
