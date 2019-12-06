package fasde.android.distanceapp.Views;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = new Intent(this, KreisPickActivity.class);
        startActivity(intent);
        finish();
    }
}
