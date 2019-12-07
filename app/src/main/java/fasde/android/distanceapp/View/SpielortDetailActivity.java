package fasde.android.distanceapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import fasde.android.distanceapp.R;
import lombok.NonNull;

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
}
