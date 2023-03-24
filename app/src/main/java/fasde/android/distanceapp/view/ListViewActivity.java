package fasde.android.distanceapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.SpielortAdapter;
import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.database.SaveData;
import fasde.android.distanceapp.model.Spielort;

/**
 * Creates a Activity about a ListView of Spielorts.
 */
public class ListViewActivity extends AppCompatActivity {

    private static String aktuellerKreis;
    private static Toast toastNow;

    ListView listView;
    SpielortAdapter spielortAdapter;
    EditText editText;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        AdView adView = findViewById(R.id.listAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        this.setTitle(aktuellerKreis);

        listView = findViewById(R.id.list);
        editText = findViewById(R.id.inputSearch);

        ArrayList<Spielort> spielorts = new ArrayList<>();

        Map<String, Spielort> vereine = new TreeMap<>(SaveData.fillVereine(aktuellerKreis));

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
                ListViewActivity.this.spielortAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent openDetail = new Intent(ListViewActivity.this, SpielortDetailActivity.class);
            SpielortDetailActivity.setAktuellerSpielort((Spielort) listView.getItemAtPosition(position));
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(context, "Öffne gewählten Spielort...", Toast.LENGTH_SHORT);
            toastNow.show();
            startActivity(openDetail);
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
                Intent openImpressum = new Intent(ListViewActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
                finish();
                break;
            }
            case R.id.Referees:
                Intent ref = new Intent(ListViewActivity.this, RefereeActivity.class);
                Toolbox.killAllToasts();
                startActivity(ref);
                finish();
                break;
            case R.id.Routenplanung:
                Intent gespann = new Intent(this, GespannPlanungActivity.class);
                Toolbox.killAllToasts();
                startActivity(gespann);
                finish();
                break;
            case R.id.Kreislist:
                Intent kreislist = new Intent(this, ListViewActivity.class);
                Toolbox.killAllToasts();
                startActivity(kreislist);
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.AktOrt:
                Intent setOrt = new Intent(ListViewActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setAktuellerKreis(@Nullable String kreis) {
        aktuellerKreis = kreis;
    }

    public static void killToast() {
        if (toastNow != null)
            toastNow.cancel();
    }
}
