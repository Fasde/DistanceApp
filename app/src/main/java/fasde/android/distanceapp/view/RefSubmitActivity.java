package fasde.android.distanceapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.controller.Toolbox;

public class RefSubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_activity);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        findViewById(R.id.buttonSubmit).setOnClickListener(view -> submitRef());
    }

    private void submitRef() {
        EditText name = findViewById(R.id.refNameSubmit);
        EditText ort = findViewById(R.id.refOrtSubmit);
        EditText strasse = findViewById(R.id.refStrasseSubmit);
        SharedPreferences refPres = getApplicationContext().getSharedPreferences("REFEREES", 0);
        SharedPreferences.Editor editor = refPres.edit();
        editor.putString(name.getText().toString(), ort.getText() + "#" + strasse.getText());
        editor.apply();
        Intent ref = new Intent(RefSubmitActivity.this, RefereeActivity.class);
        ref.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Toolbox.killAllToasts();
        startActivity(ref);
        finish();
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
                Intent openImpressum = new Intent(RefSubmitActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                Toast toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
                finish();
                break;
            }
            case R.id.Referees:
                Intent ref = new Intent(RefSubmitActivity.this, RefereeActivity.class);
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
                Intent setOrt = new Intent(RefSubmitActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}