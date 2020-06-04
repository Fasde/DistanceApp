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

import fasde.android.distanceapp.DataBase.Toolbox;
import fasde.android.distanceapp.R;

public class ImpressumActivity extends AppCompatActivity {

    private static Toast toastNow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.impressum);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView appDetailHeader = findViewById(R.id.app_detail_header);
        TextView appDetail = findViewById(R.id.app_detail);
        TextView appVersionHeader = findViewById(R.id.app_version_header);
        TextView appVersion = findViewById(R.id.app_version);
        TextView appAuthorHeader = findViewById(R.id.app_author_header);
        TextView appAuthor = findViewById(R.id.app_author);
        TextView appCodeHeader = findViewById(R.id.app_code_header);
        TextView appCode = findViewById(R.id.app_code);

        String authorString = getString(R.string.authorString1) + getString(R.string.authorString3);
        String versionString = getString(R.string.app_name) + getString(R.string.versionString) + getString(R.string.version);

        appDetailHeader.setText(R.string.detailHeader);
        appDetail.setText(R.string.detail);
        appAuthorHeader.setText(R.string.authorHeader);
        appAuthor.setText(authorString);
        appVersionHeader.setText(R.string.versionHeader);
        appVersion.setText(versionString);
        appCodeHeader.setText(R.string.codeHeader);
        appCode.setText(R.string.codeAdress);
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
                Toolbox.killAllToasts();
                toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
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
                        Toolbox.killAllToasts();
                        toastNow = Toast.makeText(this, "Schließe Impressum...", Toast.LENGTH_SHORT);
                        toastNow.show();
                        startActivity(openSpielOrtDetail);
                        break;
                    }
                    case "Main": {
                        Intent openMain = new Intent(ImpressumActivity.this, MainActivity.class).putExtra("variante", getIntent().getStringExtra("variante"));
                        Toolbox.killAllToasts();
                        toastNow = Toast.makeText(this, "Schließe Impressum...", Toast.LENGTH_SHORT);
                        toastNow.show();
                        startActivity(openMain);
                        break;
                    }
                    case "KreisPick": {
                        Intent openKreisPick = new Intent(ImpressumActivity.this, KreisPickActivity.class);
                        Toolbox.killAllToasts();
                        toastNow = Toast.makeText(this, "Schließe Impressum...", Toast.LENGTH_SHORT);
                        toastNow.show();startActivity(openKreisPick);
                        break;
                    }
                }

        }
        return super.onOptionsItemSelected(item);
    }

    public static void killToast(){
        if(toastNow != null)
            toastNow.cancel();
    }
}
