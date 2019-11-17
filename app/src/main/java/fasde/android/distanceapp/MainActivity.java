package fasde.android.distanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        editText = findViewById(R.id.inputSearch);

        List<String> setup = new ArrayList<>();

        Map<String, Integer> vereine = new TreeMap<>();
        vereine.put("Adorf", 26);
        vereine.put("Ahlen-Steinbild", 33);
        vereine.put("Ahmsen", 42);
        vereine.put("Altenlingen", 30);
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
        vereine.put("Bokeloh", 15);
        vereine.put("Bramhar", 24);
        vereine.put("Bramsche", 41);
        vereine.put("Breddenberg", 49);
        vereine.put("Brual", 48);
        vereine.put("Brögbern", 31);
        vereine.put("Börger", 42);
        vereine.put("CCI (Emslage)", 7);
        vereine.put("Clusorth", 28);
        vereine.put("Dalum", 19);
        vereine.put("Darme", 37);
        vereine.put("Dersum", 33);
        vereine.put("Dohren", 36);
        vereine.put("Dörpen", 34);
        vereine.put("Eisten-Hüven", 42);
        vereine.put("Eltern", 30);
        vereine.put("Emmeln", 11);
        vereine.put("Emsbüren", 58);
        vereine.put("Erika-Altenberge", 15);
        vereine.put("Esterwegen", 60);
        vereine.put("Fehndorf", 11);
        vereine.put("Flechum", 34);
        vereine.put("Freren", 47);
        vereine.put("Fresenburg", 29);
        vereine.put("Fullen", 6);
        vereine.put("Geeste", 21);
        vereine.put("Gersten", 34);
        vereine.put("Groß Hesepe", 15);
        vereine.put("Haren", 8);
        vereine.put("Haselünne", 30);
        vereine.put("Hebelermeer", 11);
        vereine.put("Heede", 36);
        vereine.put("Hemsen", 9);
        vereine.put("Herbrum", 51);
        vereine.put("Herssum", 43);
        vereine.put("Herzlake", 38);
        vereine.put("Hilkenbrook", 65);
        vereine.put("Holte", 41);
        vereine.put("Holthausen-Biene", 24);
        vereine.put("Hülsen-Westerloh", 29);
        vereine.put("Lähden", 38);
        vereine.put("Lahn", 44);
        vereine.put("Landegge", 11);
        vereine.put("Langen (Lathen)", 25);
        vereine.put("Langen (Lengerich)", 36);
        vereine.put("Lathen", 27);
        vereine.put("Lathen-Wahn", 24);
        vereine.put("Laxten", 24);
        vereine.put("Lehe", 37);
        vereine.put("Lehrte", 22);
        vereine.put("Lengerich-Handrup", 40);
        vereine.put("Leschede", 52);
        vereine.put("Lingen", 30);
        vereine.put("Listrup", 58);
        vereine.put("Lorup", 49);
        vereine.put("Lünne", 46);
        vereine.put("Meppen (SV)", 13);
        vereine.put("Mepppen (Union)", 6);
        vereine.put("Messingen", 43);
        vereine.put("Neubörger", 38);
        vereine.put("Neulangen", 19);
        vereine.put("Neulehe", 42);
        vereine.put("Neurhede", 47);
        vereine.put("Neuringe", 24);
        vereine.put("Ostenwalde", 41);
        vereine.put("Osterbrock", 24);
        vereine.put("Papenburg", 58);
        vereine.put("Polle", 30);
        vereine.put("Rastdorf", 51);
        vereine.put("Renkenberge", 31);
        vereine.put("Rhede", 44);
        vereine.put("Rütenbrock", 20);
        vereine.put("Salzbergen", 62);
        vereine.put("Schapen", 53);
        vereine.put("Schepsdorf", 39);
        vereine.put("Schleper", 25);
        vereine.put("Schwefingen", 15);
        vereine.put("Schöningsdorf", 11);
        vereine.put("Spahnharrenstätte", 42);
        vereine.put("Spelle-Venhaus", 55);
        vereine.put("Stavern", 30);
        vereine.put("Surwold", 49);
        vereine.put("Sögel", 36);
        vereine.put("Teglingen", 14);
        vereine.put("Thuine", 42);
        vereine.put("Tinnen", 14);
        vereine.put("Twist (Germania)", 23);
        vereine.put("Twist (Grenzland)", 26);
        vereine.put("Varenrode", 50);
        vereine.put("Versen (JVA)", 4);
        vereine.put("Vrees", 56);
        vereine.put("Walchum-Hasselbrock", 29);
        vereine.put("Wehm", 48);
        vereine.put("Werlte", 47);
        vereine.put("Werpeloh", 37);
        vereine.put("Wesuwe", 2);
        vereine.put("Wettrup", 39);
        vereine.put("Wieste", 49);
        vereine.put("Wippingen", 32);
        vereine.put("Nordhorn (WE)", 50);

        BigDecimal kosten;
        for (Map.Entry<String, Integer> entry : vereine.entrySet()) {
            kosten = new BigDecimal(entry.getValue() * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
            setup.add(entry.getKey() + "\t\t||\t\t" + entry.getValue() + "km\t\t||\t\t" + kosten + "€");
        }


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, setup);

        listView.setAdapter(arrayAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


}
