package test.mediatheque.document;

import main.mediatheque.Genre;
import main.mediatheque.Localisation;
import main.mediatheque.document.Audio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by felicien on 06/11/16.
 */
public class AudioTest {
    Audio audio;
    Localisation localisation;
    Genre genre;
    String code = "ergoiej";
    String titre = "titre";
    String auteur = "auteur";
    String annee = "2016";
    String classification = "classification";



    @Before
    public void setUp() throws Exception {
        localisation = new Localisation("salle", "rayon");
        genre = new Genre("genre");
        audio = new Audio(code, localisation, titre, auteur, annee, genre, classification);

    }

    @Test
    public void constructeur() {
        //Le setup @Before fait appel au constructeur, on peut donc tester directement les informations qui en ressortent
        Assert.assertEquals(audio.getCode(), code);
        Assert.assertEquals(audio.getLocalisation(), localisation);
        Assert.assertEquals(audio.getTitre(), titre);
        Assert.assertEquals(audio.getAuteur(), auteur);
        Assert.assertEquals(audio.getAnnee(), annee);
        Assert.assertEquals(audio.getGenre(), genre);
        Assert.assertEquals(audio.getClassification(), classification);
        Assert.assertEquals(audio.estEmpruntable(), false);
    }

    @Test
    public void emprunter() throws Exception {
        audio.metEmpruntable();
        Assert.assertEquals(audio.getNbEmprunts(), 0);
        Assert.assertTrue(audio.emprunter());
        Assert.assertEquals(audio.getNbEmprunts() , 1);
        Assert.assertEquals(audio.dureeEmprunt() , 28); //4 semaines
        Assert.assertTrue(audio.tarifEmprunt()== 1.0);

    }
}