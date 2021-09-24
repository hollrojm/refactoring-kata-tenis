package com.sofka.tennis1;

import java.util.Arrays;
import java.util.List;

public class TennisGame1 implements TennisGame {

    private int pointsPlayerOne = 0;
    private int pointsPlayerTwo = 0;
    private final String playerOneName;
    private final String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName != null && playerName.equals(this.playerOneName))
            pointsPlayerOne += 1;
        else
            pointsPlayerTwo += 1;
    }

    public String getScore() {

        if (pointsPlayerOne == pointsPlayerTwo)
            return result(pointsPlayerOne);
        return winResultTemp();
    }



    private String winResultTemp() {
        return (pointsPlayerOne >= 4 || pointsPlayerTwo >= 4) ? advantageWinResult() : scoreResultTemp();
    }

    private String scoreResultTemp() {
        String score     = "";
        return resultTemp(score);
    }

    private String resultTemp(String score) {

        for (int i = 1; i<3; i++)

        {
            score = score(score, i);
        }
        return score;
    }

    private String score(String score, int i) {
        int tempScore;
        if (i ==1) tempScore = pointsPlayerOne;
        else {
            score +="-";
            tempScore = pointsPlayerTwo;}
        score = pointsGame(score, tempScore);
        return score;
    }

    private String pointsGame(String score, int tempScore) {
        switch(tempScore)

        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
            default:
                score = "";
        }
        return score;
    }

    private String advantageWinResult() {
        String score;
        StringBuilder stringBuilder = new StringBuilder();
        int    minusResult = pointsPlayerOne - pointsPlayerTwo;
        if (minusResult==1) score = stringBuilder.append("Advantage ").append(this.playerOneName).toString();
        else if (minusResult ==-1) score = stringBuilder.append("Advantage ").append(this.playerTwoName).toString();
        else if (minusResult >=2) score = stringBuilder.append("Win for ").append(this.playerOneName).toString();
        else score = stringBuilder.append("Win for ").append(this.playerTwoName).toString();
        return score;
    }

    private String result(int scorePlayer) {
        List<String> scores = Arrays.asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce");
        return scores.get(scorePlayer);
    }
}
