package fasde.android.distanceapp.UnitTests;

import org.junit.Test;

import fasde.android.distanceapp.Model.Kreis;
import fasde.android.distanceapp.Model.Spielort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SpielortUnitTest {

    @Test
    public void test_Spielort_AndGetters(){
        Spielort spielort = new Spielort("Ort", 42, Kreis.EL_MITTE, "Here");
        assertEquals("Ort", spielort.getSpielort());
        assertEquals(42, spielort.getDistanz());
        assertEquals(42 * 2 * 0.30, spielort.getKosten().doubleValue(), 0.001);
        assertEquals(Kreis.EL_MITTE, spielort.getKreis());
        assertEquals("Here", spielort.getAdresse());
    }

    @Test
    public void test_toString(){
        Spielort spielort = new Spielort("Ort", 42, Kreis.EL_MITTE, "Here");
        String string = "Ort\nEL-Mitte\t\t--\t\t42km\t\t--\t\t25.20€";
        assertEquals(string, spielort.toString());
    }

    @Test
    public void test_toStringArray(){
        Spielort spielort = new Spielort("Ort", 42, Kreis.EL_MITTE, "Here,Street");
        String[] array = {"Ort", "42", "25.20", "EL-Mitte", "Here", "Street"};
        assertArrayEquals(array, spielort.toStringArray());
    }
}
