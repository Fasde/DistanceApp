package fasde.android.distanceapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fasde.android.distanceapp.database.SaveData;
import fasde.android.distanceapp.database.Toolbox;
import fasde.android.distanceapp.model.Kreis;
import fasde.android.distanceapp.R;

/**
 * List of picks, to pick the Kreis of Spielorts.
 */
public class KreisPickActivity extends AppCompatActivity {

    private static Toast toastNow;

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    Context context = this;

    /**
     * Creates a view to display the picks to pick a Kreis of Spielorts.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreis_pick_activity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        listView = findViewById(R.id.pickList);

        List<String> picks = new ArrayList<>();
        picks.add("Alle Kreise");
        for (Kreis kreis : SaveData.listAllKreise()) {
            picks.add(kreis.getName());
        }

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, picks);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent openListView = new Intent(KreisPickActivity.this, MainActivity.class);
            MainActivity.setAktuellerKreis((String) listView.getItemAtPosition(position));
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(context, "Öffne Spielort-Liste des gewählten Kreises...", Toast.LENGTH_SHORT);
            toastNow.show();
            startActivity(openListView);
        });
    }

    /**
     * Sets the menu button to open the menu.
     *
     * @param menu the menu source file
     * @return true as the menu will always be added
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Defines the action to do, depending of which option is selected from the menu.
     *
     * @param item the item selected from the menu
     * @return the boolean value of the item selected
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.Impressum) {
            Intent openImpressum = new Intent(KreisPickActivity.this, ImpressumActivity.class).putExtra("PrevClass", "KreisPick");
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(this, "Öffne Impressum...", Toast.LENGTH_SHORT);
            toastNow.show();
            startActivity(openImpressum);
        } else if (itemId == android.R.id.home) {
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(this, "Schließe...", Toast.LENGTH_SHORT);
            toastNow.show();
        } else if (itemId == R.id.AktOrt) {
            Intent setOrt = new Intent(KreisPickActivity.this, GeoActivity.class);
            Toolbox.killAllToasts();
            startActivity(setOrt);
        }
        return super.onOptionsItemSelected(item);
    }

    public static void killToast(){
        if(toastNow != null)
            toastNow.cancel();
    }
}
