package fasde.android.distanceapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import fasde.android.distanceapp.DataBase.SaveData;
import fasde.android.distanceapp.R;
import fasde.android.distanceapp.Types.Spielort;
import fasde.android.distanceapp.Adapter.SpielortAdapter;

/**
 * Creates a Activity about a ListView of Spielorts.
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;
    SpielortAdapter spielortAdapter;
    EditText editText;

    /**
     * Gets the whole app running. Creates a listView, an editText and a spielortAdapter and gets
     * all of them running.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String variante = intent.getStringExtra("variante");

        listView = findViewById(R.id.list);
        editText = findViewById(R.id.inputSearch);

        ArrayList<Spielort> spielorts = new ArrayList<>();

        Map<String, Spielort> vereine = new TreeMap<>();

        switch (variante) {
            case "Alle Kreise":
                for (Spielort ort : SaveData.gottaListEmAll()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Emsland-Gesamt":
                for (Spielort ort : SaveData.emslandMitte()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                for (Spielort ort : SaveData.emslandNord()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                for (Spielort ort : SaveData.emslandSued()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Emsland-Nord":
                for (Spielort ort : SaveData.emslandNord()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Emsland-Mitte":
                for (Spielort ort : SaveData.emslandMitte()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Emsland-Süd":
                for (Spielort ort : SaveData.emslandSued()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Grafschaft":
                for (Spielort ort : SaveData.grafschaft()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Cloppenburg":
                for (Spielort ort : SaveData.cloppenburg()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Ostfriesland":
                for (Spielort ort : SaveData.ostfriesland()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
            case "Osnabrück":
                for (Spielort ort : SaveData.osnabrück()) {
                    vereine.put(ort.getSpielort(), ort);
                }
                break;
        }

        for (Map.Entry<String, Spielort> entry : vereine.entrySet()) {
            spielorts.add(entry.getValue());
        }


        spielortAdapter = new SpielortAdapter(this, spielorts);

        listView.setAdapter(spielortAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.spielortAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openDetail = new Intent(MainActivity.this, SpielortDetailActivity.class)
                        .putExtra("spielort", ((Spielort) listView.getItemAtPosition(position)).toStringArray());
                startActivity(openDetail);
            }
        });
    }
}
