package fasde.android.distanceapp.database;

import fasde.android.distanceapp.view.ImpressumActivity;
import fasde.android.distanceapp.view.KreisPickActivity;
import fasde.android.distanceapp.view.MainActivity;
import fasde.android.distanceapp.view.SpielortDetailActivity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Toolbox {

    public void killAllToasts() {
        MainActivity.killToast();
        SpielortDetailActivity.killToast();
        ImpressumActivity.killToast();
        KreisPickActivity.killToast();
    }
}
