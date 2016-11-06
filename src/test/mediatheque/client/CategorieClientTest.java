package test.mediatheque.client;

import main.mediatheque.client.CategorieClient;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peawai on 06/11/16.
 */
public class CategorieClientTest {

    @Test
    public void emptyConstructorTest() {

        //Création de la catégorie de clients vide
        CategorieClient emptyCatClientTest = new CategorieClient("emptyCatName");

        //Test de la catégorie vide
        Assert.assertEquals("emptyCatName", emptyCatClientTest.getNom());
        Assert.assertEquals(0 ,emptyCatClientTest.getNbEmpruntMax());
        Assert.assertEquals(0 ,emptyCatClientTest.getCotisation(), 0);
        Assert.assertEquals(0, emptyCatClientTest.getCoefDuree(), 0);
        Assert.assertEquals(0, emptyCatClientTest.getCoefTarif(), 0);
        Assert.assertFalse(emptyCatClientTest.getCodeReducUtilise());


    }

    @Test
    public void filledConstructorTest() {

        //Création de la catégorie pleine
        CategorieClient filledCatClientTest = new CategorieClient("filledCatName" , 10, 100, 1000, 10000, true);


        //Test de la catégorie pleine
        Assert.assertEquals("filledCatName", filledCatClientTest.getNom());
        Assert.assertEquals(10 ,filledCatClientTest.getNbEmpruntMax());
        Assert.assertEquals(100 ,filledCatClientTest.getCotisation(), 0);
        Assert.assertEquals(1000, filledCatClientTest.getCoefDuree(), 0);
        Assert.assertEquals(10000, filledCatClientTest.getCoefTarif(), 0);
        Assert.assertTrue(filledCatClientTest.getCodeReducUtilise());



    }


    @Test
    public void testModifiyingCatClient(){

        //on crée une catégorie de client vide
        CategorieClient emptyCatClientTest = new CategorieClient("emptyCatName");

        //On applique les fonctions de modifications
        emptyCatClientTest.modifierNom("filledCatName");
        emptyCatClientTest.modifierMax(10);
        emptyCatClientTest.modifierCotisation(100);
        emptyCatClientTest.modifierCoefDuree(1000);
        emptyCatClientTest.modifierCoefTarif(10000);
        emptyCatClientTest.modifierCodeReducActif(true);

        //On test les modifications
        Assert.assertEquals("filledCatName", emptyCatClientTest.getNom());
        Assert.assertEquals(10 ,emptyCatClientTest.getNbEmpruntMax());
        Assert.assertEquals(100 ,emptyCatClientTest.getCotisation(), 0);
        Assert.assertEquals(1000, emptyCatClientTest.getCoefDuree(), 0);
        Assert.assertEquals(10000, emptyCatClientTest.getCoefTarif(), 0);
        Assert.assertTrue(emptyCatClientTest.getCodeReducUtilise());

    }

    @Test
    public void testEquals(){

        CategorieClient a = new CategorieClient("emptyCatName");
        CategorieClient b = new CategorieClient("emptyCatName");

        //Après création a = b, on test donc le equals
        Assert.assertTrue(a.equals(b));

    }

    @Test
    public void testHash(){

        CategorieClient a = new CategorieClient("emptyCatName");
        CategorieClient b = new CategorieClient("emptyCatName");

        //Après création a = b, on test donc le equals
        Assert.assertTrue(a.hashCode()==b.hashCode());

    }

    @Test
    public void testToString(){

        CategorieClient a = new CategorieClient("emptyCatName");


        //Après création a on test toString
        Assert.assertEquals(a.toString(), "emptyCatName");

    }


}
