package com.example;

/*
** By Jung Verheiden, implement correct behaviors of a deck of card.
*/
import java.util.ArrayList;
import java.util.Random;

import static com.example.DeckOfCards.Type.CLUB;
import static com.example.DeckOfCards.Type.DIAMOND;
import static com.example.DeckOfCards.Type.HEART;
import static com.example.DeckOfCards.Type.SPADE;

public class DeckOfCards {
    public static void main(String[] args){
        DeckOfCards cards = new DeckOfCards();
        System.out.println("Hands Count before Shuffle : " + cards.countTest(0, 12));
        cards.shuffle();
        System.out.println("Hands Count after Shuffle : " + cards.countTest(0, 12));
    }
    final static int NUM_CARDS = 52;
    Card[] deck;
    Type[] catalog;
    public enum Type {
        SPADE, HEART, DIAMOND, CLUB
    }
    class Card
    {
        Type type;
        int rank;
        int value;
        public Card(Type t, int r)
        {
            type = t;
            rank = r;
        }
    }
    int countTest(int start, int end)
    {
        ArrayList<Card> hand = new ArrayList<Card>();
        for ( int i = start; i <= end; i++)
        {
            hand.add(deck[i]);
        }
        return( countHands(hand));
    }
    public DeckOfCards()
    {
        catalog = new Type[4];
        catalog[0] = SPADE;
        catalog[1] = HEART;
        catalog[2] = DIAMOND;
        catalog[3] = CLUB;
        deck = new Card[NUM_CARDS];
        for ( int i = 0; i < NUM_CARDS; i++){
            int cat = i/13;
            int rank = i%13;
            deck[i] = new Card(catalog[cat], rank);
        }
    }
    int countHands(ArrayList<Card> a)
    {
        int total = 0;
        for ( int i = 0; i < a.size(); i++){
            if ( a.get(i).rank <= 8 )
                total += a.get(i).rank + 1;
            else
                total += 10;
        }
        return total;
    }
    void shuffle()
    {
        Random rand = new Random();

        for ( int i = 0; i < NUM_CARDS; i++)
        {
            int rIndex = rand.nextInt( NUM_CARDS);
            Card temp = deck[rIndex];
            deck[rIndex] = deck[i];
            deck[i] =  temp;
        }
    }
}
