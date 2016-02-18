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
        SpanishGame g = new SpanishGame();
        g.buildDeck();
        g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
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