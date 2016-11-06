package test.mediatheque.client;

import main.mediatheque.FicheEmprunt;
import main.mediatheque.OperationImpossible;
import main.mediatheque.client.Client;
import main.mediatheque.client.CategorieClient;
import main.util.Datutil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

/**
 * Created by felicien on 06/11/16.
 */
public class ClientTest {
    @Test
    public void clientBasique() {
        CategorieClient categorieClient = new CategorieClient("test");
        Client client;


        //Création client basique
        client = new Client("Michel", "Polnareff");
        Assert.assertEquals("Michel", client.getNom());
        Assert.assertEquals("Polnareff", client.getPrenom());
        Assert.assertEquals(Datutil.dateDuJour(), client.getDateInscription());
        Assert.assertEquals(Datutil.addDate(Datutil.dateDuJour(), 365), client.getDateCotisation());

    }

    @Test
    public void clientCompletSansReduction() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 1000, 10.2, 1.1, 1.2, false);
        Client client = new Client("Michel", "Michelle", "Lala", categorieClient);
        Assert.assertEquals("Michel", client.getNom());
        Assert.assertEquals("Michelle", client.getPrenom());
        Assert.assertEquals("Lala", client.getAdresse());
        Assert.assertEquals(categorieClient, client.getCategorie());
        Assert.assertEquals(Datutil.dateDuJour(), client.getDateInscription());
        Assert.assertEquals(Datutil.addDate(Datutil.dateDuJour(), 365), client.getDateCotisation());
    }

    @Test
    public void clientCompletAvecReduction() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 1000, 10.2, 1.1, 1.2, true);
        Client client = new Client("Michel", "Michelle", "Lala", categorieClient, 20);
        Assert.assertEquals("Michel", client.getNom());
        Assert.assertEquals("Michelle", client.getPrenom());
        Assert.assertEquals("Lala", client.getAdresse());
        Assert.assertEquals(categorieClient, client.getCategorie());
        Assert.assertEquals(Datutil.dateDuJour(), client.getDateInscription());
        Assert.assertEquals(Datutil.addDate(Datutil.dateDuJour(), 365), client.getDateCotisation());
        Assert.assertEquals(client.getReduc(), 20);
    }

    @Test
    public void equals() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 300, 15, 1.4, 1.6, false);
        Client c1 = new Client("Michel", "Michele", "Paris", categorieClient);
        Client c2 = new Client("Michel", "Michele", "Paris", categorieClient);

        Assert.assertTrue(c1.equals(c2) && c2.equals(c1));
        Assert.assertTrue(c1.hashCode() == c2.hashCode());
    }

    @Test
    public void notEquals() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 300, 15, 1.4, 1.6, false);
        Client c1 = new Client("Michel", "MicheleOEIjfzrg", "Paris", categorieClient);
        Client c2 = new Client("Michel", "Michele", "Paris", categorieClient);

        Assert.assertFalse(c1.equals(c2) && c2.equals(c1));
        Assert.assertFalse(c1.hashCode() == c2.hashCode());
    }

    @Test
    public void peutEmprunter() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 300, 15, 1.4, 1.6, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        //client peut toujours emprunter 299.
        Assert.assertTrue(client.peutEmprunter());

    }

    @Test
    public void nePeutPasEmprunter() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 2, 15, 1.4, 1.6, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        client.emprunter();
        //client ne peut plus emprunter
        Assert.assertFalse(client.peutEmprunter());


    }

    @Test
    public void empruntsEnCours() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 2, 15, 1.4, 1.6, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        client.emprunter();
        Assert.assertTrue(client.aDesEmpruntsEnCours());
        Assert.assertEquals(2, client.getNbEmpruntsEnCours());
        Assert.assertEquals(2, client.getNbEmpruntsEffectues());
    }

    @Test
    public void pasEmpruntsEnCours() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 2, 15, 1.4, 1.6, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        Assert.assertFalse(client.aDesEmpruntsEnCours());

    }

    @Test
    public void nbMaxEmprunt() throws OperationImpossible{
        CategorieClient categorieClient = new CategorieClient("Michel", 1000, 10.2, 1, 1, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);

        Assert.assertEquals(1000,client.nbMaxEmprunt());
    }

    @Test
    public void restituer() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 2, 15, 1.4, 1.6, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        client.emprunter();

        client.restituer(false);
        Assert.assertEquals(1, client.getNbEmpruntsEnCours());
        Assert.assertEquals(0, client.getNbEmpruntsEnRetard());
    }

    @Test
    public void emprunterEtRestituerAvecFiche() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 2, 15, 1.4, 1.6, false);

        //Mockito permet de gérer les tests unitaires sans avoir à se préocuper du contenu de la fiche
        FicheEmprunt ficheEmprunt = Mockito.mock(FicheEmprunt.class);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter(ficheEmprunt);

        Assert.assertEquals(1, client.getNbEmpruntsEnCours());

        client.restituer(ficheEmprunt);
        Assert.assertEquals(0, client.getNbEmpruntsEnCours());

    }

    @Test
    public void date() throws OperationImpossible {
        CategorieClient categorieClient = new CategorieClient("Michel", 1000, 10.2, 1, 1, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        Date today = new Date();
        //Sans coef de durée
        Assert.assertEquals(Datutil.addDate(today, 5), client.dateRetour(today, 5));
        Assert.assertEquals(Datutil.addDate(today, 50), client.dateRetour(today, 50));
        Assert.assertEquals(Datutil.addDate(today, 0), client.dateRetour(today, 0));

        //Vérification que le coefficient de durée est bien appliqué

        categorieClient = new CategorieClient("Michel", 1000, 10.2, 1.2, 1.3, false);
        client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        today = new Date();
        Assert.assertNotEquals(Datutil.addDate(today, 5), client.dateRetour(today, 5));
        Assert.assertNotEquals(Datutil.addDate(today, 50), client.dateRetour(today, 50));
        Assert.assertEquals(Datutil.addDate(today, 0), client.dateRetour(today, 0));

    }

    @Test
    public void retard() throws  OperationImpossible{
        CategorieClient categorieClient = new CategorieClient("Michel", 1000, 10.2, 1, 1, false);
        Client client = new Client("Michel", "Michele", "Paris", categorieClient);
        client.emprunter();
        Assert.assertEquals(0, client.getNbEmpruntsEnRetard());
        client.marquer();
        Assert.assertEquals(1,client.getNbEmpruntsEnCours());
        Assert.assertEquals(1, client.getNbEmpruntsEnRetard());
        client.restituer(true);

        Assert.assertEquals(0, client.getNbEmpruntsEnRetard());

    }

    @Test
    public void categorie()throws OperationImpossible{
        Client client = new Client("Michel", "Polnareff");
        CategorieClient categorieClient = new CategorieClient("Michel", 1000, 10.2, 1, 1, true);

        Assert.assertNotEquals(categorieClient,client.getCategorie());

        client.setCategorie(categorieClient);
        Assert.assertEquals(categorieClient,client.getCategorie());

        client.setCategorie(categorieClient,20);
        Assert.assertEquals(20,client.getReduc());

    }




}
