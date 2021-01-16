package sk.nagy.dominik.peeshquorkeebe;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class GameController {
    List<String> currentBoard = new ArrayList<>();
    String playerOne = "";
    String playerTwo = "";
    boolean gameInProgress = false;
    final String PLAYER_ONE_SYMBOL = "x";
    final String PLAYER_TWO_SYMBOL = "o";
    int playerTurn = 1;

    @MessageMapping("/startGame")
    @SendToUser("/queue/gameStatus")
    public String answerWithClearBoard(PlayerIN email) {

        if (playerOne.isEmpty()) {
            playerOne = email.getEmail();

            return "Player1 connected > " + email.getEmail();
        } else if (playerTwo.isEmpty()) {
            playerTwo = email.getEmail();
            initializeBoard();
            gameInProgress = true;
            System.out.println("A new game started!");
            return "Player2 connected > " + email.getEmail() + " < game is started.";
        } else
            return "Game already in progress";
    }

//    @MessageMapping("/startGame")
//    public void test(Message<Object> message, @Payload PlayerIN chatMessage) {
//        Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
//        assert principal != null;
//        String authedSender = principal.getName();
//        System.out.println(authedSender);
//        STOMPConnectEventListener stompConnectEventListener = new STOMPConnectEventListener();
//
//    }

    @MessageMapping("/endGame")
    @SendToUser("/queue/gameStatus")
    public String endGame(PlayerIN message) {
        System.out.println("Game ended!");
        clearBoard();
        playerOne = "";
        playerTwo = "";
        playerTurn = 1;
        return "Game ended.";
    }

    @MessageMapping("/incomingMessage")
    @SendTo("/topic/gameStatus")
    public GameBoardOUT answerMessage(PlayerIN message) throws Exception {
        if (gameInProgress) {
            if (message.getEmail().equals(playerOne) && playerTurn == 1) {
                addMoveToBoard(message.getMove(), PLAYER_ONE_SYMBOL);
                playerTurn = 2;
                if (isTheGameWon(PLAYER_ONE_SYMBOL)) {
                    currentBoard.set(0, "win_playerOne");
//                    endGame(message);
                    return new GameBoardOUT(currentBoard);
                }
            } else if (message.getEmail().equals(playerTwo) && playerTurn == 2) {
                addMoveToBoard(message.getMove(), PLAYER_TWO_SYMBOL);
                playerTurn = 1;
                if (isTheGameWon(PLAYER_TWO_SYMBOL)) {
                    currentBoard.set(0, "win_playerTwo");
//                    endGame(message);
                    return new GameBoardOUT(currentBoard);
                }
            }
        }

        return new GameBoardOUT(currentBoard);
    }

    private boolean isTheGameWon(String symbol) {
        if (currentBoard.get(0).equals(symbol) && currentBoard.get(1).equals(symbol) && currentBoard.get(2).equals(symbol)) {
            return true;
        } else if (currentBoard.get(3).equals(symbol) && currentBoard.get(4).equals(symbol) && currentBoard.get(5).equals(symbol)) {
            return true;
        } else if (currentBoard.get(6).equals(symbol) && currentBoard.get(7).equals(symbol) && currentBoard.get(8).equals(symbol)) {
            return true;
        } else if (currentBoard.get(0).equals(symbol) && currentBoard.get(3).equals(symbol) && currentBoard.get(6).equals(symbol)) {
            return true;
        } else if (currentBoard.get(1).equals(symbol) && currentBoard.get(4).equals(symbol) && currentBoard.get(7).equals(symbol)) {
            return true;
        } else if (currentBoard.get(2).equals(symbol) && currentBoard.get(5).equals(symbol) && currentBoard.get(8).equals(symbol)) {
            return true;
        } else if (currentBoard.get(0).equals(symbol) && currentBoard.get(4).equals(symbol) && currentBoard.get(8).equals(symbol)) {
            return true;
        } else return currentBoard.get(2).equals(symbol) && currentBoard.get(4).equals(symbol) && currentBoard.get(6).equals(symbol);
    }

    private void addMoveToBoard(String move, String symbol) {
        switch (move) {
            case "00":
                currentBoard.set(0, symbol);
                break;
            case "01":
                currentBoard.set(1, symbol);
                break;
            case "02":
                currentBoard.set(2, symbol);
                break;
            case "10":
                currentBoard.set(3, symbol);
                break;
            case "11":
                currentBoard.set(4, symbol);
                break;
            case "12":
                currentBoard.set(5, symbol);
                break;
            case "20":
                currentBoard.set(6, symbol);
                break;
            case "21":
                currentBoard.set(7, symbol);
                break;
            case "22":
                currentBoard.set(8, symbol);
                break;
            default:
                System.out.println("Something went wrong in addMoveToBoard.");
        }
    }

    private void clearBoard() {
        currentBoard.clear();
    }

    private void initializeBoard() {
        currentBoard.add(0, "");
        currentBoard.add(1, "");
        currentBoard.add(2, "");
        currentBoard.add(3, "");
        currentBoard.add(4, "");
        currentBoard.add(5, "");
        currentBoard.add(6, "");
        currentBoard.add(7, "");
        currentBoard.add(8, "");
    }
}