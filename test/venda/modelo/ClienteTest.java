/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josafams
 */
public class ClienteTest {
    
    public ClienteTest() {
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
     * Test of getEndereco method, of class Cliente.
     */
    @Test
    public void testGetEndereco() {
        System.out.println("getEndereco");
        Cliente instance = new Cliente();
        Endereco expResult = null;
        Endereco result = instance.getEndereco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEndereco method, of class Cliente.
     */
    @Test
    public void testSetEndereco() {
        System.out.println("setEndereco");
        Endereco endereco = null;
        Cliente instance = new Cliente();
        instance.setEndereco(endereco);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isPlanoDeFidelidade method, of class Cliente.
     */
    @Test
    public void testIsPlanoDeFidelidade() {
        System.out.println("isPlanoDeFidelidade");
        Cliente instance = new Cliente();
        boolean expResult = false;
        boolean result = instance.isPlanoDeFidelidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPlanoDeFidelidade method, of class Cliente.
     */
    @Test
    public void testSetPlanoDeFidelidade() {
        System.out.println("setPlanoDeFidelidade");
        boolean planoDeFidelidade = false;
        Cliente instance = new Cliente();
        instance.setPlanoDeFidelidade(planoDeFidelidade);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
