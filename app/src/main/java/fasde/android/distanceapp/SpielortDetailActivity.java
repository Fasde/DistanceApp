package fasde.android.distanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SpielortDetailActivity extends AppCompatActivity {

    String[] spielortA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        TextView ort = findViewById(R.id.detail_ort);
        TextView distanz = findViewById(R.id.detail_km);
        TextView kosten = findViewById(R.id.detail_kosten);
        TextView kreis = findViewById(R.id.detail_kreis);
        TextView adresse = findViewById(R.id.detail_adresse);

        Intent intent = getIntent();
        spielortA = intent.getStringArrayExtra("spielort");

        ort.setText("\t" +spielortA[0]);
        distanz.setText("Distanz: " + spielortA[1] + "km pro Strecke");
        kosten.setText("Fahrtkosten: " + spielortA[2] + "€");
        kreis.setText("Kreis: " + spielortA[3]);
        adresse.setText("Adresse: Work in Progress");
    }
}
