/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

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
public class SavePetTest {
    
    public SavePetTest() {
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
     * Test of classType method, of class SavePet.
     */
    @Test
    public void testClassType() {
        System.out.println("classType");
        Animal input = new Cat("Garfield");
        SavePet instance = new SavePet();
        int expResult = 2;
        int result = instance.classType(input);
        assertEquals(expResult, result);
        System.out.println("exp:" + expResult + " actual:"+ result);
        // should be cat class
    }
    
}
