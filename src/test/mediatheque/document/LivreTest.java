package test.mediatheque.document;

import main.mediatheque.Genre;
import main.mediatheque.Localisation;
import main.mediatheque.document.Livre;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by felicien on 06/11/16.
 */
public class LivreTest {
    Livre livre;
    Localisation localisation;
    Genre genre;
    String code = "ergoiej";
    String titre = "titre";
    String auteur = "auteur";
    String annee = "2016";
    int nbpage = 100;



    @Before
    public void setUp() throws Exception {
        localisation = new Localisation("salle", "rayon");
        genre = new Genre("genre");
        livre = new Livre(code, localisation, titre, auteur, annee, genre, nbpage);

    }

    @Test
    public void constructeur() {
        //Le setup @Before fait appel au constructeur, on peut donc tester directement les informations qui en ressortent
        Assert.assertEquals(livre.getCode(), code);
        Assert.assertEquals(livre.getLocalisation(), localisation);
        Assert.assertEquals(livre.getTitre(), titre);
        Assert.assertEquals(livre.getAuteur(), auteur);
        Assert.assertEquals(livre.getAnnee(), annee);
        Assert.assertEquals(livre.getGenre(), genre);
        Assert.assertEquals(livre.estEmpruntable(), false);
    }

    @Test
    public void emprunter() throws Exception {
        livre.metEmpruntable();
        Assert.assertEquals(livre.getNbEmprunts(), 0);
        Assert.assertTrue(livre.emprunter());
        Assert.assertEquals(livre.getNbEmprunts() , 1);
        Assert.assertEquals(livre.dureeEmprunt() , 42); //6 semaines
        Assert.assertEquals(livre.tarifEmprunt(), 0.5);

    }
}