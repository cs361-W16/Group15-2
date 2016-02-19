package models;

import org.junit.Test;

import static org.junit.Assert.*;



public class SpanishGameTestCase {

	@Test
	public void testSpanishGameCreation() {
		SpanishGame g = new SpanishGame();
		assertNotNull(g);
	}


	@Test
	public void testSpanishGameBuildDeck() {
		SpanishGame g = new SpanishGame();
        g.buildDeck();
        assertEquals(40, g.deck.size());
	}


	@Test
    public void testSpanishGameInit(){
        SpanishGame unshuffled = new SpanishGame();
        unshuffled.buildDeck();

        SpanishGame shuffled = new SpanishGame();
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
    public void testSpanishGameStart(){
        SpanishGame g = new SpanishGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }


    @Test
    public void testSpanishGameCustomDeal(){
        SpanishGame g = new SpanishGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2carrots",g.cols.get(0).get(0).toString());
        assertEquals("3carrots",g.cols.get(1).get(0).toString());
        assertEquals("4carrots",g.cols.get(2).get(0).toString());
        assertEquals("5carrots",g.cols.get(3).get(0).toString());
    }


    @Test
    public void testSpanishGameRemoveFunction(){
        SpanishGame g = new SpanishGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }

}