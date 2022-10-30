/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leon
 */
public class DBIOTest {
    
    public DBIOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of getnameList method, of class DBIO.
     */
    @Test
    public void testGetnameList() {
        System.out.println("getnameList");
        String oname = "Jake";
        DBIO instance = new DBIO();
        String expResult = "Jordan";
        ArrayList<String> result = instance.getnameList(oname);
        assertEquals(expResult, result.get(0));
        // Should return Jordan
    }



    /**
     * Test of updatemood method, of class DBIO.
     */
    @Test
    public void testUpdatemood() {
        System.out.println("updatemood");
        String oname = "Jake";
        String pname = "Jordan";
        int mood = 100;
        Integer expResult = 100;
        DBIO instance = new DBIO();
        instance.updatemood(oname, pname, mood);
        ArrayList<Integer> result = instance.getmoodList(oname);
        assertEquals(expResult, result.get(0));
        // should be 100
    }

    /**
     * Test of changetype method, of class DBIO.
     */
    @Test
    public void testChangetype() {
        System.out.println("changetype");
        String oname = "Jake";
        String pname = "Jordan";
        int type = 2;
        Integer expResult = 2;
        DBIO instance = new DBIO();
        instance.changetype(oname, pname, type);
        ArrayList<Integer> result = instance.gettypeList(oname);
        assertEquals(expResult, result.get(0));
        // should be 2 instead of 1
    }

    /**
     * Test of delete method, of class DBIO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String oname = "Jake";
        String pname = "Jordan";
        String expResult = "Paige";
        DBIO instance = new DBIO();
        instance.delete(oname, pname);
        ArrayList<String> result = instance.getnameList(oname);
        assertEquals(expResult, result.get(0));
        // should get pet name Paige for first pet
        instance.delete(oname, expResult);
        instance.newsave(oname, pname, 1, 0);
        instance.newsave(oname, expResult, 2, 80);
    }





    
}
