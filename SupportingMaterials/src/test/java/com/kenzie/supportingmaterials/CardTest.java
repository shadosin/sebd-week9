package com.kenzie.supportingmaterials;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testInstances() {
        DeckOfCards deckOne = DeckOfCards.getInstance();
        DeckOfCards deckTwo = DeckOfCards.getInstance();

        // TODO will this pass? Why?
        // assertEquals(deckOne, deckTwo);
    }

    @Test
    public void testTwoDecks() {
        // Store the "state" of the deck in a string
        DeckOfCards deckOne = DeckOfCards.getInstance();
        deckOne.shuffle();
        String deckOneFormatted = deckOne.print();

        // Store the "state" of the deck in a string
        DeckOfCards deckTwo = DeckOfCards.getInstance();
        String deckTwoFormatted = deckTwo.print();

        // TODO will this pass? Why?
        // assertEquals(deckTwoFormatted, deckOneFormatted);
    }

    @Test
    public void testShuffle() {
        // Store the "state" of the deck in a string
        DeckOfCards deckOne = DeckOfCards.getInstance();
        String deckOneFormatted = deckOne.print();

        // Moved this - Shuffle here!
        deckOne.shuffle();

        // Store the "state" of the deck in a string
        DeckOfCards deckTwo = DeckOfCards.getInstance();
        String deckTwoFormatted = deckTwo.print();

        // TODO will this pass? Why?
        // assertEquals(deckTwoFormatted, deckOneFormatted);
    }


}
