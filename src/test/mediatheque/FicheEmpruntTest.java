package test.mediatheque;

import main.mediatheque.FicheEmprunt;
import main.mediatheque.Genre;
import main.mediatheque.Localisation;
import main.mediatheque.Mediatheque;
import main.mediatheque.client.CategorieClient;
import main.mediatheque.client.Client;
import main.mediatheque.document.Document;
import main.mediatheque.document.Livre;
import main.util.Datutil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by felicien on 06/11/16.
 */
public class FicheEmpruntTest {

    FicheEmprunt ficheEmprunt;
    Document document;
    Client client;
    CategorieClient categorieClient;

    @Before
    public void setUp() throws Exception {
        String code = "zjreogijerg";
        Localisation localisation = new Localisation("cuisine", "rayon");
        String titre = "HP";
        String auteur = "JKR";
        String annee = "1995";
        Genre genre = new Genre("Style");
        categorieClient = new CategorieClient("Michel", 300, 14.2, 1.3, 1.2, false);
        client = new Client("Michel", "Polnareff", "Ici", categorieClient);
        document = new Livre(code, localisation, titre, auteur, annee, genre,100);
        document.metEmpruntable();

        ficheEmprunt = new FicheEmprunt(new Mediatheque("mediatheque"), client, document);

    }

    @Test
    public void constructeur(){
        Assert.assertEquals(client, ficheEmprunt.getClient());
        Assert.assertEquals(Datutil.dateDuJour(), ficheEmprunt.getDateEmprunt());
        Assert.assertEquals(client.dateRetour(Datutil.dateDuJour(), document.dureeEmprunt()), ficheEmprunt.getDateLimite());
        Assert.assertEquals(false, ficheEmprunt.getDepasse());
        Assert.assertEquals(document, ficheEmprunt.getDocument());
        Assert.assertEquals(document.getNbEmprunts(), 1);
        Assert.assertEquals(client.getNbEmpruntsEffectues(), 1);
    }

    @Test
    public void verifier() throws Exception {

        ficheEmprunt.verifier();
        Assert.assertFalse(ficheEmprunt.getDepasse());

    }

    @Test
    public void modifierClient() throws Exception {
        Client newClient = new Client("Bernard","Lala");
        ficheEmprunt.modifierClient(newClient);

        Assert.assertEquals(newClient,ficheEmprunt.getClient());
    }

    @Test
    public void correspond() throws Exception {
        Assert.assertTrue(ficheEmprunt.correspond(client, document));

    }


    @Test
    public void getDepasse() throws Exception {
        Assert.assertEquals(false,ficheEmprunt.getDepasse());
    }

    @Test
    public void getDureeEmprunt() throws Exception {
        Assert.assertEquals((int) ((ficheEmprunt.getDateLimite().getTime () - ficheEmprunt.getDateEmprunt().getTime ()) / (1000 * 60 * 60 * 24)), ficheEmprunt.getDureeEmprunt());

    }


    @Test
    public void afficherStatistiques() throws Exception {

    }

}