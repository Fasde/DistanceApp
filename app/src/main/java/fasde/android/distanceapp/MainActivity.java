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

        Map<String, Spielort> vereine = new TreeMap<>();

        for(Spielort ort : Spielort.gottaListEmAll()){
            vereine.put(ort.getSpielort(), ort);
        }

        for (Map.Entry<String, Spielort> entry : vereine.entrySet()) {
            setup.add(entry.getValue().toString());
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
