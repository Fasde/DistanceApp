package fasde.android.distanceapp.UnitTests;

import org.junit.Test;

import java.util.ArrayList;

import fasde.android.distanceapp.Controller.SpielortAdapter;
import fasde.android.distanceapp.Model.Spielort;

import static org.junit.Assert.assertEquals;

public class AdapterUnitTest {


    @Test
    public void testConstructor() {
        ArrayList<Spielort> spielorts = new ArrayList<>();
        SpielortAdapter spielortAdapter = new SpielortAdapter(null, spielorts);
        assertEquals(spielorts, spielortAdapter.getSpielortList());
    }

    @Test
    public void testElementCount_getCount() {
        ArrayList<Spielort> spielorts = new ArrayList<>();
        spielorts.add(new Spielort(null, 0, null, null));
        SpielortAdapter spielortAdapter = new SpielortAdapter(null, spielorts);
        assertEquals(1, spielortAdapter.getCount());
    }

    @Test
    public void test_getFilter() {
        ArrayList<Spielort> spielorts = new ArrayList<>();
        SpielortAdapter spielortAdapter = new SpielortAdapter(null, spielorts);
        assertEquals(spielortAdapter.getFilter(), spielortAdapter.getFilter());
    }

    @Test
    public void test_getItem() {
        ArrayList<Spielort> spielorts = new ArrayList<>();
        Spielort spielort = new Spielort(null, 0, null, null);
        spielorts.add(spielort);
        SpielortAdapter spielortAdapter = new SpielortAdapter(null, spielorts);
        assertEquals(spielort, spielortAdapter.getItem(0));
    }


}
