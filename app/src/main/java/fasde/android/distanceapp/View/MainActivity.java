package fasde.android.distanceapp.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import fasde.android.distanceapp.Controller.SpielortAdapter;
import fasde.android.distanceapp.DataBase.SaveData;
import fasde.android.distanceapp.Model.Spielort;
import fasde.android.distanceapp.R;

/**
 * Creates a Activity about a ListView of Spielorts.
 */
public class MainActivity extends AppCompatActivity {

    ListView listView;
    SpielortAdapter spielortAdapter;
    EditText editText;
    String[] spielOrt;
    Context context = this;

    /**
     * Gets the whole app running. Creates a listView, an editText and a spielortAdapter and gets
     * all of them running.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        @NotNull
        String variante = intent.getStringExtra("variante");

        listView = findViewById(R.id.list);
        editText = findViewById(R.id.inputSearch);

        ArrayList<Spielort> spielorts = new ArrayList<>();

        Map<String, Spielort> vereine = new TreeMap<>();
        vereine.putAll(SaveData.fillVereine(variante));

        for (Map.Entry<String, Spielort> entry : vereine.entrySet()) {
            spielorts.add(entry.getValue());
        }

        spielortAdapter = new SpielortAdapter(this, spielorts);
        listView.setAdapter(spielortAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.spielortAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openDetail = new Intent(MainActivity.this, SpielortDetailActivity.class)
                        .putExtra("spielort", (spielOrt = ((Spielort) listView.getItemAtPosition(position)).toStringArray()));
                openDetail.putExtra("variante", getIntent().getStringExtra("variante"));
                Toast.makeText(context, "Öffne gewählten Spielort...", Toast.LENGTH_SHORT).show();
                startActivity(openDetail);
                finish();
            }
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Impressum: {
                Intent openImpressum = new Intent(MainActivity.this, ImpressumActivity.class).putExtra("PrevClass", "Main");
                openImpressum.putExtra("variante", getIntent().getStringExtra("variante"));
                openImpressum.putExtra("spielort", spielOrt);
                Toast.makeText(this, "Öffne Impressum...", Toast.LENGTH_SHORT).show();
                startActivity(openImpressum);
                finish();
                break;
            }
            case android.R.id.home: {
                Intent openKreisPick = new Intent(MainActivity.this, KreisPickActivity.class);
                Toast.makeText(this, "Schließe Liste des Kreises...", Toast.LENGTH_SHORT).show();
                startActivity(openKreisPick);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
