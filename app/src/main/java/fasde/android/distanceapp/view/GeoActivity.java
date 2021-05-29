package fasde.android.distanceapp.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.R;
import fasde.android.distanceapp.geo.Geo;

public class GeoActivity extends AppCompatActivity {

    private static Toast toastNow;

    Switch switchCustomHome;
    TextView textCustomHome;
    Button submitCustomHome;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        switchCustomHome = findViewById(R.id.switchCustomHome);
        textCustomHome = findViewById(R.id.textCustomHome);
        submitCustomHome = findViewById(R.id.submitCustomHome);

        switchCustomHome.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                getGeoPermission();
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED){
                    return;
                }
                textCustomHome.setVisibility(View.INVISIBLE);
            } else {
                textCustomHome.setVisibility(View.VISIBLE);
            }
        });

        submitCustomHome.setOnClickListener(view -> {
            if(textCustomHome.getText().equals("")){
                Toast.makeText(this, "Text darf nicht leer sein", Toast.LENGTH_LONG).show();
                return;
            }
            if (switchCustomHome.isChecked()) {
                // Automatische Location
                getCurrentLocation();
            } else {
                // Manuelle Location
                getLocationByInput();
            }
            Intent back = new Intent(this, KreisPickActivity.class);
            startActivity(back);
        });

    }

    private void getGeoPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
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
        if(location == null) return;
        Geo.homeCords = location.getLongitude()+","+location.getLatitude();
    }

    private void getLocationByInput(){
        String dataToLookFor = textCustomHome.getText().toString();
        String url = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248b2d893fc69e7408c85550ae302e3b97d&text="+dataToLookFor;
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, response ->
        {
            try {
                JSONArray coords = response.getJSONArray("features").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates");
                Geo.homeCords = coords.get(0).toString()+","+coords.get(1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        },
                error -> {Toast.makeText(this, "Fehler", Toast.LENGTH_LONG).show();});
        Volley.newRequestQueue(this).add(req);
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

    public static void killToast(){
        if(toastNow != null)
            toastNow.cancel();
    }
}
