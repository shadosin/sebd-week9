package com.kenzie.supportingmaterials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class DeckOfCards {
    static DeckOfCards deck;
    private ArrayList<Card> cards;

    private DeckOfCards() {
        this.cards = new ArrayList<>();

        Suit[] suits = { Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS };
        for(Suit suit: suits) {
            for(int i = 2; i < 15; i++) {
                this.cards.add(new Card(suit, i));
            }
        }
    }

    // getInstance() method returns the single instance
    // Same call is used whether it already exists or if it needs to be created
    public static DeckOfCards getInstance() {
        if(deck == null) {
            deck = new DeckOfCards();
        }
        return deck;
    }

    public Card drawCard() {
        return null;
    }

    public void shuffle() {
        Collections.shuffle(this.cards, new Random());
    }

    public String print() {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < this.cards.size(); i++) {
            builder.append(this.cards.get(i).toString());
            builder.append("\n");
        }

        return builder.toString();
    }

}