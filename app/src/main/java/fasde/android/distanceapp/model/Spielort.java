package fasde.android.distanceapp.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;
import lombok.NonNull;

/**
 * POJO for a Spielort.
 */

public class Spielort {

    @Getter
    @lombok.NonNull
    private String ortsName;
    @Getter
    @lombok.NonNull
    private Kreis kreis;
    @Getter
    @lombok.NonNull
    private String adresse;
    @Getter
    @NonNull
    private String geoString;

    public Spielort(String ortsName, Kreis kreis, String adresse, String geoString) {
        this.ortsName = ortsName;
        this.kreis = kreis;
        this.adresse = adresse;
        this.geoString = geoString;
    }

    @Override
    @androidx.annotation.NonNull
    public String toString() {
        return this.getOrtsName() + "\n" + this.getKreis().getName() + "\t\t--\t\t";
    }

    public String[] toStringArray() {
        String[] adress = this.getAdresse().split(",");
        return new String[]{this.getOrtsName(), this.getKreis().getName(), adress[0], adress[1].substring(1)};
    }
}
