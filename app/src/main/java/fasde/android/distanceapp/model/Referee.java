package fasde.android.distanceapp.model;

import lombok.Getter;
import lombok.NonNull;

public class Referee {

    @Getter
    @lombok.NonNull
    private String name;

    @Getter
    @lombok.NonNull
    private String adresse;


    public Referee(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    @Override
    @androidx.annotation.NonNull
    public String toString() {
        return this.getName() + "\t\t--\t\t";
    }

    public String[] toStringArray() {
        String[] adress = this.getAdresse().split(",");
        return new String[]{this.getName(), adress[0], adress[1]};
    }
}
