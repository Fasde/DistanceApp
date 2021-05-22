package fasde.android.distanceapp.database;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                addSpielorte(vereine, SaveData.emsland());
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

            case "Vechta":
                addSpielorte(vereine, SaveData.vechta());
                break;
            case "Jade-Weser-Hunte":
                addSpielorte(vereine, SaveData.jadeWeserHunte());
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
        allPlaces.addAll(emsland());
        allPlaces.addAll(grafschaft());
        allPlaces.addAll(cloppenburg());
        allPlaces.addAll(osnabrück());
        allPlaces.addAll(ostfriesland());
        allPlaces.addAll(vechta());
        allPlaces.addAll(oldenburg());
        allPlaces.addAll(jadeWeserHunte());
        return allPlaces;
    }

    private List<Spielort> emsland() {
        List<Spielort> emsland = new ArrayList<>();
        emsland.add(new Spielort("Ahlen-Steinbild", Kreis.EL, "26892 Kluse, Ahornstraße 13", "7.33799,52.936597"));
        emsland.add(new Spielort("Aschendorf", Kreis.EL, "26871 Aschendorf, Emdenerstraße 36", "7.348024,53.057359"));
        emsland.add(new Spielort("Aschendorfermoor", Kreis.EL, "26871 Aschendorf, Glatzer Str. 13", "7.393241,53.040658"));
        emsland.add(new Spielort("Bockholte", Kreis.EL, "49757 Werlte, Westerkamp 16", "7.709623098553102,52.867880551195576"));
        emsland.add(new Spielort("Bockhorst", Kreis.EL, "26897 Bockhorst, Am Sportplatz 22", "7.573777069721588,53.03075242360356"));
        emsland.add(new Spielort("Breddenberg", Kreis.EL, "26897 Breddenberg, Wachtelweg 23", "7.602167240883786,52.95722415392781"));
        emsland.add(new Spielort("Brual", Kreis.EL, "26899 Rhede, Deichstraße 1", "7.285924085066736,53.09600808285782"));
        emsland.add(new Spielort("Börger", Kreis.EL, "26904 Börger, Waldstraße 58", "7.532610269718631,52.91921158161526"));
        emsland.add(new Spielort("Dersum", Kreis.EL, "26906 Dersum, Dorfstraße 38", "7.2334986427351025,52.96991853781075"));
        emsland.add(new Spielort("Dörpen", Kreis.EL, "26892 Doerpen, Am Sportpark 14", "7.31492051389897,52.959419265587904"));
        emsland.add(new Spielort("Eisten-Hüven", Kreis.EL, "49751 Hüven, Zum Kienmoor", "7.5516940562227814,52.79198865188816"));
        emsland.add(new Spielort("Esterwegen", Kreis.EL, "26897 Esterwegen, Am Sportpark 1", "7.629252796705594,52.99774659381847"));
        emsland.add(new Spielort("Fresenburg", Kreis.EL, "49762 Fresenburg, Juister Weg 4", "7.311566998553484,52.88290759122808"));
        emsland.add(new Spielort("Heede", Kreis.EL, "26892 Heede, Kirchstr. 22", "7.313765471571546,52.9906273436245"));
        emsland.add(new Spielort("Herbrum", Kreis.EL, "26871 Papenburg, Herzogstraße", "7.343091713900802,53.027265908514714"));
        emsland.add(new Spielort("Hilkenbrook", Kreis.EL, "26897 Hilkenbrook, Esterweger Weg 9", "7.702551640884508,52.98572205829264"));
        emsland.add(new Spielort("Lahn", Kreis.EL, "49757 Lahn, Rosenstraße 5", "7.607259869715776,52.812737044490774"));
        emsland.add(new Spielort("Langen (Lathen)", Kreis.EL, "49779 Niederlangen, Schulstraße 13", "7.2823528673304825,52.8533867555271"));
        emsland.add(new Spielort("Lathen", Kreis.EL, "49762 Lathen, Meppener Str. 25", "7.31835621944924,52.854573556842816"));
        emsland.add(new Spielort("Lathen-Wahn", Kreis.EL, "49762 Lathen, Wahner Str.", "7.367380282115088,52.86046466365477"));
        emsland.add(new Spielort("Lehe", Kreis.EL, "26892 Lehe, Neuleherstr.", "7.367107642735897,53.000359995468486"));
        emsland.add(new Spielort("Lorup", Kreis.EL, "26901 Lorup, Breddenberger Str. 18", "7.6353556427340346,52.930074021168906"));
        emsland.add(new Spielort("Neubörger", Kreis.EL, "26909 Neubörger, Deverweg 4", "7.449722371570389,52.94643516456423"));
        emsland.add(new Spielort("Neulangen", Kreis.EL, "49779 Niederlangen, Kastanienstraße 2", "7.179830356224872,52.86946958194129"));
        emsland.add(new Spielort("Neulehe", Kreis.EL, "26909 Neulehe, Waldstraße 3", "7.412731219453298,53.00700721591959"));
        emsland.add(new Spielort("Ostenwalde", Kreis.EL, "49757 Werlte, Dorfanger 16", "7.5918490231508535,52.84012970004131"));
        emsland.add(new Spielort("Papenburg (Eintracht)", Kreis.EL, "26871 Papenburg, Splitting links 198", "7.467729869721894,53.04152434079038"));
        emsland.add(new Spielort("Papenburg (Germania)", Kreis.EL, "26871 Papenburg, Kleiststrasse 14", "7.400805569722727,53.073580595427664"));
        emsland.add(new Spielort("Papenburg (BW 94)", Kreis.EL, "26871 Papenburg, Hans-Nolte-Str. 1", "7.440909705304785,53.07236707860145"));
        emsland.add(new Spielort("Rastdorf", Kreis.EL, "26901 Rastdorf, Am Sportplatz", "7.702604312046728,52.91411809009867"));
        emsland.add(new Spielort("Renkenberge", Kreis.EL, "49762 Renkenberge, Wahner Str.", "7.387924910195427,52.90046707317617"));
        emsland.add(new Spielort("Rhede", Kreis.EL, "26899 Rhede, Kold'n Hauk", "7.275024356229915,53.058714168095946"));
        emsland.add(new Spielort("Spahnharrenstätte", Kreis.EL, "49751 Spahnharrenstätte, Am Sportplatz", "7.6032312912579485,52.87131283757716"));
        emsland.add(new Spielort("Surwold", Kreis.EL, "26903 Surwold, Lindenstraße 15", "7.549277386915503,53.01200399969324"));
        emsland.add(new Spielort("Sögel", Kreis.EL, "49751 Sögel, Loruper Weg 9", "7.526515034792438,52.846256534464686"));
        emsland.add(new Spielort("Vrees", Kreis.EL, "49757 Vrees, Herzog-Arenberg-Str. 24", "7.776545240346733,52.892266981564845"));
        emsland.add(new Spielort("Walchum-Hasselbrock", Kreis.EL, "26907 Walchum, Im Tannensand 4", "7.274926273420974,52.93128745513596"));
        emsland.add(new Spielort("Wehm", Kreis.EL, "49757 Werlte, Am Schützenplatz 2", "7.664474778971413,52.83274906058898"));
        emsland.add(new Spielort("Werlte", Kreis.EL, "49757 Werlte, Sögeler Str. 3", "7.671085494315266,52.84957474065507"));
        emsland.add(new Spielort("Werpeloh", Kreis.EL, "49751 Werpeloh, Wippinger Str. 20", "7.5023195691821485,52.87537011596646"));
        emsland.add(new Spielort("Wippingen", Kreis.EL, "26892 Wippingen, Am Sportplatz", "7.400899754375131,52.919032226516514"));
        emsland.add(new Spielort("Adorf", Kreis.EL, "49767 Twist, Am Fuchsbau 7", "7.083195086904831,52.60785510769239"));
        emsland.add(new Spielort("Ahmsen", Kreis.EL, "49774 Lähden, Am Sportplatz 26", "7.684568244580802,52.76859830184927"));
        emsland.add(new Spielort("Apeldorn", Kreis.EL, "49716 Apeldorn, Am Sportplatz", "7.394284713893188,52.74128344683675"));
        emsland.add(new Spielort("Berßen", Kreis.EL, "49774 Klein Berßen, Schützenstraße 10", "7.470840813358547,52.76710210061195"));
        emsland.add(new Spielort("Bokeloh", Kreis.EL, "49716 Meppen, Kiefernstr. 8", "7.3563054212962635,52.70471410309691"));
        emsland.add(new Spielort("CCI (Emslage)", Kreis.EL, "49716 Meppen, Lohberg 10", "7.23965091335636,52.68346285627125"));
        emsland.add(new Spielort("Dalum", Kreis.EL, "49744 Geeste, Zum Sportzentrum", "7.217604571561095,52.59540427383116"));
        emsland.add(new Spielort("Dohren", Kreis.EL, "49770 Dohren, Am Sportplatz 3", "7.589621655683776,52.650762757671245"));
        emsland.add(new Spielort("Eltern", Kreis.EL, "49740 Haselünne, Georg-Bernd-Straße 30", "7.508046142192287,52.68708133013472"));
        emsland.add(new Spielort("Emmeln", Kreis.EL, "49733 Haren (Ems), Hanfeldstraße 6", "7.28411207658378,52.78431798277266"));
        emsland.add(new Spielort("Erika-Altenberge", Kreis.EL, "49733 Haren (Ems), Tengestraße", "7.139851842207125,52.82503741156239"));
        emsland.add(new Spielort("Fehndorf", Kreis.EL, "49733 Haren (Ems), Am Vollmond", "7.114901926945686,52.78175940530789"));
        emsland.add(new Spielort("Flechum", Kreis.EL, "49740 Haselünne, Am Sandpool", "7.554074512041285,52.70718268815405"));
        emsland.add(new Spielort("Fullen", Kreis.EL, "49716 Meppen, Heidkampstr. 2", "7.224594978967772,52.695369549748456"));
        emsland.add(new Spielort("Geeste", Kreis.EL, "49744 Geeste, Gusbergstr. 27", "7.274443645892262,52.60905666315705"));
        emsland.add(new Spielort("Groß Hesepe", Kreis.EL, "49744 Geeste, Ludgeristr.", "7.2350039697107995,52.62472894793585"));
        emsland.add(new Spielort("Haren", Kreis.EL, "49733 Haren (Ems), Am Brookdeich", "7.231606182296234,52.78605080382686"));
        emsland.add(new Spielort("Haselünne", Kreis.EL, "49734 Haselünne, Lingener Str. 29", "7.4811695482801,52.66707007390266"));
        emsland.add(new Spielort("Hebelermeer", Kreis.EL, "49767 Twist, Hebelermeer 8", "7.097046655686261,52.74588080594238"));
        emsland.add(new Spielort("Hemsen", Kreis.EL, "49716 Meppen, Kreuzweg", "7.282098431302837,52.736387455993395"));
        emsland.add(new Spielort("Herssum", Kreis.EL, "49774 Lähden, Zum Sportplatz", "7.647422740878459,52.757125550059286"));
        emsland.add(new Spielort("Herzlake", Kreis.EL, "49770 Herzlake, Im Mersch", "7.612304298548158,52.68008631121612"));
        emsland.add(new Spielort("Holte", Kreis.EL, "49774 Lähden, Clemenskoppel 5", "7.615982913893122,52.736940924599324"));
        emsland.add(new Spielort("Hülsen-Westerloh", Kreis.EL, "49740 Haselünne, Am Sportplatz 2", "7.477429813892387,52.71026538091512"));
        emsland.add(new Spielort("Lähden", Kreis.EL, "49774 Lähden, Jahnstraße 21", "7.570568554370675,52.74841485548877"));
        emsland.add(new Spielort("Landegge", Kreis.EL, "49733 Haren (Ems), Landegge-Dorf", "7.249182272608037,52.81978691971132"));
        emsland.add(new Spielort("Lehrte", Kreis.EL, "49740 Haselünne, Schulstraße 13", "7.4004379120404025,52.673536000889406"));
        emsland.add(new Spielort("Meppen (SV)", Kreis.EL, "49716 Meppen, Lathener Str.", "7.295238958085432,52.70862168393778"));
        emsland.add(new Spielort("Meppen (Union)", Kreis.EL, "49716 Meppen, Versener Str. 69", "7.258190934788713,52.704230405042296"));
        emsland.add(new Spielort("Neuringe", Kreis.EL, "49767 Twist, Neuringe", "7.023619744577204,52.63243353549059"));
        emsland.add(new Spielort("Osterbrock", Kreis.EL, "49744 Geeste, Rosenstraße 9", "7.319684871561299,52.60304124770368"));
        emsland.add(new Spielort("Polle", Kreis.EL, "49740 Haselünne, Schützenstr.", "7.519424940875655,52.651633660406965"));
        emsland.add(new Spielort("Rütenbrock", Kreis.EL, "49733 Haren (Ems), An der Mühle 12", "7.1054367820282565,52.835022818948005"));
        emsland.add(new Spielort("Schleper", Kreis.EL, "49740 Haselünne, Neuer Kamp", "7.432854240876526,52.685133855326434"));
        emsland.add(new Spielort("Schwefingen", Kreis.EL, "49716 Meppen, Landwehr 112", "7.286551340876225,52.67266815454803"));
        emsland.add(new Spielort("Schöningsdorf", Kreis.EL, "49767 Twist, Bürgermeister-Brüning-Str.", "7.0935571255337235,52.70784859049012"));
        emsland.add(new Spielort("Stavern", Kreis.EL, "49777 Stavern, Am Neuen Grund 11", "7.4209506562225425,52.78172166747211"));
        emsland.add(new Spielort("Teglingen", Kreis.EL, "49716 Meppen, Teglinger Hauptstraße 2a", "7.318179456455058,52.65973996403955"));
        emsland.add(new Spielort("Tinnen", Kreis.EL, "49733 Haren (Ems), Lohkamp", "7.326286281435998,52.797883150480864"));
        emsland.add(new Spielort("Twist (Germania)", Kreis.EL, "49767 Twist, Hesper Str. 15", "7.103243321294361,52.63276625756669"));
        emsland.add(new Spielort("Twist (Grenzland)", Kreis.EL, "49767 Twist, Am Brook 30", "7.054155063622673,52.633269128512175"));
        emsland.add(new Spielort("Versen (JVA)", Kreis.EL, "49716 Meppen, Grünfeldstr. 1", "7.185816644044201,52.72134796036134"));
        emsland.add(new Spielort("Wesuwe", Kreis.EL, "49733 Haren (Ems), Am Sportplatz", "7.206858422863424,52.75957353022217"));
        emsland.add(new Spielort("Altenlingen", Kreis.EL, "49808 Lingen, Wallkamp 11", "7.2981663292314565,52.54440173345177"));
        emsland.add(new Spielort("Andervenne", Kreis.EL, "49832 Andervenne, Schulstraße 6", "7.57306138505122,52.509974757050784"));
        emsland.add(new Spielort("Baccum", Kreis.EL, "49811 Lingen, Alte Dorfstr. 26", "7.398121117053896,52.512983108677595"));
        emsland.add(new Spielort("Bawinkel", Kreis.EL, "49844 Bawinkel, Am Sportplatz 2", "7.403302082667248,52.59988797613077"));
        emsland.add(new Spielort("Beesten", Kreis.EL, "49832 Beesten, Stadionstraße", "7.51496735563097352.42826646723915"));
        emsland.add(new Spielort("Bramhar", Kreis.EL, "49744 Geeste, Dorfstraße 8", "7.366579492457729,52.60340384646298"));
        emsland.add(new Spielort("Bramsche", Kreis.EL, "49811 Lingen, Bramscher Str. 12", "7.3658085850498844,52.45857250403054"));
        emsland.add(new Spielort("Brögbern", Kreis.EL, "49811 Lingen, Jasminstr. 13", "7.364168928696369,52.55442770692236"));
        emsland.add(new Spielort("Clusorth", Kreis.EL, "49811 Lingen, Bawinkeler Str. 1", "7.3680277458916645,52.58567313025702"));
        emsland.add(new Spielort("Darme", Kreis.EL, "48909 Lingen, Kiesbahn 24A", "7.315566051443786,52.50004900982575"));
        emsland.add(new Spielort("Emsbüren", Kreis.EL, "48488 Emsbüren, Hanwische Str. 12", "7.290692432929555,52.39730744376584"));
        emsland.add(new Spielort("Freren", Kreis.EL, "49832 Freren, Zu den Hünensteinen 13", "7.497940045889494,52.503532133951055"));
        emsland.add(new Spielort("Gersten", Kreis.EL, "49838 Gersten, Bregenbecker Str. 7", "7.489824757532715,52.57294314826056"));
        emsland.add(new Spielort("Holthausen-Biene", Kreis.EL, "49808 Geeste, Zum Biener Busch", "7.264917382041456,52.56813970190016"));
        emsland.add(new Spielort("Langen (Lengerich)", Kreis.EL, "49838 Langen, Bawinkeler Str. 4", "7.464827532933364,52.54078305854636"));
        emsland.add(new Spielort("Laxten", Kreis.EL, "49809 Lingen, Diekstr. 1", "7.346643621291532,52.52391723496651"));
        emsland.add(new Spielort("Lengerich-Handrup", Kreis.EL, "49838 Lengerich, Schulstr. 21", "7.534413117590138,52.54931003147139"));
        emsland.add(new Spielort("Leschede", Kreis.EL, "48488 Emsbüren, Narzissenstraße 25", "7.304672321288121,52.39640936688826"));
        emsland.add(new Spielort("Lingen (VfB)", Kreis.EL, "49809 Lingen, Haselünner Str. 150", "7.345580217589899,52.538178480059806"));
        emsland.add(new Spielort("Lingen (TUS)", Kreis.EL, "49808 Lingen, Teichstrasse 14", "7.30661403478379,52.51976066216895"));
        emsland.add(new Spielort("Listrup", Kreis.EL, "48488 Emsbüren, Zum Sportplatz 1", "7.361512474721882,52.371652731561156"));
        emsland.add(new Spielort("Lünne", Kreis.EL, "48480 Lünne, Am Sportplatz", "7.430846958064282,52.430447170930854"));
        emsland.add(new Spielort("Messingen", Kreis.EL, "49832 Messingen, Baccumer Weg 6", "7.444574982663816,52.47127801342877"));
        emsland.add(new Spielort("Salzbergen", Kreis.EL, "48499 Salzbergen, Ahlder Damm 16", "7.329117115268645,52.328377620404034"));
        emsland.add(new Spielort("Schapen", Kreis.EL, "48480 Schapen, Hörstraße 4", "7.5458748288295805,52.40377792885941"));
        emsland.add(new Spielort("Schepsdorf", Kreis.EL, "49808 Lingen, Nordlohner Str. 38", "7.288247607881693,52.51361589487553"));
        emsland.add(new Spielort("Spelle-Venahus", Kreis.EL, "48480 Spelle, Venhauser Str.", "7.457862746777510552.36477728159774"));
        emsland.add(new Spielort("Thuine", Kreis.EL, "49832 Thuine, Hubert-Klockenbusch-Str. 1", "7.480542067400183,52.50088244655753"));
        emsland.add(new Spielort("Varenrode", Kreis.EL, "48480 Spelle, Bönnestr. 12", "7.433161403705304,52.38437850383018"));
        emsland.add(new Spielort("Wettrup", Kreis.EL, "49838 Wettrup, Luisenweg 10", "7.606216898086005,52.583822919137134"));
        return emsland;
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
        ostfriesland.add(new Spielort("Emden (Kickers)", Kreis.OSTFRIESLAND, "26721 Emden, Sielweg 10", "7.203431245206649,53.3793514405874"));
        ostfriesland.add(new Spielort("Bentstreek", Kreis.OSTFRIESLAND, "26446 Friedeburg, Weg am Cu", "7.832095718678773,53.385669513220854"));
        ostfriesland.add(new Spielort("Bingum", Kreis.OSTFRIESLAND, "26789 Leer, Ziegeleistraße 17", "7.41314645438321,53.22102275885067"));
        ostfriesland.add(new Spielort("Burhafe", Kreis.OSTFRIESLAND, "26409 Wittmund, Am Sportplatz", "7.709551223706385,53.59711332136409"));
        ostfriesland.add(new Spielort("Wiegboldsbur", Kreis.OSTFRIESLAND, "26624 Südbrookmerland, 1.Bauckerweg 5", "7.354077812061099,53.45221414809768"));
        ostfriesland.add(new Spielort("Emden (Eintracht)", Kreis.OSTFRIESLAND, "26725 Emden, Pillauer Str. 12", "7.2229182850739795,53.366733314334795"));
        ostfriesland.add(new Spielort("Brookmerland", Kreis.OSTFRIESLAND, "26529 Upgant-Schott, Sebastianstraße 46", "7.2677281604623065,53.51950007508901"));
        ostfriesland.add(new Spielort("Eilsum-Krummhörn", Kreis.OSTFRIESLAND, "26736 Krummhörn, Im Spiekerbohr", "7.143966734779644,53.47423191153313"));
        ostfriesland.add(new Spielort("Emden (Frisia)", Kreis.OSTFRIESLAND, "26723 Emden, Dortmunder Straße 50", "7.191811360634431,53.3575829681094"));
        ostfriesland.add(new Spielort("Neuharlingersiel", Kreis.OSTFRIESLAND, "26427 Neuharlingersiel, Wirrenburg 15", "7.715975170087668,53.696906920389296"));
        ostfriesland.add(new Spielort("Völlenerkönigsfehn", Kreis.OSTFRIESLAND, "26810 Völlenerkönigsfehn, Papenburger Straße 273", "7.4538360770943175,53.1015720824551"));
        ostfriesland.add(new Spielort("Pilsum", Kreis.OSTFRIESLAND, "26736 Krummhörn, Slöter Straße 2", "7.059631386149006,53.47586228931547"));
        ostfriesland.add(new Spielort("Leer (Kickers)", Kreis.OSTFRIESLAND, "26789 Leer, Turnerweg 11", "7.454563529249666,53.231968200320864"));
        ostfriesland.add(new Spielort("Nesse", Kreis.OSTFRIESLAND, "26553 Dornum, Sielstraße 3", "7.377687407613688,53.65400750832603"));
        ostfriesland.add(new Spielort("Norden", Kreis.OSTFRIESLAND, "26506 Norden, Kastanienallee 3", "7.196612085080308,53.60277427541268"));
        ostfriesland.add(new Spielort("Oldersum", Kreis.OSTFRIESLAND, "26802 Moormerland, Kreuzweg 9", "7.336248744595878,53.33599576646478"));
        ostfriesland.add(new Spielort("Völlenerfehn", Kreis.OSTFRIESLAND, "26810 Westoverledingen, Am Sportplatz 24", "7.421696965486146,53.10351439281683"));
        ostfriesland.add(new Spielort("Loquard", Kreis.OSTFRIESLAND, "26736 Krummhörn, An der Landstraße 1", "7.045788877079615,53.38802069595686"));
        ostfriesland.add(new Spielort("Südbrookmerland", Kreis.OSTFRIESLAND, "26624 Südbrookmerland, Koppelweg", "7.35998456719458,53.49030300444401"));
        ostfriesland.add(new Spielort("Berumerfehn", Kreis.OSTFRIESLAND, "26532 Großheide, Am Berumerfehnkanal 17A", "7.324030180477534,53.568506959614865"));
        ostfriesland.add(new Spielort("Emden (FT 03)", Kreis.OSTFRIESLAND, "26725 Emden, Petkumer Straße 83", "7.2186079216198635,53.359863702845395"));
        ostfriesland.add(new Spielort("Groß Midlum", Kreis.OSTFRIESLAND, "26759 Hinte, Am Horst", "7.155418886754306,53.411431150340974"));
        ostfriesland.add(new Spielort("Hollen", Kreis.OSTFRIESLAND, "26670 Uplengen, Dardenkampsweg 3", "7.701748512055823,53.25420492855259"));
        ostfriesland.add(new Spielort("Firrel", Kreis.OSTFRIESLAND, "26835 Firrel, Ringstraße 8", "7.664110542744698,53.33044259611183"));
        ostfriesland.add(new Spielort("Heidje", Kreis.OSTFRIESLAND, "268626 Weener, Schulweg 1", "7.297188517605488,53.12864518037617"));
        ostfriesland.add(new Spielort("Holte", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, Franzosenweg", "7.570063214050277,53.16879796703641"));
        ostfriesland.add(new Spielort("Krummhörn", Kreis.OSTFRIESLAND, "26736 Krummhörn, Olympiastraße 1", "7.094243413195109,53.43972726063712"));
        ostfriesland.add(new Spielort("Upgant-Schott", Kreis.OSTFRIESLAND, "26529 Upgant-Schott, Sebastianstraße 46", "7.26812852131795,53.51946268949086"));
        ostfriesland.add(new Spielort("Harlingerland", Kreis.OSTFRIESLAND, "26409 Wittmund, Am Sportplatz", "7.709966927408452,53.598159452661044"));
        ostfriesland.add(new Spielort("Aurich (JFV)", Kreis.OSTFRIESLAND, "26607 Aurich, Wallster Loog 77", "7.450076149132221,53.47878263385654"));
        ostfriesland.add(new Spielort("Ditzum", Kreis.OSTFRIESLAND, "26844 Jemgum, An't Stauwark 15", "7.276757642744263,53.31169317061047"));
        ostfriesland.add(new Spielort("Emden (RSV)", Kreis.OSTFRIESLAND, "26723 Emden, Normannenstraße 18", "7.193040098566467,53.37117800279514"));
        ostfriesland.add(new Spielort("Visquard", Kreis.OSTFRIESLAND, "26723 Krummhörn, Lindenweg 2", "7.11083009856902,53.46493365970925"));
        ostfriesland.add(new Spielort("Wiesens", Kreis.OSTFRIESLAND, "26605 Aurich, Moorackerweg 22", "7.564968683225262,53.45355874500685"));
        ostfriesland.add(new Spielort("Dunum", Kreis.OSTFRIESLAND, "26427 Dunum Süddunumer Weg 15", "7.647618744602766,53.59319186367458"));
        ostfriesland.add(new Spielort("Leer (SC)", Kreis.OSTFRIESLAND, "26789 Leer, An den Gärten 10", "7.436166354383595,53.23598850854621"));
        ostfriesland.add(new Spielort("Rhauderfehn", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, Buchweizenkamp", "7.578845654417607,53.10922358971879"));
        ostfriesland.add(new Spielort("Tannenhausen", Kreis.OSTFRIESLAND, "26607 Aurich, Am Stadion 18", "7.471018942749753,53.518502275589576"));
        ostfriesland.add(new Spielort("Möhlenwarf", Kreis.OSTFRIESLAND, "268626 Weener, Parkstraße 14", "7.306095829248144,53.1740657028082"));
        ostfriesland.add(new Spielort("Egels-Popens", Kreis.OSTFRIESLAND, "26605 Aurich, Burenweg", "7.528524615763526,53.4666069478689"));
        ostfriesland.add(new Spielort("Freepsum", Kreis.OSTFRIESLAND, "26736 Krummhörn, Am Stieltief 11", "7.147454100418909,53.42349705894013"));
        ostfriesland.add(new Spielort("Varel", Kreis.OSTFRIESLAND, "26316 Varel, Herrenkampsweg", "8.117428779359619,be53.40361904186254"));
        ostfriesland.add(new Spielort("Upleward", Kreis.OSTFRIESLAND, "26736 Krummhörn, Sportplatzweg 7", "7.0480962543885735,53.42249601292664"));
        ostfriesland.add(new Spielort("Warsingsfehn", Kreis.OSTFRIESLAND, "26802 Moormerland, Siebrandstraße 25A", "7.492608423163427,53.312541259517246"));
        ostfriesland.add(new Spielort("Süderneuland", Kreis.OSTFRIESLAND, "26506 Norden, Wurzeldeicher Straße", "7.216089163647864,53.579425457245975"));
        ostfriesland.add(new Spielort("Emden (SUS)", Kreis.OSTFRIESLAND, "26725 Emden, Heilsberger Straße 37A", "7.225915261780153,53.366855994257264"));
        ostfriesland.add(new Spielort("Norddeich", Kreis.OSTFRIESLAND, "26506 Norden, Nordmeerstraße", "53.61505354875924, 7.16271580967913"));
        ostfriesland.add(new Spielort("Strackholt", Kreis.OSTFRIESLAND, "26629 Großefehn, Sandackersweg 4", "7.644446093508561,53.36795444833388"));
        ostfriesland.add(new Spielort("Timmel", Kreis.OSTFRIESLAND, "26629 Großefehn, Süderfenne 2", "7.5347929654930965,53.361874615481774"));
        ostfriesland.add(new Spielort("Wolthusen", Kreis.OSTFRIESLAND, "26725 Emden, Folkmar-Allena-Straße 13", "7.232896715761124,53.376096083152056"));
        ostfriesland.add(new Spielort("Ardorf", Kreis.OSTFRIESLAND, "26409 Wittmund, Heglitzer Straße 22", "7.690655298035765,53.54233806324277"));
        ostfriesland.add(new Spielort("Arle-Westerende", Kreis.OSTFRIESLAND, "26532 Großheide, Arler Straße 49", "7.395512120850582,53.605759881700266"));
        ostfriesland.add(new Spielort("Blomberg-Neuschoo", Kreis.OSTFRIESLAND, "26487 Blomberg, Hauptstraße 36", "7.559980015766411,53.57423644467"));
        ostfriesland.add(new Spielort("Leer (Borussia)", Kreis.OSTFRIESLAND, "26789 Leer, Bahndamm 33", "7.463372540891481,53.24670485754603"));
        ostfriesland.add(new Spielort("Burlage", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, Landesstraße", "7.563464599873939,53.06110833276203"));
        ostfriesland.add(new Spielort("Borssum", Kreis.OSTFRIESLAND, "26725 Emden, Wykhoffweg 26", "7.228620653958493,53.3464709200986"));
        ostfriesland.add(new Spielort("Filsum", Kreis.OSTFRIESLAND, "26849 Filsum, Osterende 19", "7.624129134515973,53.242350928751335"));
        ostfriesland.add(new Spielort("Ihrhove", Kreis.OSTFRIESLAND, "26810 Westoverledingen, Christiane-Schröter-Straße 9", "7.455600163636612,53.159416077415905"));
        ostfriesland.add(new Spielort("Neermoor", Kreis.OSTFRIESLAND, "26802 Moormerland, Wilhelmstraße 2", "7.438974348297182,53.3085467965719"));
        ostfriesland.add(new Spielort("Suurhusen", Kreis.OSTFRIESLAND, "26759 Hinte, Tütelborger Weg", "7.220526471805392,53.412111587624636"));
        ostfriesland.add(new Spielort("Dornum", Kreis.OSTFRIESLAND, "26553 Dornum, Am Sportplatz 6", "7.435467532962881,53.64997229003011"));
        ostfriesland.add(new Spielort("Ostrhauderfehn", Kreis.OSTFRIESLAND, "26842 Ostrhauderfehn, 1.Südwieke 120", "7.613274590620589,53.126047659115784"));
        ostfriesland.add(new Spielort("Ihlow", Kreis.OSTFRIESLAND, "26632 Ihlow, Am Wendeplatz", "7.441654826868128,53.41015860917614"));
        ostfriesland.add(new Spielort("Nüttermoor", Kreis.OSTFRIESLAND, "26789 Leer, An der Trah 3", "7.434416428333459,53.2612857606263"));
        ostfriesland.add(new Spielort("Plaggenburg", Kreis.OSTFRIESLAND, "26607 Aurich, Eintrachtweg", "7.545664546451406,53.50535948016116"));
        ostfriesland.add(new Spielort("Ems-Jemgum", Kreis.OSTFRIESLAND, "26844 Jemgum, Am Sportzentrum 8", "7.3891253041169564,53.27416431717247"));
        ostfriesland.add(new Spielort("Engerhafe", Kreis.OSTFRIESLAND, "26624 Südbrookmerland, Dodentwenter 18", "7.3128353632890235,53.490379147389"));
        ostfriesland.add(new Spielort("Wirdum", Kreis.OSTFRIESLAND, "26529 Wirdum, Marienhafer Straße 9", "7.2105047506084246,53.48052038876579"));
        ostfriesland.add(new Spielort("Ihren", Kreis.OSTFRIESLAND, "26810 Westoverledingen, Patersweg-Süd 51", "7.483412885777901,53.15051174276006"));
        ostfriesland.add(new Spielort("Wybelsum", Kreis.OSTFRIESLAND, "26723 Emden, Kloster-Langen-Straße 3", "7.105958540894336,53.35229086752717"));
        ostfriesland.add(new Spielort("Brinkum", Kreis.OSTFRIESLAND, "26835 Brinkum, Burgring 1", "7.5644702408921285,53.27083887442725"));
        ostfriesland.add(new Spielort("Loga", Kreis.OSTFRIESLAND, "26789 Leer, Auf den Truben 16", "7.486322317608618,53.24493674219434"));
        ostfriesland.add(new Spielort("Fulkum", Kreis.OSTFRIESLAND, "26427 Holtgast, Am Bahnsteig 26", "7.528553131120092,53.63249774286193"));
        ostfriesland.add(new Spielort("Georgsheil", Kreis.OSTFRIESLAND, "26624 Südbrookmerland, Georgsheiler Weg 36", "7.3269117464507625,53.47868798938701"));
        ostfriesland.add(new Spielort("Großefehn", Kreis.OSTFRIESLAND, "26629 Großefehn, Voßkuhlerstraße 3", "7.6071063022694165,53.40529501616104"));
        ostfriesland.add(new Spielort("Hage", Kreis.OSTFRIESLAND, "26524 Hage, Am Edenhof 3", "7.288016296721674,53.60021668006046"));
        ostfriesland.add(new Spielort("Hinrichsfehn", Kreis.OSTFRIESLAND, "26639 Wiesmoor, Oldenburger Straße 212", "7.749541186925375,53.381105576425036"));
        ostfriesland.add(new Spielort("Holtland", Kreis.OSTFRIESLAND, "26835 Holtland, Schwalbenweg 2", "7.57348578507186,53.288529656123295"));
        ostfriesland.add(new Spielort("Jennelt-Uttum", Kreis.OSTFRIESLAND, "26736 Krummhörn, Ringstraße 1", "7.156367988778294,53.45165209228469"));
        ostfriesland.add(new Spielort("Walle", Kreis.OSTFRIESLAND, "26632 Ihlow, 1.Kompanieweg", "7.44093441391105,53.41123840186524"));
        ostfriesland.add(new Spielort("Leezdorf", Kreis.OSTFRIESLAND, "26529 Rechtsupweg, Schulstraße", "7.3217439923995284,53.52725307965578"));
        ostfriesland.add(new Spielort("Leybucht", Kreis.OSTFRIESLAND, "26506 Norden, Markstraße 11A", "7.147540827406252,53.515757394511034"));
        ostfriesland.add(new Spielort("Manslagt", Kreis.OSTFRIESLAND, "26736 Krummhörn, Am Sportplatz 2", "7.0719217139122685,53.45758714296643"));
        ostfriesland.add(new Spielort("Neufirrel", Kreis.OSTFRIESLAND, "26670 Uplengen, Neufirreler Straße 42", "7.694494796915068,53.34254782057213"));
        ostfriesland.add(new Spielort("Nortmoor", Kreis.OSTFRIESLAND, "26845 Nortmoor, Hasselter Heuweg 11", "7.558581883784941,53.250402985353055"));
        ostfriesland.add(new Spielort("Ochtersum", Kreis.OSTFRIESLAND, "26489 Ochtersum, Negenmeertener Straße 4", "7.528907184782319,53.6067688606816"));
        ostfriesland.add(new Spielort("Moordorf", Kreis.OSTFRIESLAND, "26624 Südbrookmerland, Waller Weg 9", "7.412820656241115,53.47727950218425"));
        ostfriesland.add(new Spielort("Petkum", Kreis.OSTFRIESLAND, "26725 Emden, Blumenstraße 28", "7.2670077120580565,53.338128916573694"));
        ostfriesland.add(new Spielort("Simonswolde", Kreis.OSTFRIESLAND, "26632 Ihlow, Zum Sportzentrum", "7.406960783223508,53.38702765885782"));
        ostfriesland.add(new Spielort("Spetzerfehn", Kreis.OSTFRIESLAND, "26629 Großefehn, Ülkeweg", "7.635310510208491,53.392412577930585"));
        ostfriesland.add(new Spielort("Larrelt", Kreis.OSTFRIESLAND, "26723 Emden, Wolfsburger Straße", "7.151430587192528,53.360763575249315"));
        ostfriesland.add(new Spielort("Schwerinsdorf", Kreis.OSTFRIESLAND, "26835 Schwerinsdorf, Oldendorfer Straße 34", "7.6605807274006965,53.3091204950112"));
        ostfriesland.add(new Spielort("Stikelkamp", Kreis.OSTFRIESLAND, "26835 Neukamperfehn, Hauptwieke 4", "7.556748464176774,53.33884277592577"));
        ostfriesland.add(new Spielort("Steenfelde", Kreis.OSTFRIESLAND, "26810 Westoverledingen, Wanderweg 33", "7.4354662366508215,53.12219587283639"));
        ostfriesland.add(new Spielort("Tergast", Kreis.OSTFRIESLAND, "26802 Moormerland, Sünnenblink 24", "7.366519029252461,53.33511031929363"));
        ostfriesland.add(new Spielort("Stapelmoor", Kreis.OSTFRIESLAND, "26826 Weener, Hauptstraße 113A", "7.319255953795926,53.12668973841405"));
        ostfriesland.add(new Spielort("Wallinghausen", Kreis.OSTFRIESLAND, "26605 Wallinghausen, Am Sportplatz 3", "7.519726184617476,53.47718479132739"));
        ostfriesland.add(new Spielort("Werdum", Kreis.OSTFRIESLAND, "26427 Werdum, Gastriege 31", "7.721027656245958,53.65847248004759"));
        ostfriesland.add(new Spielort("Wittmund", Kreis.OSTFRIESLAND, "26409 Wittmund, Isums 48", "7.789938627561797,53.56402385627723"));
        ostfriesland.add(new Spielort("Wymeer", Kreis.OSTFRIESLAND, "26831 Bunde, Sportplatzstraße 2", "7.227587700411031,53.12803774323498"));
        ostfriesland.add(new Spielort("Aurich (SVG)", Kreis.OSTFRIESLAND, "26603 Aurich, Am Ellernfeld 10", "7.479854371584162,53.46439468982951"));
        ostfriesland.add(new Spielort("Twixlum", Kreis.OSTFRIESLAND, "26723 Emden, Osterdieksweg 17", "7.132343675283754,53.37390198651908"));
        ostfriesland.add(new Spielort("Lammertsfehn", Kreis.OSTFRIESLAND, "26849 Filsum, Kielweg 4", "7.671354500414802,53.267605330165566"));
        ostfriesland.add(new Spielort("Riepe", Kreis.OSTFRIESLAND, "26632 Ihlow, Fennenstraße 75", "7.348359194865259,53.39953868646987"));
        ostfriesland.add(new Spielort("Holterfehn", Kreis.OSTFRIESLAND, "26842 Ostrhauderfehn, Holterfehner Straße 49", "7.621857490621586,53.16239506187755"));
        ostfriesland.add(new Spielort("Hesel", Kreis.OSTFRIESLAND, "26835 Hesel, Holunderstraße 2", "7.599713027400855,53.31334122736651"));
        ostfriesland.add(new Spielort("Holtrop", Kreis.OSTFRIESLAND, "26629 Großefehn, Mühlenweg 5", "7.570794371583207,53.42965194171222"));
        ostfriesland.add(new Spielort("Carolinensiel", Kreis.OSTFRIESLAND, "26409 Wittmund, Wittmunder Straße 22", "7.7991200933826414,53.68889901128857"));
        ostfriesland.add(new Spielort("Klostermoor", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, Am Sportplatz 2", "7.523175625543682,53.08395997992682"));
        ostfriesland.add(new Spielort("Westrhauderfehn", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, Werftstraße 4", "7.581416544590327,53.1285931673576"));
        ostfriesland.add(new Spielort("Marienhafe", Kreis.OSTFRIESLAND, "26529 Upgant-Schott, Sebastianstraße 46", "7.267978317615924,53.519469068316425"));
        ostfriesland.add(new Spielort("Borkum", Kreis.OSTFRIESLAND, "26757 Borkum, Hindenburgstraße 97", "6.675094369453834,53.595875784834"));
        ostfriesland.add(new Spielort("Collingshorst", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, Unnerloogsweg 29", "7.5266394303184905,53.16239597470045"));
        ostfriesland.add(new Spielort("Detern", Kreis.OSTFRIESLAND, "26847 Detern, Mühlenstraße 10A", "7.662538830564792,53.21038568103454"));
        ostfriesland.add(new Spielort("Ditzumerverlaat", Kreis.OSTFRIESLAND, "26831 Bunde, Achter't Verlaat 1", "7.258698415838624,53.25858175639596"));
        ostfriesland.add(new Spielort("Hinte", Kreis.OSTFRIESLAND, "26759 Hinte, Sportplatzstraße 26", "7.196621456239249,53.40803951835051"));
        ostfriesland.add(new Spielort("Esens", Kreis.OSTFRIESLAND, "26427 Esens, Walpurgisstraße 13", "7.610022913917403,53.64992444520415"));
        ostfriesland.add(new Spielort("Horsten", Kreis.OSTFRIESLAND, "26446 Friedeburg, Horster Schulweg 3", "7.941511234808453,53.446938487704664"));
        ostfriesland.add(new Spielort("Großheide", Kreis.OSTFRIESLAND, "26532 Großheide, Hochisterweg 2A", "7.340889473438651,53.59409728832346"));
        ostfriesland.add(new Spielort("Halbemond", Kreis.OSTFRIESLAND, "26524 Halbemond, Fehnstraße 10", "7.300451981377362,53.56925732200497"));
        ostfriesland.add(new Spielort("Holthusen", Kreis.OSTFRIESLAND, "26826 Weener, Zum Sportplatz 8", "7.31076146972496,53.15861853986189"));
        ostfriesland.add(new Spielort("Holtriem", Kreis.OSTFRIESLAND, "26556 Westerholt, Zum Sportzentrum 2", "7.448209446453748,53.591367244169085"));
        ostfriesland.add(new Spielort("Leerhafe-Hovel", Kreis.OSTFRIESLAND, "26409 Wittmund, Müggenkrüger Straße 32B", "7.764797702690738,53.522028021119446"));
        ostfriesland.add(new Spielort("Middels", Kreis.OSTFRIESLAND, "26607 Aurich, Barger Weg 5A", "7.594752690631711553.54199536252174"));
        ostfriesland.add(new Spielort("Norderney", Kreis.OSTFRIESLAND, "26548 Norderney, An der Mühle", "7.157479767615943,53.704543422824635"));
        ostfriesland.add(new Spielort("Pewsum", Kreis.OSTFRIESLAND, "26736 Krummhörn, Olympiastraße 1", "7.093817107823409,53.439795589186346"));
        ostfriesland.add(new Spielort("Emden (RW)", Kreis.OSTFRIESLAND, "26721 Emden, Conrebbersweg 2", "7.197050800417887,53.38589435644282"));
        ostfriesland.add(new Spielort("Sandhorst", Kreis.OSTFRIESLAND, "26603 Aurich, Schulstraße 35", "7.4927120842258175,53.486192564268556"));
        ostfriesland.add(new Spielort("Strudden", Kreis.OSTFRIESLAND, "26446 Friedeburg, Strudden 10", "7.847921585076209,53.44884819031456"));
        ostfriesland.add(new Spielort("Weene", Kreis.OSTFRIESLAND, "26632 Ihlow, Weener Weg 1A", "7.514162923166377,53.4234451188444"));
        ostfriesland.add(new Spielort("Weener", Kreis.OSTFRIESLAND, "26826 Weener, Kommerzienzrat-Hesse-Straße 22", "7.34305615067975,53.16740708264196"));
        ostfriesland.add(new Spielort("Westerende", Kreis.OSTFRIESLAND, "26632 Ihlow, Auricher Straße 35", "7.412406558091106,53.442257789082255"));
        ostfriesland.add(new Spielort("Bunde", Kreis.OSTFRIESLAND, "26831 Bunde, Am Mölenland 6", "7.275725956233318,53.18818546596834"));
        ostfriesland.add(new Spielort("Greetsiel", Kreis.OSTFRIESLAND, "26736 Krummhörn, Am SPortplatz 2", "7.0719217139122685,53.45749770893343"));
        ostfriesland.add(new Spielort("Osteel", Kreis.OSTFRIESLAND, "26529 Osteel, Adeweg 30", "7.260655668834074,53.539890562123375"));
        ostfriesland.add(new Spielort("Wiesmoor", Kreis.OSTFRIESLAND, "26639 Wiesmoor, Hauptstraße 250", "7.721952185075009,53.407233937154665"));
        ostfriesland.add(new Spielort("Münkeboe", Kreis.OSTFRIESLAND, "26624 Südbrookmerland, Upender Straße 62", "7.373746386929002,53.51621386651281"));
        ostfriesland.add(new Spielort("Norden (VFB)", Kreis.OSTFRIESLAND, "26506 Norden, In der Wildbahn 4", "7.176631548305055,53.60280577651275"));
        ostfriesland.add(new Spielort("Rajen", Kreis.OSTFRIESLAND, "26817 Rhauderfehn, 4.Südwieke 1", "7.518703858796056,53.1299256141811"));
        ostfriesland.add(new Spielort("Uplengen", Kreis.OSTFRIESLAND, "26670 Uplengen, Höststraße", "7.73991451575916,53.304640480385096"));
        ostfriesland.add(new Spielort("Veenhusen", Kreis.OSTFRIESLAND, "26802 Moormerland", "7.486656069728689,53.29810046474549"));
        ostfriesland.add(new Spielort("Leer (Germania)", Kreis.OSTFRIESLAND, "26789 Leer, Osseweg", "7.473767854383446,53.22923232898799"));
        ostfriesland.add(new Spielort("Iheringsfehn", Kreis.OSTFRIESLAND, "26835 Neukamperfehn, Hauptwieke 6", "7.5568934390429305,53.33881325797481"));
        ostfriesland.add(new Spielort("Mullberg", Kreis.OSTFRIESLAND, "26639 Wiesmoor, Birkhahnweg 53a", "7.77005804089576,53.40654741731925"));
        ostfriesland.add(new Spielort("Ockenhausen", Kreis.OSTFRIESLAND, "26670 Uplengen, Am Sportplatz 13", "53.35318761452759, 7.806431659939818"));
        ostfriesland.add(new Spielort("Flachsmeer", Kreis.OSTFRIESLAND, "26810 Westoverledingen, Zu den Plätzen 6", "7.463174840888308,53.12750964378861"));
        ostfriesland.add(new Spielort("Völlen", Kreis.OSTFRIESLAND, "26810 Westoverledingen, Süderhörn 1", "7.381053669723653,53.10863801206612"));
        ostfriesland.add(new Spielort("Heisfelde", Kreis.OSTFRIESLAND, "26789 Leer, Heisfelder Straße 192", "7.458547954383877,53.2460014989047"));
        ostfriesland.add(new Spielort("Loppersum", Kreis.OSTFRIESLAND, "26759 Hinte, Friedensstraße 39", "7.24276801576258553.43140132964068"));
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

    private List<Spielort> vechta() {
        List<Spielort> vechta = new ArrayList<>();
        return vechta;
    }

    private List<Spielort> oldenburg() {
        List<Spielort> ol = new ArrayList<>();
        return ol;
    }

    private List<Spielort> jadeWeserHunte() {
        List<Spielort> jwh = new ArrayList<>();
        return jwh;
    }
}