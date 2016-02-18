package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/********************************************************************************
*     Name: class Game
*  Purpose: Abstract class for any Aces Up game using any kind deck.
* Inherits: none
* 
********************************************************************************/
public abstract class Game {

    /* Attributes */
    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();


    /* Methods */
    public abstract void buildDeck();
    public abstract void shuffle();
    public abstract void dealFour();
    public abstract void customDeal(int c1, int c2, int c3, int c4);
    public abstract void remove(int columnNumber);
    public abstract void move(int colFrom, int colTo);

    protected abstract boolean colHasCards(int colNumber);
    protected abstract Card getTopCard(int columnNumber);
    protected abstract void addCardToCol(int colTo, Card cardToMove);
    protected abstract void removeCardFromCol(int colFrom);
}