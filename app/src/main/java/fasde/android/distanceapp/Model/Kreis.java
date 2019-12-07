package fasde.android.distanceapp.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Kreis {

    EL_NORD("EL-Nord", "NFV"),
    EL_MITTE("EL-Mitte", "NFV"),
    EL_SUED("EL-Süd", "NFV"),
    GRAFSCHAFT("Grafschaft", "NFV"),
    OSTFRIESLAND("Ostfriesland", "NFV"),
    CLP("Cloppenburg", "NFV"),
    OSNA("Osnabrück", "NFV");

    @Getter
    String name;
    @Getter
    String verband;

    /**
     * This method iterates over all elements of the above declared Enum Kreise, and checks for
     * each of them, if the param 'kreisName' matches the element's name. If this is the case,
     * the checked element is returned. If none matches, null is returned.
     *
     * @param kreisName
     * @return Kreis
     */
    public static Kreis getForName(String kreisName){
        for(Kreis kreis : Kreis.values()){
            if(kreis.getName().equals(kreisName)){
                return kreis;
            }
        }
        return null;
    }
}
