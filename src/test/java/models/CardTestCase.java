package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/26/16.
 */
public class CardTestCase {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.clubs);
        assertEquals(Suit.clubs,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.clubs);
        assertEquals("5clubs",c.toString());
    }

    @Test
    public void testMoveCard(){
        AmericanGame g = new AmericanGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).size());
        assertEquals(0,g.cols.get(0).size());
    }


}
