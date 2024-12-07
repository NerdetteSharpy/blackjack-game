// src/test/java/com/blackjack/GameTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testPlayerWins() {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
        game.getPlayerHand().setScore(20);
        game.getHouseHand().setScore(18);
        assertEquals("Player Wins!", game.playerStand());
    }

    @Test
    public void testHouseWins() {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
        game.getPlayerHand().setScore(18);
        game.getHouseHand().setScore(20);
        assertEquals("House Wins!", game.playerStand());
    }

    @Test
    public void testPlayerBusts() {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
        game.getPlayerHand().setScore(22);
        assertEquals("Player Busts - House Wins!", game.playerStand());
    }
}
