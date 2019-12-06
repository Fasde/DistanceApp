package fasde.android.distanceapp.Types;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO for a Spielort.
 */
public class Spielort {

    private String spielort;
    private int distanz;
    private BigDecimal kosten;
    private Kreis kreis;
    private String adresse;

    public Spielort(String spielort, int distanz, Kreis kreis, String adresse) {
        this.spielort = spielort;
        this.distanz = distanz;
        this.kosten = new BigDecimal(distanz * 0.30 * 2).setScale(2, RoundingMode.HALF_DOWN);
        this.kreis = kreis;
        this.adresse = adresse;
    }

    public String getSpielort() {
        return spielort;
    }

    public int getDistanz() {
        return distanz;
    }

    public BigDecimal getKosten() {
        return kosten;
    }

    public Kreis getKreis() {
        return kreis;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    @NonNull
    public String toString() {
        return this.getSpielort() + "\n" + this.getKreis().getName() + "\t\t--\t\t" + this.getDistanz() + "km" + "\t\t--\t\t" + this.getKosten() + "€";
    }

    public String[] toStringArray() {
        String[] adress = this.getAdresse().split(",");
        return new String[]{this.getSpielort(), Integer.toString(this.getDistanz()), this.kosten.toString(), this.getKreis().getName(), adress[0], adress[1]};
    }
}
