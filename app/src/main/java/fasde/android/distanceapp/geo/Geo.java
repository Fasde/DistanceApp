package fasde.android.distanceapp.geo;

import android.content.Context;
import android.content.SharedPreferences;

public class Geo {

    public static String destCords;

    public static void persistHome(Context context,String coords){
        SharedPreferences settings = context.getSharedPreferences("COORDS", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("homeCoords", coords);
        editor.apply();
    }

    public static String loadPersistedHome(Context context){
        SharedPreferences settings = context.getSharedPreferences("COORDS", 0);
        return settings.getString("homeCoords", "0,0");
    }
}
