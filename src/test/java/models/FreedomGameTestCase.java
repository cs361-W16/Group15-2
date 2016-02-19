package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class FreedomGameTestCase {

    @Test
    public void testGameCreation(){
        FreedomGame g = new FreedomGame();
        assertNotNull(g);
    }

    @Test
    public void testAmericanGameBuildDeck(){
        FreedomGame g = new FreedomGame();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testAmericanGameInit(){
        FreedomGame unshuffled = new FreedomGame();
        unshuffled.buildDeck();

        FreedomGame shuffled = new FreedomGame();
        shuffled.buildDeck();
        shuffled.shuffle();

        // Compare each card in both decks
        int matches = 0;
        int size = unshuffled.deck.size();
        for(int i = 0; i < size; i++){
            Card unshuffledCard = unshuffled.deck.get(i);
            Card shuffledCard = shuffled.deck.get(i);

            Suit unshuffledSuit = unshuffledCard.getSuit();
            int unshuffledVal = unshuffledCard.getValue();
            Suit shuffledSuit = shuffledCard.getSuit();
            int shuffledVal = shuffledCard.getValue();

            if(unshuffledSuit == shuffledSuit && unshuffledVal == shuffledVal){
                matches++;
            }
        }

        // Ensure that shuffled deck is at least 85% unique
        assertTrue((matches / size) <= 0.15);
    }

    @Test
    public void testAmericanGameStart(){
        FreedomGame g = new FreedomGame();
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
        FreedomGame g = new FreedomGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2clubs",g.cols.get(0).get(0).toString());
        assertEquals("3clubs",g.cols.get(1).get(0).toString());
        assertEquals("4clubs",g.cols.get(2).get(0).toString());
        assertEquals("5clubs",g.cols.get(3).get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        FreedomGame g = new FreedomGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }



}
