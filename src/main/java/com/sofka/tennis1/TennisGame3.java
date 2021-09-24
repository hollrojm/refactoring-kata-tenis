package com.sofka.tennis1;

public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if  (puntuation()){
        return scoreResult();

        } else {
            if (draw())
                return "Deuce";

        }
        return event();
    }
    public boolean puntuation(){
        return (p2< 4 )&& (p1 < 4) && !(p2 + p1 == 6);
    }
    public boolean draw(){
        return (p1 == p2);
    }
    public String event(){
        return (deductPoints() == 1) ? "Advantage " + winning() : "Win for " + winning();
    }
    public double deductPoints(){
        return Math.pow((p2 - p1), 2);
    }
    public String winning(){
        return p2 > p1 ? p1N : p2N;
    }
    public String scoreResult(){
        String[] score = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return (p2 == p1) ? score[p2] + "-All" : score[p2] + "-" + score[p1];
    }
    
    public void wonPoint(String playerName) {
        int score = (playerName == "player1") ? (p2 ++) : (p1 ++);
        
    }






}
