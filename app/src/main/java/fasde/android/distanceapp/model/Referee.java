package fasde.android.distanceapp.model;

import androidx.annotation.Nullable;

import lombok.Getter;

public class Referee {

    @Getter
    @lombok.NonNull
    private final String name;

    @Getter
    @lombok.NonNull
    private final String adresse;

    @Nullable
    public String getEmail() {
        if(email == null) return "";
        return email;
    }

    @Nullable
    public String getTelNr() {
        if(telNr == null) return "";
        return telNr;
    }

    @Nullable
    private final String email;

    @Nullable
    private final String telNr;


    public Referee(@androidx.annotation.NonNull String name, @androidx.annotation.NonNull String adresse, @Nullable String email, @Nullable String telNr) {
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.telNr = telNr;
    }

    @Override
    @androidx.annotation.NonNull
    public String toString() {
        return this.getName() + "\t\t--\t\t";
    }

    public String[] toStringArray() {
        String[] adress = this.getAdresse().split(",");
        return new String[]{this.getName(), adress[0], adress[1], this.getEmail(), this.getTelNr()};
    }
}
