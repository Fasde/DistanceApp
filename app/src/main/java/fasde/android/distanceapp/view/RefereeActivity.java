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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.RefereeAdapter;
import fasde.android.distanceapp.controller.Toolbox;
import fasde.android.distanceapp.database.SaveData;
import fasde.android.distanceapp.model.Referee;

public class RefereeActivity extends AppCompatActivity {


    private static Toast toastNow;

    ListView listView;
    RefereeAdapter refAdapter;
    EditText editText;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referee);
        AdView adView = findViewById(R.id.listAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        this.setTitle("Schiedsrichter");

        listView = findViewById(R.id.reflistview);
        editText = findViewById(R.id.edit_query);

        ArrayList<Referee> referees = new ArrayList<>();

        Map<String, String> refs = new TreeMap<>(SaveData.getRefs(getApplicationContext()));

        for (Map.Entry<String, String> entry : refs.entrySet()) {
            String adresse = entry.getValue().split("#")[0] + ',' + entry.getValue().split("#")[1];
            String email;
            String tel;
            try{
                email = entry.getValue().split("#")[2];
            } catch (Exception e) {
                email = " ";
            }
            try{
                tel = entry.getValue().split("#")[3];
            } catch (Exception e) {
                tel = " ";
            }
            Referee ref = new Referee(entry.getKey(), adresse, email, tel);
            referees.add(ref);
        }

        refAdapter = new RefereeAdapter(this, referees);
        listView.setAdapter(refAdapter);

        findViewById(R.id.addRefButton).setOnClickListener(view -> {
            Intent intent = new Intent(RefereeActivity.this, RefSubmitActivity.class);
            startActivity(intent);
            finish();
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                RefereeActivity.this.refAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent openDetail = new Intent(RefereeActivity.this, RefereeDetailActivity.class);
            RefereeDetailActivity.setAktuellerRef((Referee) listView.getItemAtPosition(position));
            Toolbox.killAllToasts();
            toastNow = Toast.makeText(context, "Öffne gewählten Schiedsrichter...", Toast.LENGTH_SHORT);
            toastNow.show();
            startActivity(openDetail);
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
                Intent openImpressum = new Intent(RefereeActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
                finish();
                break;
            }
            case R.id.Referees:
                Intent ref = new Intent(RefereeActivity.this, RefereeActivity.class);
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
                Intent setOrt = new Intent(RefereeActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}