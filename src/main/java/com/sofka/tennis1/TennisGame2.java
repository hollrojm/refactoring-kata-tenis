package com.sofka.tennis1;

import java.util.Arrays;
import java.util.List;

public class TennisGame2 implements TennisGame
{
    private int playerOnePoint = 0;
    private int playerTwoPoint = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame2(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore(){
        String score = "";
        if (draw()){
            score = equalScore();
        }  else if(advanceSelection()){
            int scoreDifference = playerOnePoint - playerTwoPoint;
            score = advance(scoreDifference);
        } else {
            score = score(playerOnePoint) + "-" + score(playerTwoPoint);
        }
        return score;
    }

    public void wonPoint(String player) {
        int score = (player.equals("player1") ) ? (playerOnePoint++) : (playerTwoPoint++);
    }


    public boolean draw(){
        return (playerOnePoint == playerTwoPoint);
    }


    public boolean advanceSelection(){
        return ((playerOnePoint >= 4) || (playerTwoPoint >= 4));
    }


    public String equalScore() {
        List<String> scores = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return scores.get(playerOnePoint);
    }


    public String advance(int scoreDifference){
        StringBuilder stringBuilder = new StringBuilder();
        switch (scoreDifference){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return (scoreDifference >= 2)? "Win for player1" : "Win for player2";
        }
    }

    public String score(int scorePlayer){
        List<String> scores = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
        return scores.get(scorePlayer);
    }
}