package fasde.android.distanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        List<String> setup = new ArrayList<>();

        Map<String, Integer> vereine = new HashMap<>();
        vereine.put("Adorf", 26);
        vereine.put("Ahlen-Steinbild", 33);
        vereine.put("Ahmsen", 42);
        vereine.put("Altenlingen", 37);
        vereine.put("Andervenne", 50);
        vereine.put("Apeldorn", 21);
        vereine.put("Aschendorf", 47);
        vereine.put("Aschendorfermoor", 51);
        vereine.put("Baccum", 36);
        vereine.put("Bawinkel", 31);
        vereine.put("Beesten", 48);
        vereine.put("Berßen", 26);
        vereine.put("Bockholte", 47);
        vereine.put("Bockhorst", 57);
        vereine.put("Bokeloh",);
        vereine.put("Bramhar",);
        vereine.put("Bramsche",);
        vereine.put("Breddenberg",);
        vereine.put("Brual",);
        vereine.put("Brögbern",);
        vereine.put("Börger",);
        vereine.put("CCI (Emslage)",);
        vereine.put("Clusorth",);
        vereine.put("Dalum",);
        vereine.put("Darme",);
        vereine.put("Dersum",);
        vereine.put("Dohren",);
        vereine.put("Dörpen",);
        vereine.put("Eisten-Hüven",);
        vereine.put("Eltern",);
        vereine.put("Emmeln",);
        vereine.put("Emsbüren",);
        vereine.put("Erika-Altenberge",);
        vereine.put("Esterwegen",);
        vereine.put("Fehndorf",);
        vereine.put("Flechum",);
        vereine.put("Freren",);
        vereine.put("Fresenburg",);
        vereine.put("Fullen",);
        vereine.put("Geeste",);
        vereine.put("Gersten",);
        vereine.put("Groß Hesepe",);
        vereine.put("Hesepe (JVA)",);
        vereine.put("Haren",);
        vereine.put("Haselünne",);
        vereine.put("Hebelermeer",);
        vereine.put("Heede",);
        vereine.put("Hemsen",);
        vereine.put("Herbrum",);
        vereine.put("Herssum",);
        vereine.put("Herzlake",);
        vereine.put("Hilkenbrook",);
        vereine.put("Holte",);
        vereine.put("Holthausen-Biene",);
        vereine.put("Hülsen-Westerloh",);
        vereine.put("Lähden",);
        vereine.put("Lahn",);
        vereine.put("Landegge",);
        vereine.put("Langen (Lathen)",);
        vereine.put("Langen (Meppen)",);
        vereine.put("Lastrup",);
        vereine.put("Lathen",);
        vereine.put("Lathen-Wahn",);
        vereine.put("Laxten",);
        vereine.put("Lehe",);
        vereine.put("Lehrte",);
        vereine.put("Lengerich-Handrup",);
        vereine.put("Leschede",);
        vereine.put("Lingen",);
        vereine.put("Listrup",);
        vereine.put("Lorup",);
        vereine.put("Lünne",);
        vereine.put("Meppen (SV)",);
        vereine.put("Mepppen (Union)",);
        vereine.put("Messingen",);
        vereine.put("Neubörger",);
        vereine.put("Neulangen",);
        vereine.put("Neulehe",);
        vereine.put("Neurhede",);
        vereine.put("Neuringe",);
        vereine.put("Ostenwalde",);
        vereine.put("Osterbrock",);
        vereine.put("Papenburg",);
        vereine.put("Polle",);
        vereine.put("Rastdorf",);
        vereine.put("Renkenberge",);
        vereine.put("Rhede",);
        vereine.put("Rütenbrock",);
        vereine.put("Salzbergen",);
        vereine.put("Schapen",);
        vereine.put("Schepsdorf",);
        vereine.put("Schleper",);
        vereine.put("Schwefingen",);
        vereine.put("Schöningsdorf",);
        vereine.put("Spahnharrenstätte",);
        vereine.put("Spelle-Venhaus",);
        vereine.put("Stavern",);
        vereine.put("Surwold",);
        vereine.put("Sögel",);
        vereine.put("Teglingen",);
        vereine.put("Thuine",);
        vereine.put("Tinnen",);
        vereine.put("Twist (Germania)",);
        vereine.put("Twist (Grenzland)",);
        vereine.put("Varenrode",);
        vereine.put("Versen (JVA)",);
        vereine.put("Vrees",);
        vereine.put("Walchum-Hasselbrock",);
        vereine.put("Wehm",);
        vereine.put("Werlte",);
        vereine.put("Werpeloh",);
        vereine.put("Wesuwe",);
        vereine.put("Wettrup",);
        vereine.put("Wieste",);
        vereine.put("Wippingen",);

        for(Map.Entry<String, Integer> entry : vereine.entrySet()){
            setup.add(entry.getKey() +" || " + entry.getValue() +"km || " + entry.getValue()*0.30*2 + "€");
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, setup);

        listView.setAdapter(arrayAdapter);
    }


}
