
public class App {
    public static void main(String[] args) throws Exception {

        Deck cards = new Deck();                                                                            // Creates the deck.
        Players newPlayer = new Players();                                                                  // Creates the player.
        Players newCPU = new Players();                                                                     // Creates the Computer.

        /**
         * Start section which displays the game menu and 
         * opens a selection method for 1,2,3,4 input.
         * 1 to change name, 2 to shuffle the deck,
         * 3 to start the game and 4 to exit.
         */
        while (true) {
            
            UserInterface.displayMenu(newPlayer);                                                           // Displays Menu.
            int Option = 0;
                                                                                         
            Option = UserInterface.getSelection();                                                          // Opens the 1,2,3,4 selection method.
            boolean startGame = false;

            if (Option == 1)
                newPlayer.setPlayerName();                                                                  // change the player name
            if (Option == 2)
                cards.shuffleDeck();                                                                        // shuffle the deck.
            if (Option == 3)                                                                                // Starting game.
                if (!cards.getShuffeledStatus()) {                                                          // Question to start game even though not shuffeled.     
                    if (UserInterface.getYesNoOption("The deck is not shuffeled and it probalby wont be fun.\n Continue?"))                                                     // If yes, sets startGame to true so it starts at the end of while-loop.
                        startGame = true;
                } else if (cards.getShuffeledStatus())                                                      // If no, continue while-loop.
                    startGame = true;

            if (Option == 4)
                UserInterface.extiGame();                                                                   // Exit game, shows a confirmation box.
                                                                                    
            if (startGame) {                                                                                // Ready to start game and resets boolean 
                startGame = false;                                                                          // so it keeps looping when going back.
                break;
            }
        }

        /**
         * Start the game session with current score cards hit.
         */
        UserInterface.setRecentMessag("");                                                                  // Clears Recent Message.
        UserInterface.displayStartMessage(newPlayer);                                                       // Displaying the start message
        while (true) {                                                                                      // While-loop that keeps the game session going.
            UserInterface.getRecentMessag();                                                                // Used to display whos winning after each while-loop.

            /**
             * Resetting booleans which job is to keep player loop going if criteria is met
             * and keep Computer playing if criteria is met.
             * Also resets hands
             */
            newPlayer.setPlayersTurn(true);                                                                 
            newPlayer.resetHand();
            newPlayer.setBustedTo(false);                                                                   
            newCPU.resetHand();
            newCPU.setBustedTo(false);
            
            /**
             * Players turn. While-loop that keeps players turn going as long as 
             * not busting the value or untill player stops.
             */
            while(newPlayer.getPlayersTurn()) {                                                            // While-loop that keeps players session going.

                if (newPlayer.getPlayerHand() > 0)                                                      
                    System.out.print("Your hand is: " + newPlayer.getPlayerHand() + " | ");
                else {
                    System.out.print("---------------------------\nClean hand. ");
                    System.out.flush();
                }
                boolean Option = UserInterface.getYesNoOption("Hit?");
                if (Option)
                newPlayer.addToCurrentHand(cards.dealToPlayer(newPlayer));
                    
                else 
                    newPlayer.setPlayersTurn(false);

                if (newPlayer.getPlayerHand() > 21) {
                    System.out.println("Busted with " + newPlayer.getPlayerHand() + ". Better luck next time.");
                    newPlayer.setPlayersTurn(false);
                    newPlayer.setBustedTo(true);
                }
                if (newPlayer.getPlayerHand() == 21) {
                    System.out.println("You hit 21! Computers time!");
                    newCPU.setPlayersTurn(false);
                }
            }

                        
            /**
             * Computers turn. While-loop that keeps players turn going as long as 
             * not busting the value or untill player stops.
             */
            while(!newPlayer.getPlayersTurn() && !newPlayer.isBusted()) {
                // Since thread.sleep actually stops the code it's dangerous to use it. However, since this game is really linear, it works.
                Thread.sleep(700);                                           
                                           
                
                if (newCPU.getPlayerHand() > 21) {                                                                  // If computer busts, user wins.
                    newCPU.setBustedTo(true);
                    UserInterface.setRecentMessag("Computer busted with " + newCPU.getPlayerHand()+ " Player Wins with " + newPlayer.getPlayerHand() + "!");
                    newPlayer.setPlayersTurn(true);
                }
                else if (newCPU.getPlayerHand() == 21) {                                                            // If compuer get 21. Compuer wins since it wins on equal.
                    UserInterface.setRecentMessag("Computer hit 21! Computer wins!");
                    newPlayer.setPlayersTurn(true);
                } 

                else if (newCPU.getPlayerHand() >= newPlayer.getPlayerHand()) {                                     // If Computer is higher or equal to player. 
                    UserInterface.setRecentMessag("Computer: " + newCPU.getPlayerHand() + ", Player: " + newCPU.getPlayerHand() + "\nComputer wins!");
                    newPlayer.setPlayersTurn(true);
                }
                /**
                 * Keeps playing if Player is higher than computer but stops if higher than player.
                 */
                else if (newCPU.getPlayerHand() <= newPlayer.getPlayerHand() && newPlayer.getPlayerHand() <= 21) {  
                    newCPU.addToCurrentHand(cards.dealToPlayer(newCPU));
                    System.out.println("Computers hand: " + newCPU.getPlayerHand());
                }

            }
            
        }
    }
}
