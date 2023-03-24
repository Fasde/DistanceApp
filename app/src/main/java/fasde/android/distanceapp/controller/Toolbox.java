package fasde.android.distanceapp.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import fasde.android.distanceapp.R;
import fasde.android.distanceapp.view.GeoActivity;
import fasde.android.distanceapp.view.ImpressumActivity;
import fasde.android.distanceapp.view.KreisPickActivity;
import fasde.android.distanceapp.view.ListViewActivity;
import fasde.android.distanceapp.view.RefereeActivity;
import fasde.android.distanceapp.view.SpielortDetailActivity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Toolbox {

    public void killAllToasts() {
        ListViewActivity.killToast();
        SpielortDetailActivity.killToast();
        ImpressumActivity.killToast();
        KreisPickActivity.killToast();
        GeoActivity.killToast();
    }
}
