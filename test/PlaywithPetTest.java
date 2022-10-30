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
public class PlaywithPetTest {
    
    public PlaywithPetTest() {
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
     * Test of playwith method, of class PlaywithPet.
     */
    @Test
    public void testPlaywith() {
        System.out.println("playwith");
        Animal Pet = new Cat("Garfield");
        PlaywithPet instance = new PlaywithPet(); // default status/mood should be 50
        instance.playwith(Pet); // increases by 10
        assertEquals(60, Pet.getStatus());
        // should be 60
        
    }
    
}
