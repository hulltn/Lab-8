import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
  JTextField usersGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel promptguesslbl
  JLabel highorlowlbl;
  JLabel lastguesslbl;

  Random r;
  int randomNum;

  GuessingGame(){
    r = new Random();
    randomNum = r.nextInt(100)+1;

    JFrame frame = new JFrame("GuessingGame");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    usersGuess = new JTextField(10);
    usersGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    usersGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    promptguesslbl = new JLabel("Enter your guess: ");
    highorlowlbl = new JLabel("");
    lastguesslbl = new JLabel("");

    frame.add(promptguesslbl);
    frame.add(usersGuess);
    frame.add(guessButton);
    frame.add(highorlowlbl);
    frame.add(lastguesslbl);
    frame.add(playAgainButton);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")){
      int guess = Integer.parseInt(usersGuess.getText());

      if(guess < randomNum){
        highorlowlbl.setText("Too Low!");
      }
      else if(guess > randomNum){
        highorlowlbl.setText("Too High!");
      }
      else if(guess == randomNum){
        highorlowlbl("You Got It!");
      }
      lastguesslbl.setText("Last guess was " + userGuess.getText());
    }
    else if(ae.getActionCommand().equals("Play Again")){
      randomNum = r.nextInt(100)+1;
      promptguesslbl.setText("Enter your guess: ");
      highorlowlbl.setText("");
      lastguesslbl.setText("");
      usersGuess.setText("");
    }
    else{
      highorlowlbl.setText("You pressed Enter. \n Please press the Guess Button");
    }
  }
}
//finished