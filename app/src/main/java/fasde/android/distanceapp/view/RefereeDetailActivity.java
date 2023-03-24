package fasde.android.distanceapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.model.Referee;

/**
 * DetailView that shows Details about a specific Spielort
 */
public class RefereeDetailActivity extends AppCompatActivity {

    private static Referee aktuellerRef;
    String[] refArray;
    RequestQueue queue;

    public static void setAktuellerRef(Referee ref) {
        aktuellerRef = ref;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_ref);

        AdView adView = findViewById(R.id.itemAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        TextView spielortView = findViewById(R.id.detail_ref_name);
        TextView ortView = findViewById(R.id.detail_ref_adresse_ort);
        TextView strasseView = findViewById(R.id.detail_ref_adresse_strasse);

        refArray = aktuellerRef.toStringArray();

        queue = Volley.newRequestQueue(this);

        String nameString = refArray[0];
        String ortString = refArray[1];
        String strasseString = refArray[2];

        this.setTitle(nameString);

        spielortView.setText(nameString);
        ortView.setText(ortString);
        strasseView.setText(strasseString);

        findViewById(R.id.buttonDelete).setOnClickListener(view -> {
            SharedPreferences refPres = getApplicationContext().getSharedPreferences("REFEREES", 0);
            SharedPreferences.Editor editor = refPres.edit();
            editor.remove(nameString);
            editor.apply();
            Intent intent = new Intent(RefereeDetailActivity.this, RefereeActivity.class);
            startActivity(intent);
            finish();
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
                Intent openImpressum = new Intent(RefereeDetailActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                Toast toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
                finish();
                break;
            }
            case R.id.Referees:
                Intent ref = new Intent(RefereeDetailActivity.this, RefereeActivity.class);
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
                finishActivity(0);
                break;
            case R.id.AktOrt:
                Intent setOrt = new Intent(RefereeDetailActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
