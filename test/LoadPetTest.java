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
    public void tearDown() {
    }

    /**
     * Test of nameslist method, of class LoadPet.
     */
    @Test
    public void testNameslist() {
        System.out.println("nameslist");
        String oname = "Jake";
        LoadPet instance = new LoadPet();
        String expResult = "Jordan";
        ArrayList<String> result = instance.nameslist(oname);
        assertEquals(expResult, result.get(0));
        // Should get jordan from nameslist index 0 from db

    }

    /**
     * Test of load method, of class LoadPet.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        int index = 0;
        String oname = "Jake";
        LoadPet instance = new LoadPet();
        Animal expResult = new Cat("Jordan");
        Animal result = instance.load(index, oname);
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getClass(), result.getClass());
        
    }
    
}
