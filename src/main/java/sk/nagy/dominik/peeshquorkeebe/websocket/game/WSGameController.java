package sk.nagy.dominik.peeshquorkeebe.websocket.game;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WSGameController {
    List<String> currentBoard = new ArrayList<>();
    List<String> endBoard = new ArrayList<>();
    String winnerNick = "";
    String playerOne = "";
    String playerTwo = "";
    boolean gameInProgress = false;
    final String PLAYER_ONE_SYMBOL = "x";
    final String PLAYER_TWO_SYMBOL = "o";
    int playerTurn = 1;

    @MessageMapping("/startGame")
    @SendTo("/topic/gameStatus")
    public String answerWithClearBoard(PlayerIN nickname) {
        if (playerOne.isEmpty()) {
            playerOne = nickname.getNickname();
            return "Player1 connected > " + nickname.getNickname();
        } else if (playerTwo.isEmpty()) {
            playerTwo = nickname.getNickname();
            initializeBoard();
            endBoard.clear();
            gameInProgress = true;
            System.out.println("A new game started!");
            return "Player2 connected > " + nickname.getNickname() + " < game is started.";
        } else
            return "Game already in progress";
    }

    @MessageMapping("/endGame")
    @SendTo("/topic/gameStatus")
    public String endGame(PlayerIN message) {
        System.out.println("Game ended!");
        clearBoard();
        playerOne = "";
        playerTwo = "";
        playerTurn = 1;
        gameInProgress = false;

        return "Game ended.";
    }

    @MessageMapping("/playGame")
    @SendTo("/topic/gameStatus")
    public GameOut answerMessage(PlayerIN message) throws Exception {
        System.out.println("started playing game.");
        if (gameInProgress) {
            if (message.getNickname().equals(playerOne) && playerTurn == 1) {
                addMoveToBoard(message.getMove(), PLAYER_ONE_SYMBOL);
                playerTurn = 2;
                if (isTheGameWon(PLAYER_ONE_SYMBOL)) {
                    System.out.println("win 1");
                    endBoard.addAll(currentBoard);
                    winnerNick = playerOne;
                    System.out.println(winnerNick + " has win the game!");
                    addGameResultToDatabase(playerOne, playerTwo, endBoard.toString());
                    endGame(message);
                    return new GameOut(endBoard, true, false, winnerNick);
                } else if (isTheGameDraw()) {
                    System.out.println("draw");
                    endBoard.addAll(currentBoard);
                    addGameResultToDatabase(playerOne, playerTwo, endBoard.toString());
                    endGame(message);
                    return new GameOut(endBoard, false, true, "draw");
                }
            } else if (message.getNickname().equals(playerTwo) && playerTurn == 2) {
                addMoveToBoard(message.getMove(), PLAYER_TWO_SYMBOL);
                playerTurn = 1;
                if (isTheGameWon(PLAYER_TWO_SYMBOL)) {
                    System.out.println("win 2");
                    endBoard.addAll(currentBoard);
                    winnerNick = playerTwo;
                    System.out.println(winnerNick+ " has win the game!");
                    addGameResultToDatabase(playerOne, playerTwo, endBoard.toString());
                    endGame(message);
                    return new GameOut(endBoard, true, false, winnerNick);
                } else if (isTheGameDraw()) {
                    System.out.println("draw");
                    endBoard.addAll(currentBoard);
                    addGameResultToDatabase(playerOne, playerTwo, endBoard.toString());
                    endGame(message);
                    return new GameOut(endBoard, false, true, "draw");
                }
            }
        }

        return new GameOut(currentBoard, false, false, "");
    }

    private void addGameResultToDatabase(String playerOneNick, String playerTwoNick, String gameboard) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        databaseOperations.insertGameResult(new GameResult(playerOneNick, playerTwoNick, gameboard));
    }

    private boolean isTheGameDraw() {
        for (String s : currentBoard) {
            if (s.isEmpty()) {
                System.out.println(currentBoard.toString());
                return false;
            }
        }
        return true;
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
        } else if (currentBoard.get(2).equals(symbol) && currentBoard.get(4).equals(symbol) && currentBoard.get(6).equals(symbol)) {
            return true;
        } else
            return false;
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