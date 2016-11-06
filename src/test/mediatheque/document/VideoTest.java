package test.mediatheque.document;

import main.mediatheque.Genre;
import main.mediatheque.Localisation;
import main.mediatheque.document.Video;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by felicien on 06/11/16.
 */
public class VideoTest {
    Video video;
    Localisation localisation;
    Genre genre;
    String code = "ergoiej";
    String titre = "titre";
    String auteur = "auteur";
    String annee = "2016";
    int dureefilm=123;
    String mentionLegale="mentionLegale";
    @Before
    public void setUp() throws Exception {
        localisation = new Localisation("salle", "rayon");
        genre = new Genre("genre");
        video = new Video(code, localisation, titre, auteur, annee, genre, dureefilm, mentionLegale);

    }

    @Test
    public void constructeur() {
        //Le setup @Before fait appel au constructeur, on peut donc tester directement les informations qui en ressortent
        Assert.assertEquals(video.getCode(), code);
        Assert.assertEquals(video.getLocalisation(), localisation);
        Assert.assertEquals(video.getTitre(), titre);
        Assert.assertEquals(video.getAuteur(), auteur);
        Assert.assertEquals(video.getAnnee(), annee);
        Assert.assertEquals(video.getGenre(), genre);
        Assert.assertEquals(video.getDureeFilm(),dureefilm);
        Assert.assertEquals(video.getMentionLegale(),mentionLegale);
        Assert.assertEquals(video.estEmpruntable(), false);
    }

    @Test
    public void emprunter() throws Exception {
        video.metEmpruntable();
        Assert.assertEquals(video.getNbEmprunts(), 0);
        Assert.assertTrue(video.emprunter());
        Assert.assertEquals(video.getNbEmprunts() , 1);
        Assert.assertEquals(video.dureeEmprunt() , 14); //2 semaines
        Assert.assertTrue(video.tarifEmprunt()== 1.5);

    }

    @Test
    public void getMentionLegale() throws Exception {
        Assert.assertEquals(mentionLegale,video.getMentionLegale());
    }

}