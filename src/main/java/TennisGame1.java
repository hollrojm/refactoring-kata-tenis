
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
        if (playerName != null && playerName.equals(this.player1Name))
            pointsPlayer1 += 1;
        else
            pointsPlayer2 += 1;
    }

    public String getScore() {

        if (pointsPlayer1 == pointsPlayer2)
            return result();
        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) ? advantageWinResult() : scoreResultTemp();
    }

    private String scoreResultTemp() {
        String score     = "";
        return resultTemp(score);
    }

    private String resultTemp(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = pointsPlayer1;
            else { score +="-"; tempScore = pointsPlayer2;}
            score = pointsGame(score, tempScore);
        }
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
        int    minusResult = pointsPlayer1 - pointsPlayer2;
        if (minusResult==1) score = stringBuilder.append("Advantage ").append(this.player1Name).toString();
        else if (minusResult ==-1) score = stringBuilder.append("Advantage ").append(this.player2Name).toString();
        else if (minusResult >=2) score = stringBuilder.append("Win for ").append(this.player1Name).toString();
        else score = stringBuilder.append("Win for ").append(this.player2Name).toString();
        return score;
    }

    private String result() {
        switch (pointsPlayer1)
        {
            case 0:
                   return "Love-All";

            case 1:
                    return "Fifteen-All";

            case 2:
                    return  "Thirty-All";

            default:
                    return "Deuce";
        }
    }
}
