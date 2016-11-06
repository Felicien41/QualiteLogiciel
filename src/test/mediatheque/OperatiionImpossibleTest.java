package test.mediatheque;

import main.mediatheque.OperationImpossible;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by peawai on 06/11/16.
 */
public class OperatiionImpossibleTest {

    @Test
    public void constructorTest(){

        OperationImpossible opTest= new OperationImpossible("testmessage");

        Assert.assertEquals(opTest.getMessage(),"testmessage");

    }
}
