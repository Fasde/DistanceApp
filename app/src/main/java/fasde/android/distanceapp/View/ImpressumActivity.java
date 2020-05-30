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

public class ImpressumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.impressum);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView appDetail = findViewById(R.id.app_detail);
        TextView appAuthor = findViewById(R.id.app_author);
        TextView appVersion = findViewById(R.id.app_version);

        String detail = "Zweck und Inhalt:\n\t\tDiese App wurde geschaffen, um \n\t\teine kleine, nette, und vor allem " +
                "\n\t\tselbstprogrammierte Hilfe zu sein, \n\t\tum die Spritkosten und \n\t\tFahrtweiten, sowie die" +
                " Adressen \n\t\tder Fußballplätze im Bezirk \n\t\tWeser-Ems, vor allem des \n\t\tEmslands, zu sein.";
        String version = "\n\nApp-Informationen:\n\t\t" + getString(R.string.app_name) + "\n\t\t" + getString(R.string.version);
        String author = "\n\nAutor:\n\t\t" + getString(R.string.author) + "(" + getString(R.string.author2) + ")";

        appDetail.setText(detail);
        appAuthor.setText(author);
        appVersion.setText(version);
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
                Intent openImpressum = new Intent(ImpressumActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            }
            case android.R.id.home:
                String previousClass = getIntent().getStringExtra("PrevClass");
                assert previousClass != null;
                switch (previousClass) {
                    case "SpielOrtDetail": {
                        Intent openSpielOrtDetail = new Intent(ImpressumActivity.this, SpielortDetailActivity.class).putExtra("spielort", getIntent().getStringArrayExtra("spielort"));
                        openSpielOrtDetail.putExtra("variante", getIntent().getStringExtra("variante"));
                        Toast.makeText(this, "Schließe Impressum...", Toast.LENGTH_SHORT).show();
                        startActivity(openSpielOrtDetail);
                        break;
                    }
                    case "Main": {
                        Intent openMain = new Intent(ImpressumActivity.this, MainActivity.class).putExtra("variante", getIntent().getStringExtra("variante"));
                        Toast.makeText(this, "Schließe Impressum...", Toast.LENGTH_SHORT).show();
                        startActivity(openMain);
                        break;
                    }
                    case "KreisPick": {
                        Intent openKreisPick = new Intent(ImpressumActivity.this, KreisPickActivity.class);
                        Toast.makeText(this, "Schließe Impressum...", Toast.LENGTH_SHORT).show();
                        startActivity(openKreisPick);
                        break;
                    }
                }

        }
        return super.onOptionsItemSelected(item);
    }
}
