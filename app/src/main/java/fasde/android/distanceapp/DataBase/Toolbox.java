package fasde.android.distanceapp.DataBase;

import fasde.android.distanceapp.View.ImpressumActivity;
import fasde.android.distanceapp.View.KreisPickActivity;
import fasde.android.distanceapp.View.MainActivity;
import fasde.android.distanceapp.View.SpielortDetailActivity;
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
