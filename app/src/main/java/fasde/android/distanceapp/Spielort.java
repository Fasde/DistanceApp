package fasde.android.distanceapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Spielort {

    private String spielort;
    private int distanz;
    private BigDecimal kosten;
    private Kreis kreis;

    public Spielort(String spielort, int distanz, Kreis kreis) {
        this.spielort = spielort;
        this.distanz = distanz;
        this.kosten = new BigDecimal(distanz * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        this.kreis = kreis;
    }

    public String getSpielort() {
        return spielort;
    }

    public int getDistanz() {
        return distanz;
    }

    public BigDecimal getKosten() {
        return kosten;
    }

    public Kreis getKreis() {
        return kreis;
    }

    public static List<Spielort> gottaListEmAll() {
        List<Spielort> allPlaces = new ArrayList<>();
        allPlaces.addAll(emslandNord());
        allPlaces.addAll(emslandMitte());
        allPlaces.addAll(emslandSued());
        // allPlaces.addAll(grafschaft());
        // allPlaces.addAll(cloppenburg());
        // allPlaces.addAll(osnabrück());
        // allPlaces.addAll(ostfriesland());
        return allPlaces;
    }

    public static List<Spielort> emslandNord() {
        List<Spielort> emslandNord = new ArrayList<>();
        emslandNord.add(new Spielort("Ahlen-Steinbild", 33, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Aschendorf", 47, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Aschendorfermoor", 51, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Bockholte", 47, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Bockhorst", 57, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Breddenberg", 49, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Brual", 48, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Börger", 41, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Dersum", 33, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Dörpen", 34, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Eisten-Hüven", 42, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Esterwegen", 60, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Fresenburg", 29, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Heede", 36, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Herbrum", 51, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Hilkenbrook", 65, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Lahn", 44, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Langen (Lathen)", 25, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Lathen", 27, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Lathen-Wahn", 24, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Lehe", 37, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Lorup", 49, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Neubörger", 38, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Neulangen", 19, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Neulehe", 42, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Neurhede", 47, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Ostenwalde", 41, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Papenburg", 58, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Rastdorf", 51, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Renkenberge", 31, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Rhede", 44, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Spahnharrenstätte", 42, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Surwold", 49, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Sögel", 36, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Vrees", 56, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Walchum-Hasselbrock", 29, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Wehm", 48, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Werlte", 47, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Werpeloh", 37, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Wieste", 49, Kreis.EL_NORD));
        emslandNord.add(new Spielort("Wippingen", 32, Kreis.EL_NORD));
        return emslandNord;
    }

    public static List<Spielort> emslandMitte() {
        List<Spielort> emslandMitte = new ArrayList<>();
        emslandMitte.add(new Spielort("Adorf", 26, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Ahmsen", 42, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Apeldorn", 21, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Berßen", 26, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Bokeloh", 15, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("CCI (Emslage)", 7, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Dalum", 19, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Dohren", 36, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Eltern", 30, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Emmeln", 11, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Erika-Altenberge", 15, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Fehndorf", 11, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Flechum", 34, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Fullen", 6, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Geeste", 21, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Groß Hesepe", 15, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Haren", 8, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Haselünne", 30, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Hebelermeer", 11, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Hemsen", 9, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Herssum", 43, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Herzlake", 38, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Holte", 41, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Hülsen-Westerloh", 29, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Lähden", 38, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Landegge", 11, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Lehrte", 22, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Meppen (SV)", 13, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Meppen (Union)", 6, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Neuringe", 24, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Osterbrock", 24, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Polle", 30, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Rütenbrock", 20, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Schleper", 25, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Schwefingen", 15, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Schöningsdorf", 11, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Stavern", 30, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Teglingen", 14, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Tinnen", 14, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Twist (Germania)", 23, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Twist (Grenzland)", 26, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Versen (JVA)", 4, Kreis.EL_MITTE));
        emslandMitte.add(new Spielort("Wesuwe", 2, Kreis.EL_MITTE));
        return emslandMitte;
    }

    public static List<Spielort> emslandSued() {
        List<Spielort> emsLandSued = new ArrayList<>();
        emsLandSued.add(new Spielort("Altenlingen", 30, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Andervenne", 50, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Baccum", 36, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Bawinkel", 31, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Beesten", 48, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Bramhar", 24, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Bramsche", 41, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Brögbern", 31, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Clusorth", 28, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Darme", 37, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Emsbüren", 58, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Freren", 47, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Gersten", 34, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Holthausen-Biene", 24, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Langen (Lengerich)", 36, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Laxten", 24, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Lengerich-Handrup", 40, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Leschede", 52, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Lingen", 30, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Listrup", 58, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Lünne", 46, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Messingen", 43, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Salzbergen", 62, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Schapen", 53, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Schepsdorf", 39, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Spelle-Venahus", 55, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Thuine", 42, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Varenrode", 50, Kreis.EL_SUED));
        emsLandSued.add(new Spielort("Wettrup", 39, Kreis.EL_SUED));
        return emsLandSued;
    }

    public static List<Spielort> grafschaft() {
        List<Spielort> grafschaft = new ArrayList<>();
        grafschaft.add(new Spielort("Nordhorn", 50, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Wielen", 40, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Bookholt", 47, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Hohenkörben", 37, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Neuenhaus", 42, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Schüttorf", 57, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Hilten-Lemke", 45, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Füchtenfeld", 31, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Ringe-Neugnadenfeld", 40, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Hesepe (Grafschaft)", 46, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Wilsum", 45, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Emlichheim", 39, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Bad Bentheim", 71, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Haftenkamp", 50, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Brandlecht-Hestrup", 63, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Quendorf", 63, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Esche",41, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Laarwald", 48, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Hoogstede", 35, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Klausheide", 40, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Uelsen", 49, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Lage", 56, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Suddendorf-Samern", 56, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Lohne (Grafschaft)", 38, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Veldhausen", 40, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Wietmarschen", 33, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Georgsdorf", 31, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Gildehaus", 69, Kreis.GRAFSCHAFT));
        grafschaft.add(new Spielort("Frensdorf", 57, Kreis.GRAFSCHAFT));
        return grafschaft;
    }

    public static List<Spielort> ostfriesland() {
        List<Spielort> ostfriesland = new ArrayList<>();
        return ostfriesland;
    }

    public static List<Spielort> cloppenburg() {
        List<Spielort> cloppenburg = new ArrayList<>();
        return cloppenburg;
    }

    public static List<Spielort> osnabrück() {
        List<Spielort> osna = new ArrayList<>();
        return osna;
    }

    @Override
    public String toString() {
        return this.getSpielort() + "\n" + this.getKreis().getName() + "\t\t--\t\t" + this.getDistanz() + "km" + "\t\t--\t\t" + this.getKosten() + "€";
    }

    public String[] toStringArray(){
        return new String[]{this.getSpielort(), Integer.toString(this.getDistanz()), this.kosten.toString(), this.getKreis().getName()};
    }
}
