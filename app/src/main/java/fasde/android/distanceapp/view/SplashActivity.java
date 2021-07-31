package fasde.android.distanceapp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;

/**
 * LoadingScreen for DistanceApp
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this, initializationStatus -> System.out.println("Ads initialized!"));
        Intent intent = new Intent(this, GeoActivity.class);
        intent.putExtra("Dest", "Start");
        startActivity(intent);
        finish();
    }
}
