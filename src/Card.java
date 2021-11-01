public class Card {

    String cardName;
    String cardColor;
    int cardValue;

    /**
     * 
     * Card-Constructor. It takes the values of
     * the cards and translates the number of the cards
     * to names on the ones that need the change.
     */
    public Card(int cardColor, int cardName, int cardValue) {

        if (cardColor == 0)
            this.cardColor = "Hearts";
        else if (cardColor == 1)
            this.cardColor = "Diamonds";
        else if (cardColor == 2)
            this.cardColor = "Spades";
        else if (cardColor == 3)
            this.cardColor = "Clubs";
        else
            this.cardColor = "Joker";

        if (cardName == 1)
            this.cardName = "Ace";
        else if (cardName == 2)
            this.cardName = "2";
        else if (cardName == 3)
            this.cardName = "3";
        else if (cardName == 4)
            this.cardName = "4";
        else if (cardName == 5)
            this.cardName = "5";
        else if (cardName == 6)
            this.cardName = "6";
        else if (cardName == 7)
            this.cardName = "7";
        else if (cardName == 8)
            this.cardName = "8";
        else if (cardName == 9)
            this.cardName = "9";
        else if (cardName == 10)
            this.cardName = "10";
        else if (cardName == 11)
            this.cardName = "Jack";
        else if (cardName == 12)
            this.cardName = "Queen";
        else if (cardName == 13)
            this.cardName = "King";

        this.cardValue = cardValue;
    }

    /**
     *  toString - Formatting the return of cards.
     */
    public String toString() {
        return cardName + " of " + cardColor;
    }

}
