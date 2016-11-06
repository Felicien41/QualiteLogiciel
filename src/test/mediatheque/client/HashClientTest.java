package test.mediatheque.client;

import main.mediatheque.client.HashClient;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peawai on 06/11/16.
 */
public class HashClientTest {

    @Test
    public void contructorTest()
    {
        HashClient hcTest= new HashClient("lastName","firstName");

        Assert.assertEquals(hcTest.getNom(),"lastName");
        Assert.assertEquals(hcTest.getPrenom(),"firstName");
    }

    @Test
    public void equalsTest(){

        HashClient a= new HashClient("lastName","firstName");
        HashClient b= new HashClient("Name","firstName");


        Assert.assertTrue(a.equals(a));
        Assert.assertFalse(a.equals(b));
    }


    @Test
    public void hashcodeTest(){

        HashClient a= new HashClient("lastName","firstName");
        HashClient b= new HashClient("Name","firstName");

        Assert.assertEquals(a.hashCode(),a.hashCode());
        Assert.assertNotEquals(a.hashCode(),b.hashCode());

    }

}
