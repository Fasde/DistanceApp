package fasde.android.distanceapp.View;

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

import fasde.android.distanceapp.R;

/**
 * DetailView that shows Details about a specific Spielort
 */
public class SpielortDetailActivity extends AppCompatActivity {

    String[] spielortA;

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

        TextView ortView = findViewById(R.id.detail_ort);
        TextView distanzView = findViewById(R.id.detail_km);
        TextView kostenView = findViewById(R.id.detail_kosten);
        TextView kreisView = findViewById(R.id.detail_kreis);
        TextView adresseView = findViewById(R.id.detail_adresse);

        Intent intent = getIntent();
        spielortA = intent.getStringArrayExtra("spielort");

        String ortString = "\t" + spielortA[0];
        String distanzString = "Distanz: \n\t\t" + spielortA[1] + "km pro Strecke";
        String kostenString = "Fahrtkosten: \n\t\t " + spielortA[2] + "€";
        String kreisString = "Kreis: \n\t\t " + spielortA[3];
        String adresseString = "Adresse: \n\t\t " + spielortA[4] + "\n\t\t" + spielortA[5];

        ortView.setText(ortString);
        distanzView.setText(distanzString);
        kostenView.setText(kostenString);
        kreisView.setText(kreisString);
        adresseView.setText(adresseString);
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
                Intent openImpressum = new Intent(SpielortDetailActivity.this, ImpressumActivity.class).putExtra("PrevClass", "SpielOrtDetail");
                openImpressum.putExtra("spielort", getIntent().getStringArrayExtra("spielort"));
                openImpressum.putExtra("variante", getIntent().getStringExtra("variante"));
                Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT).show();
                startActivity(openImpressum);
                finish();
                break;
            }
            case android.R.id.home: {
                Intent openMain = new Intent(SpielortDetailActivity.this, MainActivity.class).putExtra("variante", getIntent().getStringExtra("variante"));
                Toast.makeText(this, "Schließe Detailansicht...", Toast.LENGTH_SHORT).show();
                startActivity(openMain);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
