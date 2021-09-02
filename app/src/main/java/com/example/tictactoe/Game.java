package com.example.tictactoe;

import android.util.Log;

import java.util.Arrays;

public class Game {
    private static Game instance = null;
    private String player1Name = "";
    private String player2Name = "";
    private String player1SelectedCardType = "";
    private String player2SelectedCardType = "";
    private String[][] gameData = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };
    private boolean isPlayer1Turn = true;
    private int player1Score = 0;
    private int player2Score = 0;

    private Game(){}

    public static Game getInstance(){
        if(instance == null)
            instance = new Game();
        return instance;
    }

    public String getPlayer1Name(){
        return player1Name;
    }

    public void setPlayer1Name(String playerName) {
        player1Name = playerName;
    }

    public String getPlayer2Name(){
        return player2Name;
    }

    public void setPlayer2Name(String playerName) {
        player2Name = playerName;
    }

    public String getPlayer1SelectedCardType(){
        return player1SelectedCardType;
    }

    public void setPlayer1SelectedCardType(String cardType){
        player1SelectedCardType = cardType;
    }

    public String getPlayer2SelectedCardType(){
        return player2SelectedCardType;
    }

    public void setPlayer2SelectedCardType(String cardType){
        player2SelectedCardType = cardType;
    }

    public void endGameDate(){
        player1Name = "";
        player2Name = "";
        player1SelectedCardType = "";
        player2SelectedCardType = "";
        player1Score = 0;
        player2Score = 0;
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                gameData[i][j] = "";
            }
        }
        isPlayer1Turn = true;
    }

    public void restartGame(){
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                gameData[i][j] = "";
            }
        }
        player1Score = 0;
        player2Score = 0;
    }

    public void resetGameDashboard(){
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                gameData[i][j] = "";
            }
        }
    }

    public void setPlayer1Turn(boolean value){
        isPlayer1Turn = value;
    }

    public boolean isPlayer1Turn(){
        return isPlayer1Turn;
    }

    public void setPlayer1Score(int score) {
        player1Score = score;
    }
    public void increasePlayer1Score(){
        player1Score++;
    }
    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer2Score(int score) {
        player2Score = score;
    }
    public void increasePlayer2Score(){
        player2Score++;
    }
    public int getPlayer2Score() {
        return player2Score;
    }

    public String getGameDataByIndex(int row, int column) {
        if(row > 2 || column > 2){
            return "";
        }
        return gameData[row][column];
    }

    public void setGameDataByIndex(int row, int column, String data){
            gameData[row][column] = data;
    }

    public boolean isAllElementSelected(){
        int count = 0;
        for (int i = 0; i < gameData.length; i++) {
            for (int j = 0; j < gameData[i].length; j++) {
                if (!gameData[i][j].equals("")) {
                    count++;
                }else {
                    break;
                }
            }
        }
        return count == 9;
    }

    /**
     * This method is used to check for the winner
     *
     * @return return 1 if player 1 won else 2 if player 2 won else 0 if both of them fails
     */
    public int getWhoWin(){
        // For all horizontal win check
        if (gameData[0][0].equals("X") && gameData[0][1].equals("X") && gameData[0][2].equals("X")) {
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[0][0].equals("O") && gameData[0][1].equals("O") && gameData[0][2].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        } else if(gameData[1][0].equals("X") && gameData[1][1].equals("X") && gameData[1][2].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[1][0].equals("O") && gameData[1][1].equals("O") && gameData[1][2].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        } else if(gameData[2][0].equals("X") && gameData[2][1].equals("X") && gameData[2][2].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[2][0].equals("O") && gameData[2][1].equals("O") && gameData[2][2].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        }
        // for all vertical win check
        else if(gameData[0][0].equals("X") && gameData[1][0].equals("X") && gameData[2][0].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[0][0].equals("O") && gameData[1][0].equals("O") && gameData[2][0].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        }else if(gameData[0][1].equals("X") && gameData[1][1].equals("X") && gameData[2][1].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[0][1].equals("O") && gameData[1][1].equals("O") && gameData[2][1].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        } else if(gameData[0][2].equals("X") && gameData[1][2].equals("X") && gameData[2][2].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[0][2].equals("O") && gameData[1][2].equals("O") && gameData[2][2].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        }
        // for \ win check
        else if(gameData[0][0].equals("X") && gameData[1][1].equals("X") && gameData[2][2].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[0][0].equals("O") && gameData[1][1].equals("O") && gameData[2][2].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        }
        // for / win check
        else if(gameData[0][2].equals("X") && gameData[1][1].equals("X") && gameData[2][0].equals("X")){
            if (player1SelectedCardType.equals("X")) {
                return 1;
            }else {
                return 2;
            }
        } else if (gameData[0][2].equals("O") && gameData[1][1].equals("O") && gameData[2][0].equals("O")) {
            if (player1SelectedCardType.equals("O")) {
                return 1;
            }else {
                return 2;
            }
        }
        return 0;
    }

}
