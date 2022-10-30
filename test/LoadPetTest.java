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
public class LoadPetTest {
    
    public LoadPetTest() {
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
    publi    }

    /**
     * Test of nameslist method, of class LoadPet.
     */
    @Test
    public void testNameslist() {
        System.out.println("nameslist");
        String oname = "";
        LoadPet instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.nameslist(oname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class LoadPet.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        int index = 0;
        String oname = "";
        LoadPet instance = null;
        Animal expResult = null;
        Animal result = instance.load(index, oname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadPet method, of class LoadPet.
     */
    @Test
    public void testLoadPet() throws Exception {
        System.out.println("loadPet");
        LoadPet instance = null;
        Animal expResult = null;
        Animal result = instance.loadPet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
c void tearDown() {
    }
    
}
