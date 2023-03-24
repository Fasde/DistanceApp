package fasde.android.distanceapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.database.SaveData;
import fasde.android.distanceapp.geo.Geo;
import fasde.android.distanceapp.model.Spielort;

public class GespannPlanungActivity extends AppCompatActivity {

    Spinner startadresse;
    Spinner sra1;
    Spinner sra2;
    Spinner zielort;
    Map<String, String> refMap;
    Map<String, Spielort> ortMap;
    List<String> refList;
    List<String> spielortList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gespann_planung);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        startadresse = findViewById(R.id.startadresse);
        sra1 = findViewById(R.id.sra_spinner);
        sra2 = findViewById(R.id.sra2_spinner);
        zielort = findViewById(R.id.zielort_spinner);


        refMap = SaveData.getRefs(getApplicationContext());
        refList = new ArrayList<>(refMap.keySet()).stream().sorted().collect(Collectors.toList());
        ortMap = SaveData.fillVereine("Alle Kreise");
        spielortList = new ArrayList<>(ortMap.keySet()).stream().sorted().collect(Collectors.toList());

        String coords = Geo.loadPersistedHome(getApplicationContext());
        if (coords != null && !coords.equals("0,0")) {
            String[] cords = coords.split(",");
            refMap.put("Eigene Adresse", cords[1] + "," + cords[0]);
            refList.add(0, "Eigene Adresse");
        }
        ArrayAdapter<String> refArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, refList);
        ArrayAdapter<String> ortArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spielortList);
        startadresse.setAdapter(refArrayAdapter);
        sra1.setAdapter(refArrayAdapter);
        sra2.setAdapter(refArrayAdapter);
        zielort.setAdapter(ortArrayAdapter);

        findViewById(R.id.toMapsRoute).setOnClickListener(view -> routeInMaps());
    }

    private void routeInMaps() {
        String adr_refStart;
        String adr_sra1;
        String adr_sra2;
        Spielort adr_ziel;
        adr_refStart = Objects.requireNonNull(refMap.get(startadresse.getSelectedItem().toString())).replace("#", ", ");
        adr_sra1 = Objects.requireNonNull(refMap.get(sra1.getSelectedItem().toString())).replace("#", ", ");
        adr_sra2 = Objects.requireNonNull(refMap.get(sra2.getSelectedItem().toString())).replace("#", ", ");
        adr_ziel = ortMap.get(zielort.getSelectedItem().toString());
        Uri mapsIntentUri = Uri.parse("https://www.google.com/maps/dir/" +
                adr_refStart + '/' +
                adr_sra1 + '/' +
                adr_sra2 + '/' +
                Objects.requireNonNull(adr_ziel).getOrtsName() + ", " + adr_ziel.getAdresse()
        );
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);
        mapsIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapsIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Impressum: {
                Intent openImpressum = new Intent(this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                Toast toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
                finish();
                break;
            }
            case R.id.Referees:
                Intent ref = new Intent(this, RefereeActivity.class);
                Toolbox.killAllToasts();
                startActivity(ref);
                finish();
                break;
            case R.id.Kreislist:
                Intent kreislist = new Intent(this, ListViewActivity.class);
                Toolbox.killAllToasts();
                startActivity(kreislist);
                finish();
                break;
            case R.id.Routenplanung:
                Intent gespann = new Intent(this, GespannPlanungActivity.class);
                Toolbox.killAllToasts();
                startActivity(gespann);
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.AktOrt:
                Intent setOrt = new Intent(this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}