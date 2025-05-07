import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame implements ActionListener{
    JButton rockButton,paperButton,ScissorButton;
    JLabel computerChoice, resultLabel,computerScoreLabel,playerScoreLabel;
    RockPaperScissor rockPaperScissor;
    public RockPaperScissorGUI(){
        super("Rock Paper Scissors");

        setSize(450, 574);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        rockPaperScissor = new RockPaperScissor();
        addGuiComponents();
    }

    private void addGuiComponents(){
        computerScoreLabel = new JLabel("Computer: 0");

        computerScoreLabel.setBounds(0,43,450,30);
        computerScoreLabel.setFont(new Font("San-Serif", Font.BOLD,26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        add(computerScoreLabel);

        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,90,81);
        computerChoice.setFont(new Font("Dialog",Font.BOLD,26));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //Player Score
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //Player Button

        //Rock Button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog", Font.BOLD,18));
        rockButton.addActionListener(this);
        add(rockButton);

        // Paper Button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        rockButton.setFont(new Font("Dialog",Font.BOLD,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //Scissor Button
        ScissorButton = new JButton("Scissors");
        ScissorButton.setBounds(290,387,115,81);
        ScissorButton.setFont(new Font("Dialog",Font.BOLD,18));
        ScissorButton.addActionListener(this);
        add(ScissorButton);
    }

    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);

        //Try Again Button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reset Computer Choice
                computerChoice.setText("?");
                resultDialog.dispose();
            }
        });

        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getPlayerChoice = e.getActionCommand();
        String[] resultAndChoice = rockPaperScissor.playRockPaperScissor(getPlayerChoice);

        String result = resultAndChoice[0];
        String computerPlayed = resultAndChoice[1];


        computerChoice.setText(computerPlayed);
        computerScoreLabel.setText("Computer Score: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player Score: " + rockPaperScissor.getPlayerScore());
        showDialog(result);
    }

}
