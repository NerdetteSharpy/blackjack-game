// src/main/java/com/blackjack/Game.java
import java.util.*;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand houseHand;

    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        houseHand = new Hand();
    }

    public void startGame() {
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        houseHand.addCard(deck.draw());
        houseHand.addCard(deck.draw());
    }

    public void playerHit() {
        playerHand.addCard(deck.draw());
    }

    public String playerStand() {
        while (houseHand.getScore() < 17) {
            houseHand.addCard(deck.draw());
        }
        return getResult();
    }

    private String getResult() {
        if (playerHand.getScore() > 21) return "Player Busts - House Wins!";
        if (houseHand.getScore() > 21) return "House Busts - Player Wins!";
        if (playerHand.getScore() > houseHand.getScore()) return "Player Wins!";
        if (houseHand.getScore() > playerHand.getScore()) return "House Wins!";
        return "It's a Tie!";
    }
    
    public Hand getPlayerHand() { return playerHand; }
    public Hand getHouseHand() { return houseHand; }
}

// Other required classes: Deck.java, Hand.java, and Card.java
// Include getters, and shuffle logic for Deck; add, draw, and scoring logic for Hand.
