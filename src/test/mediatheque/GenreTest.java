package test.mediatheque;

import main.mediatheque.Genre;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peawai on 06/11/16.
 */
public class GenreTest {


    @Test
    public void constructorTest() {

        Genre gtest = new Genre("testName");

        Assert.assertEquals("testName", gtest.getNom());
        Assert.assertEquals(1, gtest.getNbEmprunts());
    }


    @Test
    public void emprunterTest(){


        //Création de genre et emprunt
        Genre gtest = new Genre("testName");
        gtest.emprunter();


        //test de l'addition au compteur
        Assert.assertEquals(2, gtest.getNbEmprunts());

    }

    @Test
    public void equalsTest(){


        //Création de genre
        Genre gtest = new Genre("tName");
        Genre gtest2 = new Genre("testName");

        //TEST DE EQUALS

        Assert.assertTrue(gtest.equals(gtest));
        Assert.assertFalse(gtest.equals(gtest2));

    }

    @Test
    public void hashCodeTest(){

        //Création de genre
        Genre gtest = new Genre("tName");
        Genre gtest2 = new Genre("testName");

        //test de hashcode

        Assert.assertEquals(gtest.hashCode(),gtest.hashCode());
        Assert.assertNotEquals(gtest.hashCode(),gtest2.hashCode());

    }


    @Test
    public void toStringTest(){

        //Création de genre
        Genre gtest = new Genre("tName");

        //Test de tostring
        Assert.assertEquals(gtest.toString(),"Genre: tName, nbemprunts:1");


    }


    @Test
    public void modifierTest(){

        //Création de genre et modification
        Genre gtest = new Genre("tName");
        gtest.modifier("name");

        //test de la modification
        Assert.assertEquals(gtest.getNom(),"name");


    }




}
