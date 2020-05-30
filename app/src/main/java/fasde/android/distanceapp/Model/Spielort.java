package fasde.android.distanceapp.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;

/**
 * POJO for a Spielort.
 */

public class Spielort {

    @Getter
    @lombok.NonNull
    private String spielort;
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

    public Spielort(String spielort, int distanz, Kreis kreis, String adresse) {
        this.spielort = spielort;
        this.distanz = distanz;
        this.kosten = new BigDecimal(distanz * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        this.kreis = kreis;
        this.adresse = adresse;
    }

    @Override
    @androidx.annotation.NonNull
    public String toString() {
        return this.getSpielort() + "\n" + this.getKreis().getName() + "\t\t--\t\t" + this.getDistanz() + "km" + "\t\t--\t\t" + this.getKosten() + "€";
    }

    public String[] toStringArray() {
        String[] adress = this.getAdresse().split(",");
        return new String[]{this.getSpielort(), Integer.toString(this.getDistanz()), this.kosten.toString(), this.getKreis().getName(), adress[0], adress[1]};
    }
}
