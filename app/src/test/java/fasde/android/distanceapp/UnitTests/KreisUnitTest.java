package fasde.android.distanceapp.UnitTests;

import org.junit.Test;

import fasde.android.distanceapp.model.Kreis;

import static org.junit.Assert.assertEquals;

public class KreisUnitTest {


    @Test
    public void test_getForName_Grafschaft() {
        assertEquals(Kreis.GRAFSCHAFT, Kreis.getForName("Grafschaft"));
    }

    @Test
    public void test_getForName_Ostfriesland() {
        assertEquals(Kreis.OSTFRIESLAND, Kreis.getForName("Ostfriesland"));
    }

    @Test
    public void test_getForName_Cloppenburg() {
        assertEquals(Kreis.CLP, Kreis.getForName("Cloppenburg"));
    }


    @Test
    public void test_Verband(){
        Kreis[] kreise = Kreis.values();
        for(Kreis kreis: kreise){
            assertEquals("NFV", kreis.getVerband());
        }
    }
}
