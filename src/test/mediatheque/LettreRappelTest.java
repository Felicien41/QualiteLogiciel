package test.mediatheque;

import main.mediatheque.*;
import main.mediatheque.client.CategorieClient;
import main.mediatheque.client.Client;
import main.mediatheque.document.Audio;
import main.mediatheque.document.Livre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by felicien on 06/11/16.
 */
public class LettreRappelTest {
    String nomMedia = "audio";

    String code = "1523bd";
    String titre = "titre";
    String auteur = "auteur";
    String annee = "1999";
    Localisation localisation;
    Genre genre;
    String classification = "classification";

    FicheEmprunt ficheEmprunt;

    @Before
    public void setUp() throws Exception {

        Localisation localisation = new Localisation("salle", "rayon");

        Genre genre = new Genre("BD");
        int nombrePage = 252;

        Mediatheque mediatheque = new Mediatheque("mediatheque");
        Client client = new Client("Michel", "Michcmic", "ici", new CategorieClient("Lala", 200, 54, 2.5, 1.5, true), 10);
        Audio audio = new Audio(code, localisation, titre, auteur, annee, genre, classification);
        audio.metEmpruntable();

        ficheEmprunt = new FicheEmprunt(mediatheque, client, audio);
    }

}