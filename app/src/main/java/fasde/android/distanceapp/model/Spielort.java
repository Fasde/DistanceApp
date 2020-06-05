package fasde.android.distanceapp.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;

/**
 * POJO for a Spielort.
 */

public class Spielort {

    @Getter
    @lombok.NonNull
    private String ortsName;
    @Getter
    private int distanz;
    @Getter
    @lombok.NonNull
    private BigDecimal kosten;
    @Getter
    @lombok.NonNull
    private Kreis kreis;
    @Getter
    @lombok.NonNull
    private String adresse;

    public Spielort(String ortsName, int distanz, Kreis kreis, String adresse) {
        this.ortsName = ortsName;
        this.distanz = distanz;
        this.kosten = BigDecimal.valueOf(distanz * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        this.kreis = kreis;
        this.adresse = adresse;
    }

    @Override
    @androidx.annotation.NonNull
    public String toString() {
        return this.getOrtsName() + "\n" + this.getKreis().getName() + "\t\t--\t\t" + this.getDistanz() + "km" + "\t\t--\t\t" + this.getKosten() + "€";
    }

    public String[] toStringArray() {
        String[] adress = this.getAdresse().split(",");
        return new String[]{this.getOrtsName(), Integer.toString(this.getDistanz()), this.kosten.toString(), this.getKreis().getName(), adress[0], adress[1]};
    }
}
