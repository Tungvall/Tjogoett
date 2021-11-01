import java.util.*;


public class Players {
    private String name = "";
    private boolean nameSet;
    private boolean playersTurn;
    private boolean busted;
    private int currentScore;
    private int scoreCurrentHand;



    public boolean checkIfnameSet() {
        return nameSet;
    }

    public boolean getPlayersTurn() {
        return playersTurn;
    }
    public void setPlayersTurn(boolean turn) {
        playersTurn = turn;
    }

    public int getPlayerScore() {
        return currentScore;
    }

    public int getPlayerHand() {
        return scoreCurrentHand;
    }
    
    public void setBustedTo(boolean bustedStatus) {
        busted = bustedStatus;
    }

    public boolean isBusted() {
        return busted;
    }

    public String setPlayerName() {

        System.out.print("Whats your name?: ");
        String s = "";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            s = sc.nextLine();
            if (s != null && s.matches("^[a-zA-Z]*$"))
                break;
        }
        UserInterface.setRecentMessag("Fresh! " + s + " sure is a fresh name!");
        nameSet = true;
        return this.name;
    }

    public String getPlayerName() {
        return this.name;
        

    }

    public void addToCurrentHand(int cardValue) {
        this.scoreCurrentHand = this.scoreCurrentHand + cardValue;
    }

    public void resetHand() {
        this.scoreCurrentHand = 0;
    }
    
}
