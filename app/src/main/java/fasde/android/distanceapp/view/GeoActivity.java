package fasde.android.distanceapp.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.geo.Geo;

public class GeoActivity extends AppCompatActivity {

    private static Toast toastNow;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchCustomHome;
    EditText textCustomHome;
    Button submitCustomHome;
    RequestQueue queue;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        AdView adView = findViewById(R.id.geoAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        queue = Volley.newRequestQueue(this);

        switchCustomHome = findViewById(R.id.switchCustomHome);
        textCustomHome = findViewById(R.id.textCustomHome);
        submitCustomHome = findViewById(R.id.submitCustomHome);

        textCustomHome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                getLocationByInput();
            }
        });

        switchCustomHome.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                getGeoPermission();
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
                    return;
                }
                textCustomHome.setVisibility(View.INVISIBLE);
                getCurrentLocation();
            } else {
                textCustomHome.setVisibility(View.VISIBLE);
                getLocationByInput();
            }
        });

        submitCustomHome.setOnClickListener(view -> {
            if (switchCustomHome.isChecked()) {
            } else {
                // Manuelle Location
                if (textCustomHome.getText().toString().equals("")) {
                    Toast.makeText(this, "Text darf nicht leer sein.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (Geo.homeCords == null) {
                    Toast.makeText(this, "Die Berechnung der Adresse hat nicht geklappt. Bitte versuchen Sie es mit einer anderen Adresseingabe.", Toast.LENGTH_LONG).show();
                }
            }
            Intent back = new Intent(this, KreisPickActivity.class);
            startActivity(back);
        });

    }

    private void getGeoPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Der aktuelle Standort kann verwendet werden.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "GPS-Berechtigung wird benötigt, um den aktuellen Standort zu verwenden.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void getCurrentLocation() {
        LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = loc.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) return;
        Geo.homeCords = location.getLongitude() + "," + location.getLatitude();
    }

    private void getLocationByInput() {
        String dataToLookFor = textCustomHome.getText().toString();
        try {
            dataToLookFor = URLEncoder.encode(dataToLookFor, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "https://nominatim.geocoding.ai/search.php?q=" + dataToLookFor + "&countrycodes=de&limit=1";
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            try {
                JSONObject obj = response.getJSONObject(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.d("JSON","Fehler in der JSON-Vearbeitung");
        });
        queue.add(req);
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
                Intent openImpressum = new Intent(GeoActivity.this, ImpressumActivity.class);
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
                Intent setOrt = new Intent(GeoActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void killToast() {
        if (toastNow != null)
            toastNow.cancel();
    }
}
