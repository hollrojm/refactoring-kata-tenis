
public class TennisGame1 implements TennisGame {
    
    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName != null && playerName.equals("player1"))
            pointsPlayer1 += 1;
        else
            pointsPlayer2 += 1;
    }

    public String getScore() {
        String score     = "";
        int    tempScore = 0;
        if (pointsPlayer1 == pointsPlayer2)
            return result();
        if (pointsPlayer1 >= 4 || pointsPlayer2 >= 4)
            return advantage_win_result();{

        }
            return  result_temp(score);
    }

    private String result_temp(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = pointsPlayer1;
            else { score +="-"; tempScore = pointsPlayer2;}
            score = points_game(score, tempScore);
        }
        return score;
    }

    private String points_game(String score, int tempScore) {
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

    private String advantage_win_result() {
        String score;
        int    minusResult = pointsPlayer1 - pointsPlayer2;

        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String result() {
        String score;
        switch (pointsPlayer1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;
            
        }
        return score;
    }
}
