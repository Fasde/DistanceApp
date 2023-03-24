package fasde.android.distanceapp.view;

import android.annotation.SuppressLint;
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
import fasde.android.distanceapp.controller.Toolbox;

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
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Impressum:
                Intent openImpressum = new Intent(ImpressumActivity.this, ImpressumActivity.class);
                startActivity(openImpressum);
                Toolbox.killAllToasts();
                toastNow = Toast.makeText(this, "Impressum geöffnet.", Toast.LENGTH_SHORT);
                toastNow.show();
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
            case R.id.Referees:
                Intent ref = new Intent(ImpressumActivity.this, RefereeActivity.class);
                Toolbox.killAllToasts();
                startActivity(ref);
                finish();
                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.AktOrt:
                Intent setOrt = new Intent(ImpressumActivity.this, GeoActivity.class);
                Toolbox.killAllToasts();
                startActivity(setOrt);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void killToast() {
        if (toastNow != null)
            toastNow.cancel();
    }
}
