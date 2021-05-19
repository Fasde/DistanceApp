package fasde.android.distanceapp.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import fasde.android.distanceapp.geo.Geo;

/**
 * LoadingScreen for DistanceApp
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Creates a screen, that showes an image of a soccer pitch as starting screen.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, GeoActivity.class);
        startActivity(intent);
        finish();
    }
}
