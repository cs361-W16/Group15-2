package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class AmericanGameTestCase {

    @Test
    public void testGameCreation(){
        AmericanGame g = new AmericanGame();
        assertNotNull(g);
    }

    @Test
    public void testAmericanGameBuildDeck(){
        AmericanGame g = new AmericanGame();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testAmericanGameInit(){
        AmericanGame g = new AmericanGame();
        g.buildDeck();
        g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testAmericanGameStart(){
        AmericanGame g = new AmericanGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }

    @Test
    public void testCustomDeal(){
        AmericanGame g = new AmericanGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2clubs",g.cols.get(0).get(0).toString());
        assertEquals("3clubs",g.cols.get(1).get(0).toString());
        assertEquals("4clubs",g.cols.get(2).get(0).toString());
        assertEquals("5clubs",g.cols.get(3).get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        AmericanGame g = new AmericanGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }



}
