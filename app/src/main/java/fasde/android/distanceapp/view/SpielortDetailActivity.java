package fasde.android.distanceapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.database.Toolbox;
import fasde.android.distanceapp.geo.Geo;
import fasde.android.distanceapp.model.Spielort;

/**
 * DetailView that shows Details about a specific Spielort
 */
public class SpielortDetailActivity extends AppCompatActivity {

    private static Spielort aktuellerSpielort;
    private static Toast toastNow;
    String[] spielortArray;
    RequestQueue queue;
    String geoString;

    public static void setAktuellerSpielort(Spielort spielort) {
        aktuellerSpielort = spielort;
    }

    public static void killToast() {
        if (toastNow != null)
            toastNow.cancel();
    }

    /**
     * Creates a view, that shoes details about a specific Spielort.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Geo.destCords = aktuellerSpielort.getGeoString();

        TextView ortView = findViewById(R.id.detail_ort);
        TextView kreisView = findViewById(R.id.detail_kreis);
        TextView adresseView = findViewById(R.id.detail_adresse);

        geoString = aktuellerSpielort.getGeoString();
        spielortArray = aktuellerSpielort.toStringArray();

        queue = Volley.newRequestQueue(this);
        request();

        String ortString = "\t" + spielortArray[0];
        String kreisString = "Kreis: \n\t\t " + spielortArray[1];
        String adresseString = "Adresse: \n\t\t " + spielortArray[2] + "\n\t\t" + spielortArray[3];

        ortView.setText(ortString);
        kreisView.setText(kreisString);
        adresseView.setText(adresseString);
    }

    private void request() {
        String url = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248b2d893fc69e7408c85550ae302e3b97d&start="+Geo.homeCords+"&end="+Geo.destCords;
        JsonObjectRequest req2 = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
           try{
               JSONObject object = response.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getJSONObject("summary");
               setTexts(object.get("duration").toString(), object.get("distance").toString());
           } catch (Exception e){
               e.printStackTrace();
           }
        }, error -> {Toast.makeText(this, "Fehler", Toast.LENGTH_LONG).show();
            System.out.println(Arrays.toString(error.getStackTrace()));});
        queue.add(req2);
    }

    private void setTexts(String duration, String distance){
        TextView distanzView = findViewById(R.id.detail_km);
        TextView kostenView = findViewById(R.id.detail_kosten);
        Double d = Double.parseDouble(distance);
        d /= 1000;
        int i = d.intValue();
        String distanzString = "Distanz: \n\t\t" + i + "km pro Strecke";
        distanzView.setText(distanzString);
        BigDecimal bd = BigDecimal.valueOf(i * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        String kostenString = "Fahrtkosten: \n\t\t " + bd.toString() + "€";
        kostenView.setText(kostenString);
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
        if (item.getItemId() == R.id.Impressum) {
            Intent openImpressum = new Intent(SpielortDetailActivity.this, ImpressumActivity.class).putExtra("PrevClass", "SpielOrtDetail");
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
            toastNow.show();
            startActivity(openImpressum);
        } else if (item.getItemId() == android.R.id.home) {
            Intent openMain = new Intent(SpielortDetailActivity.this, MainActivity.class).putExtra("variante", getIntent().getStringExtra("variante"));
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(this, "Schließe Detailansicht...", Toast.LENGTH_SHORT);
            toastNow.show();
            startActivity(openMain);
        } else if (item.getItemId() == R.id.AktOrt) {
            Intent setOrt = new Intent(SpielortDetailActivity.this, GeoActivity.class);
            Toolbox.killAllToasts();
            startActivity(setOrt);
        }
        return super.onOptionsItemSelected(item);
    }
}