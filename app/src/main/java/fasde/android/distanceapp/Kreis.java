package fasde.android.distanceapp;

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
}
