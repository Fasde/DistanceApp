package fasde.android.distanceapp.database;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import fasde.android.distanceapp.model.Kreis;
import fasde.android.distanceapp.model.Spielort;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SaveData {

    public Map<String, Spielort> fillVereine(String variante) {
        HashMap<String, Spielort> vereine = new HashMap<>();

        switch (variante) {
            case "Alle Kreise":
                addSpielorte(vereine, SaveData.gottaListEmAll());
                break;
            case "Emsland":
                addSpielorte(vereine, SaveData.emslandNord());
                addSpielorte(vereine, SaveData.emslandMitte());
                addSpielorte(vereine, SaveData.emslandSued());
                break;
            case "EL-Nord":
                addSpielorte(vereine, SaveData.emslandNord());
                break;
            case "EL-Mitte":
                addSpielorte(vereine, SaveData.emslandMitte());
                break;
            case "EL-Süd":
                addSpielorte(vereine, SaveData.emslandSued());
                break;
            case "Grafschaft":
                addSpielorte(vereine, SaveData.grafschaft());
                break;
            case "Cloppenburg":
                addSpielorte(vereine, SaveData.cloppenburg());
                break;
            case "Ostfriesland":
                addSpielorte(vereine, SaveData.ostfriesland());
                break;
            case "Osnabrück":
                addSpielorte(vereine, SaveData.osnabrück());
                break;
            default:
               Log.println(Log.ERROR, "Fehler", "Kein Kreis gewählt!");
        }

        return vereine;
    }

    private void addSpielorte(Map<String, Spielort> vereine, List<Spielort> list){
        for(Spielort ort : list){
            vereine.put(ort.getOrtsName(), ort);
        }
    }

    public List<Kreis> listAllKreise() {
        return Arrays.asList(Kreis.values());
    }

    private List<Spielort> gottaListEmAll() {
        List<Spielort> allPlaces = new ArrayList<>();
        allPlaces.addAll(emslandNord());
        allPlaces.addAll(emslandMitte());
        allPlaces.addAll(emslandSued());
        allPlaces.addAll(grafschaft());
        allPlaces.addAll(cloppenburg());
        allPlaces.addAll(osnabrück());
        allPlaces.addAll(ostfriesland());
        return allPlaces;
    }

    private List<Spielort> emslandNord() {
        List<Spielort> emslandNord = new ArrayList<>();
        emslandNord.add(new Spielort("Ahlen-Steinbild", Kreis.EL_NORD, "26892 Kluse, Ahornstraße 13", "7.33799,52.936597"));
        emslandNord.add(new Spielort("Aschendorf", Kreis.EL_NORD, "26871 Aschendorf, Emdenerstraße 36", "7.348024,53.057359"));
        emslandNord.add(new Spielort("Aschendorfermoor", Kreis.EL_NORD, "26871 Aschendorf, Glatzer Str. 13", "7.393241,53.040658"));
        emslandNord.add(new Spielort("Bockholte", Kreis.EL_NORD, "49757 Werlte, Westerkamp 16", "7.709623098553102,52.867880551195576"));
        emslandNord.add(new Spielort("Bockhorst", Kreis.EL_NORD, "26897 Bockhorst, Am Sportplatz 22", "7.573777069721588,53.03075242360356"));
        emslandNord.add(new Spielort("Breddenberg", Kreis.EL_NORD, "26897 Breddenberg, Wachtelweg 23", "7.602167240883786,52.95722415392781"));
        emslandNord.add(new Spielort("Brual", Kreis.EL_NORD, "26899 Rhede, Deichstraße 1", "7.285924085066736,53.09600808285782"));
        emslandNord.add(new Spielort("Börger", Kreis.EL_NORD, "26904 Börger, Waldstraße 58", "7.532610269718631,52.91921158161526"));
        emslandNord.add(new Spielort("Dersum", Kreis.EL_NORD, "26906 Dersum, Dorfstraße 38", "7.2334986427351025,52.96991853781075"));
        emslandNord.add(new Spielort("Dörpen", Kreis.EL_NORD, "26892 Doerpen, Am Sportpark 14", "7.31492051389897,52.959419265587904"));
        emslandNord.add(new Spielort("Eisten-Hüven", Kreis.EL_NORD, "49751 Hüven, Zum Kienmoor", "7.5516940562227814,52.79198865188816"));
        emslandNord.add(new Spielort("Esterwegen", Kreis.EL_NORD, "26897 Esterwegen, Am Sportpark 1", "7.629252796705594,52.99774659381847"));
        emslandNord.add(new Spielort("Fresenburg", Kreis.EL_NORD, "49762 Fresenburg, Juister Weg 4", "7.311566998553484,52.88290759122808"));
        emslandNord.add(new Spielort("Heede", Kreis.EL_NORD, "26892 Heede, Kirchstr. 22", "7.313765471571546,52.9906273436245"));
        emslandNord.add(new Spielort("Herbrum", Kreis.EL_NORD, "26871 Papenburg, Herzogstraße", "7.343091713900802,53.027265908514714"));
        emslandNord.add(new Spielort("Hilkenbrook", Kreis.EL_NORD, "26897 Hilkenbrook, Esterweger Weg 9", "7.702551640884508,52.98572205829264"));
        emslandNord.add(new Spielort("Lahn", Kreis.EL_NORD, "49757 Lahn, Rosenstraße 5", "7.607259869715776,52.812737044490774"));
        emslandNord.add(new Spielort("Langen (Lathen)", Kreis.EL_NORD, "49779 Niederlangen, Schulstraße 13", "7.2823528673304825,52.8533867555271"));
        emslandNord.add(new Spielort("Lathen", Kreis.EL_NORD, "49762 Lathen, Meppener Str. 25", "7.31835621944924,52.854573556842816"));
        emslandNord.add(new Spielort("Lathen-Wahn", Kreis.EL_NORD, "49762 Lathen, Wahner Str.", "7.367380282115088,52.86046466365477"));
        emslandNord.add(new Spielort("Lehe", Kreis.EL_NORD, "26892 Lehe, Neuleherstr.", "7.367107642735897,53.000359995468486"));
        emslandNord.add(new Spielort("Lorup", Kreis.EL_NORD, "26901 Lorup, Breddenberger Str. 18", "7.6353556427340346,52.930074021168906"));
        emslandNord.add(new Spielort("Neubörger", Kreis.EL_NORD, "26909 Neubörger, Deverweg 4", "7.449722371570389,52.94643516456423"));
        emslandNord.add(new Spielort("Neulangen", Kreis.EL_NORD, "49779 Niederlangen, Kastanienstraße 2", "7.179830356224872,52.86946958194129"));
        emslandNord.add(new Spielort("Neulehe", Kreis.EL_NORD, "26909 Neulehe, Waldstraße 3", "7.412731219453298,53.00700721591959"));
        emslandNord.add(new Spielort("Ostenwalde", Kreis.EL_NORD, "49757 Werlte, Dorfanger 16", "7.5918490231508535,52.84012970004131"));
        emslandNord.add(new Spielort("Papenburg (Eintracht)", Kreis.EL_NORD, "26871 Papenburg, Splitting links 198", "7.467729869721894,53.04152434079038"));
        emslandNord.add(new Spielort("Papenburg (Germania)", Kreis.EL_NORD, "26871 Papenburg, Kleiststrasse 14", "7.400805569722727,53.073580595427664"));
        emslandNord.add(new Spielort("Papenburg (BW 94)", Kreis.EL_NORD, "26871 Papenburg, Hans-Nolte-Str. 1", "7.440909705304785,53.07236707860145"));
        emslandNord.add(new Spielort("Rastdorf", Kreis.EL_NORD, "26901 Rastdorf, Am Sportplatz", "7.702604312046728,52.91411809009867"));
        emslandNord.add(new Spielort("Renkenberge", Kreis.EL_NORD, "49762 Renkenberge, Wahner Str.", "7.387924910195427,52.90046707317617"));
        emslandNord.add(new Spielort("Rhede", Kreis.EL_NORD, "26899 Rhede, Kold'n Hauk", "7.275024356229915,53.058714168095946"));
        emslandNord.add(new Spielort("Spahnharrenstätte", Kreis.EL_NORD, "49751 Spahnharrenstätte, Am Sportplatz", "7.6032312912579485,52.87131283757716"));
        emslandNord.add(new Spielort("Surwold", Kreis.EL_NORD, "26903 Surwold, Lindenstraße 15", "7.549277386915503,53.01200399969324"));
        emslandNord.add(new Spielort("Sögel", Kreis.EL_NORD, "49751 Sögel, Loruper Weg 9", "7.526515034792438,52.846256534464686"));
        emslandNord.add(new Spielort("Vrees", Kreis.EL_NORD, "49757 Vrees, Herzog-Arenberg-Str. 24", "7.776545240346733,52.892266981564845"));
        emslandNord.add(new Spielort("Walchum-Hasselbrock", Kreis.EL_NORD, "26907 Walchum, Im Tannensand 4", "7.274926273420974,52.93128745513596"));
        emslandNord.add(new Spielort("Wehm", Kreis.EL_NORD, "49757 Werlte, Am Schützenplatz 2", "7.664474778971413,52.83274906058898"));
        emslandNord.add(new Spielort("Werlte", Kreis.EL_NORD, "49757 Werlte, Sögeler Str. 3", "7.671085494315266,52.84957474065507"));
        emslandNord.add(new Spielort("Werpeloh", Kreis.EL_NORD, "49751 Werpeloh, Wippinger Str. 20", "7.5023195691821485,52.87537011596646"));
        emslandNord.add(new Spielort("Wippingen", Kreis.EL_NORD, "26892 Wippingen, Am Sportplatz", "7.400899754375131,52.919032226516514"));
        return emslandNord;
    }

    private List<Spielort> emslandMitte() {
        List<Spielort> emslandMitte = new ArrayList<>();
        emslandMitte.add(new Spielort("Adorf", Kreis.EL_MITTE, "49767 Twist, Am Fuchsbau 7", "7.083195086904831,52.60785510769239"));
        emslandMitte.add(new Spielort("Ahmsen", Kreis.EL_MITTE, "49774 Lähden, Am Sportplatz 26", "7.684568244580802,52.76859830184927"));
        emslandMitte.add(new Spielort("Apeldorn", Kreis.EL_MITTE, "49716 Apeldorn, Am Sportplatz", "7.394284713893188,52.74128344683675"));
        emslandMitte.add(new Spielort("Berßen", Kreis.EL_MITTE, "49774 Klein Berßen, Schützenstraße 10", "7.470840813358547,52.76710210061195"));
        emslandMitte.add(new Spielort("Bokeloh", Kreis.EL_MITTE, "49716 Meppen, Kiefernstr. 8", "7.3563054212962635,52.70471410309691"));
        emslandMitte.add(new Spielort("CCI (Emslage)", Kreis.EL_MITTE, "49716 Meppen, Lohberg 10", "7.23965091335636,52.68346285627125"));
        emslandMitte.add(new Spielort("Dalum", Kreis.EL_MITTE, "49744 Geeste, Zum Sportzentrum", "7.217604571561095,52.59540427383116"));
        emslandMitte.add(new Spielort("Dohren", Kreis.EL_MITTE, "49770 Dohren, Am Sportplatz 3", "7.589621655683776,52.650762757671245"));
        emslandMitte.add(new Spielort("Eltern", Kreis.EL_MITTE, "49740 Haselünne, Georg-Bernd-Straße 30", "7.508046142192287,52.68708133013472"));
        emslandMitte.add(new Spielort("Emmeln", Kreis.EL_MITTE, "49733 Haren (Ems), Hanfeldstraße 6", "7.28411207658378,52.78431798277266"));
        emslandMitte.add(new Spielort("Erika-Altenberge", Kreis.EL_MITTE, "49733 Haren (Ems), Tengestraße", "7.139851842207125,52.82503741156239"));
        emslandMitte.add(new Spielort("Fehndorf", Kreis.EL_MITTE, "49733 Haren (Ems), Am Vollmond", "7.114901926945686,52.78175940530789"));
        emslandMitte.add(new Spielort("Flechum", Kreis.EL_MITTE, "49740 Haselünne, Am Sandpool", "7.554074512041285,52.70718268815405"));
        emslandMitte.add(new Spielort("Fullen", Kreis.EL_MITTE, "49716 Meppen, Heidkampstr. 2", "7.224594978967772,52.695369549748456"));
        emslandMitte.add(new Spielort("Geeste", Kreis.EL_MITTE, "49744 Geeste, Gusbergstr. 27", "7.274443645892262,52.60905666315705"));
        emslandMitte.add(new Spielort("Groß Hesepe", Kreis.EL_MITTE, "49744 Geeste, Ludgeristr.", "7.2350039697107995,52.62472894793585"));
        emslandMitte.add(new Spielort("Haren", Kreis.EL_MITTE, "49733 Haren (Ems), Am Brookdeich", "7.231606182296234,52.78605080382686"));
        emslandMitte.add(new Spielort("Haselünne", Kreis.EL_MITTE, "49734 Haselünne, Lingener Str. 29", "7.4811695482801,52.66707007390266"));
        emslandMitte.add(new Spielort("Hebelermeer", Kreis.EL_MITTE, "49767 Twist, Hebelermeer 8", "7.097046655686261,52.74588080594238"));
        emslandMitte.add(new Spielort("Hemsen", Kreis.EL_MITTE, "49716 Meppen, Kreuzweg", "7.282098431302837,52.736387455993395"));
        emslandMitte.add(new Spielort("Herssum", Kreis.EL_MITTE, "49774 Lähden, Zum Sportplatz", "7.647422740878459,52.757125550059286"));
        emslandMitte.add(new Spielort("Herzlake", Kreis.EL_MITTE, "49770 Herzlake, Im Mersch", "7.612304298548158,52.68008631121612"));
        emslandMitte.add(new Spielort("Holte", Kreis.EL_MITTE, "49774 Lähden, Clemenskoppel 5", "7.615982913893122,52.736940924599324"));
        emslandMitte.add(new Spielort("Hülsen-Westerloh", Kreis.EL_MITTE, "49740 Haselünne, Am Sportplatz 2", "7.477429813892387,52.71026538091512"));
        emslandMitte.add(new Spielort("Lähden", Kreis.EL_MITTE, "49774 Lähden, Jahnstraße 21", "7.570568554370675,52.74841485548877"));
        emslandMitte.add(new Spielort("Landegge", Kreis.EL_MITTE, "49733 Haren (Ems), Landegge-Dorf", "7.249182272608037,52.81978691971132"));
        emslandMitte.add(new Spielort("Lehrte", Kreis.EL_MITTE, "49740 Haselünne, Schulstraße 13", "7.4004379120404025,52.673536000889406"));
        emslandMitte.add(new Spielort("Meppen (SV)", Kreis.EL_MITTE, "49716 Meppen, Lathener Str.", "7.295238958085432,52.70862168393778"));
        emslandMitte.add(new Spielort("Meppen (Union)", Kreis.EL_MITTE, "49716 Meppen, Versener Str. 69", "7.258190934788713,52.704230405042296"));
        emslandMitte.add(new Spielort("Neuringe", Kreis.EL_MITTE, "49767 Twist, Neuringe", "7.023619744577204,52.63243353549059"));
        emslandMitte.add(new Spielort("Osterbrock", Kreis.EL_MITTE, "49744 Geeste, Rosenstraße 9", "7.319684871561299,52.60304124770368"));
        emslandMitte.add(new Spielort("Polle", Kreis.EL_MITTE, "49740 Haselünne, Schützenstr.", "7.519424940875655,52.651633660406965"));
        emslandMitte.add(new Spielort("Rütenbrock", Kreis.EL_MITTE, "49733 Haren (Ems), An der Mühle 12", "7.1054367820282565,52.835022818948005"));
        emslandMitte.add(new Spielort("Schleper", Kreis.EL_MITTE, "49740 Haselünne, Neuer Kamp", "7.432854240876526,52.685133855326434"));
        emslandMitte.add(new Spielort("Schwefingen", Kreis.EL_MITTE, "49716 Meppen, Landwehr 112", "7.286551340876225,52.67266815454803"));
        emslandMitte.add(new Spielort("Schöningsdorf", Kreis.EL_MITTE, "49767 Twist, Bürgermeister-Brüning-Str.", "7.0935571255337235,52.70784859049012"));
        emslandMitte.add(new Spielort("Stavern", Kreis.EL_MITTE, "49777 Stavern, Am Neuen Grund 11", "7.4209506562225425,52.78172166747211"));
        emslandMitte.add(new Spielort("Teglingen", Kreis.EL_MITTE, "49716 Meppen, Teglinger Hauptstraße 2a", "7.318179456455058,52.65973996403955"));
        emslandMitte.add(new Spielort("Tinnen", Kreis.EL_MITTE, "49733 Haren (Ems), Lohkamp", "7.326286281435998,52.797883150480864"));
        emslandMitte.add(new Spielort("Twist (Germania)", Kreis.EL_MITTE, "49767 Twist, Hesper Str. 15", "7.103243321294361,52.63276625756669"));
        emslandMitte.add(new Spielort("Twist (Grenzland)", Kreis.EL_MITTE, "49767 Twist, Am Brook 30", "7.054155063622673,52.633269128512175"));
        emslandMitte.add(new Spielort("Versen (JVA)", Kreis.EL_MITTE, "49716 Meppen, Grünfeldstr. 1", "7.185816644044201,52.72134796036134"));
        emslandMitte.add(new Spielort("Wesuwe", Kreis.EL_MITTE, "49733 Haren (Ems), Am Sportplatz", "7.206858422863424,52.75957353022217"));
        return emslandMitte;
    }

    private List<Spielort> emslandSued() {
        List<Spielort> emsLandSued = new ArrayList<>();
        emsLandSued.add(new Spielort("Altenlingen", Kreis.EL_SUED, "49808 Lingen, Wallkamp 11", "7.2981663292314565,52.54440173345177"));
        emsLandSued.add(new Spielort("Andervenne", Kreis.EL_SUED, "49832 Andervenne, Schulstraße 6", "7.57306138505122,52.509974757050784"));
        emsLandSued.add(new Spielort("Baccum", Kreis.EL_SUED, "49811 Lingen, Alte Dorfstr. 26", "7.398121117053896,52.512983108677595"));
        emsLandSued.add(new Spielort("Bawinkel", Kreis.EL_SUED, "49844 Bawinkel, Am Sportplatz 2", "7.403302082667248,52.59988797613077"));
        emsLandSued.add(new Spielort("Beesten", Kreis.EL_SUED, "49832 Beesten, Stadionstraße", "7.51496735563097352.42826646723915"));
        emsLandSued.add(new Spielort("Bramhar", Kreis.EL_SUED, "49744 Geeste, Dorfstraße 8", "7.366579492457729,52.60340384646298"));
        emsLandSued.add(new Spielort("Bramsche", Kreis.EL_SUED, "49811 Lingen, Bramscher Str. 12", "7.3658085850498844,52.45857250403054"));
        emsLandSued.add(new Spielort("Brögbern", Kreis.EL_SUED, "49811 Lingen, Jasminstr. 13", "7.364168928696369,52.55442770692236"));
        emsLandSued.add(new Spielort("Clusorth", Kreis.EL_SUED, "49811 Lingen, Bawinkeler Str. 1", "7.3680277458916645,52.58567313025702"));
        emsLandSued.add(new Spielort("Darme", Kreis.EL_SUED, "48909 Lingen, Kiesbahn 24A", "7.315566051443786,52.50004900982575"));
        emsLandSued.add(new Spielort("Emsbüren", Kreis.EL_SUED, "48488 Emsbüren, Hanwische Str. 12", "7.290692432929555,52.39730744376584"));
        emsLandSued.add(new Spielort("Freren", Kreis.EL_SUED, "49832 Freren, Zu den Hünensteinen 13", "7.497940045889494,52.503532133951055"));
        emsLandSued.add(new Spielort("Gersten", Kreis.EL_SUED, "49838 Gersten, Bregenbecker Str. 7", "7.489824757532715,52.57294314826056"));
        emsLandSued.add(new Spielort("Holthausen-Biene", Kreis.EL_SUED, "49808 Geeste, Zum Biener Busch", "7.264917382041456,52.56813970190016"));
        emsLandSued.add(new Spielort("Langen (Lengerich)", Kreis.EL_SUED, "49838 Langen, Bawinkeler Str. 4", "7.464827532933364,52.54078305854636"));
        emsLandSued.add(new Spielort("Laxten", Kreis.EL_SUED, "49809 Lingen, Diekstr. 1", "7.346643621291532,52.52391723496651"));
        emsLandSued.add(new Spielort("Lengerich-Handrup", Kreis.EL_SUED, "49838 Lengerich, Schulstr. 21", "7.534413117590138,52.54931003147139"));
        emsLandSued.add(new Spielort("Leschede", Kreis.EL_SUED, "48488 Emsbüren, Narzissenstraße 25", "7.304672321288121,52.39640936688826"));
        emsLandSued.add(new Spielort("Lingen (VfB)", Kreis.EL_SUED, "49809 Lingen, Haselünner Str. 150", "7.345580217589899,52.538178480059806"));
        emsLandSued.add(new Spielort("Lingen (TUS)", Kreis.EL_SUED, "49808 Lingen, Teichstrasse 14", "7.30661403478379,52.51976066216895"));
        emsLandSued.add(new Spielort("Listrup", Kreis.EL_SUED, "48488 Emsbüren, Zum Sportplatz 1", "7.361512474721882,52.371652731561156"));
        emsLandSued.add(new Spielort("Lünne", Kreis.EL_SUED, "48480 Lünne, Am Sportplatz", "7.430846958064282,52.430447170930854"));
        emsLandSued.add(new Spielort("Messingen", Kreis.EL_SUED, "49832 Messingen, Baccumer Weg 6", "7.444574982663816,52.47127801342877"));
        emsLandSued.add(new Spielort("Salzbergen", Kreis.EL_SUED, "48499 Salzbergen, Ahlder Damm 16", "7.329117115268645,52.328377620404034"));
        emsLandSued.add(new Spielort("Schapen", Kreis.EL_SUED, "48480 Schapen, Hörstraße 4", "7.5458748288295805,52.40377792885941"));
        emsLandSued.add(new Spielort("Schepsdorf", Kreis.EL_SUED, "49808 Lingen, Nordlohner Str. 38", "7.288247607881693,52.51361589487553"));
        emsLandSued.add(new Spielort("Spelle-Venahus", Kreis.EL_SUED, "48480 Spelle, Venhauser Str.", "7.457862746777510552.36477728159774"));
        emsLandSued.add(new Spielort("Thuine", Kreis.EL_SUED, "49832 Thuine, Hubert-Klockenbusch-Str. 1", "7.480542067400183,52.50088244655753"));
        emsLandSued.add(new Spielort("Varenrode", Kreis.EL_SUED, "48480 Spelle, Bönnestr. 12", "7.433161403705304,52.38437850383018"));
        emsLandSued.add(new Spielort("Wettrup", Kreis.EL_SUED, "49838 Wettrup, Luisenweg 10", "7.606216898086005,52.583822919137134"));
        return emsLandSued;
    }

    private List<Spielort> grafschaft() {
        List<Spielort> grafschaft = new ArrayList<>();
        grafschaft.add(new Spielort("Nordhorn (AP & Blanke)", Kreis.GRAFSCHAFT, "48529 Nordhorn, Westfalenstr. 28", "7.0756370869931215,52.417363364230155"));
        grafschaft.add(new Spielort("Nordhorn (Sparta)", Kreis.GRAFSCHAFT, "48527 Nordhorn, Querstr. 5", "7.058481433019157,52.4467915679573"));
        grafschaft.add(new Spielort("Nordhorn (Alemannia & Eintracht)", Kreis.GRAFSCHAFT, "48529 Nordhorn, Heideweg 18", "7.079400138562454,52.417227339035854"));
        grafschaft.add(new Spielort("Nordhorn (Vorwärts)", Kreis.GRAFSCHAFT, "48531 Nordhorn, Immenweg 93", "7.1126321906897445,52.43669225331825"));
        grafschaft.add(new Spielort("Nordhorn (WE)", Kreis.GRAFSCHAFT, "48527 Nordhorn, Ootmarsumer Weg 155", "7.039004626916995,52.426306398081884"));
        grafschaft.add(new Spielort("Wielen", Kreis.GRAFSCHAFT, "49847 Wielen, Am Sportplatz 4", "6.727665227477308,52.527433442784655"));
        grafschaft.add(new Spielort("Bookholt", Kreis.GRAFSCHAFT, "48527 Nordhorn, Berglandstr. 10", "7.052730136715675,52.46229814417775"));
        grafschaft.add(new Spielort("Hohenkörben", Kreis.GRAFSCHAFT, "49828 Osterwald, Schulstr. 37", "7.010454951501856,52.5307534484149"));
        grafschaft.add(new Spielort("Neuenhaus (Borussia)", Kreis.GRAFSCHAFT, "49828 Neuenhaus, Prinzenstr. 50", "6.969638463703903,52.49049956698973"));
        grafschaft.add(new Spielort("Schüttorf (FC 09)", Kreis.GRAFSCHAFT, "48465 Schüttorf, Salzberger Str. 80", "7.24188940972437,52.32381924154121"));
        grafschaft.add(new Spielort("Schüttorf (SC)", Kreis.GRAFSCHAFT, "48465 Schüttorf, Jahnstr. 3", "7.215865353901467,52.321125131816764"));
        grafschaft.add(new Spielort("Hilten-Lemke", Kreis.GRAFSCHAFT, "49828 Neuenhaus, Uelsener Str. 63", "6.946077372944145,52.4959140862448"));
        grafschaft.add(new Spielort("Füchtenfeld", Kreis.GRAFSCHAFT, "49835 Wietmarschen, Reichenberger Str.", "7.115792497809845,52.55821504475328"));
        grafschaft.add(new Spielort("Ringe-Neugnadenfeld", Kreis.GRAFSCHAFT, "49824 Ringe, Emlichheimer Str. 51", "6.914589236162062,52.60130161871849"));
        grafschaft.add(new Spielort("Hesepe (Grafschaft)", Kreis.GRAFSCHAFT, "48531 Nordhorn, Dorfkrugstr. 10", "7.111514511575064,52.418165509874356"));
        grafschaft.add(new Spielort("Wilsum", Kreis.GRAFSCHAFT, "49849 Wilsum, Echtelerstr. 8", "6.832449949900284,52.540701749504926"));
        grafschaft.add(new Spielort("Emlichheim", Kreis.GRAFSCHAFT, "49824 Emlichheim, Berliner Str. 50", "6.845806690137376,52.6174731567492"));
        grafschaft.add(new Spielort("Bad Bentheim (SV)", Kreis.GRAFSCHAFT, "48455 Bad Bentheim, Gutenbergstr. 6", "7.165262818230672,52.296318041132565"));
        grafschaft.add(new Spielort("Bad Bentheim (SG)", Kreis.GRAFSCHAFT, "48455 Bad Bentheim, Brookdiek 2", "7.069282913977129,52.295487459455245"));
        grafschaft.add(new Spielort("Haftenkamp", Kreis.GRAFSCHAFT, "49843 Gölenkamp, Uelsener Str. 22", "6.9358257115784525,52.538812695149915"));
        grafschaft.add(new Spielort("Brandlecht-Hestrup", Kreis.GRAFSCHAFT, "48531 Nordhorn, Schüttorfer Str. 16", "7.119414325067996,52.390399041059915"));
        grafschaft.add(new Spielort("Quendorf", Kreis.GRAFSCHAFT, "48465 Quendorf, Schulstr. 13", "7.18990446978421,52.33918632890049"));
        grafschaft.add(new Spielort("Esche", Kreis.GRAFSCHAFT, "49828 Esche, Hauptstr. 2", "6.966227279046905,52.53778984798221"));
        grafschaft.add(new Spielort("Laarwald", Kreis.GRAFSCHAFT, "49824 Laar, Coevordener Str.", "6.7789767982525095,52.627027423584195"));
        grafschaft.add(new Spielort("Hoogstede", Kreis.GRAFSCHAFT, "49846 Hoogstede, Bathorner Diek 10", "6.951573832465472,52.58112238415325"));
        grafschaft.add(new Spielort("Klausheide", Kreis.GRAFSCHAFT, "48531 Nordhorn, Heideschulstr. 3", "7.157396657627181,52.45882533977866"));
        grafschaft.add(new Spielort("Uelsen", Kreis.GRAFSCHAFT, "49843 Uelsen, Zum Waldbad 8", "6.888101007880869,52.485865847764764"));
        grafschaft.add(new Spielort("Lage", Kreis.GRAFSCHAFT, "49828 Lage, Am Sportplatz 2", "6.9646494906905945,52.467231392900345"));
        grafschaft.add(new Spielort("Suddendorf-Samern", Kreis.GRAFSCHAFT, "48465 Schüttorf, Schützenstr. 1", "7.2169330999260515,52.299203690707984"));
        grafschaft.add(new Spielort("Lohne (Grafschaft)", Kreis.GRAFSCHAFT, "49835 Wietmarschen, Jahnstr. 2", "7.23041307904576,52.49777269755529"));
        grafschaft.add(new Spielort("Veldhausen", Kreis.GRAFSCHAFT, "49828 Neuenhaus, Lingener Str. 28", "6.99784758071861,52.510504814650375"));
        grafschaft.add(new Spielort("Wietmarschen", Kreis.GRAFSCHAFT, "49835 Wietmarschen, Im Alten Dorf 2", "7.12548047664116,52.52729107040778"));
        grafschaft.add(new Spielort("Georgsdorf", Kreis.GRAFSCHAFT, "49828 Georgsdorf, Finkenstr. 20", "7.077945711579186,52.56660780096059"));
        grafschaft.add(new Spielort("Gildehaus", Kreis.GRAFSCHAFT, "48455 Bad Bentheim, Romberg 37", "7.105621660002632,52.30683333902507"));
        grafschaft.add(new Spielort("Frensdorf", Kreis.GRAFSCHAFT, "48527 Nordhorn, Resum 58", "7.036480288284365,52.440255761036696"));
        return grafschaft;
    }

    private List<Spielort> ostfriesland() {
        List<Spielort> ostfriesland = new ArrayList<>();
        return ostfriesland;
    }

    private List<Spielort> cloppenburg() {
        List<Spielort> cloppenburg = new ArrayList<>();
        return cloppenburg;
    }

    private List<Spielort> osnabrück() {
        List<Spielort> osna = new ArrayList<>();
        return osna;
    }
}
