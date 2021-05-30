package fasde.android.distanceapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.database.SaveData;
import fasde.android.distanceapp.model.Kreis;

/**
 * List of picks, to pick the Kreis of Spielorts.
 */
public class KreisPickActivity extends AppCompatActivity {

    private static Toast toastNow;

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kreis_pick_activity);

        AdView adView = findViewById(R.id.kreispickAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
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
            Intent openListView = new Intent(KreisPickActivity.this, ListViewActivity.class);
            ListViewActivity.setAktuellerKreis((String) listView.getItemAtPosition(position));
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
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Impressum: {
                Intent openImpressum = new Intent(KreisPickActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
                finish();
                break;
            }
            case android.R.id.home:
                finish();
                break;
            case R.id.AktOrt:
                Intent setOrt = new Intent(KreisPickActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void killToast(){
        if(toastNow != null)
            toastNow.cancel();
    }
}
