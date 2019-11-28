package fasde.android.distanceapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO for a Spielort.
 */
public class Spielort {

    private String spielort;
    private int distanz;
    private BigDecimal kosten;
    private Kreis kreis;
    private String adresse;

    @Deprecated
    private Spielort(String spielort, int distanz, Kreis kreis) {
        this.spielort = spielort;
        this.distanz = distanz;
        this.kosten = new BigDecimal(distanz * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        this.kreis = kreis;
    }

    private Spielort(String spielort, int distanz, Kreis kreis, String adresse) {
        this.spielort = spielort;
        this.distanz = distanz;
        this.kosten = new BigDecimal(distanz * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        this.kreis = kreis;
        this.adresse = adresse;
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

    public String getAdresse() {
        return adresse;
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
        emslandNord.add(new Spielort("Ahlen-Steinbild", 33, Kreis.EL_NORD, "26892 Kluse, Ahornstraße 13"));
        emslandNord.add(new Spielort("Aschendorf", 47, Kreis.EL_NORD, "26871 Papenburg Emdener Str. 36"));
        emslandNord.add(new Spielort("Aschendorfermoor", 51, Kreis.EL_NORD, "26871 Aschendorfermoor, Glatzer Str. 13"));
        emslandNord.add(new Spielort("Bockholte", 47, Kreis.EL_NORD, "49757 Werlte, Westerkamp 16"));
        emslandNord.add(new Spielort("Bockhorst", 57, Kreis.EL_NORD, "26897 Bockhorst, Am Sportplatz 22"));
        emslandNord.add(new Spielort("Breddenberg", 49, Kreis.EL_NORD, "26897 Breddenberg, Wachtelweg 23"));
        emslandNord.add(new Spielort("Brual", 48, Kreis.EL_NORD, "26899 Rhede, Deichstraße 1"));
        emslandNord.add(new Spielort("Börger", 41, Kreis.EL_NORD, "26904 Börger, Waldstraße 58"));
        emslandNord.add(new Spielort("Dersum", 33, Kreis.EL_NORD, "26906 Dersum, Dorfstraße 38"));
        emslandNord.add(new Spielort("Dörpen", 34, Kreis.EL_NORD, "26892 Dorpen, Am Sportpark 14"));
        emslandNord.add(new Spielort("Eisten-Hüven", 42, Kreis.EL_NORD, "49751 Hüven, Zum Kienmoor"));
        emslandNord.add(new Spielort("Esterwegen", 60, Kreis.EL_NORD, "26897 Esterwegen, Am Sportpark 1"));
        emslandNord.add(new Spielort("Fresenburg", 29, Kreis.EL_NORD, "49762 Fresenburg, Juister Weg 4"));
        emslandNord.add(new Spielort("Heede", 36, Kreis.EL_NORD, "26892 Heede, Kirchstr. 22"));
        emslandNord.add(new Spielort("Herbrum", 51, Kreis.EL_NORD, "26871 Papenburg, Herzogstraße"));
        emslandNord.add(new Spielort("Hilkenbrook", 65, Kreis.EL_NORD, "26897 Hilkenbrook, Esterweger Weg 9"));
        emslandNord.add(new Spielort("Lahn", 44, Kreis.EL_NORD, "49757 Lahn, Rosenstraße 5"));
        emslandNord.add(new Spielort("Langen (Lathen)", 25, Kreis.EL_NORD, "49779 Niederlangen, Schulstraße 13"));
        emslandNord.add(new Spielort("Lathen", 27, Kreis.EL_NORD, "49762 Lathen, Meppener Str. 25"));
        emslandNord.add(new Spielort("Lathen-Wahn", 24, Kreis.EL_NORD, "49762 Lathen, Ahornstraße"));
        emslandNord.add(new Spielort("Lehe", 37, Kreis.EL_NORD, "26892 Lehe, Neuleherstr."));
        emslandNord.add(new Spielort("Lorup", 49, Kreis.EL_NORD, "26901 Lorup, Breddenberger Str. 18"));
        emslandNord.add(new Spielort("Neubörger", 38, Kreis.EL_NORD, "26909 Neubörger, Deverweg 4"));
        emslandNord.add(new Spielort("Neulangen", 19, Kreis.EL_NORD, "49779 Niederlangen, Kastanienstraße 2"));
        emslandNord.add(new Spielort("Neulehe", 42, Kreis.EL_NORD, "26909 Neulehe, Waldstraße 3"));
        emslandNord.add(new Spielort("Ostenwalde", 41, Kreis.EL_NORD, "49757 Werlte, Dorfanger 16"));
        emslandNord.add(new Spielort("Papenburg (Eintracht)", 58, Kreis.EL_NORD, "26871 Papenburg, Splitting links 198"));
        emslandNord.add(new Spielort("Papenburg (Germania)", 58, Kreis.EL_NORD, "26871 Papenburg, Kleiststr. 14"));
        emslandNord.add(new Spielort("Papenburg (BW 94)", 58, Kreis.EL_NORD, "26871 Papenburg, Hans-Nolte-Str. 1"));
        emslandNord.add(new Spielort("Rastdorf", 51, Kreis.EL_NORD, "26901 Rastdorf, Am Sportplatz"));
        emslandNord.add(new Spielort("Renkenberge", 31, Kreis.EL_NORD, "49762 Renkenberge, Wahner Str."));
        emslandNord.add(new Spielort("Rhede", 44, Kreis.EL_NORD, "26899 Rhede, Kold'n Hauk"));
        emslandNord.add(new Spielort("Spahnharrenstätte", 42, Kreis.EL_NORD, "49751 Spahnharrenstätte, Am Sportplatz"));
        emslandNord.add(new Spielort("Surwold", 49, Kreis.EL_NORD, "26903 Surwold, Lindenstraße 15"));
        emslandNord.add(new Spielort("Sögel", 36, Kreis.EL_NORD, "49751 Sögel, Loruper Weg 9"));
        emslandNord.add(new Spielort("Vrees", 56, Kreis.EL_NORD, "49757 Vrees, Herzog-Arenberg-Str. 24"));
        emslandNord.add(new Spielort("Walchum-Hasselbrock", 29, Kreis.EL_NORD, "26907 Walchum, Im Tannensand 4"));
        emslandNord.add(new Spielort("Wehm", 48, Kreis.EL_NORD, "49757 Werlte, Am Schützenplatz 2"));
        emslandNord.add(new Spielort("Werlte", 47, Kreis.EL_NORD, "49757 Werlte, Sögeler Str. 3"));
        emslandNord.add(new Spielort("Werpeloh", 37, Kreis.EL_NORD, "49751 Werpeloh, Wippinger Str. 20"));
        emslandNord.add(new Spielort("Wippingen", 32, Kreis.EL_NORD, "26892 Wippingen, Am Sportplatz"));
        return emslandNord;
    }

    public static List<Spielort> emslandMitte() {
        List<Spielort> emslandMitte = new ArrayList<>();
        emslandMitte.add(new Spielort("Adorf", 26, Kreis.EL_MITTE, "49767 Twist, Am Fuchsbau 7"));
        emslandMitte.add(new Spielort("Ahmsen", 42, Kreis.EL_MITTE, "49774 Lähnden, Am Sportplatz 26"));
        emslandMitte.add(new Spielort("Apeldorn", 21, Kreis.EL_MITTE, "49716 Meppen, Am Sportplatz"));
        emslandMitte.add(new Spielort("Berßen", 26, Kreis.EL_MITTE, "49774 Klein Berßen, Schützenstraße 10"));
        emslandMitte.add(new Spielort("Bokeloh", 15, Kreis.EL_MITTE, "491716 Meppen, Kiefernstr. 8"));
        emslandMitte.add(new Spielort("CCI (Emslage)", 7, Kreis.EL_MITTE, "49716 Meppen, Lohberg 10"));
        emslandMitte.add(new Spielort("Dalum", 19, Kreis.EL_MITTE, "49744 Geeste, Zum Sportzentrum"));
        emslandMitte.add(new Spielort("Dohren", 36, Kreis.EL_MITTE, "49770 Dohren, Am Sportplatz 3"));
        emslandMitte.add(new Spielort("Eltern", 30, Kreis.EL_MITTE, "49740 Haselünne, Georg-Bernd-Straße 30"));
        emslandMitte.add(new Spielort("Emmeln", 11, Kreis.EL_MITTE, "49733 Haren (Ems), Hanfeldstraße 6"));
        emslandMitte.add(new Spielort("Erika-Altenberge", 15, Kreis.EL_MITTE, "49733 Haren (Ems), An der Koppel 1"));
        emslandMitte.add(new Spielort("Fehndorf", 11, Kreis.EL_MITTE, "49733 Haren (Ems), Handwerkerstr."));
        emslandMitte.add(new Spielort("Flechum", 34, Kreis.EL_MITTE, "49740 Haselünne, Am Sandpool"));
        emslandMitte.add(new Spielort("Fullen", 6, Kreis.EL_MITTE, "49716 Meppen, Heidkampstr. 2"));
        emslandMitte.add(new Spielort("Geeste", 21, Kreis.EL_MITTE, "49744 Geeste, Gusbergstr. 27"));
        emslandMitte.add(new Spielort("Groß Hesepe", 15, Kreis.EL_MITTE, "49744 Geeste, Ludgeristr."));
        emslandMitte.add(new Spielort("Haren", 8, Kreis.EL_MITTE, "49733 Haren (Ems), Parkweg 3"));
        emslandMitte.add(new Spielort("Haselünne", 30, Kreis.EL_MITTE, "49734 Haselünne, Lingener Str. 29"));
        emslandMitte.add(new Spielort("Hebelermeer", 11, Kreis.EL_MITTE, "49767 Twist, Hebelermeer 8"));
        emslandMitte.add(new Spielort("Hemsen", 9, Kreis.EL_MITTE, "49716 Meppen, Kreuzweg"));
        emslandMitte.add(new Spielort("Herssum", 43, Kreis.EL_MITTE, "49774 Lähden, Zum Sportplatz"));
        emslandMitte.add(new Spielort("Herzlake", 38, Kreis.EL_MITTE, "49770 Herzlake, Im Mersch"));
        emslandMitte.add(new Spielort("Holte", 41, Kreis.EL_MITTE, "49774 Lähden, Clemenskoppel 5"));
        emslandMitte.add(new Spielort("Hülsen-Westerloh", 29, Kreis.EL_MITTE, "49740 Haselünne, Am Sportplatz 2"));
        emslandMitte.add(new Spielort("Lähden", 38, Kreis.EL_MITTE, "49774 Lähden, Jahnstraße 21"));
        emslandMitte.add(new Spielort("Landegge", 11, Kreis.EL_MITTE, "49733 Haren (Ems), Landegge-Dorf"));
        emslandMitte.add(new Spielort("Lehrte", 22, Kreis.EL_MITTE, "49740 Haselünne, Schulstraße 13"));
        emslandMitte.add(new Spielort("Meppen (SV)", 13, Kreis.EL_MITTE, "49716 Meppen, Lathener Str."));
        emslandMitte.add(new Spielort("Meppen (Union)", 6, Kreis.EL_MITTE, "49716 Meppen, Versener Str. 69"));
        emslandMitte.add(new Spielort("Neuringe", 24, Kreis.EL_MITTE, "49767 Twist, Neuringe"));
        emslandMitte.add(new Spielort("Osterbrock", 24, Kreis.EL_MITTE, "49744 Geeste, Rosenstraße 9"));
        emslandMitte.add(new Spielort("Polle", 30, Kreis.EL_MITTE, "49740 Haselünne, Schützenstr."));
        emslandMitte.add(new Spielort("Rütenbrock", 20, Kreis.EL_MITTE, "49733 Haren (Ems), An der Mühle 12"));
        emslandMitte.add(new Spielort("Schleper", 25, Kreis.EL_MITTE, "49740 Haselünne, Neuer Kamp"));
        emslandMitte.add(new Spielort("Schwefingen", 15, Kreis.EL_MITTE, "49716 Meppen, Landwehr 112"));
        emslandMitte.add(new Spielort("Schöningsdorf", 11, Kreis.EL_MITTE, "49767 Twist, Bürgermeister-Brüning-Str."));
        emslandMitte.add(new Spielort("Stavern", 30, Kreis.EL_MITTE, "49777 Stavern, Am Neuen Grund 11"));
        emslandMitte.add(new Spielort("Teglingen", 14, Kreis.EL_MITTE, "49716 Meppen, Amselweg 12"));
        emslandMitte.add(new Spielort("Tinnen", 14, Kreis.EL_MITTE, "49733 Haren (Ems), Lohhang 6"));
        emslandMitte.add(new Spielort("Twist (Germania)", 23, Kreis.EL_MITTE, "49767 Twist, Hesper Str. 15"));
        emslandMitte.add(new Spielort("Twist (Grenzland)", 26, Kreis.EL_MITTE, "49767 Twist, Am Brook 30"));
        emslandMitte.add(new Spielort("Versen (JVA)", 4, Kreis.EL_MITTE, "49716 Meppen, Grünfeldstr. 1"));
        emslandMitte.add(new Spielort("Wesuwe", 2, Kreis.EL_MITTE, "49733 Haren (Ems), Am Sportplatz"));
        return emslandMitte;
    }

    public static List<Spielort> emslandSued() {
        List<Spielort> emsLandSued = new ArrayList<>();
        emsLandSued.add(new Spielort("Altenlingen", 30, Kreis.EL_SUED, "49808 Lingen, Wallkamp 11"));
        emsLandSued.add(new Spielort("Andervenne", 50, Kreis.EL_SUED, "49832 Andervenne, Schulstraße 6"));
        emsLandSued.add(new Spielort("Baccum", 36, Kreis.EL_SUED, "49811 Lingen, Alte Dorfstr. 26"));
        emsLandSued.add(new Spielort("Bawinkel", 31, Kreis.EL_SUED, "49844 Bawinkel, Am Sportplatz 2"));
        emsLandSued.add(new Spielort("Beesten", 48, Kreis.EL_SUED, "49832 Beesten, Stadionstraße"));
        emsLandSued.add(new Spielort("Bramhar", 24, Kreis.EL_SUED, "49744 Geeste, Dorfstraße 8"));
        emsLandSued.add(new Spielort("Bramsche", 41, Kreis.EL_SUED, "49811 Lingen, Bramscher Str. 12"));
        emsLandSued.add(new Spielort("Brögbern", 31, Kreis.EL_SUED, "49811 Lingen, Jasminstr. 13"));
        emsLandSued.add(new Spielort("Clusorth", 28, Kreis.EL_SUED, "49811 Lingen, Bawinkeler Str. 1"));
        emsLandSued.add(new Spielort("Darme", 37, Kreis.EL_SUED, "48909 Lingen, Schubertstr. 2"));
        emsLandSued.add(new Spielort("Emsbüren", 58, Kreis.EL_SUED, "48488 Emsbüren, Hanwische Str. 12"));
        emsLandSued.add(new Spielort("Freren", 47, Kreis.EL_SUED, "49832 Freren, Zu den Hünensteinen 13"));
        emsLandSued.add(new Spielort("Gersten", 34, Kreis.EL_SUED, "49838 Gersten, Bregenbecker Str. 7"));
        emsLandSued.add(new Spielort("Holthausen-Biene", 24, Kreis.EL_SUED, "49808 Geeste, Zum Biener Busch"));
        emsLandSued.add(new Spielort("Langen (Lengerich)", 36, Kreis.EL_SUED, "49838 Langen, Bawinkeler Str. 4"));
        emsLandSued.add(new Spielort("Laxten", 24, Kreis.EL_SUED, "49809 Lingen, Diekstr. 1"));
        emsLandSued.add(new Spielort("Lengerich-Handrup", 40, Kreis.EL_SUED, "49838 Lengerich, Schulstr. 21"));
        emsLandSued.add(new Spielort("Leschede", 52, Kreis.EL_SUED, "48488 Emsbüren, Narzissenstraße 25"));
        emsLandSued.add(new Spielort("Lingen (VfB)", 30, Kreis.EL_SUED, "49809 Lingen, Haselünner Str. 150"));
        emsLandSued.add(new Spielort("Listrup", 58, Kreis.EL_SUED, "48488 Emsbüren, Zum Sportplatz 1"));
        emsLandSued.add(new Spielort("Lünne", 46, Kreis.EL_SUED, "48480 Lünne, Am Sportplatz"));
        emsLandSued.add(new Spielort("Messingen", 43, Kreis.EL_SUED, "49832 Messingen, Baccumer Weg 6"));
        emsLandSued.add(new Spielort("Salzbergen", 62, Kreis.EL_SUED, "48499 Salzbergen, Ahlder Damm 16"));
        emsLandSued.add(new Spielort("Schapen", 53, Kreis.EL_SUED, "48480 Schapen, Hörstraße 4"));
        emsLandSued.add(new Spielort("Schepsdorf", 39, Kreis.EL_SUED, "49808 Lingen, Nordlohner Str. 38"));
        emsLandSued.add(new Spielort("Spelle-Venahus", 55, Kreis.EL_SUED, "48480 Spelle, Venhauser Str."));
        emsLandSued.add(new Spielort("Thuine", 42, Kreis.EL_SUED, "49832 Thuine, Hubert-Klockenbusch-Str. 1"));
        emsLandSued.add(new Spielort("Varenrode", 50, Kreis.EL_SUED, "48480 Spelle, Bönnestr. 12"));
        emsLandSued.add(new Spielort("Wettrup", 39, Kreis.EL_SUED, "49838 Wettrup, Luisenweg 10"));
        return emsLandSued;
    }

    @Deprecated
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
        grafschaft.add(new Spielort("Esche", 41, Kreis.GRAFSCHAFT));
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

    @Deprecated
    public static List<Spielort> ostfriesland() {
        List<Spielort> ostfriesland = new ArrayList<>();
        return ostfriesland;
    }

    @Deprecated
    public static List<Spielort> cloppenburg() {
        List<Spielort> cloppenburg = new ArrayList<>();
        return cloppenburg;
    }

    @Deprecated
    public static List<Spielort> osnabrück() {
        List<Spielort> osna = new ArrayList<>();
        return osna;
    }

    @Override
    public String toString() {
        return this.getSpielort() + "\n" + this.getKreis().getName() + "\t\t--\t\t" + this.getDistanz() + "km" + "\t\t--\t\t" + this.getKosten() + "€";
    }

    public String[] toStringArray() {
        String adress[] = this.getAdresse().split(",");
        return new String[]{this.getSpielort(), Integer.toString(this.getDistanz()), this.kosten.toString(), this.getKreis().getName(), adress[0], adress[1]};
    }
}
