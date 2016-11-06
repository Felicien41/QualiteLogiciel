package test.mediatheque;

import main.mediatheque.Localisation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peawai on 06/11/16.
 */
public class LocalisationTest {


    @Test
    public void toStringTest() throws Exception {

        Localisation locTest= new Localisation("salle","rayon");

        Assert.assertEquals(locTest.toString(),"Salle/Rayon : salle/rayon");

    }

    @Test
    public void hashCodeTest() throws Exception {

        Localisation locTest= new Localisation("salle","rayon");
        Localisation locTest2= new Localisation("salle2","rayon2");

        Assert.assertEquals(locTest.hashCode(),locTest.hashCode());
        Assert.assertNotEquals(locTest.hashCode(),locTest2.hashCode());


    }

    @Test
    public void equalsTest() throws Exception {

        Localisation locTest= new Localisation("salle","rayon");
        Localisation locTest2= new Localisation("salle2","rayon2");

        Assert.assertTrue(locTest.equals(locTest));
        Assert.assertFalse(locTest2.equals(locTest));


    }

    @Test
    public void constructorTest(){

        Localisation locTest= new Localisation("salle","rayon");

        Assert.assertEquals("salle",locTest.getSalle());
        Assert.assertEquals("rayon",locTest.getRayon());
    }

}
