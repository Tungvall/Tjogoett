import java.util.Random;

public class Deck {
    private int cardsCurrentlyInDeck;
    private boolean deckShuffeled;
    private Card[] cards;

    /**
     * Constructor for Deck. It creates each card-object required to fill a deck.
     * Loops through all 14 cars for each color. Puts color, card number and card
     * value into each card.
     */
    public Deck() {
        int cardNr = 0;

        this.cards = new Card[52];

        for (int color = 0; color <= 3; color++) {
            for (int i = 1; i <= 13; i++) {
                this.cards[cardNr++] = new Card(color, i, i);
            }
            cardsCurrentlyInDeck = cardNr;

        }
        System.out.println((cardsCurrentlyInDeck+1) + " cards in deck.");
    }

    /**
     * Shuffles deck by going through each card postion, however since cards are
     * moving, it can swith the same card more than once. Since shuffling cards are
     * kinda random at normal I will keep this for now.
     */
    public void shuffleDeck() {
        Card tempCard;
        Random randomCard = new Random();
        for (int i = 0; i < 52; i++) {

            int tempCardToshuffle = randomCard.nextInt(52);
            tempCard = cards[i];
            cards[i] = cards[tempCardToshuffle];
            cards[tempCardToshuffle] = tempCard;
            deckShuffeled = true;
        }
        UserInterface.setRecentMessag("Ahh, nothing beats the smell of a newly shuffled deck!");
    }

    /**
     * Prints the whole deck.
     */
    public void getDeck() {
        for (int i = 0; i < 52; i++)
            System.out.println("[" + cards[i].cardValue + "] " + cards[i].cardName + " of " + cards[i].cardColor);

        System.out.println("------");
    }

    /**
     * Get status of if deck is shuffeled or not.
     * 
     * @return
     */
    public boolean getShuffeledStatus() {
        if (deckShuffeled)
            return true;
        return false;
    }

    /**
     * Reshuffle deck by running shuffleDeck() and reset card counter.
     */

    public void timeToShuffle() {
        shuffleDeck();
        cardsCurrentlyInDeck = 51;
    }

    /**
     * Deal cards to players.
     * Takes the player object and fetches a card based on a position
     * set by integer i, which also simulates the position of the top card.
     * 
     * If-statement checks for enoguh cards in deck, reshuffeles and 
     * resets top card to highest array if needed.
     * 
     * Prints the card and @return it's value.
     * 
     */
    public int dealToPlayer(Players player) {
        int i = cardsCurrentlyInDeck - 1;
        if (cardsCurrentlyInDeck < 4) {
            timeToShuffle();
            System.out.println("-----------------------------------\n\n\n");
            System.out.println("Less than 4 cards less. Shuffeling.\n");
            System.out.println("-----------------------------------");
        }
        System.out.println("-----------------------------------"); 
        System.out.println(cards[i].cardName + " of " + cards[i].cardColor);

        cardsCurrentlyInDeck = cardsCurrentlyInDeck - 1;

        if (cards[i].cardName.equals("Ace"))                                    // If Ace
            if (player.getPlayerHand() <= 7)                                    // if less than or equal to 7
                return 14;                                                      // Return 14.
            else                                                                
                return 1;                                                       // Else return 1.
        return cards[i].cardValue;                                              // Return 14
                                                      
    }


    
    
}
