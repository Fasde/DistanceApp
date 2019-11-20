package fasde.android.distanceapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


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

        listView = findViewById(R.id.spielort_list);
        editText = findViewById(R.id.inputSearch);

        List<String> setup = new ArrayList<>();
        ArrayList<Spielort> spielorts = new ArrayList<>();

        Map<String, Spielort> vereine = new TreeMap<>();

        for (Spielort ort : Spielort.gottaListEmAll()) {
            vereine.put(ort.getSpielort(), ort);
        }

        for (Map.Entry<String, Spielort> entry : vereine.entrySet()) {
            setup.add(entry.getValue().toString());
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


    }


}
