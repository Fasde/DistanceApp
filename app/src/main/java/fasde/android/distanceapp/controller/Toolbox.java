package fasde.android.distanceapp.controller;

import fasde.android.distanceapp.view.GeoActivity;
import fasde.android.distanceapp.view.ImpressumActivity;
import fasde.android.distanceapp.view.KreisPickActivity;
import fasde.android.distanceapp.view.ListViewActivity;
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
