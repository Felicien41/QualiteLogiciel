package test.mediatheque;

import main.mediatheque.Localisation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peawai on 06/11/16.
 */
public class LocalisationTest {

    @Test
    public void constructorTest{

        Localisation locTest= new Localisation("salle","rayon");

        Assert.assertEquals("salle",locTest.getSalle());
        Assert.assertEquals("rayon",locTest.getRayon());


    }
}
