import java.util.Random;

public class RockPaperScissor {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};
    private int computerScore,playerScore;
    //Getter
    public int getComputerScore() {
        return computerScore;
    }
    //Setter
    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }
    //Getter
    public int getPlayerScore() {
        return playerScore;
    }
    //Setter
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    private final Random random;

    public RockPaperScissor(){
        random = new Random();
    }

    private String getWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        if ((player.equals("Rock") && computer.equals("Scissors")) ||
                (player.equals("Paper") && computer.equals("Rock")) ||
                (player.equals("Scissors") && computer.equals("Paper")))
            return "Player";
        return "Computer";
    }


    public String[] playRockPaperScissor(String playerChoice) {
        String computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        playerChoice = playerChoice.substring(0, 1).toUpperCase() + playerChoice.substring(1).toLowerCase();
        computerChoice = computerChoice.substring(0, 1).toUpperCase() + computerChoice.substring(1).toLowerCase();
        String winner = getWinner(playerChoice, computerChoice);
        if (winner.equals("Player")) playerScore++;
        else if (winner.equals("Computer")) {
            computerScore++;
        }
        String result = winner.equals("Draw") ? "It's a Draw!" : winner + " wins!";
        return new String[]{result,computerChoice};
    }
}
