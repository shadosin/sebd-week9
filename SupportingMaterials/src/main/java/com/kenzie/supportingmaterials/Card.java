package com.kenzie.supportingmaterials;

class Card {
    private Suit suit;
    private int number;
    private String[] names = {
            null,
            null,
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "Jack",
            "Queen",
            "King",
            "Ace"
    };

    public Card(Suit s, int n) {
        this.suit = s;
        if((n < 2) || (n > 14)) {
            throw new IllegalArgumentException();
        }
        this.number = n;
    }

    public String toString() {
        int length = 10;

        StringBuilder result = new StringBuilder("------------");

        String which = names[this.number];

        result.append(center(which, length, ' '));
        result.append("|    of    | ");

        result.append(center(this.suit.name(), length, ' '));
        result.append("------------");

        return result.toString();
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);

        while (sb.length() < size) {
            sb.append(pad);
        }

        return "\n|" + sb + "| \n";
    }


}

