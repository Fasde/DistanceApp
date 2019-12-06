package fasde.android.distanceapp.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fasde.android.distanceapp.DataBase.SaveData;
import fasde.android.distanceapp.R;
import fasde.android.distanceapp.Types.Kreis;

/**
 * List of picks, to pick the Kreis of Spielorts.
 */
public class KreisPickActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    /**
     * Creates a view to display the picks to pick a Kreis of Spielorts.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreis_pick_activity);

        listView = findViewById(R.id.pickList);

        List<String> picks = new ArrayList<>();
        picks.add("Alle Kreise");
        for(Kreis kreis : SaveData.listAllKreise()){
            picks.add(kreis.getName());
        }

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, picks);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openList = new Intent(KreisPickActivity.this, MainActivity.class).putExtra("variante", (String) listView.getItemAtPosition(position));
                startActivity(openList);
            }
        });
    }
}
